package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;

import java.util.List;

public interface ResourceService {

    /**
     * �����Դ
     */
    Result addResource(Resource resource, Integer aid);

    /**
     * ����Դ����ת��Ϊ��ѯģ�����
     */
    ResourceExample transformResourceToResourceExample(Resource resource, Admin currentAdmin);

    /**
     * ���ݲ�ѯ������ѯһ����Դ
     */
    List<Resource> selectResources(ResourceExample resourceExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ������ѯһ����Դ
     */
    List<Resource> selectResources(Resource resource, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * ����������ѯ������
     */
    Integer count(ResourceExample resourceExample);

    /**
     * ����������ѯ������
     */
    Integer count(Resource resource, Admin currentAdmin);

    /**
     * ����Դ��ȾΪLayUI��Դ
     */
    LayUIResource renderResourceForLayUI(Resource resource, boolean isAname);

    /**
     * ��һ����Դ��ȾΪLayUI��Դ
     */
    List<LayUIResource> renderResourcesForLayUI(List<Resource> resources, boolean isAname);

    /**
     * ������Դ
     */
    Result updateResource(Resource resource, Integer aid);

    /**
     * ����idɾ����Դ
     */
    Result deleteResourcesByIds(List<Integer> idList);

    /**
     * ����id��ѯ��Դ(����������)
     */
    Resource selectResourceByIdBlob(Integer id);
}
