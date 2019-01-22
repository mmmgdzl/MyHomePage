package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;
import com.mmmgdzl.pojo.SystemResourceColumn;
import com.mmmgdzl.pojo.SystemResourceColumnExample;

import java.util.List;

public interface SystemResourceColumnService {

    /**
     * �����Դ��Ŀ
     */
    Result addResourceColumn(SystemResourceColumn systemResourceColumn);

    /**
     * ����Դ��Ŀ����ת��Ϊ��ѯģ�����
     */
    SystemResourceColumnExample transformResourceColumnToResourceColumnExample(SystemResourceColumn systemResourceColumn);

    /**
     * ���ݲ�ѯ������ȡ��Դ��Ŀ
     */
    List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumnExample systemResourceColumnExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ȡ��Դ��Ŀ
     */
    List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumn systemResourceColumn, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(SystemResourceColumn systemResourceColumn);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(SystemResourceColumnExample systemResourceColumnExample);

    /**
     * ������Դ��Ŀ
     */
    Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn);

    /**
     * ����Դ��Ŀ������ȾΪLayUI��Դ��Ŀ����
     */
    LayUISystemResourceColumn renderSystemResourceColumnForLayUI(SystemResourceColumn systemResourceColumn);

    /**
     * ��һ����Դ��Ŀ������ȾΪLayUI��Դ��Ŀ����
     */
    List<LayUISystemResourceColumn> renderSystemResourceColumnsForLayUI(List<SystemResourceColumn> systemResourceColumns);

    /**
     * ������Դ��ĿCID��ѯ��Դ��Ŀ
     */
    SystemResourceColumn selectSystemResourceColumnBySrcid(Integer srcid);

    /**
     * ������Դ��Ŀ����ѯ��Դ��Ŀ
     */
    SystemResourceColumn selectSystemResourceColumnBySrcname(String srcname);

    /**
     * ����idɾ������
     */
    Result deleteSystemResourceColumnById(Integer id);

}
