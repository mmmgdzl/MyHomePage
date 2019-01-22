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

        //��ѯ�Ƿ����ظ����Ƶ�ϵͳ��Դ��Ŀ
        if(this.selectSystemResourceColumnBySrcname(systemResourceColumn.getSrcname()) != null)
            throw new XKException("��ϵͳ��Դ��Ŀ���Ѵ���");

        //�������
        systemResourceColumn.setSrcid(0);
        systemResourceColumn.setSrccreatedate(new Date());
        systemResourceColumn.setSrcenable(1);

        //ִ�����
        systemResourceColumnMapper.insert(systemResourceColumn);

        return Result.OK();
    }

    @Override
    public SystemResourceColumnExample transformResourceColumnToResourceColumnExample(SystemResourceColumn systemResourceColumn) {

        //������ѯģ�����
        SystemResourceColumnExample systemResourceColumnExample = new SystemResourceColumnExample();
        SystemResourceColumnExample.Criteria criteria = systemResourceColumnExample.createCriteria();

        if(systemResourceColumn != null) {
            //���������
            ClearBlankUtil.clearStringBlank(systemResourceColumn);
            //�������
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
        //���÷�ҳ
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ������
        return systemResourceColumnMapper.selectByExample(systemResourceColumnExample);
    }

    @Override
    public List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumn systemResourceColumn, Integer currentPage, Integer pageSize) {
        //����ѯ����ת��Ϊ��ѯģ�����
        SystemResourceColumnExample systemResourceColumnExample = this.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //ִ�в�ѯ������
        return this.selectSystemResourceColumns(systemResourceColumnExample, currentPage, pageSize);
    }

    @Override
    public Integer count(SystemResourceColumn systemResourceColumn) {
        //����ѯ����ת��Ϊ��ѯģ�����
        SystemResourceColumnExample systemResourceColumnExample = this.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //ִ�в�ѯ������
        return this.count(systemResourceColumnExample);
    }

    @Override
    public Integer count(SystemResourceColumnExample systemResourceColumnExample) {
        return systemResourceColumnMapper.countByExample(systemResourceColumnExample);
    }

    @Override
    public Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn) {
        //��ѯ�Ƿ����ظ����Ƶ�ϵͳ��Դ��Ŀ
        SystemResourceColumn checkSystemResourceColumn = this.selectSystemResourceColumnBySrcname(systemResourceColumn.getSrcname());
        if(checkSystemResourceColumn != null && checkSystemResourceColumn.getSrcid() != systemResourceColumn.getSrcid())
            throw new XKException("��ϵͳ��Դ��Ŀ���Ѵ���");

        //ִ�и���
        systemResourceColumnMapper.updateByPrimaryKeySelective(systemResourceColumn);

        return Result.OK();
    }

    @Override
    public LayUISystemResourceColumn renderSystemResourceColumnForLayUI(SystemResourceColumn systemResourceColumn) {
        LayUISystemResourceColumn layUISystemResourceColumn = new LayUISystemResourceColumn();
        layUISystemResourceColumn.setSrcid(systemResourceColumn.getSrcid());
        layUISystemResourceColumn.setSrcname(systemResourceColumn.getSrcname());
        //ִ����Ⱦ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUISystemResourceColumn.setSrccreatedate(sdf.format(systemResourceColumn.getSrccreatedate()));
        if(systemResourceColumn.getSrcenable() == 0)
            layUISystemResourceColumn.setSrcenable("������");
        else if(systemResourceColumn.getSrcenable() == 1)
            layUISystemResourceColumn.setSrcenable("����");
        else if(systemResourceColumn.getSrcenable() == 2)
            layUISystemResourceColumn.setSrcenable("ɾ��");
        //��Ⱦ������
        layUISystemResourceColumn.setSrccreater(superService.selectAdminById(systemResourceColumn.getSrccreater()).getAaccount());
        return layUISystemResourceColumn;
    }

    @Override
    public List<LayUISystemResourceColumn> renderSystemResourceColumnsForLayUI(List<SystemResourceColumn> systemResourceColumns) {
        List<LayUISystemResourceColumn> layUISystemResourceColumnList = new ArrayList<LayUISystemResourceColumn>();
        for(SystemResourceColumn systemResourceColumn : systemResourceColumns) {
            //ִ����Ⱦ
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

        //ѡ��������ͬ����
        criteria.andSrcnameEqualTo(srcname);
        //ѡ��δɾ������
        criteria.andSrcenableNotEqualTo(2);

        //ִ�в�ѯ
        List<SystemResourceColumn> systemResourceColumns = systemResourceColumnMapper.selectByExample(systemResourceColumnExample);

        if(systemResourceColumns.size() == 0)
            return null;
        else
            return systemResourceColumns.get(0);
    }

    @Override
    public Result deleteSystemResourceColumnById(Integer id) {
        SystemResourceColumn systemResourceColumn = new SystemResourceColumn();
        //����ɾ������
        systemResourceColumn.setSrcid(id);
        systemResourceColumn.setSrcenable(2);

        //ִ���߼�ɾ��
        systemResourceColumnMapper.updateByPrimaryKeySelective(systemResourceColumn);

        return Result.OK();
    }
}
