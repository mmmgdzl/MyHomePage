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
	 * ��ת����Ӧ��Դҳ��
	 */
	@RequestMapping("/resourceList/{cid}")
	public String toResourceListPage(@PathVariable Integer cid, Model model,
									 @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
									 @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
		//��ȡ��Դҳ������
		ResourceListPageBean<LayUIResource> pageBean = resourceListService.getResourceListWithBlobs(cid, currentPage, pageSize);
		//����ҳ������
		pageBean.setType(resourceColumnService.selectResourceColumnByCid(cid).getCname());
		//�����ݷ���
		model.addAttribute("pageBean", pageBean);

		//��ȡǰ5��������
		List<LayUIResource> hot = resourceListService.getHot(5);
		//�����ݷ���
		model.addAttribute("hot", hot);

		//����ͷ����
		setHeadAttribute(model);

		return "resourceList";
	}

	/**
	 * ��ת����Ӧ��Դ����ҳ��
	 */
	@RequestMapping("/resourceInfo/{rid}")
	public String toResourceInfoPage(@PathVariable Integer rid, Model model) {
		//��ȡ��Դ����
		Resource resource = resourceListService.getResourceInfo(rid);
		//��ȡ����������
		Admin creater = superService.selectAdminById(resource.getRcreater());
		//��Ⱦ�����߸��˽���
		superService.renderAdminIntroduce(creater);
		//����޸����봴���߲�һ��
		if(resource.getRcreater() != resource.getRupdater()) {
			Admin updater = superService.selectAdminById(resource.getRupdater());
			//��Ⱦ�޸��߸��˽���
			superService.renderAdminIntroduce(creater);
			model.addAttribute("updater", updater);
		}
		//����Դ���ݽ�����Ⱦ
		LayUIResource resourceInfo = resourceService.renderResourceForLayUI(resource);

		//�����ݷ���model��
		model.addAttribute("resourceInfo", resourceInfo);
		model.addAttribute("creater", creater);


		//��ȡǰ5��������
		List<LayUIResource> hot = resourceListService.getHot(5);
		//�����ݷ���model��
		model.addAttribute("hot", hot);

		//����ͷ����
		setHeadAttribute(model);

		return "resourceInfo";
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
