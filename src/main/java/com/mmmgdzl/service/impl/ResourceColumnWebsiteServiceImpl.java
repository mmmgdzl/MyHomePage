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
        //�������
        resourceColumnWebsite.setRcwid(0);
        resourceColumnWebsite.setRcwcreater(createrId);
        resourceColumnWebsite.setRcwcreatedate(new Date());
        resourceColumnWebsite.setRcwenable(1);

        //ִ�����
        resourceColumnWebsiteMapper.insert(resourceColumnWebsite);
        return Result.OK();
    }

    @Override
    public ResourceColumnWebsiteExample transformResourceColumnWebsiteToResourceColumnWebsiteExample(ResourceColumnWebsite resourceColumnWebsite) {
        //������ѯģ�����
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = new ResourceColumnWebsiteExample();
        ResourceColumnWebsiteExample.Criteria criteria = resourceColumnWebsiteExample.createCriteria();

        //��Ӳ�ѯ����
        if(resourceColumnWebsite != null) {
            //���������
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
        //���÷�ҳ
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ������
        return resourceColumnWebsiteMapper.selectByExample(resourceColumnWebsiteExample);
    }

    @Override
    public List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite, Integer currentPage, Integer pageSize) {
        //��ResourceColumnWebsiteת��Ϊ��ѯģ�����
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = this.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //ִ�в�ѯ������
        return this.selectResourceColumnWebsites(resourceColumnWebsiteExample, currentPage, pageSize);
    }

    @Override
    public Integer countResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample) {
        return resourceColumnWebsiteMapper.countByExample(resourceColumnWebsiteExample);
    }

    @Override
    public Integer countResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite) {
        //��ResourceColumnWebsiteת��Ϊ��ѯģ�����
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = this.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //ִ��ͳ�Ʋ�����
        return this.countResourceColumnWebsites(resourceColumnWebsiteExample);
    }

    @Override
    public LayUIResourceColumnWebsite renderResourceColumnWebsiteForLayUI(ResourceColumnWebsite resourceColumnWebsite) {
        LayUIResourceColumnWebsite layUIResourceColumnWebsite = new LayUIResourceColumnWebsite(resourceColumnWebsite);
        //ִ����Ⱦ
        layUIResourceColumnWebsite.setRcwid(resourceColumnWebsite.getRcwid());
        layUIResourceColumnWebsite.setRcwname(resourceColumnWebsite.getRcwname());
        layUIResourceColumnWebsite.setRcwhref(resourceColumnWebsite.getRcwhref());
        layUIResourceColumnWebsite.setRcwlogo(resourceColumnWebsite.getRcwlogo());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResourceColumnWebsite.setRcwcreatedate(sdf.format(resourceColumnWebsite.getRcwcreatedate()));
        if(resourceColumnWebsite.getRcwenable() == 0) {
            layUIResourceColumnWebsite.setRcwenable("������");
        } else if(resourceColumnWebsite.getRcwenable() == 1) {
            layUIResourceColumnWebsite.setRcwenable("����");
        } else if(resourceColumnWebsite.getRcwenable() == 2) {
            layUIResourceColumnWebsite.setRcwenable("ɾ��");
        }
        //��Ⱦ��Ŀ��
        layUIResourceColumnWebsite.setRcwcid(resourceColumnService.selectResourceColumnByCid(resourceColumnWebsite.getRcwcid()).getCname());
        //��Ⱦ�������˺�
        layUIResourceColumnWebsite.setRcwcreater(superService.selectAdminById(resourceColumnWebsite.getRcwcreater()).getAaccount());
        return layUIResourceColumnWebsite;
    }

    @Override
    public List<LayUIResourceColumnWebsite> renderResourceColumnWebsitesForLayUI(List<ResourceColumnWebsite> resourceColumnWebsites) {
        List<LayUIResourceColumnWebsite> layUIResourceColumnWebsiteList = new ArrayList<>();
        //ִ��������Ⱦ
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
        //ִ�и���
        resourceColumnWebsiteMapper.updateByPrimaryKeySelective(resourceColumnWebsite);
        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnWebsitesByIds(List<Integer> ids) {
        //����ɾ��ģ�����
        ResourceColumnWebsite deleteResourceColumnWebsite = new ResourceColumnWebsite();
        deleteResourceColumnWebsite.setRcwenable(2);
        for(Integer id : ids) {
            //ɾ����Դ��Ŀ��վLogo
            fileService.deleteResourceColumnWebsiteLogo(id);
            //�߼�ɾ��
            deleteResourceColumnWebsite.setRcwid(id);
            resourceColumnWebsiteMapper.updateByPrimaryKeySelective(deleteResourceColumnWebsite);
        }
        return Result.OK();
    }

    @Override
    public List<ResourceColumnWebsite> getResourceColumnWebsiteByCid(Integer cid) {
        //������ѯģ��
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = new ResourceColumnWebsiteExample();
        ResourceColumnWebsiteExample.Criteria criteria = resourceColumnWebsiteExample.createCriteria();
        //���ò�ѯ����
        criteria.andRcwcidEqualTo(cid);
        //���ò�ѯ�ɼ�
        criteria.andRcwenableEqualTo(1);
        //ִ�в�ѯ������
        return this.selectResourceColumnWebsites(resourceColumnWebsiteExample, null, null);
    }
}
