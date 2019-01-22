package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.SystemResourceColumnMapper;
import com.mmmgdzl.pojo.SystemResourceColumn;
import com.mmmgdzl.pojo.SystemResourceColumnExample;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SystemResourceColumnServiceImpl implements SystemResourceColumnService {

    @Autowired
    private SystemResourceColumnMapper systemResourceColumnMapper;
    @Autowired
    private SuperService superService;

    @Override
    public Result addResourceColumn(SystemResourceColumn systemResourceColumn) {

        //查询是否有重复名称的系统资源栏目
        if(this.selectSystemResourceColumnBySrcname(systemResourceColumn.getSrcname()) != null)
            throw new XKException("该系统资源栏目名已存在");

        //填充条件
        systemResourceColumn.setSrcid(0);
        systemResourceColumn.setSrccreatedate(new Date());
        systemResourceColumn.setSrcenable(1);

        //执行添加
        systemResourceColumnMapper.insert(systemResourceColumn);

        return Result.OK();
    }

    @Override
    public SystemResourceColumnExample transformResourceColumnToResourceColumnExample(SystemResourceColumn systemResourceColumn) {

        //创建查询模板对象
        SystemResourceColumnExample systemResourceColumnExample = new SystemResourceColumnExample();
        SystemResourceColumnExample.Criteria criteria = systemResourceColumnExample.createCriteria();

        if(systemResourceColumn != null) {
            //清除空条件
            ClearBlankUtil.clearStringBlank(systemResourceColumn);
            //添加条件
            if(systemResourceColumn.getSrcname() != null)
                criteria.andSrcnameLike("%" + systemResourceColumn.getSrcname() + "%");
            if(systemResourceColumn.getSrccreater() != null)
                criteria.andSrccreaterEqualTo(systemResourceColumn.getSrccreater());
            if(systemResourceColumn.getSrcenable() != null)
                criteria.andSrcenableEqualTo(systemResourceColumn.getSrcenable());
            else
                criteria.andSrcenableNotEqualTo(2);
        }
        return systemResourceColumnExample;
    }

    @Override
    public List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumnExample systemResourceColumnExample, Integer currentPage, Integer pageSize) {
        //设置分页
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //执行查询并返回
        return systemResourceColumnMapper.selectByExample(systemResourceColumnExample);
    }

    @Override
    public List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumn systemResourceColumn, Integer currentPage, Integer pageSize) {
        //将查询条件转换为查询模板对象
        SystemResourceColumnExample systemResourceColumnExample = this.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //执行查询并返回
        return this.selectSystemResourceColumns(systemResourceColumnExample, currentPage, pageSize);
    }

    @Override
    public Integer count(SystemResourceColumn systemResourceColumn) {
        //将查询条件转换为查询模板对象
        SystemResourceColumnExample systemResourceColumnExample = this.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //执行查询并返回
        return this.count(systemResourceColumnExample);
    }

    @Override
    public Integer count(SystemResourceColumnExample systemResourceColumnExample) {
        return systemResourceColumnMapper.countByExample(systemResourceColumnExample);
    }

    @Override
    public Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn) {
        //查询是否有重复名称的系统资源栏目
        SystemResourceColumn checkSystemResourceColumn = this.selectSystemResourceColumnBySrcname(systemResourceColumn.getSrcname());
        if(checkSystemResourceColumn != null && checkSystemResourceColumn.getSrcid() != systemResourceColumn.getSrcid())
            throw new XKException("该系统资源栏目名已存在");

        //执行更新
        systemResourceColumnMapper.updateByPrimaryKeySelective(systemResourceColumn);

        return Result.OK();
    }

    @Override
    public LayUISystemResourceColumn renderSystemResourceColumnForLayUI(SystemResourceColumn systemResourceColumn) {
        LayUISystemResourceColumn layUISystemResourceColumn = new LayUISystemResourceColumn();
        layUISystemResourceColumn.setSrcid(systemResourceColumn.getSrcid());
        layUISystemResourceColumn.setSrcname(systemResourceColumn.getSrcname());
        //执行渲染
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUISystemResourceColumn.setSrccreatedate(sdf.format(systemResourceColumn.getSrccreatedate()));
        if(systemResourceColumn.getSrcenable() == 0)
            layUISystemResourceColumn.setSrcenable("不可用");
        else if(systemResourceColumn.getSrcenable() == 1)
            layUISystemResourceColumn.setSrcenable("可用");
        else if(systemResourceColumn.getSrcenable() == 2)
            layUISystemResourceColumn.setSrcenable("删除");
        //渲染创建者
        layUISystemResourceColumn.setSrccreater(superService.selectAdminById(systemResourceColumn.getSrccreater()).getAaccount());
        return layUISystemResourceColumn;
    }

    @Override
    public List<LayUISystemResourceColumn> renderSystemResourceColumnsForLayUI(List<SystemResourceColumn> systemResourceColumns) {
        List<LayUISystemResourceColumn> layUISystemResourceColumnList = new ArrayList<LayUISystemResourceColumn>();
        for(SystemResourceColumn systemResourceColumn : systemResourceColumns) {
            //执行渲染
            layUISystemResourceColumnList.add(this.renderSystemResourceColumnForLayUI(systemResourceColumn));
        }
        return layUISystemResourceColumnList;
    }

    @Override
    public SystemResourceColumn selectSystemResourceColumnBySrcid(Integer srcid) {
        return systemResourceColumnMapper.selectByPrimaryKey(srcid);
    }

    @Override
    public SystemResourceColumn selectSystemResourceColumnBySrcname(String srcname) {

        SystemResourceColumnExample systemResourceColumnExample = new SystemResourceColumnExample();
        SystemResourceColumnExample.Criteria criteria = systemResourceColumnExample.createCriteria();

        //选择名称相同数据
        criteria.andSrcnameEqualTo(srcname);
        //选择未删除数据
        criteria.andSrcenableNotEqualTo(2);

        //执行查询
        List<SystemResourceColumn> systemResourceColumns = systemResourceColumnMapper.selectByExample(systemResourceColumnExample);

        if(systemResourceColumns.size() == 0)
            return null;
        else
            return systemResourceColumns.get(0);
    }

    @Override
    public Result deleteSystemResourceColumnById(Integer id) {
        SystemResourceColumn systemResourceColumn = new SystemResourceColumn();
        //设置删除条件
        systemResourceColumn.setSrcid(id);
        systemResourceColumn.setSrcenable(2);

        //执行逻辑删除
        systemResourceColumnMapper.updateByPrimaryKeySelective(systemResourceColumn);

        return Result.OK();
    }
}
