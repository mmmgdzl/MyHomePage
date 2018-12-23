package admin.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;

import java.util.List;

public interface ResourceColumnService {

    /**
     * 添加资源栏目
     */
    Result addResourceColumn(ResourceColumn resourceColumn);

    /**
     * 根据条件获取资源栏目
     */
    List<ResourceColumn> selectResourceColumn(ResourceColumn resourceColumn);

    /**
     * 更新资源栏目
     */
    Result updateResourceColumn(ResourceColumn resourceColumn);

    /**
     * 根据条件查询一组资源栏目
     */
    LayUIResult<LayUIResourceColumn> selectResourceColumnsForLayUI(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize);

    /**
     * 根据资源栏目CID查询资源栏目
     */
    ResourceColumn selectResourceColumnByCid(Integer cid);

    /**
     * 根据资源栏目名查询资源栏目
     */
    ResourceColumn selectResourceColumnByCname(String cname);

    /**
     * 根据条件查询总条数
     */
    Integer count(ResourceColumnExample resourceColumnExample);

    /**
     * 根据id删除数据
     */
    Result deleteResourceColumnById(Integer id);

}
