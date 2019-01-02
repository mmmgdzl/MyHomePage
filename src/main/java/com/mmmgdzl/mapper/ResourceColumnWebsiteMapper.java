package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.ResourceColumnWebsite;
import com.mmmgdzl.pojo.ResourceColumnWebsiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceColumnWebsiteMapper {
    int countByExample(ResourceColumnWebsiteExample example);

    int deleteByExample(ResourceColumnWebsiteExample example);

    int deleteByPrimaryKey(Integer rcwid);

    int insert(ResourceColumnWebsite record);

    int insertSelective(ResourceColumnWebsite record);

    List<ResourceColumnWebsite> selectByExample(ResourceColumnWebsiteExample example);

    ResourceColumnWebsite selectByPrimaryKey(Integer rcwid);

    int updateByExampleSelective(@Param("record") ResourceColumnWebsite record, @Param("example") ResourceColumnWebsiteExample example);

    int updateByExample(@Param("record") ResourceColumnWebsite record, @Param("example") ResourceColumnWebsiteExample example);

    int updateByPrimaryKeySelective(ResourceColumnWebsite record);

    int updateByPrimaryKey(ResourceColumnWebsite record);
}