package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传头像
     */
    Result updateHeadImage(MultipartFile headImage, Integer aid);

    /**
     * 上传资源标题图
     */
    Result uploadRtitleimg(MultipartFile rtitleimg);

    /**
     * 根据管理员aid删除原头像
     */
    Result deletePreHeadImg(Integer aid);

    /**
     * 根据资源rid删除标题图
     */
    Result deleteResourceTitleImg(Integer rid);
}
