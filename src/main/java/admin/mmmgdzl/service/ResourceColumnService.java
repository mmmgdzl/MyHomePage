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
     * �����Դ��Ŀ
     */
    Result addResourceColumn(ResourceColumn resourceColumn);

    /**
     * ����������ȡ��Դ��Ŀ
     */
    List<ResourceColumn> selectResourceColumn(ResourceColumn resourceColumn);

    /**
     * ������Դ��Ŀ
     */
    Result updateResourceColumn(ResourceColumn resourceColumn);

    /**
     * ����������ѯһ����Դ��Ŀ
     */
    LayUIResult<LayUIResourceColumn> selectResourceColumnsForLayUI(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize);

    /**
     * ������Դ��ĿCID��ѯ��Դ��Ŀ
     */
    ResourceColumn selectResourceColumnByCid(Integer cid);

    /**
     * ������Դ��Ŀ����ѯ��Դ��Ŀ
     */
    ResourceColumn selectResourceColumnByCname(String cname);

    /**
     * ����������ѯ������
     */
    Integer count(ResourceColumnExample resourceColumnExample);

    /**
     * ����idɾ������
     */
    Result deleteResourceColumnById(Integer id);

}
