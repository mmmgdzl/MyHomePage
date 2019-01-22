package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUISystemResource;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.pojo.SystemResourceExample;

import java.util.List;

public interface SystemResourceService {

    /**
     * ���ϵͳ��Դ
     */
    Result addSystemResource(SystemResource systemResource);

    /**
     * ��ϵͳ��Դ����ת��Ϊ��ѯģ�����
     */
    SystemResourceExample transformResourceToSystemResourceExample(SystemResource systemResource);

    /**
     * ���ݲ�ѯ������ȡϵͳ��Դ
     */
    List<SystemResource> selectSystemResources(SystemResourceExample systemResourceExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ȡϵͳ��Դ
     */
    List<SystemResource> selectSystemResources(SystemResource systemResource, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(SystemResource systemResource);

    /**
     * ���ݲ�ѯ������ѯ������
     */
    Integer count(SystemResourceExample systemResourceExample);

    /**
     * ����ϵͳ��Դ
     */
    Result updateSystemResource(SystemResource systemResource);

    /**
     * ����Դ��Ŀ������ȾΪLayUIϵͳ��Դ����
     */
    LayUISystemResource renderSystemResourceForLayUI(SystemResource systemResource);

    /**
     * ��һ��ϵͳ��Դ������ȾΪLayUIϵͳ��Դ����
     */
    List<LayUISystemResource> renderSystemResourcesForLayUI(List<SystemResource> systemResources);

    /**
     * ������Դ��Ŀsrid��ѯϵͳ��Դ
     */
    SystemResource selectSystemResourceBySrid(Integer srid);

    /**
     * ����idɾ������
     */
    Result deleteSystemResourceByIds(List<Integer> ids);

}
