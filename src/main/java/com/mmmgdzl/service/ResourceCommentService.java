package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;

import java.util.List;

public interface ResourceCommentService {

    /**
     * 添加一条评论
     */
    Result addResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * 将ResourceComment对象转换为查询模板对象
     */
    ResourceCommentExample transformResourceCommentToTesourceCommentExample(ResourceComment resourceComment);

    /**
     * 根据查询条件查询一组资源评论
     */
    List<ResourceComment> selectResourceComments(ResourceCommentExample resourceCommentExample, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * 根据查询条件查询一组资源评论
     */
    List<ResourceComment> selectResourceComments(ResourceComment resourceComment, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * 根据查询条件统计条数
     */
    Integer countResourceComment(ResourceCommentExample resourceCommentExample, Admin currentAdmin);

    /**
     * 根据查询条件统计条数
     */
    Integer countResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * 将ResourceComment对象渲染为LayUIResourceComment对象
     */
    LayUIResourceComment renderResourceCommentForLayUI(ResourceComment resourceComment, boolean isForBackground);

    /**
     * 将一组ResourceComment对象渲染为LayUIResourceComment对象
     */
    List<LayUIResourceComment> renderResourceCommentsForLayUI(List<ResourceComment> resourceComments, boolean isForBackground);

    /**
     * 更新资源评论
     */
    Result updateResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * 根据id列表删除评论
     */
    Result deleteResourceCommentsByIds(List<Integer> idList);

    /**
     * 获取当前资源的评论的最大评论楼层数
     */
    Integer getMaxRccount(Integer rid);

}
