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
 * ��Service�ṩ��Դ�������
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
        //�������
        resource.setRid(0);
        resource.setRcreatedate(new Date());
        resource.setRcreater(aid);
        resource.setRupdatedate(new Date());
        resource.setRupdater(aid);
        resource.setRviews(0);
        resource.setRenable(1);
        //ִ�в���
        resourceMapper.insert(resource);
        return Result.OK();
    }

    @Override
    public ResourceExample transformResourceToResourceExample(Resource resource, Admin currentAdmin) {
        //������ѯģ��
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //��Ӳ�ѯ����
        if(resource != null) {
            //����հ�����
            ClearBlankUtil.clearStringBlank(resource);
            //��Ӳ�ѯ����
            if(resource.getRtitle() != null)
                criteria.andRtitleLike("%" + resource.getRtitle() + "%");
            if(resource.getRcolumn() != null)
                criteria.andRcolumnEqualTo(resource.getRcolumn());
            if(resource.getRcreater() != null)
                criteria.andRcreaterEqualTo(resource.getRcreater());
            //��û��ָ����Դ״̬������ֻ��ʾ�ɼ���Դ
            if(resource.getRenable() != null)
                criteria.andRenableEqualTo(resource.getRenable());
            else
                criteria.andRenableNotEqualTo(2);
        }
        //�����ǰ�û���Ϊ����Ա������ֻ�ܿ����Լ�����Դ
        if(currentAdmin != null && currentAdmin.getAlevel() >= 2) {
            criteria.andRcreaterEqualTo(currentAdmin.getAid());
        }

        //���ز�ѯģ�����
        return resourceExample;
    }

    @Override
    public List<Resource> selectResources(ResourceExample resourceExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //���÷�ҳ
            PageHelper.startPage(currentPage, pageSize);
        }
        //ִ�в�ѯ������
        return resourceMapper.selectByExample(resourceExample);
    }

    @Override
    public List<Resource> selectResources(Resource resource, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //����Դ����ת��Ϊ��ѯģ�����
        ResourceExample resourceExample = this.transformResourceToResourceExample(resource, currentAdmin);
        //ִ�в�ѯ������
        return selectResources(resourceExample, currentPage, pageSize);
    }

    @Override
    public Integer count(ResourceExample resourceExample) {
        //ִ��ͳ�Ʋ�����
        return resourceMapper.countByExample(resourceExample);
    }

    @Override
    public Integer count(Resource resource, Admin currentAdmin) {
        //����Դ����ת��Ϊ��ѯģ�����
        ResourceExample resourceExample = this.transformResourceToResourceExample(resource, currentAdmin);
        //ִ��ͳ�Ʋ�����
        return count(resourceExample);
    }

    @Override
    public LayUIResource renderResourceForLayUI(Resource resource, boolean isAname) {
        LayUIResource layUIResource = new LayUIResource();
        //ִ����Ⱦ
        layUIResource.setRid(resource.getRid());
        layUIResource.setRtitle(resource.getRtitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResource.setRcreatedate(sdf.format(resource.getRcreatedate()));
        layUIResource.setRupdatedate(sdf.format(resource.getRupdatedate()));
        layUIResource.setRviews(resource.getRviews());
        if(resource.getRenable() == 0) {
            layUIResource.setRenable("������");
        } else if(resource.getRenable() == 1) {
            layUIResource.setRenable("����");
        } else if(resource.getRenable() == 2) {
            layUIResource.setRenable("ɾ��");
        }
        layUIResource.setRcontent(resource.getRcontent());
        layUIResource.setRtitleimg(resource.getRtitleimg());
        //��Ⱦ�����˺��޸���
        if(isAname) {
            layUIResource.setRcreater(superService.selectAdminById(resource.getRcreater()).getAname());
            layUIResource.setRupdater(superService.selectAdminById(resource.getRupdater()).getAname());
        } else {
            layUIResource.setRcreater(superService.selectAdminById(resource.getRcreater()).getAaccount());
            layUIResource.setRupdater(superService.selectAdminById(resource.getRupdater()).getAaccount());
        }
        //��Ⱦ��Ŀ��
        layUIResource.setRcolumn(resourceColumnService.selectResourceColumnByCid(resource.getRcolumn()).getCname());
        return layUIResource;
    }

    @Override
    public List<LayUIResource> renderResourcesForLayUI(List<Resource> resources, boolean isAname) {
        //ִ��������Ⱦ
        List<LayUIResource> resourceList = new ArrayList<>();
        for(Resource resource : resources) {
            resourceList.add(this.renderResourceForLayUI(resource,isAname));
        }
        return resourceList;
    }

    @Override
    public Result updateResource(Resource resource, Integer aid) {
        //���������
        ClearBlankUtil.clearStringBlank(resource);
        //�������
        resource.setRupdater(aid);
        resource.setRupdatedate(new Date());
        //ִ�и���
        resourceMapper.updateByPrimaryKeySelective(resource);
        return Result.OK();
    }

    @Override
    public Result deleteResourcesByIds(List<Integer> idList) {
        Resource deleteResource = new Resource();
        deleteResource.setRenable(2);
        for(Integer id : idList) {
            //ɾ����Դ��Ӧ�ı���ͼƬ
            fileService.deleteResourceTitleImg(id);
            //ɾ����Դ(�߼�ɾ��)
            deleteResource.setRid(id);
            resourceMapper.updateByPrimaryKeySelective(deleteResource);
        }
        return Result.OK();
    }

    @Override
    public Resource selectResourceByIdBlob(Integer id) {
        //��������ģ��
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        //��Ӳ�ѯ����
        criteria.andRidEqualTo(id);
        //ִ�в�ѯ
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
