package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceCommentMapper {
    int countByExample(ResourceCommentExample example);

    int deleteByExample(ResourceCommentExample example);

    int deleteByPrimaryKey(Integer rcid);

    int insert(ResourceComment record);

    int insertSelective(ResourceComment record);

    List<ResourceComment> selectByExample(ResourceCommentExample example);

    ResourceComment selectByPrimaryKey(Integer rcid);

    int updateByExampleSelective(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    int updateByExample(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    int updateByPrimaryKeySelective(ResourceComment record);

    int updateByPrimaryKey(ResourceComment record);
}