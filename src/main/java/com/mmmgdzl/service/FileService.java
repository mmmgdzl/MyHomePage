package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * �ϴ�ͷ��
     */
    Result updateHeadImage(MultipartFile headImage, Integer aid);

    /**
     * �ϴ���Դ����ͼ
     */
    Result uploadRtitleimg(MultipartFile rtitleimg);

    /**
     * ���ݹ���Աaidɾ��ԭͷ��
     */
    Result deletePreHeadImg(Integer aid);

    /**
     * ������Դridɾ������ͼ
     */
    Result deleteResourceTitleImg(Integer rid);
}
