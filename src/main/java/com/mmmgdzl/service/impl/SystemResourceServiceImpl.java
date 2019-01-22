package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUISystemResource;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.SystemResourceMapper;
import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.pojo.SystemResourceExample;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.service.SystemResourceService;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SystemResourceServiceImpl implements SystemResourceService {

    @Value("${SYSTEM_RESOURCE_PATH}")
    private String SYSTEM_RESOURCE_PATH;
    @Value("${RESOURCE_SERVER}")
    private String RESOURCE_SERVER;

    @Autowired
    private SystemResourceMapper systemResourceMapper;
    @Autowired
    private SystemResourceColumnService systemResourceColumnService;
    @Autowired
    private SuperService superService;
    @Autowired
    private FileService fileService;

    @Override
    public Result addSystemResource(SystemResource systemResource) {
        //执行填充
        systemResource.setSrcreatedate(new Date());
        systemResource.setSrenable(1);
        //执行插入
        systemResourceMapper.insert(systemResource);
        return Result.OK();
    }

    @Override
    public SystemResourceExample transformResourceToSystemResourceExample(SystemResource systemResource) {
        //创建查询模板对象
        SystemResourceExample systemResourceExample = new SystemResourceExample();
        SystemResourceExample.Criteria criteria = systemResourceExample.createCriteria();
        if(systemResource != null) {
            //清除空数据
            ClearBlankUtil.clearStringBlank(systemResource);
            //添加查询条件
            if(systemResource.getSrname() != null)
                criteria.andSrnameLike("%" + systemResource.getSrname() + "%");
            if(systemResource.getSrcolumn() != null)
                criteria.andSrcolumnEqualTo(systemResource.getSrcolumn());
            if(systemResource.getSrcreater() != null)
                criteria.andSrcreaterEqualTo(systemResource.getSrcreater());
            if(systemResource.getSrenable() != null)
                criteria.andSrenableEqualTo(systemResource.getSrenable());
            else
                criteria.andSrenableNotEqualTo(2);
            if(systemResource.getSrdesc() != null)
                criteria.andSrdescLike("%" + systemResource.getSrdesc() + "%");
        }
        return systemResourceExample;
    }

    @Override
    public List<SystemResource> selectSystemResources(SystemResourceExample systemResourceExample, Integer currentPage, Integer pageSize) {
        //设置分页
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //执行查询并返回
        return systemResourceMapper.selectByExample(systemResourceExample);
    }

    @Override
    public List<SystemResource> selectSystemResources(SystemResource systemResource, Integer currentPage, Integer pageSize) {
        //将SystemResource对象转换为查询模板对象
        SystemResourceExample systemResourceExample = this.transformResourceToSystemResourceExample(systemResource);
        //执行查询并返回
        return this.selectSystemResources(systemResourceExample, currentPage, pageSize);
    }

    @Override
    public Integer count(SystemResource systemResource) {
        //将SystemResource对象转换为查询模板对象
        SystemResourceExample systemResourceExample = this.transformResourceToSystemResourceExample(systemResource);
        //执行查询并返回
        return this.count(systemResourceExample);
    }

    @Override
    public Integer count(SystemResourceExample systemResourceExample) {
        return systemResourceMapper.countByExample(systemResourceExample);
    }

    @Override
    public Result updateSystemResource(SystemResource systemResource) {
        //执行更新
        systemResourceMapper.updateByPrimaryKeySelective(systemResource);
        return Result.OK();
    }

    @Override
    public LayUISystemResource renderSystemResourceForLayUI(SystemResource systemResource) {
        LayUISystemResource layUISystemResource = new LayUISystemResource();
        //执行渲染
        layUISystemResource.setSrid(systemResource.getSrid());
        layUISystemResource.setSrname(systemResource.getSrname());
        layUISystemResource.setSrdesc(systemResource.getSrdesc());
        layUISystemResource.setSrcreater(superService.selectAdminById(systemResource.getSrcreater()).getAaccount());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUISystemResource.setSrcreatedate(sdf.format(systemResource.getSrcreatedate()));
        layUISystemResource.setSrcolumn(systemResourceColumnService.selectSystemResourceColumnBySrcid(systemResource.getSrcolumn()).getSrcname());
        if(systemResource.getSrenable() == 0) {
            layUISystemResource.setSrenable("不可用");
        } else if(systemResource.getSrenable() == 1) {
            layUISystemResource.setSrenable("可用");
        } else if(systemResource.getSrenable() == 2) {
            layUISystemResource.setSrenable("删除");
        }
        //渲染下载路径
        layUISystemResource.setSrfilename(RESOURCE_SERVER + "/" + SYSTEM_RESOURCE_PATH + "/" + systemResource.getSrfilename());
        return layUISystemResource;
    }

    @Override
    public List<LayUISystemResource> renderSystemResourcesForLayUI(List<SystemResource> systemResources) {
        List<LayUISystemResource> layUISystemResourceList = new ArrayList<>();
        for(SystemResource systemResource : systemResources) {
            //执行渲染
            layUISystemResourceList.add(this.renderSystemResourceForLayUI(systemResource));
        }
        return layUISystemResourceList;
    }

    @Override
    public SystemResource selectSystemResourceBySrid(Integer srid) {
        return systemResourceMapper.selectByPrimaryKey(srid);
    }

    @Override
    public Result deleteSystemResourceByIds(List<Integer> ids) {
        //创建删除模板
        SystemResource systemResource = new SystemResource();
        systemResource.setSrenable(2);
        //执行删除
        for(Integer id : ids) {
            //删除资源文件
            fileService.deleteSystemResourceBySrid(id);
            //执行逻辑删除
            systemResource.setSrid(id);
            systemResourceMapper.updateByPrimaryKeySelective(systemResource);
        }
        return Result.OK();
    }
}
