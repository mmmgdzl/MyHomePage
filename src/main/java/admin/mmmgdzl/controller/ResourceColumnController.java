package admin.mmmgdzl.controller;

import admin.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 该Controller用于提供资源栏目操作的前端访问接口
 */
@Controller
public class ResourceColumnController {

    @Autowired
    private ResourceColumnService resourceColumnService;

    /**
     * 添加资源栏目
     */
    @PostMapping("/xk/super/resourceColumn")
    @ResponseBody
    public Result addResourceColumn(ResourceColumn resourceColumn, HttpSession session) {
        try {
            //获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute("admin");
            //设置创建用户
            resourceColumn.setCcreater(currentAdmin.getAid());
            resourceColumnService.addResourceColumn(resourceColumn);
            //返回成功结果
            return Result.OK();
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
     * 查询资源栏目信息
     */
    @GetMapping("/xk/super/resourceColumn")
    @ResponseBody
    public LayUIResult<LayUIResourceColumn> selectAdminsLikeAccount(ResourceColumn resourceColumn,
                                                           @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10")Integer limit) {

        return resourceColumnService.selectResourceColumnsForLayUI(resourceColumn, page, limit);
    }

    /**
     * 更新管理员信息
     */
    @PutMapping("/xk/super/resourceColumn")
    @ResponseBody
    public Result updateResourceColumn(ResourceColumn resourceColumn) {
        //执行更新
        try {
            Result result = resourceColumnService.updateResourceColumn(resourceColumn);
            //返回成功结果
            return result;
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
     * 删除资源栏目
     */
    @DeleteMapping("/xk/super/resourceColumn/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable String id) {
        try {
            resourceColumnService.deleteResourceColumnById(Integer.parseInt(id));
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
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
    @RequestMapping("/xk/super/resourceColumnPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/super/resourceColumnPage/" + page;
    }

}
