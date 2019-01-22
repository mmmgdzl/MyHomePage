package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.utils.ConstantValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemResourceColumnController {

    @Autowired
    private SystemResourceColumnService systemResourceColumnService;

    /**
     * 添加系统资源栏目
     */
    @PostMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public Result addResourceColumn(SystemResourceColumn systemResourceColumn, HttpSession session) {
        try {
            //获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //设置创建用户
            systemResourceColumn.setSrccreater(currentAdmin.getAid());
            //执行添加
            Result result = systemResourceColumnService.addResourceColumn(systemResourceColumn);
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
     * 查询系统资源栏目信息
     */
    @GetMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public LayUIResult<LayUISystemResourceColumn> selectSystemResourceColumn(SystemResourceColumn systemResourceColumn,
                                                                             @RequestParam(defaultValue = "1") Integer page,
                                                                             @RequestParam(defaultValue = "10")Integer limit) {
        //将资源栏目对象转换为查询模板对象
        SystemResourceColumnExample systemResourceColumnExample = systemResourceColumnService.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //查询总条数
        Integer count = systemResourceColumnService.count(systemResourceColumnExample);
        //查询资源栏目列表
        List<SystemResourceColumn> systemResourceColumnList = systemResourceColumnService.selectSystemResourceColumns(systemResourceColumnExample, page, limit);
        //执行资源栏目渲染
        List<LayUISystemResourceColumn> layUISystemResourceColumnList = systemResourceColumnService.renderSystemResourceColumnsForLayUI(systemResourceColumnList);
        //返回查询结果
        return new LayUIResult<>(0, count, layUISystemResourceColumnList);
    }

    /**
     * 更新系统资源栏目信息
     */
    @PutMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn) {
        //执行更新
        try {
            Result result = systemResourceColumnService.updateSystemResourceColumn(systemResourceColumn);
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
     * 删除系统资源栏目
     */
    @DeleteMapping("/xk/super/systemResourceColumn/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable Integer id) {
        try {
            Result result = systemResourceColumnService.deleteSystemResourceColumnById(id);
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
     * 页面定向
     */
    @RequestMapping("/xk/super/systemResourceColumnPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/super/systemResourceColumnPage/" + page;
    }



}
