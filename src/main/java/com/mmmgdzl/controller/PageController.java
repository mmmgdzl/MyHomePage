package com.mmmgdzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmmgdzl.pojo.GameWebsiteCat;
import com.mmmgdzl.service.GameService;

@Controller
public class PageController {

	@Autowired
	private GameService gameService;
	
	/**
	 * 跳转到前端首页
	 */
	@RequestMapping("/")
	public String toHomePage(Model model) {
		//获取游戏预览列表
		List<GameWebsiteCat> gameWebSiteCatList = gameService.getGameWebSiteCatList();
		
		//将参数放入模型中
		model.addAttribute("gameWebSiteCatList", gameWebSiteCatList);
		
		return "index";
	}
	
	/**
	 * 跳转到对应页面
	 */
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		return page;
	}
}
