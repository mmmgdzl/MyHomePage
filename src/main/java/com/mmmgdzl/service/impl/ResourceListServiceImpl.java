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
        //创建查询模板
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //添加查询条件
        criteria.andRcolumnEqualTo(cid);
        //查询可见资源
        criteria.andRenableEqualTo(1);
        //设置排序
        resourceExample.setOrderByClause("rupdatedate desc, rviews desc, rid desc");

        //创建PageBean
        ResourceListPageBean<LayUIResource> pageBean = new ResourceListPageBean<>();
        pageBean.setCurrentPage(currenetPage);
        pageBean.setPageSize(pageSize);

        //设置分页
        PageHelper.startPage(currenetPage, pageSize);

        //执行查询
        List<Resource> resources = resourceMapper.selectByExampleWithBLOBs(resourceExample);

        //获取页面信息
        PageInfo<Resource> pageInfo = new PageInfo<>(resources);
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setTotalNum((int)pageInfo.getTotal());

        //执行数据渲染
        List<LayUIResource> resourceList = resourceService.renderResourcesForLayUI(resources);

        //将列表放入PageBean
        pageBean.setData(resourceList);

        return pageBean;
    }

    @Override
    public List<LayUIResource> getHot(Integer topNum) {
        //创建查询模板
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //查询可见资源
        criteria.andRenableEqualTo(1);
        //设置排序
        resourceExample.setOrderByClause("rviews desc, rupdatedate desc, rid desc");
        //设置分页
        PageHelper.startPage(1, topNum);
        //执行查询
        List<Resource> resources = resourceMapper.selectByExample(resourceExample);
        //执行数据渲染
        List<LayUIResource> resourceList = resourceService.renderResourcesForLayUI(resources);
        return resourceList;
    }

    @Override
    public Resource getResourceInfo(Integer rid) {
        //创建查询模板
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //设置查询条件
        criteria.andRidEqualTo(rid);
        //查询可见资源
        criteria.andRenableEqualTo(1);
        //获取资源
        List<Resource> resources = resourceMapper.selectByExampleWithBLOBs(resourceExample);
        //如果结果为空
        if(resources.size() == 0)
            return null;

        //资源浏览量+1
        resourceViewCountUP(rid);

        return resources.get(0);
    }

    /**
     * 资源浏览量+1
     */
    private void resourceViewCountUP(Integer id) {
        //执行查询
        Resource resource = resourceMapper.selectByPrimaryKey(id);
        //执行+1
        Resource resource1 = new Resource();
        resource1.setRid(id);
        resource1.setRviews(resource.getRviews()+1);
        resourceMapper.updateByPrimaryKeySelective(resource1);
    }

//    /**
//     * 截取摘要
//     */
//    private String getPreviewContent(String rcontent) {
//        System.out.println(rcontent);
//        //去除image标签
//        rcontent = rcontent.replaceAll("<\\s*img\\s+([^>]*)\\s*>", "");
//        System.out.println("after" + rcontent);
//        return rcontent;
//    }

    @Override
    public Integer count(ResourceExample resourceExample) {
        return null;
    }
}
