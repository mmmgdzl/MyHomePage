package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;

import java.util.List;

/**
 * 该Service提供资源栏目管理服务
 */
public interface ResourceColumnService {

    /**
     * 添加资源栏目
     */
    Result addResourceColumn(ResourceColumn resourceColumn);

    /**
     * 将资源栏目对象转换为查询模板对象
     */
    ResourceColumnExample transformResourceColumnToResourceColumnExample(ResourceColumn resourceColumn);

    /**
     * 根据查询条件获取资源栏目
     */
    List<ResourceColumn> selectResourceColumns(ResourceColumnExample resourceColumnExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件获取资源栏目
     */
    List<ResourceColumn> selectResourceColumns(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(ResourceColumn resourceColumn);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(ResourceColumnExample resourceColumnExample);

    /**
     * 更新资源栏目
     */
    Result updateResourceColumn(ResourceColumn resourceColumn);

    /**
     * 将资源栏目对象渲染为LayUI资源栏目对象
     */
    LayUIResourceColumn renderResourceColumnForLayUI(ResourceColumn resourceColumn);

    /**
     * 将一组资源栏目对象渲染为LayUI资源栏目对象
     */
    List<LayUIResourceColumn> renderResourceColumnsForLayUI(List<ResourceColumn> resourceColumns);

    /**
     * 根据资源栏目CID查询资源栏目
     */
    ResourceColumn selectResourceColumnByCid(Integer cid);

    /**
     * 根据资源栏目名查询资源栏目
     */
    ResourceColumn selectResourceColumnByCname(String cname);

    /**
     * 根据id删除数据
     */
    Result deleteResourceColumnById(Integer id);

}
