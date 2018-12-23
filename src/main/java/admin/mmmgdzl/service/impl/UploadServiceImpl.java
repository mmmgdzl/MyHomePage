package admin.mmmgdzl.service.impl;

import admin.mmmgdzl.service.UploadService;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${HEAD_IMAGE_PATH}")
    private String HEAD_IMAGE_PATH;

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 项目在系统中的真实路径
     */
    private String realPath = null;

    @Override
    public Result updateHeadImage(MultipartFile headImage, Integer aid) {
        //获取文件名
        String originalFilename = headImage.getOriginalFilename();
        //如果文件格式不为.jpg或.png则抛出异常
        if(!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png"))
            throw new XKException("头像图片的格式只能为.jpg或.png");
        //组装新的文件名 aid_日期.后缀
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = aid + "_" + dateName + postfix;
        //组装完整文件路径
        String fileSavePath = getRealPath() + HEAD_IMAGE_PATH + "\\" + fileName;
        //保存文件
        try {
            headImage.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("文件保存时出错");
        }
        //更新头像路径信息
        Admin admin = new Admin();
        admin.setAid(aid);
        admin.setAheadimg(fileName);
        adminMapper.updateByPrimaryKeySelective(admin);
        //返回执行成功信息(包含文件名称)
        return Result.OK(fileName);
    }

    /**
     * 该方法用于获取项目在系统中的真实路径
     */
    private String getRealPath() {
        if(realPath == null) {
            realPath = httpSession.getServletContext().getRealPath("");
            //本地端
            realPath = "F:\\apache-tomcat-7.0.52\\webapps";
            //如果是服务端
//            realPath = new File(realPath).getParentFile().getParentFile().getPath();
        }
        return realPath;
    }

}
