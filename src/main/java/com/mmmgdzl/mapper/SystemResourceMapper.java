package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.pojo.SystemResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemResourceMapper {
    int countByExample(SystemResourceExample example);

    int deleteByExample(SystemResourceExample example);

    int deleteByPrimaryKey(Integer srid);

    int insert(SystemResource record);

    int insertSelective(SystemResource record);

    List<SystemResource> selectByExample(SystemResourceExample example);

    SystemResource selectByPrimaryKey(Integer srid);

    int updateByExampleSelective(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByExample(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByPrimaryKeySelective(SystemResource record);

    int updateByPrimaryKey(SystemResource record);
}