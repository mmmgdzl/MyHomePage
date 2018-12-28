package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.PageBean;
import com.mmmgdzl.domain.ResourceListPageBean;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;

import java.util.List;

public interface ResourceListService {
    /**
     * ����cid��ȡ���õĶ�Ӧ��Դ
     */
    ResourceListPageBean<LayUIResource> getResourceListWithBlobs(Integer cid, Integer currenetPage, Integer pageSize);

    /**
     * ����������ѯ��Դ������
     */
    Integer count(ResourceExample resourceExample);

    /**
     * ��ѯ��������
     */
    List<LayUIResource> getHot(Integer topNum);

    /**
     * ����rid��ȡ��Ӧ��Դ����
     */
    Resource getResourceInfo(Integer rid);

}
