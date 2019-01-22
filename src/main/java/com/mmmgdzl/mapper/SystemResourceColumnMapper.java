package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.SystemResourceColumn;
import com.mmmgdzl.pojo.SystemResourceColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemResourceColumnMapper {
    int countByExample(SystemResourceColumnExample example);

    int deleteByExample(SystemResourceColumnExample example);

    int deleteByPrimaryKey(Integer srcid);

    int insert(SystemResourceColumn record);

    int insertSelective(SystemResourceColumn record);

    List<SystemResourceColumn> selectByExample(SystemResourceColumnExample example);

    SystemResourceColumn selectByPrimaryKey(Integer srcid);

    int updateByExampleSelective(@Param("record") SystemResourceColumn record, @Param("example") SystemResourceColumnExample example);

    int updateByExample(@Param("record") SystemResourceColumn record, @Param("example") SystemResourceColumnExample example);

    int updateByPrimaryKeySelective(SystemResourceColumn record);

    int updateByPrimaryKey(SystemResourceColumn record);
}