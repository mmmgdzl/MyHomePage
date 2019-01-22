package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.LayUISystemResource;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.service.SystemResourceService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.utils.DeleteParameterSplitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class SystemResourceController {

    @Autowired
    private FileService fileService;
    @Autowired
    private SystemResourceService systemResourceService;
    @Autowired
    private SystemResourceColumnService systemResourceColumnService;

    @PostMapping("/xk/super/systemResource")
    @ResponseBody
    public Result addSystemResource(Integer srcolumn, String srdesc, MultipartFile srfile, HttpSession session) {
        try {
            //获取当前登录用户
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //保存系统资源文件
            Result uploadResult = fileService.uploadSystemResource(srfile);
            //填充系统资源信息
            SystemResource systemResource = new SystemResource();
            systemResource.setSrcolumn(srcolumn);
            systemResource.setSrdesc(srdesc);
            systemResource.setSrname(srfile.getOriginalFilename());
            systemResource.setSrfilename(uploadResult.getData().toString());
            //设置创建用户
            systemResource.setSrcreater(currentAdmin.getAid());
            //执行插入
            Result result = systemResourceService.addSystemResource(systemResource);
            return result;
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    @GetMapping("/xk/super/systemResource")
    @ResponseBody
    public LayUIResult<LayUISystemResource> getSystemResourceList(SystemResource systemResource,
                                                                  @RequestParam(defaultValue = "1") Integer page,
                                                                  @RequestParam(defaultValue = "10")Integer limit) {
        //将资源栏目对象转换为查询模板对象
        SystemResourceExample systemResourceExample = systemResourceService.transformResourceToSystemResourceExample(systemResource);
        //查询总条数
        Integer count = systemResourceService.count(systemResourceExample);
        //查询资源栏目列表
        List<SystemResource> systemResourceList = systemResourceService.selectSystemResources(systemResourceExample, page, limit);
        //执行资源栏目渲染
        List<LayUISystemResource> layUISystemResourceList = systemResourceService.renderSystemResourcesForLayUI(systemResourceList);
        //返回查询结果
        return new LayUIResult<>(0, count, layUISystemResourceList);
    }

    /**
     * 跳转到用户编辑界面
     */
    @GetMapping("/xk/super/systemResource/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        //初始化model
        this.initModel(model);
        //查询id对应的系统资源信息
        SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(id);
        //将数据存入
        model.addAttribute("editSystemResource", systemResource);
        return "xk/super/systemResourcePage/editSystemResource";
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/xk/super/systemResource")
    @ResponseBody
    public Result updateAdmin(SystemResource systemResource) {
        //执行更新
        try {
            //执行更新
            Result result = systemResourceService.updateSystemResource(systemResource);
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
    @DeleteMapping("/xk/super/systemResource")
    @ResponseBody
    public Result deleteSystemResource(@RequestBody String ids) {
        try {
            //执行剪切
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //执行删除
            Result result = systemResourceService.deleteSystemResourceByIds(idList);
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

    @RequestMapping("/xk/super/systemResourcePage/{page}")
    public String toSystemResourcePage(@PathVariable String page, Model model) {
        //获取必要对象
        this.initModel(model);

        return "xk/super/systemResourcePage/" + page;
    }

    private void initModel(Model model) {
        //添加可用系统资源栏目列表
        SystemResourceColumn systemResourceColumn = new SystemResourceColumn();
        systemResourceColumn.setSrcenable(1);
        List<SystemResourceColumn> systemResourceColumnList = systemResourceColumnService.selectSystemResourceColumns(systemResourceColumn, null, null);
        model.addAttribute("systemResourceColumnList", systemResourceColumnList);
    }

}
