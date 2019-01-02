package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResourceColumnWebsite;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceColumnWebsiteServcie;
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
public class ResourceColumnWebsiteController {


    @Autowired
    private ResourceColumnService resourceColumnService;
    @Autowired
    private ResourceColumnWebsiteServcie resourceColumnWebsiteServcie;
    @Autowired
    private FileService fileService;

    /**
     * 添加资源栏目网站
     */
    @PostMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public Result addResource(String rcwname, String rcwhref, Integer rcwcid, MultipartFile rcwlogo, HttpSession session) {
        try {
            ResourceColumnWebsite resourceColumnWebsite = new ResourceColumnWebsite();
            resourceColumnWebsite.setRcwname(rcwname);
            resourceColumnWebsite.setRcwhref(rcwhref);
            resourceColumnWebsite.setRcwcid(rcwcid);
            //保存资源栏目网站logo
            Result result = fileService.uploadRcwlogo(rcwlogo);
            //设置标题图片文件名称
            resourceColumnWebsite.setRcwlogo(result.getData().toString());
            //获取当前登录的管理员
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //添加资源栏目网站
            Result finalResult = resourceColumnWebsiteServcie.addResourceColumnWebsite(resourceColumnWebsite, admin.getAid());
            //返回成功结果
            return finalResult;
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 查询资源栏目网站
     */
    @GetMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public LayUIResult<LayUIResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite,
                                                                              @RequestParam(defaultValue = "1") Integer page,
                                                                              @RequestParam(defaultValue = "10")Integer limit) {

        //将资源栏目网站对象转换为查询模板对象
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = resourceColumnWebsiteServcie.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //查询总条数
        Integer count = resourceColumnWebsiteServcie.countResourceColumnWebsites(resourceColumnWebsiteExample);
        //查询资源栏目网站列表
        List<ResourceColumnWebsite> resourceColumnWebsites = resourceColumnWebsiteServcie.selectResourceColumnWebsites(resourceColumnWebsiteExample, page, limit);
        //渲染资源栏目网站列表
        List<LayUIResourceColumnWebsite> layUIResourceColumnWebsiteList = resourceColumnWebsiteServcie.renderResourceColumnWebsitesForLayUI(resourceColumnWebsites);
        //返回查询结果
        return new LayUIResult<>(0, count, layUIResourceColumnWebsiteList);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/xk/super/resourceColumnWebsite/{id}")
    public String toEditResourcePage(@PathVariable Integer id, Model model) {
        //查询id对应的资源栏目网站信息
        ResourceColumnWebsite resourceColumnWebsite = resourceColumnWebsiteServcie.selectResourceColumnWebsiteById(id);
        //将资源信息放入model中
        model.addAttribute("editResourceColumnWebsite", resourceColumnWebsite);
        //获取所有可用栏目信息
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //将栏目信息放入model中
        model.addAttribute("resourceColumnList", resourceColumns);

        return "xk/super/resourceColumnWebsitePage/editResourceColumnWebsite";
    }

    /**
     * 编辑资源
     */
    @PostMapping("/xk/super/resourceColumnWebsiteUpdate")
    @ResponseBody
    public Result editResource(Integer rcwid, String rcwname, String rcwhref, Integer rcwcid, Integer rcwenable,
                               @RequestParam(value = "rcwlogo", required = false) MultipartFile rcwlogo) {
        try {
            ResourceColumnWebsite resourceColumnWebsite = new ResourceColumnWebsite();
            resourceColumnWebsite.setRcwid(rcwid);
            resourceColumnWebsite.setRcwname(rcwname);
            resourceColumnWebsite.setRcwhref(rcwhref);
            resourceColumnWebsite.setRcwcid(rcwcid);
            resourceColumnWebsite.setRcwenable(rcwenable);
            //检查是否要更新Logo图片
            if(rcwlogo != null) {
                //删除原Logo
                fileService.deleteResourceColumnWebsiteLogo(rcwid);
                //保存新Logo
                Result result = fileService.uploadRcwlogo(rcwlogo);
                //设置图片文件名称
                resourceColumnWebsite.setRcwlogo(result.getData().toString());
            }
            //编辑资源
            return resourceColumnWebsiteServcie.updateResourceColumnWebsite(resourceColumnWebsite);
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 删除资源栏目网站
     */
    @DeleteMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public Result deleteResource(@RequestBody String ids) {
        try {
            //执行剪切
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //执行删除
            Result result = resourceColumnWebsiteServcie.deleteResourceColumnWebsitesByIds(idList);
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
    @RequestMapping("/xk/super/resourceColumnWebsitePage/{page}")
    public String toResourceColumnWebsitePage(@PathVariable String page, Model model) {
        //获取所有可用栏目信息
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //将栏目信息放入model中
        model.addAttribute("resourceColumnList", resourceColumns);
        return "xk/super/resourceColumnWebsitePage/" + page;
    }

}
