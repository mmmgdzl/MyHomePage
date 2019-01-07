package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;

import java.util.List;

public interface ResourceCommentService {

    /**
     * ���һ������
     */
    Result addResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * ��ResourceComment����ת��Ϊ��ѯģ�����
     */
    ResourceCommentExample transformResourceCommentToTesourceCommentExample(ResourceComment resourceComment);

    /**
     * ���ݲ�ѯ������ѯһ����Դ����
     */
    List<ResourceComment> selectResourceComments(ResourceCommentExample resourceCommentExample, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * ���ݲ�ѯ������ѯһ����Դ����
     */
    List<ResourceComment> selectResourceComments(ResourceComment resourceComment, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * ���ݲ�ѯ����ͳ������
     */
    Integer countResourceComment(ResourceCommentExample resourceCommentExample, Admin currentAdmin);

    /**
     * ���ݲ�ѯ����ͳ������
     */
    Integer countResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * ��ResourceComment������ȾΪLayUIResourceComment����
     */
    LayUIResourceComment renderResourceCommentForLayUI(ResourceComment resourceComment, boolean isForBackground);

    /**
     * ��һ��ResourceComment������ȾΪLayUIResourceComment����
     */
    List<LayUIResourceComment> renderResourceCommentsForLayUI(List<ResourceComment> resourceComments, boolean isForBackground);

    /**
     * ������Դ����
     */
    Result updateResourceComment(ResourceComment resourceComment, Admin currentAdmin);

    /**
     * ����id�б�ɾ������
     */
    Result deleteResourceCommentsByIds(List<Integer> idList);

    /**
     * ��ȡ��ǰ��Դ�����۵��������¥����
     */
    Integer getMaxRccount(Integer rid);

}
