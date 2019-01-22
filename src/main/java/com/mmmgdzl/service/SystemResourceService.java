package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUISystemResource;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.pojo.SystemResourceExample;

import java.util.List;

public interface SystemResourceService {

    /**
     * 添加系统资源
     */
    Result addSystemResource(SystemResource systemResource);

    /**
     * 将系统资源对象转换为查询模板对象
     */
    SystemResourceExample transformResourceToSystemResourceExample(SystemResource systemResource);

    /**
     * 根据查询条件获取系统资源
     */
    List<SystemResource> selectSystemResources(SystemResourceExample systemResourceExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件获取系统资源
     */
    List<SystemResource> selectSystemResources(SystemResource systemResource, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(SystemResource systemResource);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(SystemResourceExample systemResourceExample);

    /**
     * 更新系统资源
     */
    Result updateSystemResource(SystemResource systemResource);

    /**
     * 将资源栏目对象渲染为LayUI系统资源对象
     */
    LayUISystemResource renderSystemResourceForLayUI(SystemResource systemResource);

    /**
     * 将一组系统资源对象渲染为LayUI系统资源对象
     */
    List<LayUISystemResource> renderSystemResourcesForLayUI(List<SystemResource> systemResources);

    /**
     * 根据资源栏目srid查询系统资源
     */
    SystemResource selectSystemResourceBySrid(Integer srid);

    /**
     * 根据id删除数据
     */
    Result deleteSystemResourceByIds(List<Integer> ids);

}
