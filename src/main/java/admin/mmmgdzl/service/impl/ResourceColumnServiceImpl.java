package admin.mmmgdzl.service.impl;

import admin.mmmgdzl.service.ResourceColumnService;
import admin.mmmgdzl.service.ResourceService;
import admin.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.ResourceColumnMapper;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 该Service提供资源栏目管理服务
 */
@Service
public class ResourceColumnServiceImpl implements ResourceColumnService {

    @Autowired
    private ResourceColumnMapper resourceColumnMapper;
    @Autowired
    private SuperService superService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public Result addResourceColumn(ResourceColumn resourceColumn) {
        //清除空白项
        ClearBlankUtil.clearStringBlank(resourceColumn);

        //检查资源栏目名是否重复
        ResourceColumn checkResourceColumn = this.selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null && checkResourceColumn.getCid() != resourceColumn.getCid()) {
            //如果资源栏目名重复且不是与自己重复则抛出异常
            throw new XKException("该资源栏目名已存在!");
        }

        //填充属性
        resourceColumn.setCid(0);
        resourceColumn.setCcreatedate(new Date());

        //执行插入
        resourceColumnMapper.insert(resourceColumn);

        //返回成功结果
        return Result.OK();
    }

    @Override
    public List<ResourceColumn> selectResourceColumn(ResourceColumn resourceColumn) {
        //清除空白项
        ClearBlankUtil.clearStringBlank(resourceColumn);
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();
        //添加查询条件
        if(resourceColumn.getCname() != null)
            criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
        if(resourceColumn.getCcreater() != null)
            criteria.andCcreaterEqualTo(resourceColumn.getCcreater());
        //执行查询并返回
        return resourceColumnMapper.selectByExample(resourceColumnExample);
    }

    @Override
    public LayUIResult<LayUIResourceColumn> selectResourceColumnsForLayUI(ResourceColumn resourceColumn, Integer currentPage, Integer pageSize) {
        //创建模板对象
        ResourceColumnExample rce = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = rce.createCriteria();

        //添加查询条件
        if(resourceColumn != null) {
            //清除空值
            ClearBlankUtil.clearStringBlank(resourceColumn);
            //添加查询条件
            if(resourceColumn.getCname() != null)
                criteria.andCnameLike("%" + resourceColumn.getCname() + "%");
        }
        //获取总条数
        int totalNum = count(rce);
        //设置分页
        PageHelper.startPage(currentPage, pageSize);
        //执行查询
        List<ResourceColumn> resourceColumnList = resourceColumnMapper.selectByExample(rce);
        //执行数据渲染
        List<LayUIResourceColumn> resultList = new ArrayList<>();
        for(ResourceColumn resourceColumn1 : resourceColumnList) {
            LayUIResourceColumn layUIResourceColumn = new LayUIResourceColumn(resourceColumn1);
            //填充创建者账号
            layUIResourceColumn.setCcreater(superService.selectAdminById(resourceColumn1.getCcreater()).getAaccount());
            resultList.add(layUIResourceColumn);
        }

        return new LayUIResult<>(0, totalNum, resultList);
    }

    /**
     * 根据资源栏目CID查询资源栏目
     */
    @Override
    public ResourceColumn selectResourceColumnByCid(Integer cid) {
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();

        //添加查询条件
        criteria.andCidEqualTo(cid);

        //执行查询
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);

        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    /**
     * 根据资源栏目名查询资源栏目
     */
    @Override
    public ResourceColumn selectResourceColumnByCname(String cname) {
        //创建查询模板
        ResourceColumnExample resourceColumnExample = new ResourceColumnExample();
        ResourceColumnExample.Criteria criteria = resourceColumnExample.createCriteria();

        //添加查询条件
        criteria.andCnameEqualTo(cname);

        //执行查询
        List<ResourceColumn> resourceColumns = resourceColumnMapper.selectByExample(resourceColumnExample);

        if(resourceColumns.size() == 0) {
            return null;
        } else {
            return resourceColumns.get(0);
        }
    }

    @Override
    public Result updateResourceColumn(ResourceColumn resourceColumn) {
        //清除空白数据
        ClearBlankUtil.clearStringBlank(resourceColumn);

        //检查资源栏目名是否重复
        ResourceColumn checkResourceColumn = selectResourceColumnByCname(resourceColumn.getCname());
        if(checkResourceColumn != null) {
            if(checkResourceColumn.getCid() == resourceColumn.getCid()) {
                throw new XKException("与原栏目名一致,无需修改");
            } else {
                throw new XKException("该栏目名已存在");
            }
        }

        //执行修改
        resourceColumnMapper.updateByPrimaryKeySelective(resourceColumn);

        return Result.OK();
    }

    @Override
    public Result deleteResourceColumnById(Integer id) {
        resourceColumnMapper.deleteByPrimaryKey(id);
        return Result.OK();
    }

    @Override
    public Integer count(ResourceColumnExample resourceColumnExample) {
        return resourceColumnMapper.countByExample(resourceColumnExample);
    }

}
