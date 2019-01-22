package com.mmmgdzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.ResourceCommentMapper;
import com.mmmgdzl.mapper.XKResourceCommentMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceComment;
import com.mmmgdzl.pojo.ResourceCommentExample;
import com.mmmgdzl.service.ResourceCommentService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceCommentServiceImpl implements ResourceCommentService {

    @Autowired
    private ResourceCommentMapper resourceCommentMapper;
    @Autowired
    private XKResourceCommentMapper xkResourceCommentMapper;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private SuperService superService;

    @Override
    public Result addResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //填充数据
        resourceComment.setRcid(0);
        Integer rcCount = this.getMaxRccount(resourceComment.getRcresource());
        resourceComment.setRccount(rcCount == null?1:rcCount + 1);
        resourceComment.setRccreater(currentAdmin.getAid());
        resourceComment.setRccreatedate(new Date());
        resourceComment.setRcupdater(currentAdmin.getAid());
        resourceComment.setRcupdatedate(new Date());
        resourceComment.setRcenable(1);

        //执行插入
        resourceCommentMapper.insert(resourceComment);
        return Result.OK();
    }

    @Override
    public ResourceCommentExample transformResourceCommentToTesourceCommentExample(ResourceComment resourceComment) {
        //创建查询模板对象
        ResourceCommentExample resourceCommentExample = new ResourceCommentExample();
        ResourceCommentExample.Criteria criteria = resourceCommentExample.createCriteria();
        //添加查询条件
        if(resourceComment != null) {
            //清除空数据
            ClearBlankUtil.clearStringBlank(resourceComment);
            //添加查询条件
            if(resourceComment.getRccount() != null)
                criteria.andRccountEqualTo(resourceComment.getRccount());
            //这里应该填充reply在对应的楼层数的rcid集合中
            if(resourceComment.getRcreply() != null)
                criteria.andRcreplyIn(xkResourceCommentMapper.selectRcidsByRccount(resourceComment.getRcreply()));
            if(resourceComment.getRccreater() != null)
                criteria.andRccreaterEqualTo(resourceComment.getRccreater());
            if(resourceComment.getRcupdater() != null)
                criteria.andRcupdaterEqualTo(resourceComment.getRcupdater());
            if(resourceComment.getRccontent() != null)
                criteria.andRccontentLike("%" + resourceComment.getRccontent() + "%");
            if(resourceComment.getRcresource() != null)
                criteria.andRcresourceEqualTo(resourceComment.getRcresource());
            if(resourceComment.getRcenable() != null)
                criteria.andRcenableEqualTo(resourceComment.getRcenable());
            else
                criteria.andRcenableNotEqualTo(2);
        }

        //返回查询模板
        return resourceCommentExample;
    }

    @Override
    public List<ResourceComment> selectResourceComments(ResourceCommentExample resourceCommentExample, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //设置分页
        if(currentPage != null && pageSize != null)
            PageHelper.startPage(currentPage, pageSize);
        //执行查询并返回
        if(currentAdmin == null || currentAdmin.getAlevel() <= 1)
            return resourceCommentMapper.selectByExample(resourceCommentExample);
        else
            return xkResourceCommentMapper.selectAdminResourceCommentsByExample(resourceCommentExample, currentAdmin.getAid());
    }

    @Override
    public List<ResourceComment> selectResourceComments(ResourceComment resourceComment, Integer currentPage, Integer pageSize, Admin currentAdmin) {
        //将ResourceComment对象转换为查询模板对象
        ResourceCommentExample resourceCommentExample = transformResourceCommentToTesourceCommentExample(resourceComment);
        //执行查询并返回
        return selectResourceComments(resourceCommentExample, currentPage, pageSize, currentAdmin);
    }

    @Override
    public Integer countResourceComment(ResourceCommentExample resourceCommentExample, Admin currentAdmin) {
        //执行统计并返回
        if(currentAdmin == null || currentAdmin.getAlevel() <= 1)
            return resourceCommentMapper.countByExample(resourceCommentExample);
        else
            return xkResourceCommentMapper.countAdminResourceCommentsByExample(resourceCommentExample, currentAdmin.getAid());
    }

    @Override
    public Integer countResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //将ResourceComment对象转换为查询模板对象
        ResourceCommentExample resourceCommentExample = transformResourceCommentToTesourceCommentExample(resourceComment);
        //执行统计并返回
        return countResourceComment(resourceCommentExample, currentAdmin);
    }

    @Override
    public LayUIResourceComment renderResourceCommentForLayUI(ResourceComment resourceComment, boolean isForBackground) {
        LayUIResourceComment layUIResourceComment = new LayUIResourceComment();
        //执行渲染
        layUIResourceComment.setRcid(resourceComment.getRcid());
        layUIResourceComment.setRccount(resourceComment.getRccount());
        layUIResourceComment.setRccontent(resourceComment.getRccontent());
        //渲染创建用户
        if(isForBackground) {
            layUIResourceComment.setRccreater(superService.selectAdminById(resourceComment.getRccreater()).getAaccount());
            layUIResourceComment.setRcupdater(superService.selectAdminById(resourceComment.getRcupdater()).getAaccount());
        } else {
            layUIResourceComment.setRccreater(superService.selectAdminById(resourceComment.getRccreater()).getAname());
            layUIResourceComment.setRcupdater(superService.selectAdminById(resourceComment.getRcupdater()).getAname());
        }
        //渲染日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIResourceComment.setRccreatedate(sdf.format(resourceComment.getRccreatedate()));
        layUIResourceComment.setRcupdatedate(sdf.format(resourceComment.getRcupdatedate()));
        //渲染资源
        Resource resource = resourceService.selectResourceById(resourceComment.getRcresource());
        layUIResourceComment.setRcresource(resource.getRtitle());
        layUIResourceComment.setRcresourcehref(resource.getRid() + "");
        //渲染资源评论状态
        if(resourceComment.getRcenable() == 0) {
            layUIResourceComment.setRcenable("不可用");
        } else if(resourceComment.getRcenable() == 1) {
            layUIResourceComment.setRcenable("可用");
        } else if(resourceComment.getRcenable() == 2) {
            layUIResourceComment.setRcenable("删除");
        }
        //渲染回复的楼层数
        if(resourceComment.getRcreply() == null)
            layUIResourceComment.setRcreply("无");
        else
            layUIResourceComment.setRcreply(resourceCommentMapper.selectByPrimaryKey(resourceComment.getRcreply()).getRccount() + "");
        return layUIResourceComment;
    }

    @Override
    public List<LayUIResourceComment> renderResourceCommentsForLayUI(List<ResourceComment> resourceComments, boolean isForBackground) {
        List<LayUIResourceComment> layUIResourceCommentList = new ArrayList<>();
        for(ResourceComment resourceComment : resourceComments) {
            layUIResourceCommentList.add(renderResourceCommentForLayUI(resourceComment, isForBackground));
        }
        return layUIResourceCommentList;
    }

    @Override
    public Result updateResourceComment(ResourceComment resourceComment, Admin currentAdmin) {
        //填充数据
        resourceComment.setRcupdater(currentAdmin.getAid());
        resourceComment.setRcupdatedate(new Date());
        //执行更新
       resourceCommentMapper.updateByPrimaryKeySelective(resourceComment);
       return Result.OK();
    }

    @Override
    public Result deleteResourceCommentsByIds(List<Integer> idList) {
        //创建删除模板对象
        ResourceComment resourceComment = new ResourceComment();
        resourceComment.setRcenable(2);
        //执行逻辑删除
        for(Integer id : idList) {
            resourceComment.setRcid(id);
            resourceCommentMapper.updateByPrimaryKeySelective(resourceComment);
        }
        return Result.OK();
    }

    @Override
    public Integer getMaxRccount(Integer rid) {
        return xkResourceCommentMapper.getMaxRccount(rid);
    }
}
