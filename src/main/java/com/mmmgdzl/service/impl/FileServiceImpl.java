package com.mmmgdzl.service.impl;

import com.mmmgdzl.mapper.ResourceColumnWebsiteMapper;
import com.mmmgdzl.pojo.ResourceColumnWebsite;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.mapper.ResourceMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Value("${HEAD_IMAGE_PATH}")
    private String HEAD_IMAGE_PATH;
    @Value("${RESOURCE_TITLE_IMAGE_PATH}")
    private String RESOURCE_TITLE_IMAGE_PATH;
    @Value("${RESOURCE_COLUMN_WEBSITE_LOGO_PATH}")
    private String RESOURCE_COLUMN_WEBSITE_LOGO_PATH;

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceColumnWebsiteMapper resourceColumnWebsiteMapper;
    //该session用于服务器版本获取真实路径
    @Autowired
    private HttpSession httpSession;

    /**
     * 项目在系统中的真实路径(不可直接使用)
     */
    private String realPath = null;

    @Override
    public Result updateHeadImage(MultipartFile headImage, Integer aid) {
        //获取文件名
        String originalFilename = headImage.getOriginalFilename();
        //如果文件格式不为.jpg或.png则抛出异常
        if(!originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".png"))
            throw new XKException("头像图片的格式只能为.jpg或.png");
        //组装新的头像图片文件名 aid_日期.后缀
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = aid + "_" + dateName + postfix;
        //组装完整文件路径
        String fileSavePath = this.getRealPath() + HEAD_IMAGE_PATH + "/" + fileName;
        //保存文件
        try {
            headImage.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("文件保存时出错");
        }
        //删除原头像文件
        this.deletePreHeadImg(aid);

        //更新头像路径信息
        Admin admin = new Admin();
        admin.setAid(aid);
        admin.setAheadimg(fileName);
        adminMapper.updateByPrimaryKeySelective(admin);
        //返回执行成功信息(包含文件名称)
        return Result.OK(fileName);
    }

    @Override
    public Result deletePreHeadImg(Integer aid) {
        //获取原头像路径
        Admin preAdmin = adminMapper.selectByPrimaryKey(aid);
        if(!preAdmin.getAheadimg().equals("default.jpg")) {
            //如果不为默认图片则删除
            //组装完整文件路径
            String fileSavePath = getRealPath() + HEAD_IMAGE_PATH + "/" + preAdmin.getAheadimg();
            File headImgFile = new File(fileSavePath);
            if(headImgFile.exists()) {
                //如果文件存在则删除
                headImgFile.delete();
            }
        }
        return Result.OK();
    }

    @Override
    public Result uploadRtitleimg(MultipartFile rtitleimg) {
        //获取文件名
        String originalFilename = rtitleimg.getOriginalFilename();
        //如果文件格式不为.jpg或.png则抛出异常
        if(!originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".png"))
            throw new XKException("标题图片的格式只能为.jpg或.png");
        //生成新的文件名 日期_毫秒.后缀
        String fileName = createNewFileName(originalFilename);
        //组装完整文件路径
        String fileSavePath = getRealPath() + RESOURCE_TITLE_IMAGE_PATH + "/" + fileName;
        //保存文件
        try {
            rtitleimg.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("保存标题图片时出错");
        }
        //返回执行成功信息(包含文件名称)
        return Result.OK(fileName);
    }

    @Override
    public Result deleteResourceTitleImg(Integer rid) {
        //获取标题图路径
        Resource resource = resourceMapper.selectByPrimaryKey(rid);
        //组装完整文件路径
        String fileSavePath = getRealPath() + RESOURCE_TITLE_IMAGE_PATH + "/" + resource.getRtitleimg();
        File titleImgFile = new File(fileSavePath);
        if(titleImgFile.exists()) {
            //如果文件存在则删除
            titleImgFile.delete();
        }
        return Result.OK();
    }

    @Override
    public Result uploadRcwlogo(MultipartFile rcwlogo) {
        //获取文件名
        String originalFilename = rcwlogo.getOriginalFilename();
        //如果文件格式不为.jpg或.png则抛出异常
        if(!originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".png")
                && !originalFilename.toLowerCase().endsWith(".gif"))
            throw new XKException("Logo图片的格式只能为.jpg或.png或.gif");
        //生成新的文件名 日期_毫秒.后缀
        String fileName = createNewFileName(originalFilename);
        //组装完整文件路径
        String fileSavePath = this.getRealPath() + RESOURCE_COLUMN_WEBSITE_LOGO_PATH + "/" + fileName;
        //保存文件
        try {
            rcwlogo.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("保存资源网站Logo时出错");
        }
        //返回执行成功信息(包含文件名称)
        return Result.OK(fileName);
    }

    @Override
    public Result deleteResourceColumnWebsiteLogo(Integer rcwid) {
        //获取资源栏目网站对象
        ResourceColumnWebsite resourceColumnWebsite = resourceColumnWebsiteMapper.selectByPrimaryKey(rcwid);
        //组装完整文件路径
        String fileSavePath = getRealPath() + RESOURCE_COLUMN_WEBSITE_LOGO_PATH + "/" + resourceColumnWebsite.getRcwlogo();
        File titleImgFile = new File(fileSavePath);
        if(titleImgFile.exists()) {
            //如果文件存在则删除
            titleImgFile.delete();
        }
        return Result.OK();
    }

    /**
     * 该方法用于获取项目在系统中的真实路径
     */
    private String getRealPath() {
        if(realPath == null) {
            //如果是服务端
//            realPath = new File(httpSession.getServletContext().getRealPath("")).getParentFile().getPath() + "/resource/";
//            System.out.println("realPath:" + realPath);
            //本地端
            realPath = "F:\\apache-tomcat-7.0.52\\webapps\\resource\\";
        }
        return realPath;
    }

    /**
     * 该方法用于生成文件名称
     * @param originalFilename 原文件名
     */
    private String createNewFileName(String originalFilename) {
        //生成新的文件名 日期_毫秒.后缀
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String millName = System.currentTimeMillis() + "";
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = dateName + "_" + millName + postfix;

        return fileName;
    }

}
