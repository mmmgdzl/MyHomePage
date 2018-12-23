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
     * ��Ŀ��ϵͳ�е���ʵ·��
     */
    private String realPath = null;

    @Override
    public Result updateHeadImage(MultipartFile headImage, Integer aid) {
        //��ȡ�ļ���
        String originalFilename = headImage.getOriginalFilename();
        //����ļ���ʽ��Ϊ.jpg��.png���׳��쳣
        if(!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png"))
            throw new XKException("ͷ��ͼƬ�ĸ�ʽֻ��Ϊ.jpg��.png");
        //��װ�µ��ļ��� aid_����.��׺
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = aid + "_" + dateName + postfix;
        //��װ�����ļ�·��
        String fileSavePath = getRealPath() + HEAD_IMAGE_PATH + "\\" + fileName;
        //�����ļ�
        try {
            headImage.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("�ļ�����ʱ����");
        }
        //����ͷ��·����Ϣ
        Admin admin = new Admin();
        admin.setAid(aid);
        admin.setAheadimg(fileName);
        adminMapper.updateByPrimaryKeySelective(admin);
        //����ִ�гɹ���Ϣ(�����ļ�����)
        return Result.OK(fileName);
    }

    /**
     * �÷������ڻ�ȡ��Ŀ��ϵͳ�е���ʵ·��
     */
    private String getRealPath() {
        if(realPath == null) {
            realPath = httpSession.getServletContext().getRealPath("");
            //���ض�
            realPath = "F:\\apache-tomcat-7.0.52\\webapps";
            //����Ƿ����
//            realPath = new File(realPath).getParentFile().getParentFile().getPath();
        }
        return realPath;
    }

}
