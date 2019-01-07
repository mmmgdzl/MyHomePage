package com.mmmgdzl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmmgdzl.domain.*;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	@Autowired
	private ResourceListService resourceListService;
	@Autowired
	private ResourceColumnService resourceColumnService;
	@Autowired
	private ResourceCommentService resourceCommentService;
	@Autowired
	private ResourceColumnWebsiteServcie resourceColumnWebsiteServcie;
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
		resourceInfoPageBean.setResourceColumn(resource.getRcolumn());
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
     * ��ȡ��Դ������������
     */
    @RequestMapping("/resourceInfo/resourceComments")
    @ResponseBody
    public ResourceCommentPageBean getResourceComments(Integer rid, Model model,
                                                       @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        ResourceCommentPageBean resourceCommentPageBean = new ResourceCommentPageBean();
        //��ȡ��Դ��������
        ResourceComment resourceComment = new ResourceComment();
        resourceComment.setRcresource(rid);
        resourceComment.setRcenable(1);
        ResourceCommentExample resourceCommentExample = resourceCommentService.transformResourceCommentToTesourceCommentExample(resourceComment);
        //����ʱ�䵹��
        resourceCommentExample.setOrderByClause("rccreatedate desc");
        //��ȡ��Դ����ҳ����
        List<ResourceComment> resourceCommentList = resourceCommentService.selectResourceComments(resourceCommentExample, currentPage, pageSize, null);
        PageInfo<ResourceComment> pageInfo = new PageInfo<>(resourceCommentList);
        resourceCommentPageBean.setRcCount((int) pageInfo.getTotal());
        resourceCommentPageBean.setRcTotalPage(pageInfo.getPages());
        resourceCommentPageBean.setRcCurrentPage(currentPage);
        resourceCommentPageBean.setRcPageSize(pageSize);
        //��ȡ��Դ�����û�����
        for(ResourceComment rc : resourceCommentList) {
            resourceCommentPageBean.getResourceCommentAdminMap().put(rc.getRcid(), superService.selectAdminById(rc.getRccreater()));
        }
        //��Ⱦ��Դ����
        List<LayUIResourceComment> layUIResourceCommentList = resourceCommentService.renderResourceCommentsForLayUI(resourceCommentList, false);
        resourceCommentPageBean.setResourceCommentList(layUIResourceCommentList);

        return resourceCommentPageBean;
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
