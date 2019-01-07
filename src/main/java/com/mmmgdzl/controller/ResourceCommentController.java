package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.ResourceCommentService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.utils.DeleteParameterSplitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ResourceCommentController {

    @Autowired
    private ResourceCommentService resourceCommentService;

    /**
     * 添加资源评论
     */
    @PostMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result addResourceComment(ResourceComment resourceComment, HttpSession session) {
        //执行插入
        try {
            //获取当前登录的用户
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            Result result = resourceCommentService.addResourceComment(resourceComment, currentAdmin);
            //返回结果
            return result;
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 查询资源评论列表
     */
    @GetMapping("/xk/protect/resourceComment")
    @ResponseBody
    public LayUIResult<LayUIResourceComment> selectResourceComments(ResourceComment resourceComment,
                                                                    @RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10")Integer limit,
                                                                    HttpSession session) {
        //获取当前用户
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //将资源对象转换为查询模板对象
        ResourceCommentExample resourceCommentExample = resourceCommentService.transformResourceCommentToTesourceCommentExample(resourceComment);
        //设置 修改时间倒序 id倒序查询
        resourceCommentExample.setOrderByClause("rcupdatedate desc");
        //查询总条数
        Integer count = resourceCommentService.countResourceComment(resourceCommentExample, admin);
        //查询资源列表
        List<ResourceComment> resourceCommentList = resourceCommentService.selectResourceComments(resourceCommentExample, page, limit, admin);
        //渲染资源列表
        List<LayUIResourceComment> layUIResourceCommentList = resourceCommentService.renderResourceCommentsForLayUI(resourceCommentList, true);
        //返回查询结果
        return new LayUIResult<>(0, count, layUIResourceCommentList);
    }

    /**
     * 查询我的资源评论列表
     */
    @GetMapping("/xk/protect/myResourceComment")
    @ResponseBody
    public LayUIResult<LayUIResourceComment> selectMyResourceComments(ResourceComment resourceComment,
                                                                    @RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10")Integer limit,
                                                                    HttpSession session) {
        //获取当前用户
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //查询我的评论
        resourceComment.setRccreater(admin.getAid());
        //将资源对象转换为查询模板对象
        ResourceCommentExample resourceCommentExample = resourceCommentService.transformResourceCommentToTesourceCommentExample(resourceComment);
        //设置 修改时间倒序 id倒序查询
        resourceCommentExample.setOrderByClause("rcupdatedate desc");
        //查询总条数
        Integer count = resourceCommentService.countResourceComment(resourceCommentExample, admin);
        //查询资源列表
        List<ResourceComment> resourceCommentList = resourceCommentService.selectResourceComments(resourceCommentExample, page, limit, null);
        //渲染资源列表
        List<LayUIResourceComment> layUIResourceCommentList = resourceCommentService.renderResourceCommentsForLayUI(resourceCommentList, true);
        //返回查询结果
        return new LayUIResult<>(0, count, layUIResourceCommentList);
    }

    /**
     * 更新管理员信息
     */
    @PutMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result updateResourceComment(ResourceComment resourceComment, HttpSession session) {
        //执行更新
        try {
            //获取当前登录的用户
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            Result result = resourceCommentService.updateResourceComment(resourceComment, currentAdmin);
            //返回成功结果
            return result;
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 删除资源
     */
    @DeleteMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result deleteResourceComments(@RequestBody String ids) {
        try {
            //执行剪切
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //执行删除
            Result result = resourceCommentService.deleteResourceCommentsByIds(idList);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "编码失败");
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 页面定向
     */
    @RequestMapping("/xk/protect/resourceCommentPage/{page}")
    public String toResourcePage(@PathVariable String page, Model model) {
        return "xk/protect/resourceCommentPage/" + page;
    }

}
