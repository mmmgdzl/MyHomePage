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
     * �����Դ��Ŀ��վ
     */
    @PostMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public Result addResource(String rcwname, String rcwhref, Integer rcwcid, MultipartFile rcwlogo, HttpSession session) {
        try {
            ResourceColumnWebsite resourceColumnWebsite = new ResourceColumnWebsite();
            resourceColumnWebsite.setRcwname(rcwname);
            resourceColumnWebsite.setRcwhref(rcwhref);
            resourceColumnWebsite.setRcwcid(rcwcid);
            //������Դ��Ŀ��վlogo
            Result result = fileService.uploadRcwlogo(rcwlogo);
            //���ñ���ͼƬ�ļ�����
            resourceColumnWebsite.setRcwlogo(result.getData().toString());
            //��ȡ��ǰ��¼�Ĺ���Ա
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //�����Դ��Ŀ��վ
            Result finalResult = resourceColumnWebsiteServcie.addResourceColumnWebsite(resourceColumnWebsite, admin.getAid());
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
     * ��ѯ��Դ��Ŀ��վ
     */
    @GetMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public LayUIResult<LayUIResourceColumnWebsite> selectResourceColumnWebsites(ResourceColumnWebsite resourceColumnWebsite,
                                                                              @RequestParam(defaultValue = "1") Integer page,
                                                                              @RequestParam(defaultValue = "10")Integer limit) {

        //����Դ��Ŀ��վ����ת��Ϊ��ѯģ�����
        ResourceColumnWebsiteExample resourceColumnWebsiteExample = resourceColumnWebsiteServcie.transformResourceColumnWebsiteToResourceColumnWebsiteExample(resourceColumnWebsite);
        //��ѯ������
        Integer count = resourceColumnWebsiteServcie.countResourceColumnWebsites(resourceColumnWebsiteExample);
        //��ѯ��Դ��Ŀ��վ�б�
        List<ResourceColumnWebsite> resourceColumnWebsites = resourceColumnWebsiteServcie.selectResourceColumnWebsites(resourceColumnWebsiteExample, page, limit);
        //��Ⱦ��Դ��Ŀ��վ�б�
        List<LayUIResourceColumnWebsite> layUIResourceColumnWebsiteList = resourceColumnWebsiteServcie.renderResourceColumnWebsitesForLayUI(resourceColumnWebsites);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUIResourceColumnWebsiteList);
    }

    /**
     * ��ת���༭ҳ��
     */
    @GetMapping("/xk/super/resourceColumnWebsite/{id}")
    public String toEditResourcePage(@PathVariable Integer id, Model model) {
        //��ѯid��Ӧ����Դ��Ŀ��վ��Ϣ
        ResourceColumnWebsite resourceColumnWebsite = resourceColumnWebsiteServcie.selectResourceColumnWebsiteById(id);
        //����Դ��Ϣ����model��
        model.addAttribute("editResourceColumnWebsite", resourceColumnWebsite);
        //��ȡ���п�����Ŀ��Ϣ
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //����Ŀ��Ϣ����model��
        model.addAttribute("resourceColumnList", resourceColumns);

        return "xk/super/resourceColumnWebsitePage/editResourceColumnWebsite";
    }

    /**
     * �༭��Դ
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
            //����Ƿ�Ҫ����LogoͼƬ
            if(rcwlogo != null) {
                //ɾ��ԭLogo
                fileService.deleteResourceColumnWebsiteLogo(rcwid);
                //������Logo
                Result result = fileService.uploadRcwlogo(rcwlogo);
                //����ͼƬ�ļ�����
                resourceColumnWebsite.setRcwlogo(result.getData().toString());
            }
            //�༭��Դ
            return resourceColumnWebsiteServcie.updateResourceColumnWebsite(resourceColumnWebsite);
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ɾ����Դ��Ŀ��վ
     */
    @DeleteMapping("/xk/super/resourceColumnWebsite")
    @ResponseBody
    public Result deleteResource(@RequestBody String ids) {
        try {
            //ִ�м���
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //ִ��ɾ��
            Result result = resourceColumnWebsiteServcie.deleteResourceColumnWebsitesByIds(idList);
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
    @RequestMapping("/xk/super/resourceColumnWebsitePage/{page}")
    public String toResourceColumnWebsitePage(@PathVariable String page, Model model) {
        //��ȡ���п�����Ŀ��Ϣ
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setCenable(1);
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        List<ResourceColumn> resourceColumns = resourceColumnService.selectResourceColumns(resourceColumnExample, null, null);
        //����Ŀ��Ϣ����model��
        model.addAttribute("resourceColumnList", resourceColumns);
        return "xk/super/resourceColumnWebsitePage/" + page;
    }

}
