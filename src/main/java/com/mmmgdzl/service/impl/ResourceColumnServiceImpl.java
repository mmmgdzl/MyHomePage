package com.mmmgdzl.service.impl;

import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.ResourceColumnMapper;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceColumnServiceImpl implements ResourceColumnService {

    @Autowired
    private ResourceColumnMapper resourceColumnMapper;
    @Autowired
    private SuperService superService;

    @Override
    public Result addResourceColumn(ResourceColumn resourceColumn) {
        //清除空白项
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //检查资源栏目名是否重复
        ResourceColumn checkResourceColumn = this.selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null && checkResourceColumn.getCid() != resourceColumn.getCid()) {
            //如果资源栏目名重复且不是与自己重复则抛出异常
            throw new XKException("资源栏目名已存在");
        }
        //填充属性
        resourceColumn.setCid(0);
        resourceColumn.setCcreatedate(new Date());
        //执行插入
        resourceColumnMapper.insert(resourceColumn);
        //返回成功结果
        return Result.OK();
    }

    @Override
    public ResourceColumnExample transformResourceColumnToResourceColumnExample(ResourceColumn resourceColumn) {
        //清除空白项
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //添加查询条件
        if(resourceColumn.getCname() != null)
            criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
        if(resourceColumn.getCcreater() != null)
            criteria.andCcreaterEqualTo(resourceColumn.getCcreater());
        //返回查询模板对象
        return resourceColumnExample;
    }

    @Override
    public List<ResourceColumn> selectResourceColumns(ResourceColumnExample resourceColumnExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //设置分页
            PageHelper.startPage(currentPage, pageSize);
        }
        //执行查询并返回
        return resourceColumnMapper.selectByExample(resourceColumnExample);
    }

    @Override
    public List<ResourceColumn> selectResourceColumns(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize) {
        //将资源栏目对象转换为查询模板对象
        ResourceColumnExample resourceColumnExample = this.transformResourceColumnToResourceColumnExample(resourceColumn);
        //执行查询并返回
        return this.selectResourceColumns(resourceColumnExample, currentPage, pageSize);
    }

    @Override
    public Integer count(ResourceColumnExample resourceColumnExample) {
        //执行统计并返回
        return resourceColumnMapper.countByExample(resourceColumnExample);
    }

    @Override
    public Integer count(ResourceColumn resourceColumn) {
        //将资源栏目对象转换为查询模板对象
        ResourceColumnExample resourceColumnExample = this.transformResourceColumnToResourceColumnExample(resourceColumn);
        //执行统计并返回
        return this.count(resourceColumnExample);
    }

    @Override
    public LayUIResourceColumn renderResourceColumnForLayUI(ResourceColumn resourceColumn) {
        LayUIResourceColumn layUIResourceColumn = new LayUIResourceColumn(resourceColumn);
        //填充创建者账号
        layUIResourceColumn.setCcreater(superService.selectAdminById(resourceColumn.getCcreater()).getAaccount());
        //返回渲染结果
        return layUIResourceColumn;
    }

    @Override
    public List<LayUIResourceColumn> renderResourceColumnsForLayUI(List<ResourceColumn> resourceColumns) {
        List<LayUIResourceColumn> layUIResourceColumnList = new ArrayList<>();
        for(ResourceColumn resourceColumn : resourceColumns) {
            LayUIResourceColumn layUIResourceColumn = renderResourceColumnForLayUI(resourceColumn);
            layUIResourceColumnList.add(layUIResourceColumn);
        }
        //返回渲染结果
        return layUIResourceColumnList;
    }


    @Override
    public ResourceColumn selectResourceColumnByCid(Integer cid) {
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //添加查询条件
        criteria.andCidEqualTo(cid);
        //执行查询
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);
        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    @Override
    public ResourceColumn selectResourceColumnByCname(String cname) {
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //添加查询条件
        criteria.andCnameEqualTo(cname);
        //执行查询
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);
        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    @Override
    public Result updateResourceColumn(ResourceColumn resourceColumn) {
        //清除空白数据
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //检查资源栏目名是否重复
        ResourceColumn checkResourceColumn = selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null) {
            if(checkResourceColumn.getCid() == resourceColumn.getCid()) {
                throw new XKException("与原栏目名一致,无需修改");
            } else {
                throw new XKException("该栏目名已存在");
            }
        }
        //执行修改
        resourceColumnMapper.updateByPrimaryKeySelective(resourceColumn);
        //返回查询结果
        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnById(Integer id) {
        resourceColumnMapper.deleteByPrimaryKey(id);
        return Result.OK();
    }

}
