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
		//���÷�ҳ(ȡtop10)
        PageHelper.startPage(1, 10);
		//�����ղ�ѯ����
		GameWebsiteCatExample example = new GameWebsiteCatExample();
		//ִ�в�ѯ����б�
		List<GameWebsiteCat> resultList = gameWebsiteCatMapper.selectByExample(example);
		return resultList;
	}
	
	
	
}
