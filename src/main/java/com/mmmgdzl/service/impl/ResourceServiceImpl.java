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

import java.text.SimpleDateFormat;
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
            //若没有指定资源状态则设置只显示可见资源
            if(resource.getRenable() != null)
                criteria.andRenableEqualTo(resource.getRenable());
            else
                criteria.andRenableNotEqualTo(2);
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
    public LayUIResource renderResourceForLayUI(Resource resource, boolean isAname) {
        LayUIResource layUIResource = new LayUIResource();
        //执行渲染
        layUIResource.setRid(resource.getRid());
        layUIResource.setRtitle(resource.getRtitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResource.setRcreatedate(sdf.format(resource.getRcreatedate()));
        layUIResource.setRupdatedate(sdf.format(resource.getRupdatedate()));
        layUIResource.setRviews(resource.getRviews());
        if(resource.getRenable() == 0) {
            layUIResource.setRenable("不可用");
        } else if(resource.getRenable() == 1) {
            layUIResource.setRenable("可用");
        } else if(resource.getRenable() == 2) {
            layUIResource.setRenable("删除");
        }
        layUIResource.setRcontent(resource.getRcontent());
        layUIResource.setRtitleimg(resource.getRtitleimg());
        //渲染创建人和修改人
        if(isAname) {
            layUIResource.setRcreater(superService.selectAdminById(resource.getRcreater()).getAname());
            layUIResource.setRupdater(superService.selectAdminById(resource.getRupdater()).getAname());
        } else {
            layUIResource.setRcreater(superService.selectAdminById(resource.getRcreater()).getAaccount());
            layUIResource.setRupdater(superService.selectAdminById(resource.getRupdater()).getAaccount());
        }
        //渲染栏目名
        layUIResource.setRcolumn(resourceColumnService.selectResourceColumnByCid(resource.getRcolumn()).getCname());
        return layUIResource;
    }

    @Override
    public List<LayUIResource> renderResourcesForLayUI(List<Resource> resources, boolean isAname) {
        //执行数据渲染
        List<LayUIResource> resourceList = new ArrayList<>();
        for(Resource resource : resources) {
            resourceList.add(this.renderResourceForLayUI(resource,isAname));
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
        Resource deleteResource = new Resource();
        deleteResource.setRenable(2);
        for(Integer id : idList) {
            //删除资源对应的标题图片
            fileService.deleteResourceTitleImg(id);
            //删除资源(逻辑删除)
            deleteResource.setRid(id);
            resourceMapper.updateByPrimaryKeySelective(deleteResource);
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

    @Override
    public Resource selectResourceById(Integer id) {
        return resourceMapper.selectByPrimaryKey(id);
    }
}
