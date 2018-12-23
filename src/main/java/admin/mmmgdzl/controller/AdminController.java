package admin.mmmgdzl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import admin.mmmgdzl.service.SuperService;
import admin.mmmgdzl.service.UploadService;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.mmmgdzl.service.AdminService;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 该Controller用于提供后台管理员操作的前端访问接口
 */

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private SuperService superService;
    @Autowired
    private UploadService uploadService;

    /**
     * 管理员登录
     */
    @RequestMapping("/xk/adminLogin")
    @ResponseBody
    public Result adminLogin(String account, String password, HttpSession session) {
        //校对账号密码
        Result result = adminService.adminLogin(account, password);
        //如果登陆成功则将管理员信息放入session中
        if(result.getCode() == 200) {
            session.setAttribute("admin", result.getData());
            result.setData(null);
        }
        return result;
    }

    /**
     * 管理员注册
     */
    @RequestMapping("/xk/doRegister")
    @ResponseBody
    public Result adminRegister(Admin admin) {
        try{
            Result result = adminService.adminRegister(admin);
            return result;
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.build(500, "未知错误");
        }
    }

    /**
     * 管理员激活
     */
    @RequestMapping(value="/xk/activeAccount/{activeCode}")
    public String activeAccount(@PathVariable String activeCode, Model model) {
        try{
            Result result = adminService.adminActive(activeCode);
            model.addAttribute("activeAdminAccount", result.getData());
            model.addAttribute("activeResult", "激活成功");
        } catch (XKException e) {
            model.addAttribute("activeResult", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("activeResult", "未知错误");
        }
        return "xk/login";
    }

    /**
     * 管理员登出
     */
    @RequestMapping("/xk/protect/adminLogout")
    @ResponseBody
    public Result adminLogout(HttpSession httpSession) {
        httpSession.setAttribute("admin", null);
        return Result.OK();
    }

    /**
     * 管理员修改密码
     */
    @RequestMapping("/xk/protect/doChangePassword")
    @ResponseBody
    public Result changePassword(Admin admin, String newPassword) {
        try{
            Result result = adminService.adminChangePassword(admin, newPassword);
            return result;
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.build(500, "未知错误");
        }
    }

    /**
     * 上传/更新头像
     */
    @RequestMapping("/xk/protect/upload/headImage")
    @ResponseBody
    public Result uploadHeadImage(@RequestParam("file") MultipartFile multipartFile, HttpSession session) {
        try {
            //从session域中获取当前登录用户
            Admin admin = (Admin) session.getAttribute("admin");
            //获取当前用户的aid
            Integer aid = admin.getAid();
            //更新当前登录用户的头像
            Result result = uploadService.updateHeadImage(multipartFile, aid);
            //更新当前session中的管理员头像信息
            Admin refreshAdmin = superService.selectAdminById(admin.getAid());
            session.setAttribute("admin", refreshAdmin);
            return result;
        } catch(XKException e) {
            return  Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 用户修改个人信息
     */
    @RequestMapping("/xk/protect/doChangeUserInfo")
    @ResponseBody
    public Result doChangeUserInfo(Admin admin, HttpSession session) {
        try {
            //从session中获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute("admin");
            //设置用户aid
            admin.setAid(currentAdmin.getAid());
            //更新用户信息
            adminService.adminUpdateInfo(admin);
            //获取更新后的用户信息
            currentAdmin = superService.selectAdminById(currentAdmin.getAid());
            //将更新后的用户信息放入session域中
            session.setAttribute("admin", currentAdmin);
            return Result.OK(currentAdmin);
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 页面定向
     */
    @RequestMapping("/xk")
    public String toAdminLogin() {
        return "xk/login";
    }


    @RequestMapping("/xk/{path}")
    public String toPage(@PathVariable String path) {
        return "xk/" + path;
    }

    @RequestMapping("/xk/protect/index")
    public String toStartPage() {
        return "xk/protect/outside";
    }

    @RequestMapping("/xk/protect/personalPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/protect/personalPage/" + page;
    }

}
