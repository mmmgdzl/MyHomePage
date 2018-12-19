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
	 * ��ת��ǰ����ҳ
	 */
	@RequestMapping("/")
	public String toHomePage(Model model) {
		//����head�е��б�
		setHeadAttribute(model);
		return "index";
	}
	
	/**
	 * ��ת����Ӧҳ��
	 */
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page, Model model) {
		//����head�е��б�
		setHeadAttribute(model);
		return page;
	}

	/**
	 * ����ͷ����Ϣ
	 */
	private void setHeadAttribute(Model model) {
		//��ȡ��ϷԤ���б�
		List<GameWebsiteCat> gameWebSiteCatList = gameService.getGameWebSiteCatList();

		//����������ģ����
		model.addAttribute("gameWebSiteCatList", gameWebSiteCatList);
	}
}
