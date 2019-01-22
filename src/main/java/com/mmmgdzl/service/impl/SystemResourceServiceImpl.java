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
        //ִ�����
        systemResource.setSrcreatedate(new Date());
        systemResource.setSrenable(1);
        //ִ�в���
        systemResourceMapper.insert(systemResource);
        return Result.OK();
    }

    @Override
    public SystemResourceExample transformResourceToSystemResourceExample(SystemResource systemResource) {
        //������ѯģ�����
        SystemResourceExample systemResourceExample = new SystemResourceExample();
        SystemResourceExample.Criteria criteria = systemResourceExample.createCriteria();
        if(systemResource != null) {
            //���������
            ClearBlankUtil.clearStringBlank(systemResource);
            //��Ӳ�ѯ����
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
        //���÷�ҳ
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ������
        return systemResourceMapper.selectByExample(systemResourceExample);
    }

    @Override
    public List<SystemResource> selectSystemResources(SystemResource systemResource, Integer currentPage, Integer pageSize) {
        //��SystemResource����ת��Ϊ��ѯģ�����
        SystemResourceExample systemResourceExample = this.transformResourceToSystemResourceExample(systemResource);
        //ִ�в�ѯ������
        return this.selectSystemResources(systemResourceExample, currentPage, pageSize);
    }

    @Override
    public Integer count(SystemResource systemResource) {
        //��SystemResource����ת��Ϊ��ѯģ�����
        SystemResourceExample systemResourceExample = this.transformResourceToSystemResourceExample(systemResource);
        //ִ�в�ѯ������
        return this.count(systemResourceExample);
    }

    @Override
    public Integer count(SystemResourceExample systemResourceExample) {
        return systemResourceMapper.countByExample(systemResourceExample);
    }

    @Override
    public Result updateSystemResource(SystemResource systemResource) {
        //ִ�и���
        systemResourceMapper.updateByPrimaryKeySelective(systemResource);
        return Result.OK();
    }

    @Override
    public LayUISystemResource renderSystemResourceForLayUI(SystemResource systemResource) {
        LayUISystemResource layUISystemResource = new LayUISystemResource();
        //ִ����Ⱦ
        layUISystemResource.setSrid(systemResource.getSrid());
        layUISystemResource.setSrname(systemResource.getSrname());
        layUISystemResource.setSrdesc(systemResource.getSrdesc());
        layUISystemResource.setSrcreater(superService.selectAdminById(systemResource.getSrcreater()).getAaccount());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUISystemResource.setSrcreatedate(sdf.format(systemResource.getSrcreatedate()));
        layUISystemResource.setSrcolumn(systemResourceColumnService.selectSystemResourceColumnBySrcid(systemResource.getSrcolumn()).getSrcname());
        if(systemResource.getSrenable() == 0) {
            layUISystemResource.setSrenable("������");
        } else if(systemResource.getSrenable() == 1) {
            layUISystemResource.setSrenable("����");
        } else if(systemResource.getSrenable() == 2) {
            layUISystemResource.setSrenable("ɾ��");
        }
        //��Ⱦ����·��
        layUISystemResource.setSrfilename(RESOURCE_SERVER + "/" + SYSTEM_RESOURCE_PATH + "/" + systemResource.getSrfilename());
        return layUISystemResource;
    }

    @Override
    public List<LayUISystemResource> renderSystemResourcesForLayUI(List<SystemResource> systemResources) {
        List<LayUISystemResource> layUISystemResourceList = new ArrayList<>();
        for(SystemResource systemResource : systemResources) {
            //ִ����Ⱦ
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
        //����ɾ��ģ��
        SystemResource systemResource = new SystemResource();
        systemResource.setSrenable(2);
        //ִ��ɾ��
        for(Integer id : ids) {
            //ɾ����Դ�ļ�
            fileService.deleteSystemResourceBySrid(id);
            //ִ���߼�ɾ��
            systemResource.setSrid(id);
            systemResourceMapper.updateByPrimaryKeySelective(systemResource);
        }
        return Result.OK();
    }
}
