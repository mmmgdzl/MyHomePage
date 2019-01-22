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

import java.text.SimpleDateFormat;
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
        //����հ���
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //�����Դ��Ŀ���Ƿ��ظ�
        ResourceColumn checkResourceColumn = this.selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null) {
            //�����Դ��Ŀ���ظ��Ҳ������Լ��ظ����׳��쳣
            throw new XKException("��Դ��Ŀ���Ѵ���");
        }
        //�������
        resourceColumn.setCid(0);
        resourceColumn.setCcreatedate(new Date());
        resourceColumn.setCenable(1);
        resourceColumn.setCshowinheader(0);
        //ִ�в���
        resourceColumnMapper.insert(resourceColumn);
        //���سɹ����
        return Result.OK();
    }

    @Override
    public ResourceColumnExample transformResourceColumnToResourceColumnExample(ResourceColumn resourceColumn) {
        //������ѯģ��
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        if(resourceColumn != null) {
            //����հ���
            ClearBlankUtil.clearStringBlank(resourceColumn);
            //��Ӳ�ѯ����
            if(resourceColumn.getCname() != null)
                criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
            if(resourceColumn.getCcreater() != null)
                criteria.andCcreaterEqualTo(resourceColumn.getCcreater());
            //���û��ָ��״̬����ʾɾ��������
            if(resourceColumn.getCenable() != null)
                criteria.andCenableEqualTo(resourceColumn.getCenable());
            else
                criteria.andCenableNotEqualTo(2);
            if(resourceColumn.getCshowinheader() != null)
                criteria.andCshowinheaderEqualTo(resourceColumn.getCshowinheader());
        }

        //���ز�ѯģ�����
        return resourceColumnExample;
    }

    @Override
    public List<ResourceColumn> selectResourceColumns(ResourceColumnExample resourceColumnExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //���÷�ҳ
            PageHelper.startPage(currentPage, pageSize);
        }
        //ִ�в�ѯ������
        return resourceColumnMapper.selectByExample(resourceColumnExample);
    }

    @Override
    public List<ResourceColumn> selectResourceColumns(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize) {
        //����Դ��Ŀ����ת��Ϊ��ѯģ�����
        ResourceColumnExample resourceColumnExample = this.transformResourceColumnToResourceColumnExample(resourceColumn);
        //ִ�в�ѯ������
        return this.selectResourceColumns(resourceColumnExample, currentPage, pageSize);
    }

    @Override
    public Integer count(ResourceColumnExample resourceColumnExample) {
        //ִ��ͳ�Ʋ�����
        return resourceColumnMapper.countByExample(resourceColumnExample);
    }

    @Override
    public Integer count(ResourceColumn resourceColumn) {
        //����Դ��Ŀ����ת��Ϊ��ѯģ�����
        ResourceColumnExample resourceColumnExample = this.transformResourceColumnToResourceColumnExample(resourceColumn);
        //ִ��ͳ�Ʋ�����
        return this.count(resourceColumnExample);
    }

    @Override
    public LayUIResourceColumn renderResourceColumnForLayUI(ResourceColumn resourceColumn) {
        LayUIResourceColumn layUIResourceColumn = new LayUIResourceColumn();
        //ִ����Ⱦ
        layUIResourceColumn.setCid(resourceColumn.getCid());
        layUIResourceColumn.setCname(resourceColumn.getCname());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResourceColumn.setCcreatedate(sdf.format(resourceColumn.getCcreatedate()));
        if(resourceColumn.getCenable() == 0) {
            layUIResourceColumn.setCenable("������");
        } else if(resourceColumn.getCenable() == 1) {
            layUIResourceColumn.setCenable("����");
        } else if(resourceColumn.getCenable() == 2) {
            layUIResourceColumn.setCenable("ɾ��");
        }
        if(resourceColumn.getCshowinheader() == 0) {
            layUIResourceColumn.setCshowinheader("��");
        } else {
            layUIResourceColumn.setCshowinheader("��");
        }
        //��Ⱦ�������˺�
        layUIResourceColumn.setCcreater(superService.selectAdminById(resourceColumn.getCcreater()).getAaccount());
        //������Ⱦ���
        return layUIResourceColumn;
    }

    @Override
    public List<LayUIResourceColumn> renderResourceColumnsForLayUI(List<ResourceColumn> resourceColumns) {
        List<LayUIResourceColumn> layUIResourceColumnList = new ArrayList<>();
        for(ResourceColumn resourceColumn : resourceColumns) {
            LayUIResourceColumn layUIResourceColumn = renderResourceColumnForLayUI(resourceColumn);
            layUIResourceColumnList.add(layUIResourceColumn);
        }
        //������Ⱦ���
        return layUIResourceColumnList;
    }


    @Override
    public ResourceColumn selectResourceColumnByCid(Integer cid) {
        return resourceColumnMapper.selectByPrimaryKey(cid);
    }

    @Override
    public ResourceColumn selectResourceColumnByCname(String cname) {
        //������ѯģ��
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //��Ӳ�ѯ����
        criteria.andCnameEqualTo(cname);
        //��ѯδɾ������
        criteria.andCenableNotEqualTo(2);
        //ִ�в�ѯ
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);
        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    @Override
    public Result updateResourceColumn(ResourceColumn resourceColumn) {
        //����հ�����
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //�����Դ��Ŀ���Ƿ��ظ�
        ResourceColumn checkResourceColumn = this.selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null && checkResourceColumn.getCid() != resourceColumn.getCid()) {
                throw new XKException("����Ŀ���Ѵ���");
        }
        //ִ���޸�
        resourceColumnMapper.updateByPrimaryKeySelective(resourceColumn);
        //���ز�ѯ���
        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnById(Integer id) {
        //�߼�ɾ��
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(2);
        resourceColumn.setCid(id);
        resourceColumnMapper.updateByPrimaryKeySelective(resourceColumn);
        return Result.OK();
    }

    @Override
    public List<ResourceColumn> getHeaderResourceColumns() {
        //���ò�ѯ����
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        criteria.andCshowinheaderEqualTo(1);
        criteria.andCenableEqualTo(1);

        //ִ�в�ѯ
        return this.selectResourceColumns(resourceColumnExample, null, null);
    }
}
