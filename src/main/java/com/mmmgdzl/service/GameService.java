package com.mmmgdzl.service;

import java.util.List;

import com.mmmgdzl.pojo.GameWebsiteCat;

public interface GameService {
	
	/**
	 * 获取游戏资源概览列表
	 */
	List<GameWebsiteCat> getGameWebSiteCatList();
}
