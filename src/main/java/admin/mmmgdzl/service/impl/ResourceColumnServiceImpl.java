package admin.mmmgdzl.service.impl;

import admin.mmmgdzl.service.ResourceColumnService;
import admin.mmmgdzl.service.ResourceService;
import admin.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.ResourceColumnMapper;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��Service�ṩ��Դ��Ŀ�������
 */
@Service
public class ResourceColumnServiceImpl implements ResourceColumnService {

    @Autowired
    private ResourceColumnMapper resourceColumnMapper;
    @Autowired
    private SuperService superService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public Result addResourceColumn(ResourceColumn resourceColumn) {
        //����հ���
        ClearBlankUtil.clearStringBlank(resourceColumn);

        //�����Դ��Ŀ���Ƿ��ظ�
        ResourceColumn checkResourceColumn = this.selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null && checkResourceColumn.getCid() != resourceColumn.getCid()) {
            //�����Դ��Ŀ���ظ��Ҳ������Լ��ظ����׳��쳣
            throw new XKException("����Դ��Ŀ���Ѵ���!");
        }

        //�������
        resourceColumn.setCid(0);
        resourceColumn.setCcreatedate(new Date());

        //ִ�в���
        resourceColumnMapper.insert(resourceColumn);

        //���سɹ����
        return Result.OK();
    }

    @Override
    public List<ResourceColumn> selectResourceColumn(ResourceColumn resourceColumn) {
        //����հ���
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //������ѯģ��
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //��Ӳ�ѯ����
        if(resourceColumn.getCname() != null)
            criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
        if(resourceColumn.getCcreater() != null)
            criteria.andCcreaterEqualTo(resourceColumn.getCcreater());
        //ִ�в�ѯ������
        return resourceColumnMapper.selectByExample(resourceColumnExample);
    }

    @Override
    public LayUIResult<LayUIResourceColumn> selectResourceColumnsForLayUI(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize) {
        //����ģ�����
        ResourceColumnExample rce = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = rce.createCriteria();

        //��Ӳ�ѯ����
        if(resourceColumn != null) {
            //�����ֵ
            ClearBlankUtil.clearStringBlank(resourceColumn);
            //��Ӳ�ѯ����
            if(resourceColumn.getCname() != null)
                criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
        }
        //��ȡ������
        int totalNum = count(rce);
        //���÷�ҳ
        PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ
        List<ResourceColumn> resourceColumnList = resourceColumnMapper.selectByExample(rce);
        //ִ��������Ⱦ
        List<LayUIResourceColumn> resultList = new ArrayList<>();
        for(ResourceColumn resourceColumn1 : resourceColumnList) {
            LayUIResourceColumn layUIResourceColumn = new LayUIResourceColumn(resourceColumn1);
            //��䴴�����˺�
            layUIResourceColumn.setCcreater(superService.selectAdminById(resourceColumn1.getCcreater()).getAaccount());
            resultList.add(layUIResourceColumn);
        }

        return new LayUIResult<>(0, totalNum, resultList);
    }

    /**
     * ������Դ��ĿCID��ѯ��Դ��Ŀ
     */
    @Override
    public ResourceColumn selectResourceColumnByCid(Integer cid) {
        //������ѯģ��
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();

        //��Ӳ�ѯ����
        criteria.andCidEqualTo(cid);

        //ִ�в�ѯ
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);

        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    /**
     * ������Դ��Ŀ����ѯ��Դ��Ŀ
     */
    @Override
    public ResourceColumn selectResourceColumnByCname(String cname) {
        //������ѯģ��
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();

        //��Ӳ�ѯ����
        criteria.andCnameEqualTo(cname);

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
        ResourceColumn checkResourceColumn = selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null) {
            if(checkResourceColumn.getCid() == resourceColumn.getCid()) {
                throw new XKException("��ԭ��Ŀ��һ��,�����޸�");
            } else {
                throw new XKException("����Ŀ���Ѵ���");
            }
        }

        //ִ���޸�
        resourceColumnMapper.updateByPrimaryKeySelective(resourceColumn);

        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnById(Integer id) {
        resourceColumnMapper.deleteByPrimaryKey(id);
        return Result.OK();
    }

    @Override
    public Integer count(ResourceColumnExample resourceColumnExample) {
        return resourceColumnMapper.countByExample(resourceColumnExample);
    }

}
