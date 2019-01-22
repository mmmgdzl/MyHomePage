package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * �ϴ�ͷ��
     */
    Result updateHeadImage(MultipartFile headImage, Integer aid);

    /**
     * ���ݹ���Աaidɾ��ԭͷ��
     */
    Result deletePreHeadImg(Integer aid);

    /**
     * �ϴ���Դ����ͼ
     */
    Result uploadRtitleimg(MultipartFile rtitleimg);

    /**
     * ������Դridɾ������ͼ
     */
    Result deleteResourceTitleImg(Integer rid);

    /**
     * �ϴ���Դ��Ŀ��վlogo
     */
    Result uploadRcwlogo(MultipartFile rcwlogo);

    /**
     * ������Դ��Ŀ��վrcwidɾ����Դ��Ŀ��վlogo
     */
    Result deleteResourceColumnWebsiteLogo(Integer rcwid);

    /**
     * �ϴ�ϵͳ��Դ
     */
    Result uploadSystemResource(MultipartFile srfile);

    /**
     * ����ϵͳ��Դsridɾ��ϵͳ��Դ
     */
    Result deleteSystemResourceBySrid(Integer srid);

}
