package com.mmmgdzl.service.impl;

import com.mmmgdzl.service.FileService;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.mapper.ResourceMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
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
public class FileServiceImpl implements FileService {

    @Value("${HEAD_IMAGE_PATH}")
    private String HEAD_IMAGE_PATH;
    @Value("${RESOURCE_TITLE_IMAGE_PATH}")
    private String RESOURCE_TITLE_IMAGE_PATH;

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    //��session���ڷ������汾��ȡ��ʵ·��
    @Autowired
    private HttpSession httpSession;

    /**
     * ��Ŀ��ϵͳ�е���ʵ·��(����ֱ��ʹ��)
     */
    private String realPath = null;

    @Override
    public Result updateHeadImage(MultipartFile headImage, Integer aid) {
        //��ȡ�ļ���
        String originalFilename = headImage.getOriginalFilename();
        //����ļ���ʽ��Ϊ.jpg��.png���׳��쳣
        if(!originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".png"))
            throw new XKException("ͷ��ͼƬ�ĸ�ʽֻ��Ϊ.jpg��.png");
        //��װ�µ�ͷ��ͼƬ�ļ��� aid_����.��׺
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = aid + "_" + dateName + postfix;
        //��װ�����ļ�·��
        String fileSavePath = this.getRealPath() + HEAD_IMAGE_PATH + "/" + fileName;
        //�����ļ�
        try {
            headImage.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("�ļ�����ʱ����");
        }
        //ɾ��ԭͷ���ļ�
        this.deletePreHeadImg(aid);

        //����ͷ��·����Ϣ
        Admin admin = new Admin();
        admin.setAid(aid);
        admin.setAheadimg(fileName);
        adminMapper.updateByPrimaryKeySelective(admin);
        //����ִ�гɹ���Ϣ(�����ļ�����)
        return Result.OK(fileName);
    }

    @Override
    public Result deletePreHeadImg(Integer aid) {
        //��ȡԭͷ��·��
        Admin preAdmin = adminMapper.selectByPrimaryKey(aid);
        if(!preAdmin.getAheadimg().equals("default.jpg")) {
            //�����ΪĬ��ͼƬ��ɾ��
            //��װ�����ļ�·��
            String fileSavePath = getRealPath() + HEAD_IMAGE_PATH + "/" + preAdmin.getAheadimg();
            File headImgFile = new File(fileSavePath);
            if(headImgFile.exists()) {
                //����ļ�������ɾ��
                headImgFile.delete();
            }
        }
        return Result.OK();
    }

    @Override
    public Result uploadRtitleimg(MultipartFile rtitleimg) {
        //��ȡ�ļ���
        String originalFilename = rtitleimg.getOriginalFilename();
        //����ļ���ʽ��Ϊ.jpg��.png���׳��쳣
        if(!originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".png"))
            throw new XKException("ͷ��ͼƬ�ĸ�ʽֻ��Ϊ.jpg��.png");
        //��װ�µ��ļ��� ����_����.��׺
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateName = simpleDateFormat.format(new Date());
        String millName = System.currentTimeMillis() + "";
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = dateName + "_" + millName + postfix;
        //��װ�����ļ�·��
        String fileSavePath = getRealPath() + RESOURCE_TITLE_IMAGE_PATH + "/" + fileName;
        //�����ļ�
        try {
            rtitleimg.transferTo(new File(fileSavePath));
        } catch (IOException e) {
            throw new XKException("�������ͼƬʱ����");
        }
        //����ִ�гɹ���Ϣ(�����ļ�����)
        return Result.OK(fileName);
    }

    @Override
    public Result deleteResourceTitleImg(Integer rid) {
        //��ȡ����ͼ·��
        Resource resource = resourceMapper.selectByPrimaryKey(rid);
        //��װ�����ļ�·��
        String fileSavePath = getRealPath() + RESOURCE_TITLE_IMAGE_PATH + "/" + resource.getRtitleimg();
        File titleImgFile = new File(fileSavePath);
        if(titleImgFile.exists()) {
            //����ļ�������ɾ��
            titleImgFile.delete();
        }
        return Result.OK();
    }

    /**
     * �÷������ڻ�ȡ��Ŀ��ϵͳ�е���ʵ·��
     */
    private String getRealPath() {
        if(realPath == null) {
            //����Ƿ����
//            realPath = new File(httpSession.getServletContext().getRealPath("")).getParentFile().getPath() + "/resource/";
//            System.out.println("realPath:" + realPath);
            //���ض�
            realPath = "F:\\apache-tomcat-7.0.52\\webapps\\resource\\";
        }
        return realPath;
    }
}
