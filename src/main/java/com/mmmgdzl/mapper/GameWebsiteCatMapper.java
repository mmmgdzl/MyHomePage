package com.mmmgdzl.mapper;

import com.mmmgdzl.pojo.GameWebsiteCat;
import com.mmmgdzl.pojo.GameWebsiteCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameWebsiteCatMapper {
    int countByExample(GameWebsiteCatExample example);

    int deleteByExample(GameWebsiteCatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameWebsiteCat record);

    int insertSelective(GameWebsiteCat record);

    List<GameWebsiteCat> selectByExample(GameWebsiteCatExample example);

    GameWebsiteCat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameWebsiteCat record, @Param("example") GameWebsiteCatExample example);

    int updateByExample(@Param("record") GameWebsiteCat record, @Param("example") GameWebsiteCatExample example);

    int updateByPrimaryKeySelective(GameWebsiteCat record);

    int updateByPrimaryKey(GameWebsiteCat record);
}