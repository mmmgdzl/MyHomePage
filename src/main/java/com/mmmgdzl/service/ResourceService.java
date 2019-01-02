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
     * 添加资源
     */
    Result addResource(Resource resource, Integer aid);

    /**
     * 将资源对象转换为查询模板对象
     */
    ResourceExample transformResourceToResourceExample(Resource resource, Admin currentAdmin);

    /**
     * 根据查询条件查询一组资源
     */
    List<Resource> selectResources(ResourceExample resourceExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件查询一组资源
     */
    List<Resource> selectResources(Resource resource, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * 根据条件查询总条数
     */
    Integer count(ResourceExample resourceExample);

    /**
     * 根据条件查询总条数
     */
    Integer count(Resource resource, Admin currentAdmin);

    /**
     * 将资源渲染为LayUI资源
     */
    LayUIResource renderResourceForLayUI(Resource resource, boolean isAname);

    /**
     * 将一组资源渲染为LayUI资源
     */
    List<LayUIResource> renderResourcesForLayUI(List<Resource> resources, boolean isAname);

    /**
     * 更新资源
     */
    Result updateResource(Resource resource, Integer aid);

    /**
     * 根据id删除资源
     */
    Result deleteResourcesByIds(List<Integer> idList);

    /**
     * 根据id查询资源(带大型数据)
     */
    Resource selectResourceByIdBlob(Integer id);
}
