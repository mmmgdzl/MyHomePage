package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.DataIndex;
import com.mmmgdzl.pojo.DataIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataIndexMapper {
    int countByExample(DataIndexExample example);

    int deleteByExample(DataIndexExample example);

    int deleteByPrimaryKey(Integer diid);

    int insert(DataIndex record);

    int insertSelective(DataIndex record);

    List<DataIndex> selectByExample(DataIndexExample example);

    DataIndex selectByPrimaryKey(Integer diid);

    int updateByExampleSelective(@Param("record") DataIndex record, @Param("example") DataIndexExample example);

    int updateByExample(@Param("record") DataIndex record, @Param("example") DataIndexExample example);

    int updateByPrimaryKeySelective(DataIndex record);

    int updateByPrimaryKey(DataIndex record);
}