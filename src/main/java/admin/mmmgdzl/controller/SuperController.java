package admin.mmmgdzl.controller;

import admin.mmmgdzl.service.SuperService;
import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 该Controller提供管理员管理控制前端访问接口
 */
@Controller
public class SuperController {

    @Autowired
    private SuperService superService;

    /**
     * 添加
     */
    @PostMapping("/xk/super/admin")
    @ResponseBody
    public Result addAdmin(Admin admin, HttpSession session) {
        try {
            //获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute("admin");
            //添加用户
            superService.addAdmin(admin, currentAdmin);
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
        //返回成功结果
        return Result.OK();
    }

    /**
     * 查询管理员信息
     */
    @GetMapping("/xk/super/admin")
    @ResponseBody
    public LayUIResult<LayUIAdmin> selectAdminsLikeAccount(Admin admin,
                                                           @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10")Integer limit) {
        return superService.selectAdminsForLayUI(admin, page, limit);
    }

    /**
     * 跳转到编辑界面
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
     * 更新管理员信息
     */
    @PutMapping("/xk/super/admin")
    @ResponseBody
    public Result updateAdmin(Admin admin, HttpSession session) {
        //执行更新
        try {
            Admin checkAdmin = superService.updateAdminSelective(admin);
            Admin currentAdmin = (Admin) session.getAttribute("admin");
            if(checkAdmin.getAid() == currentAdmin.getAid()) {
                session.setAttribute("admin", checkAdmin);
            }
            //返回成功结果
            return Result.OK(checkAdmin);
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }

    }

    /**
     * 删除管理员
     */
    @DeleteMapping("/xk/super/admin")
    @ResponseBody
    public Result deleteAdmin(@RequestBody String ids) {
        try {
            //剪切
            ids = URLDecoder.decode(ids, "UTF-8");
            ids = ids.substring(5, ids.length()-1);
            //分割
            String[] ids2 = ids.split(",");
            //转换为Integer数组
            Integer[] idArray = new Integer[ids2.length];
            for(int i=0; i<idArray.length; i++) {
                idArray[i] = Integer.parseInt(ids2[i]);
            }
            //执行删除
            superService.deleteAdminsByIds(idArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "编码失败");
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
        return Result.OK();
    }

    /**
     * 页面定向
     */
    @RequestMapping("/xk/super/adminPage/{path}")
    public String toSuperPage(@PathVariable String path) {
        return "xk/super/adminPage/" + path;
    }

}
