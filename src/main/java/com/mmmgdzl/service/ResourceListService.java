package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.PageBean;
import com.mmmgdzl.domain.ResourceListPageBean;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceExample;

import java.util.List;

public interface ResourceListService {
    /**
     * 根据cid获取可用的对应资源
     */
    ResourceListPageBean<LayUIResource> getResourceListWithBlobs(Integer cid, Integer currenetPage, Integer pageSize);

    /**
     * 根据条件查询资源总条数
     */
    Integer count(ResourceExample resourceExample);

    /**
     * 查询最热数据
     */
    List<LayUIResource> getHot(Integer topNum);

    /**
     * 根据rid获取对应资源数据
     */
    Resource getResourceInfo(Integer rid);

}
