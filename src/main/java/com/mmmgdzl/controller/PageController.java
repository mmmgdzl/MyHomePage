package com.mmmgdzl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mmmgdzl.domain.ResourceInfoPageBean;
import com.mmmgdzl.domain.ResourceListPageBean;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.*;
import com.mmmgdzl.domain.LayUIResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@Autowired
	private ResourceListService resourceListService;
	@Autowired
	private ResourceColumnService resourceColumnService;
	@Autowired
	private ResourceColumnWebsiteServcie resourceColumnWebsiteServcie;
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
		//创建资源详情页面对象
        ResourceInfoPageBean<LayUIResource> resourceInfoPageBean = new ResourceInfoPageBean<>();
		//获取资源数据
		Resource resource = resourceListService.getResourceInfo(rid);
		//获取创建者数据
		Admin creater = superService.selectAdminById(resource.getRcreater());
		//渲染创建者个人介绍
		superService.renderAdminIntroduce(creater);
		resourceInfoPageBean.setCreater(creater);
		//如果修改者与创建者不一致
		if(resource.getRcreater() != resource.getRupdater()) {
			Admin updater = superService.selectAdminById(resource.getRupdater());
			//渲染修改者个人介绍
			superService.renderAdminIntroduce(creater);
			resourceInfoPageBean.setUpdater(updater);
		}
		//将资源数据进行渲染
		LayUIResource resourceInfo = resourceService.renderResourceForLayUI(resource, true);
		resourceInfoPageBean.setData(resourceInfo);

		//将数据放入model中
		model.addAttribute("pageBean", resourceInfoPageBean);

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

		//获取头部资源栏目列表
		List<ResourceColumn> headerResourceColumnList = resourceColumnService.getHeaderResourceColumns();
		//获取资源栏目网站列表
		Map<Integer, List<ResourceColumnWebsite>> resourceColumnWebsiteMap = new HashMap<>();
		for(ResourceColumn resourceColumn : headerResourceColumnList) {
			resourceColumnWebsiteMap.put(resourceColumn.getCid(), resourceColumnWebsiteServcie.getResourceColumnWebsiteByCid(resourceColumn.getCid()));
		}
		//将参数放入模型中
		model.addAttribute("headerResourceColumnList", headerResourceColumnList);
		model.addAttribute("resourceColumnWebsiteMap", resourceColumnWebsiteMap);
	}
}
