package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResourceColumnWebsite;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumnWebsite;
import com.mmmgdzl.pojo.ResourceColumnWebsiteExample;

import java.util.List;

public interface ResourceColumnWebsiteServcie {

    /**
     * 添加资源栏目网站
     */
    Result addResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite, Integer createrId);

    /**
     * 将ResourceColumnWebsite对象转换为查询模板对象
     */
    ResourceColumnWebsiteExample transformResourceColumnWebsiteToResourceColumnWebsiteExample(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * 根据查询条件进行查询资源栏目网站
     */
    List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件进行查询资源栏目网站
     */
    List<ResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件统计资源栏目网站数据条数
     */
    Integer countResourceColumnWebsites(ResourceColumnWebsiteExample resourceColumnWebsiteExample);

    /**
     * 根据查询条件统计资源栏目网站数据条数
     */
    Integer countResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * 将ResourceColumnWebsite对象渲染为LayUIResourceColumnWebsite对象
     */
    LayUIResourceColumnWebsite renderResourceColumnWebsiteForLayUI(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * 将一组ResourceColumnWebsite对象渲染为LayUIResourceColumnWebsite对象
     */
    List<LayUIResourceColumnWebsite> renderResourceColumnWebsitesForLayUI(List<ResourceColumnWebsite> resourceColumnWebsites);

    /**
     * 根据id查询一条数据
     */
    ResourceColumnWebsite selectResourceColumnWebsiteById(Integer rcwid);

    /**
     * 更新资源栏目网站对象
     */
    Result updateResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite);

    /**
     * 根据一组id删除一组资源栏目网站
     */
    Result deleteResourceColumnWebsitesByIds(List<Integer> ids);

    /**
     * 根据cid获取可见资源栏目网站数据
     */
    List<ResourceColumnWebsite> getResourceColumnWebsiteByCid(Integer cid);

}
