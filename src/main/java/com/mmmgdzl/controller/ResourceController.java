package com.mmmgdzl.controller;

import com.mmmgdzl.pojo.ResourceExample;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.ResourceService;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.Resource;
import com.mmmgdzl.pojo.ResourceColumn;
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
 * ��Controller�����ṩ��Դ������ǰ�˷��ʽӿ�
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
     * �����Դ
     */
    @PostMapping("/xk/protect/resource")
    @ResponseBody
    public Result addResource(String rtitle, String rcontent, Integer rcolumn, MultipartFile rtitleimg, HttpSession session) {
        try {
            Resource resource = new Resource();
            resource.setRtitle(rtitle);
            resource.setRcontent(rcontent);
            resource.setRcolumn(rcolumn);
            //�������ͼƬ
            Result result = fileService.uploadRtitleimg(rtitleimg);
            //���ñ���ͼƬ�ļ�����
            resource.setRtitleimg(result.getData().toString());
            //��ȡ��ǰ��¼�Ĺ���Ա
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //�����Դ
            Result finalResult = resourceService.addResource(resource, admin.getAid());
            //���سɹ����
            return finalResult;
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ��ѯ��Դ
     */
    @GetMapping("/xk/protect/resource")
    @ResponseBody
    public LayUIResult<LayUIResource> selectResourcesLikeAccount(Resource resource,
                                                              @RequestParam(defaultValue = "1") Integer page,
                                                              @RequestParam(defaultValue = "10")Integer limit,
                                                              HttpSession session) {
        //��ȡ��ǰ�û�
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //����Դ����ת��Ϊ��ѯģ�����
        ResourceExample resourceExample = resourceService.transformResourceToResourceExample(resource, admin);
        //��ѯ������
        Integer count = resourceService.count(resourceExample);
        //��ѯ��Դ�б�
        List<Resource> resourceList = resourceService.selectResources(resourceExample, page, limit);
        //��Ⱦ��Դ�б�
        List<LayUIResource> layUIResourceList = resourceService.renderResourcesForLayUI(resourceList);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUIResourceList);
    }

    /**
     * ��ת���༭ҳ��
     */
    @GetMapping("/xk/protect/resource/{id}")
    public String toEditResourcePage(@PathVariable Integer id, Model model) {
        //��ѯid��Ӧ����Դ��Ϣ
        Resource resource = resourceService.selectResourceByIdBlob(id);
        //����Դ��Ϣ����model��
        model.addAttribute("editResource", resource);
        //��ȡ������Ŀ��Ϣ
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(new ResourceColumn(), null, null);
        //����Ŀ��Ϣ����model��
        model.addAttribute("resourceColumnList", resourceColumns);

        return "xk/protect/resourcePage/editResource";
    }

    /**
     * �༭��Դ
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
            //����Ƿ�Ҫ���±���ͼ
            if(rtitleimg != null) {
                //ɾ��ԭ����ͼ
                fileService.deleteResourceTitleImg(rid);
                //�����±���ͼ
                Result result = fileService.uploadRtitleimg(rtitleimg);
                //����ͼƬ�ļ�����
                resource.setRtitleimg(result.getData().toString());
            }
            //��ȡ��ǰ��¼�Ĺ���Ա
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //�༭��Դ
            return resourceService.updateResource(resource, admin.getAid());
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ɾ����Դ
     */
    @DeleteMapping("/xk/protect/resource")
    @ResponseBody
    public Result deleteResource(@RequestBody String ids) {
        try {
            //ִ�м���
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //ִ��ɾ��
            Result result = resourceService.deleteResourcesByIds(idList);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "����ʧ��");
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ҳ�涨��
     */
    @RequestMapping("/xk/protect/resourcePage/{page}")
    public String toAdminPage(@PathVariable String page,Model model) {
        //��ȡ������Ŀ��Ϣ
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(new ResourceColumn(), null, null);
        //����Ŀ��Ϣ����model��
        model.addAttribute("resourceColumnList", resourceColumns);
        return "xk/protect/resourcePage/" + page;
    }
}
