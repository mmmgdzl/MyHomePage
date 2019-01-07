package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResource;
import com.mmmgdzl.domain.LayUIResourceComment;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.ResourceCommentService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.utils.DeleteParameterSplitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ResourceCommentController {

    @Autowired
    private ResourceCommentService resourceCommentService;

    /**
     * �����Դ����
     */
    @PostMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result addResourceComment(ResourceComment resourceComment, HttpSession session) {
        //ִ�в���
        try {
            //��ȡ��ǰ��¼���û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            Result result = resourceCommentService.addResourceComment(resourceComment, currentAdmin);
            //���ؽ��
            return result;
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ��ѯ��Դ�����б�
     */
    @GetMapping("/xk/protect/resourceComment")
    @ResponseBody
    public LayUIResult<LayUIResourceComment> selectResourceComments(ResourceComment resourceComment,
                                                                    @RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10")Integer limit,
                                                                    HttpSession session) {
        //��ȡ��ǰ�û�
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //����Դ����ת��Ϊ��ѯģ�����
        ResourceCommentExample resourceCommentExample = resourceCommentService.transformResourceCommentToTesourceCommentExample(resourceComment);
        //���� �޸�ʱ�䵹�� id�����ѯ
        resourceCommentExample.setOrderByClause("rcupdatedate desc");
        //��ѯ������
        Integer count = resourceCommentService.countResourceComment(resourceCommentExample, admin);
        //��ѯ��Դ�б�
        List<ResourceComment> resourceCommentList = resourceCommentService.selectResourceComments(resourceCommentExample, page, limit, admin);
        //��Ⱦ��Դ�б�
        List<LayUIResourceComment> layUIResourceCommentList = resourceCommentService.renderResourceCommentsForLayUI(resourceCommentList, true);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUIResourceCommentList);
    }

    /**
     * ��ѯ�ҵ���Դ�����б�
     */
    @GetMapping("/xk/protect/myResourceComment")
    @ResponseBody
    public LayUIResult<LayUIResourceComment> selectMyResourceComments(ResourceComment resourceComment,
                                                                    @RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10")Integer limit,
                                                                    HttpSession session) {
        //��ȡ��ǰ�û�
        Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
        //��ѯ�ҵ�����
        resourceComment.setRccreater(admin.getAid());
        //����Դ����ת��Ϊ��ѯģ�����
        ResourceCommentExample resourceCommentExample = resourceCommentService.transformResourceCommentToTesourceCommentExample(resourceComment);
        //���� �޸�ʱ�䵹�� id�����ѯ
        resourceCommentExample.setOrderByClause("rcupdatedate desc");
        //��ѯ������
        Integer count = resourceCommentService.countResourceComment(resourceCommentExample, admin);
        //��ѯ��Դ�б�
        List<ResourceComment> resourceCommentList = resourceCommentService.selectResourceComments(resourceCommentExample, page, limit, null);
        //��Ⱦ��Դ�б�
        List<LayUIResourceComment> layUIResourceCommentList = resourceCommentService.renderResourceCommentsForLayUI(resourceCommentList, true);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUIResourceCommentList);
    }

    /**
     * ���¹���Ա��Ϣ
     */
    @PutMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result updateResourceComment(ResourceComment resourceComment, HttpSession session) {
        //ִ�и���
        try {
            //��ȡ��ǰ��¼���û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            Result result = resourceCommentService.updateResourceComment(resourceComment, currentAdmin);
            //���سɹ����
            return result;
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ɾ����Դ
     */
    @DeleteMapping("/xk/protect/resourceComment")
    @ResponseBody
    public Result deleteResourceComments(@RequestBody String ids) {
        try {
            //ִ�м���
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //ִ��ɾ��
            Result result = resourceCommentService.deleteResourceCommentsByIds(idList);
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
    @RequestMapping("/xk/protect/resourceCommentPage/{page}")
    public String toResourcePage(@PathVariable String page, Model model) {
        return "xk/protect/resourceCommentPage/" + page;
    }

}
