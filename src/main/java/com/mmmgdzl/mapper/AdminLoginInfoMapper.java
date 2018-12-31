package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.AdminLoginInfo;
import com.mmmgdzl.pojo.AdminLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginInfoMapper {
    int countByExample(AdminLoginInfoExample example);

    int deleteByExample(AdminLoginInfoExample example);

    int deleteByPrimaryKey(Integer alid);

    int insert(AdminLoginInfo record);

    int insertSelective(AdminLoginInfo record);

    List<AdminLoginInfo> selectByExample(AdminLoginInfoExample example);

    AdminLoginInfo selectByPrimaryKey(Integer alid);

    int updateByExampleSelective(@Param("record") AdminLoginInfo record, @Param("example") AdminLoginInfoExample example);

    int updateByExample(@Param("record") AdminLoginInfo record, @Param("example") AdminLoginInfoExample example);

    int updateByPrimaryKeySelective(AdminLoginInfo record);

    int updateByPrimaryKey(AdminLoginInfo record);
}