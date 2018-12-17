package com.mmmgdzl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.mapper.GameWebsiteCatMapper;
import com.mmmgdzl.pojo.GameWebsiteCat;
import com.mmmgdzl.pojo.GameWebsiteCatExample;
import com.mmmgdzl.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameWebsiteCatMapper gameWebsiteCatMapper;

	@Override
	public List<GameWebsiteCat> getGameWebSiteCatList() {
		//设置分页(取top10)
        PageHelper.startPage(1, 10);
		//创建空查询条件
		GameWebsiteCatExample example = new GameWebsiteCatExample();
		//执行查询获得列表
		List<GameWebsiteCat> resultList = gameWebsiteCatMapper.selectByExample(example);
		return resultList;
	}
	
	
	
}
