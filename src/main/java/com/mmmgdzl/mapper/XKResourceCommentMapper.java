package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XKResourceCommentMapper {

    /**
     * 选择某位用户的资源的评论
     */
    List<ResourceComment> selectAdminResourceCommentsByExample(ResourceCommentExample example, Integer adminId);

    /**
     * 统计某位用户的资源
     */
    Integer countAdminResourceCommentsByExample(ResourceCommentExample example, Integer adminId);

    /**
     * 获取当前资源的评论的最大评论楼层数
     */
    Integer getMaxRccount(Integer rid);

}