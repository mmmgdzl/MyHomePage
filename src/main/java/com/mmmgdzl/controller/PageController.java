package com.mmmgdzl.controller;

import java.util.List;

import com.mmmgdzl.domain.ResourceListPageBean;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.GameWebsiteCat;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.PageBean;
import com.mmmgdzl.service.ResourceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmmgdzl.service.GameService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@Autowired
	private ResourceListService resourceListService;
	@Autowired
	private ResourceColumnService resourceColumnService;
	@Autowired
	private GameService gameService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private SuperService superService;
	
	/**
	 * 跳转到前端首页
	 */
	@RequestMapping("/")
	public String toHomePage(Model model) {
		//设置head中的列表
		setHeadAttribute(model);
		return "index";
	}
	
	/**
	 * 跳转到对应页面
	 */
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page, Model model) {
		//设置head中的列表
		setHeadAttribute(model);
		return page;
	}

	/**
	 * 跳转到对应资源页面
	 */
	@RequestMapping("/resourceList/{cid}")
	public String toResourceListPage(@PathVariable Integer cid, Model model,
									 @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
									 @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
		//获取资源页面数据
		ResourceListPageBean<LayUIResource> pageBean = resourceListService.getResourceListWithBlobs(cid, currentPage, pageSize);
		//设置页面主题
		pageBean.setType(resourceColumnService.selectResourceColumnByCid(cid).getCname());
		//将数据放入
		model.addAttribute("pageBean", pageBean);

		//获取前5热门数据
		List<LayUIResource> hot = resourceListService.getHot(5);
		//将数据放入
		model.addAttribute("hot", hot);

		//设置头数据
		setHeadAttribute(model);

		return "resourceList";
	}

	/**
	 * 跳转到对应资源详情页面
	 */
	@RequestMapping("/resourceInfo/{rid}")
	public String toResourceInfoPage(@PathVariable Integer rid, Model model) {
		//获取资源数据
		Resource resource = resourceListService.getResourceInfo(rid);
		//获取创建者数据
		Admin creater = superService.selectAdminById(resource.getRcreater());
		//渲染创建者个人介绍
		superService.renderAdminIntroduce(creater);
		//如果修改者与创建者不一致
		if(resource.getRcreater() != resource.getRupdater()) {
			Admin updater = superService.selectAdminById(resource.getRupdater());
			//渲染修改者个人介绍
			superService.renderAdminIntroduce(creater);
			model.addAttribute("updater", updater);
		}
		//将资源数据进行渲染
		LayUIResource resourceInfo = resourceService.renderResourceForLayUI(resource);

		//将数据放入model中
		model.addAttribute("resourceInfo", resourceInfo);
		model.addAttribute("creater", creater);


		//获取前5热门数据
		List<LayUIResource> hot = resourceListService.getHot(5);
		//将数据放入model中
		model.addAttribute("hot", hot);

		//设置头数据
		setHeadAttribute(model);

		return "resourceInfo";
	}

	/**
	 * 设置头部信息
	 */
	private void setHeadAttribute(Model model) {
		//获取游戏预览列表
		List<GameWebsiteCat> gameWebSiteCatList = gameService.getGameWebSiteCatList();
		//将参数放入模型中
		model.addAttribute("gameWebSiteCatList", gameWebSiteCatList);
	}
}
