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
		//������Դ����ҳ�����
        ResourceInfoPageBean<LayUIResource> resourceInfoPageBean = new ResourceInfoPageBean<>();
		//��ȡ��Դ����
		Resource resource = resourceListService.getResourceInfo(rid);
		//��ȡ����������
		Admin creater = superService.selectAdminById(resource.getRcreater());
		//��Ⱦ�����߸��˽���
		superService.renderAdminIntroduce(creater);
		resourceInfoPageBean.setCreater(creater);
		//����޸����봴���߲�һ��
		if(resource.getRcreater() != resource.getRupdater()) {
			Admin updater = superService.selectAdminById(resource.getRupdater());
			//��Ⱦ�޸��߸��˽���
			superService.renderAdminIntroduce(creater);
			resourceInfoPageBean.setUpdater(updater);
		}
		//����Դ���ݽ�����Ⱦ
		LayUIResource resourceInfo = resourceService.renderResourceForLayUI(resource, true);
		resourceInfoPageBean.setData(resourceInfo);

		//�����ݷ���model��
		model.addAttribute("pageBean", resourceInfoPageBean);

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

		//��ȡͷ����Դ��Ŀ�б�
		List<ResourceColumn> headerResourceColumnList = resourceColumnService.getHeaderResourceColumns();
		//��ȡ��Դ��Ŀ��վ�б�
		Map<Integer, List<ResourceColumnWebsite>> resourceColumnWebsiteMap = new HashMap<>();
		for(ResourceColumn resourceColumn : headerResourceColumnList) {
			resourceColumnWebsiteMap.put(resourceColumn.getCid(), resourceColumnWebsiteServcie.getResourceColumnWebsiteByCid(resourceColumn.getCid()));
		}
		//����������ģ����
		model.addAttribute("headerResourceColumnList", headerResourceColumnList);
		model.addAttribute("resourceColumnWebsiteMap", resourceColumnWebsiteMap);
	}
}
