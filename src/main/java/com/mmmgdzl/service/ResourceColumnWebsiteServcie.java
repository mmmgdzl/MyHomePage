package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceColumnWebsite;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumnWebsite;
import com.mmmgdzl.pojo.ResourceColumnWebsiteExample;

import java.util.List;

public interface ResourceColumnWebsiteServcie {

    /**
     * �����Դ��Ŀ��վ
     */
    Result addResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite, Integer createrId);

    /**
     * ��ResourceColumnWebsite����ת��Ϊ��ѯģ�����
     */
    ResourceColumnWebsiteExample transformResourceColumnWebsiteToResourceColumnWebsiteExample(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * ���ݲ�ѯ�������в�ѯ��Դ��Ŀ��վ
     */
    List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ�������в�ѯ��Դ��Ŀ��վ
     */
    List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ����ͳ����Դ��Ŀ��վ��������
     */
    Integer countResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample);

    /**
     * ���ݲ�ѯ����ͳ����Դ��Ŀ��վ��������
     */
    Integer countResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * ��ResourceColumnWebsite������ȾΪLayUIResourceColumnWebsite����
     */
    LayUIResourceColumnWebsite renderResourceColumnWebsiteForLayUI(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * ��һ��ResourceColumnWebsite������ȾΪLayUIResourceColumnWebsite����
     */
    List<LayUIResourceColumnWebsite> renderResourceColumnWebsitesForLayUI(List<ResourceColumnWebsite> resourceColumnWebsites);

    /**
     * ����id��ѯһ������
     */
    ResourceColumnWebsite selectResourceColumnWebsiteById(Integer rcwid);

    /**
     * ������Դ��Ŀ��վ����
     */
    Result updateResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * ����һ��idɾ��һ����Դ��Ŀ��վ
     */
    Result deleteResourceColumnWebsitesByIds(List<Integer> ids);

    /**
     * ����cid��ȡ�ɼ���Դ��Ŀ��վ����
     */
    List<ResourceColumnWebsite> getResourceColumnWebsiteByCid(Integer cid);

}
