package com.mmmgdzl.service.impl;

import com.mmmgdzl.domain.ResourceListPageBean;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceListService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.PageBean;
import com.mmmgdzl.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceListServiceImpl implements ResourceListService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceColumnService resourceColumnService;
    @Autowired
    private SuperService superService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public ResourceListPageBean<LayUIResource> getResourceListWithBlobs(Integer cid, Integer currenetPage, Integer pageSize) {
        //������ѯģ��
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //��Ӳ�ѯ����
        criteria.andRcolumnEqualTo(cid);
        //��ѯ�ɼ���Դ
        criteria.andRenableEqualTo(1);
        //��������
        resourceExample.setOrderByClause("rupdatedate desc, rviews desc, rid desc");

        //����PageBean
        ResourceListPageBean<LayUIResource> pageBean = new ResourceListPageBean<>();
        pageBean.setCurrentPage(currenetPage);
        pageBean.setPageSize(pageSize);

        //���÷�ҳ
        PageHelper.startPage(currenetPage, pageSize);

        //ִ�в�ѯ
        List<Resource> resources = resourceMapper.selectByExampleWithBLOBs(resourceExample);

        //��ȡҳ����Ϣ
        PageInfo<Resource> pageInfo = new PageInfo<>(resources);
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setTotalNum((int)pageInfo.getTotal());

        //ִ��������Ⱦ
        List<LayUIResource> resourceList = resourceService.renderResourcesForLayUI(resources);

        //���б����PageBean
        pageBean.setData(resourceList);

        return pageBean;
    }

    @Override
    public List<LayUIResource> getHot(Integer topNum) {
        //������ѯģ��
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //��ѯ�ɼ���Դ
        criteria.andRenableEqualTo(1);
        //��������
        resourceExample.setOrderByClause("rviews desc, rupdatedate desc, rid desc");
        //���÷�ҳ
        PageHelper.startPage(1, topNum);
        //ִ�в�ѯ
        List<Resource> resources = resourceMapper.selectByExample(resourceExample);
        //ִ��������Ⱦ
        List<LayUIResource> resourceList = resourceService.renderResourcesForLayUI(resources);
        return resourceList;
    }

    @Override
    public Resource getResourceInfo(Integer rid) {
        //������ѯģ��
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //���ò�ѯ����
        criteria.andRidEqualTo(rid);
        //��ѯ�ɼ���Դ
        criteria.andRenableEqualTo(1);
        //��ȡ��Դ
        List<Resource> resources = resourceMapper.selectByExampleWithBLOBs(resourceExample);
        //������Ϊ��
        if(resources.size() == 0)
            return null;

        //��Դ�����+1
        resourceViewCountUP(rid);

        return resources.get(0);
    }

    /**
     * ��Դ�����+1
     */
    private void resourceViewCountUP(Integer id) {
        //ִ�в�ѯ
        Resource resource = resourceMapper.selectByPrimaryKey(id);
        //ִ��+1
        Resource resource1 = new Resource();
        resource1.setRid(id);
        resource1.setRviews(resource.getRviews()+1);
        resourceMapper.updateByPrimaryKeySelective(resource1);
    }

//    /**
//     * ��ȡժҪ
//     */
//    private String getPreviewContent(String rcontent) {
//        System.out.println(rcontent);
//        //ȥ��image��ǩ
//        rcontent = rcontent.replaceAll("<\\s*img\\s+([^>]*)\\s*>", "");
//        System.out.println("after" + rcontent);
//        return rcontent;
//    }

    @Override
    public Integer count(ResourceExample resourceExample) {
        return null;
    }
}
