package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceColumnMapper {
    int countByExample(ResourceColumnExample example);

    int deleteByExample(ResourceColumnExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(ResourceColumn record);

    int insertSelective(ResourceColumn record);

    List<ResourceColumn> selectByExample(ResourceColumnExample example);

    ResourceColumn selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") ResourceColumn record, @Param("example") ResourceColumnExample example);

    int updateByExample(@Param("record") ResourceColumn record, @Param("example") ResourceColumnExample example);

    int updateByPrimaryKeySelective(ResourceColumn record);

    int updateByPrimaryKey(ResourceColumn record);
}