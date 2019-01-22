package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.ResourceCommentMapper;
import com.mmmgdzl.mapper.XKResourceCommentMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;
import com.mmmgdzl.service.ResourceCommentService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceCommentServiceImpl implements ResourceCommentService {

    @Autowired
    private ResourceCommentMapper resourceCommentMapper;
    @Autowired
    private XKResourceCommentMapper xkResourceCommentMapper;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private SuperService superService;

    @Override
    public Result addResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //�������
        resourceComment.setRcid(0);
        Integer rcCount = this.getMaxRccount(resourceComment.getRcresource());
        resourceComment.setRccount(rcCount == null?1:rcCount + 1);
        resourceComment.setRccreater(currentAdmin.getAid());
        resourceComment.setRccreatedate(new Date());
        resourceComment.setRcupdater(currentAdmin.getAid());
        resourceComment.setRcupdatedate(new Date());
        resourceComment.setRcenable(1);

        //ִ�в���
        resourceCommentMapper.insert(resourceComment);
        return Result.OK();
    }

    @Override
    public ResourceCommentExample transformResourceCommentToTesourceCommentExample(ResourceComment resourceComment) {
        //������ѯģ�����
        ResourceCommentExample resourceCommentExample = new ResourceCommentExample();
        ResourceCommentExample.Criteria criteria = resourceCommentExample.createCriteria();
        //��Ӳ�ѯ����
        if(resourceComment != null) {
            //���������
            ClearBlankUtil.clearStringBlank(resourceComment);
            //��Ӳ�ѯ����
            if(resourceComment.getRccount() != null)
                criteria.andRccountEqualTo(resourceComment.getRccount());
            //����Ӧ�����reply�ڶ�Ӧ��¥������rcid������
            if(resourceComment.getRcreply() != null)
                criteria.andRcreplyIn(xkResourceCommentMapper.selectRcidsByRccount(resourceComment.getRcreply()));
            if(resourceComment.getRccreater() != null)
                criteria.andRccreaterEqualTo(resourceComment.getRccreater());
            if(resourceComment.getRcupdater() != null)
                criteria.andRcupdaterEqualTo(resourceComment.getRcupdater());
            if(resourceComment.getRccontent() != null)
                criteria.andRccontentLike("%" + resourceComment.getRccontent() + "%");
            if(resourceComment.getRcresource() != null)
                criteria.andRcresourceEqualTo(resourceComment.getRcresource());
            if(resourceComment.getRcenable() != null)
                criteria.andRcenableEqualTo(resourceComment.getRcenable());
            else
                criteria.andRcenableNotEqualTo(2);
        }

        //���ز�ѯģ��
        return resourceCommentExample;
    }

    @Override
    public List<ResourceComment> selectResourceComments(ResourceCommentExample resourceCommentExample, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //���÷�ҳ
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ������
        if(currentAdmin == null || currentAdmin.getAlevel() <= 1)
            return resourceCommentMapper.selectByExample(resourceCommentExample);
        else
            return xkResourceCommentMapper.selectAdminResourceCommentsByExample(resourceCommentExample, currentAdmin.getAid());
    }

    @Override
    public List<ResourceComment> selectResourceComments(ResourceComment resourceComment, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //��ResourceComment����ת��Ϊ��ѯģ�����
        ResourceCommentExample resourceCommentExample = transformResourceCommentToTesourceCommentExample(resourceComment);
        //ִ�в�ѯ������
        return selectResourceComments(resourceCommentExample, currentPage, pageSize, currentAdmin);
    }

    @Override
    public Integer countResourceComment(ResourceCommentExample resourceCommentExample, Admin currentAdmin) {
        //ִ��ͳ�Ʋ�����
        if(currentAdmin == null || currentAdmin.getAlevel() <= 1)
            return resourceCommentMapper.countByExample(resourceCommentExample);
        else
            return xkResourceCommentMapper.countAdminResourceCommentsByExample(resourceCommentExample, currentAdmin.getAid());
    }

    @Override
    public Integer countResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //��ResourceComment����ת��Ϊ��ѯģ�����
        ResourceCommentExample resourceCommentExample = transformResourceCommentToTesourceCommentExample(resourceComment);
        //ִ��ͳ�Ʋ�����
        return countResourceComment(resourceCommentExample, currentAdmin);
    }

    @Override
    public LayUIResourceComment renderResourceCommentForLayUI(ResourceComment resourceComment, boolean isForBackground) {
        LayUIResourceComment layUIResourceComment = new LayUIResourceComment();
        //ִ����Ⱦ
        layUIResourceComment.setRcid(resourceComment.getRcid());
        layUIResourceComment.setRccount(resourceComment.getRccount());
        layUIResourceComment.setRccontent(resourceComment.getRccontent());
        //��Ⱦ�����û�
        if(isForBackground) {
            layUIResourceComment.setRccreater(superService.selectAdminById(resourceComment.getRccreater()).getAaccount());
            layUIResourceComment.setRcupdater(superService.selectAdminById(resourceComment.getRcupdater()).getAaccount());
        } else {
            layUIResourceComment.setRccreater(superService.selectAdminById(resourceComment.getRccreater()).getAname());
            layUIResourceComment.setRcupdater(superService.selectAdminById(resourceComment.getRcupdater()).getAname());
        }
        //��Ⱦ����
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResourceComment.setRccreatedate(sdf.format(resourceComment.getRccreatedate()));
        layUIResourceComment.setRcupdatedate(sdf.format(resourceComment.getRcupdatedate()));
        //��Ⱦ��Դ
        Resource resource = resourceService.selectResourceById(resourceComment.getRcresource());
        layUIResourceComment.setRcresource(resource.getRtitle());
        layUIResourceComment.setRcresourcehref(resource.getRid() + "");
        //��Ⱦ��Դ����״̬
        if(resourceComment.getRcenable() == 0) {
            layUIResourceComment.setRcenable("������");
        } else if(resourceComment.getRcenable() == 1) {
            layUIResourceComment.setRcenable("����");
        } else if(resourceComment.getRcenable() == 2) {
            layUIResourceComment.setRcenable("ɾ��");
        }
        //��Ⱦ�ظ���¥����
        if(resourceComment.getRcreply() == null)
            layUIResourceComment.setRcreply("��");
        else
            layUIResourceComment.setRcreply(resourceCommentMapper.selectByPrimaryKey(resourceComment.getRcreply()).getRccount() + "");
        return layUIResourceComment;
    }

    @Override
    public List<LayUIResourceComment> renderResourceCommentsForLayUI(List<ResourceComment> resourceComments, boolean isForBackground) {
        List<LayUIResourceComment> layUIResourceCommentList = new ArrayList<>();
        for(ResourceComment resourceComment : resourceComments) {
            layUIResourceCommentList.add(renderResourceCommentForLayUI(resourceComment, isForBackground));
        }
        return layUIResourceCommentList;
    }

    @Override
    public Result updateResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //�������
        resourceComment.setRcupdater(currentAdmin.getAid());
        resourceComment.setRcupdatedate(new Date());
        //ִ�и���
       resourceCommentMapper.updateByPrimaryKeySelective(resourceComment);
       return Result.OK();
    }

    @Override
    public Result deleteResourceCommentsByIds(List<Integer> idList) {
        //����ɾ��ģ�����
        ResourceComment resourceComment = new ResourceComment();
        resourceComment.setRcenable(2);
        //ִ���߼�ɾ��
        for(Integer id : idList) {
            resourceComment.setRcid(id);
            resourceCommentMapper.updateByPrimaryKeySelective(resourceComment);
        }
        return Result.OK();
    }

    @Override
    public Integer getMaxRccount(Integer rid) {
        return xkResourceCommentMapper.getMaxRccount(rid);
    }
}
