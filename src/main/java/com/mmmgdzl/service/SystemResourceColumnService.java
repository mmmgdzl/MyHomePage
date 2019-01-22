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
     * 添加资源栏目
     */
    Result addResourceColumn(SystemResourceColumn systemResourceColumn);

    /**
     * 将资源栏目对象转换为查询模板对象
     */
    SystemResourceColumnExample transformResourceColumnToResourceColumnExample(SystemResourceColumn systemResourceColumn);

    /**
     * 根据查询条件获取资源栏目
     */
    List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumnExample systemResourceColumnExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件获取资源栏目
     */
    List<SystemResourceColumn> selectSystemResourceColumns(SystemResourceColumn systemResourceColumn, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(SystemResourceColumn systemResourceColumn);

    /**
     * 根据查询条件查询总条数
     */
    Integer count(SystemResourceColumnExample systemResourceColumnExample);

    /**
     * 更新资源栏目
     */
    Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn);

    /**
     * 将资源栏目对象渲染为LayUI资源栏目对象
     */
    LayUISystemResourceColumn renderSystemResourceColumnForLayUI(SystemResourceColumn systemResourceColumn);

    /**
     * 将一组资源栏目对象渲染为LayUI资源栏目对象
     */
    List<LayUISystemResourceColumn> renderSystemResourceColumnsForLayUI(List<SystemResourceColumn> systemResourceColumns);

    /**
     * 根据资源栏目CID查询资源栏目
     */
    SystemResourceColumn selectSystemResourceColumnBySrcid(Integer srcid);

    /**
     * 根据资源栏目名查询资源栏目
     */
    SystemResourceColumn selectSystemResourceColumnBySrcname(String srcname);

    /**
     * 根据id删除数据
     */
    Result deleteSystemResourceColumnById(Integer id);

}
