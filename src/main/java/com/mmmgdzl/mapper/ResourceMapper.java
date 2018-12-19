package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    int countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExampleWithBLOBs(ResourceExample example);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKeyWithBLOBs(Resource record);

    int updateByPrimaryKey(Resource record);
}