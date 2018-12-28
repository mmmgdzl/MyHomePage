package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;

import java.util.List;

/**
 * ��Service�ṩ��Դ��Ŀ�������
 */
public interface ResourceColumnService {

    /**
     * �����Դ��Ŀ
     */
    Result addResourceColumn(ResourceColumn resourceColumn);

    /**
     * ����Դ��Ŀ����ת��Ϊ��ѯģ�����
     */
    ResourceColumnExample transformResourceColumnToResourceColumnExample(ResourceColumn resourceColumn);

    /**
     * ���ݲ�ѯ������ȡ��Դ��Ŀ
     */
    List<ResourceColumn> selectResourceColumns(ResourceColumnExample resourceColumnExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ȡ��Դ��Ŀ
     */
    List<ResourceColumn> selectResourceColumns(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(ResourceColumn resourceColumn);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(ResourceColumnExample resourceColumnExample);

    /**
     * ������Դ��Ŀ
     */
    Result updateResourceColumn(ResourceColumn resourceColumn);

    /**
     * ����Դ��Ŀ������ȾΪLayUI��Դ��Ŀ����
     */
    LayUIResourceColumn renderResourceColumnForLayUI(ResourceColumn resourceColumn);

    /**
     * ��һ����Դ��Ŀ������ȾΪLayUI��Դ��Ŀ����
     */
    List<LayUIResourceColumn> renderResourceColumnsForLayUI(List<ResourceColumn> resourceColumns);

    /**
     * ������Դ��ĿCID��ѯ��Դ��Ŀ
     */
    ResourceColumn selectResourceColumnByCid(Integer cid);

    /**
     * ������Դ��Ŀ����ѯ��Դ��Ŀ
     */
    ResourceColumn selectResourceColumnByCname(String cname);

    /**
     * ����idɾ������
     */
    Result deleteResourceColumnById(Integer id);

}
