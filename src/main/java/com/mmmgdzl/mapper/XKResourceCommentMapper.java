package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XKResourceCommentMapper {

    /**
     * ѡ��ĳλ�û�����Դ������
     */
    List<ResourceComment> selectAdminResourceCommentsByExample(ResourceCommentExample example, Integer adminId);

    /**
     * ͳ��ĳλ�û�����Դ
     */
    Integer countAdminResourceCommentsByExample(ResourceCommentExample example, Integer adminId);

    /**
     * ��ȡ��ǰ��Դ�����۵��������¥����
     */
    Integer getMaxRccount(Integer rid);

}