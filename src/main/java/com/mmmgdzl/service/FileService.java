package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传头像
     */
    Result updateHeadImage(MultipartFile headImage, Integer aid);

    /**
     * 根据管理员aid删除原头像
     */
    Result deletePreHeadImg(Integer aid);

    /**
     * 上传资源标题图
     */
    Result uploadRtitleimg(MultipartFile rtitleimg);

    /**
     * 根据资源rid删除标题图
     */
    Result deleteResourceTitleImg(Integer rid);

    /**
     * 上传资源栏目网站logo
     */
    Result uploadRcwlogo(MultipartFile rcwlogo);

    /**
     * 根据资源栏目网站rcwid删除资源栏目网站logo
     */
    Result deleteResourceColumnWebsiteLogo(Integer rcwid);

    /**
     * 上传系统资源
     */
    Result uploadSystemResource(MultipartFile srfile);

    /**
     * 根据系统资源srid删除系统资源
     */
    Result deleteSystemResourceBySrid(Integer srid);

}
