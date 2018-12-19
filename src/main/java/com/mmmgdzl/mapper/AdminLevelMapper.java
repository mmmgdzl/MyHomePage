package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.AdminLevel;
import com.mmmgdzl.pojo.AdminLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLevelMapper {
    int countByExample(AdminLevelExample example);

    int deleteByExample(AdminLevelExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(AdminLevel record);

    int insertSelective(AdminLevel record);

    List<AdminLevel> selectByExample(AdminLevelExample example);

    AdminLevel selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") AdminLevel record, @Param("example") AdminLevelExample example);

    int updateByExample(@Param("record") AdminLevel record, @Param("example") AdminLevelExample example);

    int updateByPrimaryKeySelective(AdminLevel record);

    int updateByPrimaryKey(AdminLevel record);
}