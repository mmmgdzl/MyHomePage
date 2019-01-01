package com.mmmgdzl.controller;

import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.utils.DeleteParameterSplitUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * 该Controller提供用户管理控制前端访问接口
 */
@Controller
public class SuperController {

    @Autowired
    private SuperService superService;

    /**
     * 添加用户
     */
    @PostMapping("/xk/super/admin")
    @ResponseBody
    public Result addAdmin(Admin admin, HttpSession session) {
        try {
            //获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //添加用户
            Result result = superService.addAdmin(admin, currentAdmin);
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
     * 查询用户列表
     */
    @GetMapping("/xk/super/admin")
    @ResponseBody
    public LayUIResult<LayUIAdmin> selectAdminsLikeAccount(Admin admin,
                                                           @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10")Integer limit) {
        //将用户对象转换为查询模板对象
        AdminExample adminExample = superService.transformAdminToAdminExample(admin);
        //根据查询条件查询总条数
        Integer count = superService.count(adminExample);
        //根据查询条件查询用户列表
        List<Admin> admins = superService.selectAdmins(adminExample, page, limit);
        //将用户列表渲染为LayUI用户列表
        List<LayUIAdmin> layUIAdmins = superService.renderAdminsForLayUI(admins);
        //返回结果
        return new LayUIResult<>(0, count, layUIAdmins);
    }

    /**
     * 跳转到用户编辑界面
     */
    @GetMapping("/xk/super/admin/{id}")
    public String toEditPage(@PathVariable Integer id, Model data) {
        //查询id对应的管理员信息
        Admin admin = superService.selectAdminById(id);
        //消除密码
        admin.setApassword(null);
        //将数据存入
        data.addAttribute("editAdmin", admin);
        return "xk/super/adminPage/editAdmin";
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/xk/super/admin")
    @ResponseBody
    public Result updateAdmin(Admin admin, HttpSession session) {
        //执行更新
        try {
            Admin checkAdmin = superService.updateAdminSelective(admin);
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //如果更新的用户是当前登录用户则同步更新当前登录用户信息
            if(checkAdmin.getAid() == currentAdmin.getAid()) {
                session.setAttribute("admin", checkAdmin);
            }
            //返回成功结果
            return Result.OK(checkAdmin);
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/xk/super/admin")
    @ResponseBody
    public Result deleteAdmin(@RequestBody String ids) {
        try {
            //获取id列表
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //执行删除
            Result result = superService.deleteAdminsByIds(idList);
            //返回结果
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "编码失败");
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        }  catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 页面定向
     */
    @RequestMapping("/xk/super/adminPage/{path}")
    public String toSuperPage(@PathVariable String path) {
        return "xk/super/adminPage/" + path;
    }

}
