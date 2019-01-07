package com.mmmgdzl.controller;

import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
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

/**
 * 该Controller用于提供资源操作的前端访问接口
 */
@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ResourceColumnService resourceColumnService;
    @Autowired
    private FileService fileService;

    /**
     * 添加资源
     */
    @PostMapping("/xk/protect/resource")
    @ResponseBody
    public Result addResource(String rtitle, String rcontent, Integer rcolumn, MultipartFile rtitleimg, HttpSession session) {
        try {
            Resource resource = new Resource();
            resource.setRtitle(rtitle);
            resource.setRcontent(rcontent);
            resource.setRcolumn(rcolumn);
            //保存标题图片
            Result result = fileService.uploadRtitleimg(rtitleimg);
            //设置标题图片文件名称
            resource.setRtitleimg(result.getData().toString());
            //获取当前登录的管理员
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //添加资源
            Result finalResult = resourceService.addResource(resource, admin.getAid());
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
     * 查询资源
     */
    @GetMapping("/xk/protect/resource")
    @ResponseBody
    public LayUIResult<LayUIResource> selectResources(Resource resource,
                                                          @RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10")Integer limit,
                                                          HttpSession session) {
        //获取当前用户
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //将资源对象转换为查询模板对象
        ResourceExample resourceExample = resourceService.transformResourceToResourceExample(resource, admin);
        //设置 修改时间倒序 id倒序查询
        resourceExample.setOrderByClause("rupdatedate desc");
        //查询总条数
        Integer count = resourceService.count(resourceExample);
        //查询资源列表
        List<Resource> resourceList = resourceService.selectResources(resourceExample, page, limit);
        //渲染资源列表
        List<LayUIResource> layUIResourceList = resourceService.renderResourcesForLayUI(resourceList, false);
        //返回查询结果
        return new LayUIResult<>(0, count, layUIResourceList);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/xk/protect/resource/{id}")
    public String toEditResourcePage(@PathVariable Integer id, Model model) {
        //查询id对应的资源信息
        Resource resource = resourceService.selectResourceByIdBlob(id);
        //将资源信息放入model中
        model.addAttribute("editResource", resource);
        //获取所有可用栏目信息
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //将栏目信息放入model中
        model.addAttribute("resourceColumnList", resourceColumns);

        return "xk/protect/resourcePage/editResource";
    }

    /**
     * 编辑资源
     */
    @PostMapping("/xk/protect/resourceUpdate")
    @ResponseBody
    public Result editResource(Integer rid, String rtitle, String rcontent, Integer rcolumn, Integer renable,
                               @RequestParam(value = "rtitleimg", required = false) MultipartFile rtitleimg, HttpSession session) {
        try {
            Resource resource = new Resource();
            resource.setRid(rid);
            resource.setRtitle(rtitle);
            resource.setRcontent(rcontent);
            resource.setRcolumn(rcolumn);
            resource.setRenable(renable);
            //检查是否要更新标题图
            if(rtitleimg != null) {
                //删除原标题图
                fileService.deleteResourceTitleImg(rid);
                //保存新标题图
                Result result = fileService.uploadRtitleimg(rtitleimg);
                //设置图片文件名称
                resource.setRtitleimg(result.getData().toString());
            }
            //获取当前登录的管理员
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //编辑资源
            return resourceService.updateResource(resource, admin.getAid());
        } catch (XKException e) {
            //如果执行出现异常则返回异常原因
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //如果执行出现异常则返回异常原因
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 删除资源
     */
    @DeleteMapping("/xk/protect/resource")
    @ResponseBody
    public Result deleteResource(@RequestBody String ids) {
        try {
            //执行剪切
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //执行删除
            Result result = resourceService.deleteResourcesByIds(idList);
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
    @RequestMapping("/xk/protect/resourcePage/{page}")
    public String toResourcePage(@PathVariable String page,Model model) {
        //获取可用栏目列表
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //将栏目信息放入model中
        model.addAttribute("resourceColumnList", resourceColumns);
        return "xk/protect/resourcePage/" + page;
    }
}
