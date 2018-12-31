package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.ResourceMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.service.FileService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 该Service提供资源管理服务
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private SuperService superService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ResourceColumnService resourceColumnService;

    @Override
    public Result addResource(Resource resource, Integer aid) {
        //填充数据
        resource.setRid(0);
        resource.setRcreatedate(new Date());
        resource.setRcreater(aid);
        resource.setRupdatedate(new Date());
        resource.setRupdater(aid);
        resource.setRviews(0);
        resource.setRenable(1);
        //执行插入
        resourceMapper.insert(resource);
        return Result.OK();
    }

    @Override
    public ResourceExample transformResourceToResourceExample(Resource resource, Admin currentAdmin) {
        //创建查询模板
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //添加查询条件
        if(resource != null) {
            //清除空白条件
            ClearBlankUtil.clearStringBlank(resource);
            //添加查询条件
            if(resource.getRtitle() != null)
                criteria.andRtitleLike("%" + resource.getRtitle() + "%");
            if(resource.getRcolumn() != null)
                criteria.andRcolumnEqualTo(resource.getRcolumn());
            if(resource.getRcreater() != null)
                criteria.andRcreaterEqualTo(resource.getRcreater());
            if(resource.getRenable() != null)
                criteria.andRenableEqualTo(resource.getRenable());
        }
        //如果当前用户不为管理员级别则只能看到自己的资源
        if(currentAdmin != null && currentAdmin.getAlevel() >= 2) {
            criteria.andRcreaterEqualTo(currentAdmin.getAid());
        }

        //返回查询模板对象
        return resourceExample;
    }

    @Override
    public List<Resource> selectResources(ResourceExample resourceExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //设置分页
            PageHelper.startPage(currentPage, pageSize);
        }
        //执行查询并返回
        return resourceMapper.selectByExample(resourceExample);
    }

    @Override
    public List<Resource> selectResources(Resource resource, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //将资源对象转换为查询模板对象
        ResourceExample resourceExample = this.transformResourceToResourceExample(resource, currentAdmin);
        //执行查询并返回
        return selectResources(resourceExample, currentPage, pageSize);
    }

    @Override
    public Integer count(ResourceExample resourceExample) {
        //执行统计并返回
        return resourceMapper.countByExample(resourceExample);
    }

    @Override
    public Integer count(Resource resource, Admin currentAdmin) {
        //将资源对象转换为查询模板对象
        ResourceExample resourceExample = this.transformResourceToResourceExample(resource, currentAdmin);
        //执行统计并返回
        return count(resourceExample);
    }

    @Override
    public LayUIResource renderResourceForLayUI(Resource resource) {
        LayUIResource layUIResource = new LayUIResource(resource);
        //渲染创建人和修改人
        layUIResource.setRcreater(superService.selectAdminById(resource.getRcreater()).getAname());
        layUIResource.setRupdater(superService.selectAdminById(resource.getRupdater()).getAname());
        //渲染栏目名
        layUIResource.setRcolumn(resourceColumnService.selectResourceColumnByCid(resource.getRcolumn()).getCname());
        return layUIResource;
    }

    @Override
    public List<LayUIResource> renderResourcesForLayUI(List<Resource> resources) {
        //执行数据渲染
        List<LayUIResource> resourceList = new ArrayList<>();
        for(Resource resource : resources) {
            LayUIResource layUIResource = this.renderResourceForLayUI(resource);
            //添加到列表
            resourceList.add(layUIResource);
        }
        return resourceList;
    }

    @Override
    public Result updateResource(Resource resource, Integer aid) {
        //清除空数据
        ClearBlankUtil.clearStringBlank(resource);
        //填充数据
        resource.setRupdater(aid);
        resource.setRupdatedate(new Date());
        //执行更新
        resourceMapper.updateByPrimaryKeySelective(resource);
        return Result.OK();
    }

    @Override
    public Result deleteResourcesByIds(List<Integer> idList) {
        for(Integer id : idList) {
            //删除资源对应的标题图片
            fileService.deleteResourceTitleImg(id);
            //删除资源
            resourceMapper.deleteByPrimaryKey(id);
        }
        return Result.OK();
    }

    @Override
    public Resource selectResourceByIdBlob(Integer id) {
        //创建条件模板
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //添加查询条件
        criteria.andRidEqualTo(id);
        //执行查询
        List<Resource> resources = resourceMapper.selectByExampleWithBLOBs(resourceExample);
        if(resources.size() == 0)
            return null;
        else
            return resources.get(0);
    }
}
