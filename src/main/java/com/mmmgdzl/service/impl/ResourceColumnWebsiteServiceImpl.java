package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceColumnWebsite;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.ResourceColumnWebsiteMapper;
import com.mmmgdzl.pojo.ResourceColumnWebsite;
import com.mmmgdzl.pojo.ResourceColumnWebsiteExample;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceColumnWebsiteServcie;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceColumnWebsiteServiceImpl implements ResourceColumnWebsiteServcie {

    @Autowired
    private ResourceColumnWebsiteMapper resourceColumnWebsiteMapper;
    @Autowired
    private ResourceColumnService resourceColumnService;
    @Autowired
    private SuperService superService;
    @Autowired
    private FileService fileService;

    @Override
    public Result addResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite, Integer createrId) {
        //填充数据
        resourceColumnWebsite.setRcwid(0);
        resourceColumnWebsite.setRcwcreater(createrId);
        resourceColumnWebsite.setRcwcreatedate(new Date());
        resourceColumnWebsite.setRcwenable(1);

        //执行添加
        resourceColumnWebsiteMapper.insert(resourceColumnWebsite);
        return Result.OK();
    }

    @Override
    public ResourceColumnWebsiteExample transformResourceColumnWebsiteToResourceColumnWebsiteExample(ResourceColumnWebsite resourceColumnWebsite) {
        //创建查询模板对象
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = new ResourceColumnWebsiteExample();
        ResourceColumnWebsiteExample.Criteria criteria = resourceColumnWebsiteExample.createCriteria();

        //添加查询对象
        if(resourceColumnWebsite != null) {
            //清除空数据
            ClearBlankUtil.clearStringBlank(resourceColumnWebsite);
            if(resourceColumnWebsite.getRcwname() != null)
                criteria.andRcwnameLike("%" + resourceColumnWebsite.getRcwname() + "%");
            if(resourceColumnWebsite.getRcwhref() != null)
                criteria.andRcwhrefLike("%" + resourceColumnWebsite.getRcwhref() + "%");
            if(resourceColumnWebsite.getRcwcid() != null)
                criteria.andRcwcidEqualTo(resourceColumnWebsite.getRcwcid());
            if(resourceColumnWebsite.getRcwcreater() != null)
                criteria.andRcwcreaterEqualTo(resourceColumnWebsite.getRcwcreater());
            if(resourceColumnWebsite.getRcwenable() != null) {
                criteria.andRcwenableEqualTo(resourceColumnWebsite.getRcwenable());
            } else {
                criteria.andRcwenableNotEqualTo(2);
            }
        }
        return resourceColumnWebsiteExample;
    }

    @Override
    public List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample, Integer currentPage, Integer pageSize) {
        //设置分页
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //执行查询并返回
        return resourceColumnWebsiteMapper.selectByExample(resourceColumnWebsiteExample);
    }

    @Override
    public List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite, Integer currentPage, Integer pageSize) {
        //将ResourceColumnWebsite转换为查询模板对象
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = this.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //执行查询并返回
        return this.selectResourceColumnWebsites(resourceColumnWebsiteExample, currentPage, pageSize);
    }

    @Override
    public Integer countResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample) {
        return resourceColumnWebsiteMapper.countByExample(resourceColumnWebsiteExample);
    }

    @Override
    public Integer countResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite) {
        //将ResourceColumnWebsite转换为查询模板对象
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = this.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //执行统计并返回
        return this.countResourceColumnWebsites(resourceColumnWebsiteExample);
    }

    @Override
    public LayUIResourceColumnWebsite renderResourceColumnWebsiteForLayUI(ResourceColumnWebsite resourceColumnWebsite) {
        LayUIResourceColumnWebsite layUIResourceColumnWebsite = new LayUIResourceColumnWebsite(resourceColumnWebsite);
        //执行渲染
        layUIResourceColumnWebsite.setRcwid(resourceColumnWebsite.getRcwid());
        layUIResourceColumnWebsite.setRcwname(resourceColumnWebsite.getRcwname());
        layUIResourceColumnWebsite.setRcwhref(resourceColumnWebsite.getRcwhref());
        layUIResourceColumnWebsite.setRcwlogo(resourceColumnWebsite.getRcwlogo());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResourceColumnWebsite.setRcwcreatedate(sdf.format(resourceColumnWebsite.getRcwcreatedate()));
        if(resourceColumnWebsite.getRcwenable() == 0) {
            layUIResourceColumnWebsite.setRcwenable("不可用");
        } else if(resourceColumnWebsite.getRcwenable() == 1) {
            layUIResourceColumnWebsite.setRcwenable("可用");
        } else if(resourceColumnWebsite.getRcwenable() == 2) {
            layUIResourceColumnWebsite.setRcwenable("删除");
        }
        //渲染栏目名
        layUIResourceColumnWebsite.setRcwcid(resourceColumnService.selectResourceColumnByCid(resourceColumnWebsite.getRcwcid()).getCname());
        //渲染创建者账号
        layUIResourceColumnWebsite.setRcwcreater(superService.selectAdminById(resourceColumnWebsite.getRcwcreater()).getAaccount());
        return layUIResourceColumnWebsite;
    }

    @Override
    public List<LayUIResourceColumnWebsite> renderResourceColumnWebsitesForLayUI(List<ResourceColumnWebsite> resourceColumnWebsites) {
        List<LayUIResourceColumnWebsite> layUIResourceColumnWebsiteList = new ArrayList<>();
        //执行数据渲染
        for(ResourceColumnWebsite resourceColumnWebsite : resourceColumnWebsites) {
            layUIResourceColumnWebsiteList.add(renderResourceColumnWebsiteForLayUI(resourceColumnWebsite));
        }
        return layUIResourceColumnWebsiteList;
    }

    @Override
    public ResourceColumnWebsite selectResourceColumnWebsiteById(Integer rcwid) {
        return resourceColumnWebsiteMapper.selectByPrimaryKey(rcwid);
    }

    @Override
    public Result updateResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite) {
        //执行更新
        resourceColumnWebsiteMapper.updateByPrimaryKeySelective(resourceColumnWebsite);
        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnWebsitesByIds(List<Integer> ids) {
        //创建删除模板对象
        ResourceColumnWebsite deleteResourceColumnWebsite = new ResourceColumnWebsite();
        deleteResourceColumnWebsite.setRcwenable(2);
        for(Integer id : ids) {
            //删除资源栏目网站Logo
            fileService.deleteResourceColumnWebsiteLogo(id);
            //逻辑删除
            deleteResourceColumnWebsite.setRcwid(id);
            resourceColumnWebsiteMapper.updateByPrimaryKeySelective(deleteResourceColumnWebsite);
        }
        return Result.OK();
    }

    @Override
    public List<ResourceColumnWebsite> getResourceColumnWebsiteByCid(Integer cid) {
        //创建查询模板
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = new ResourceColumnWebsiteExample();
        ResourceColumnWebsiteExample.Criteria criteria = resourceColumnWebsiteExample.createCriteria();
        //设置查询条件
        criteria.andRcwcidEqualTo(cid);
        //设置查询可见
        criteria.andRcwenableEqualTo(1);
        //执行查询并返回
        return this.selectResourceColumnWebsites(resourceColumnWebsiteExample, null, null);
    }
}
