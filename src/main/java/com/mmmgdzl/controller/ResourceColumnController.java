package com.mmmgdzl.controller;

import com.mmmgdzl.pojo.ResourceColumnExample;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.utils.ConstantValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ��Controller�����ṩ��Դ��Ŀ������ǰ�˷��ʽӿ�
 */
@Controller
public class ResourceColumnController {

    @Autowired
    private ResourceColumnService resourceColumnService;

    /**
     * �����Դ��Ŀ
     */
    @PostMapping("/xk/super/resourceColumn")
    @ResponseBody
    public Result addResourceColumn(ResourceColumn resourceColumn, HttpSession session) {
        try {
            //��ȡ��ǰ��¼�û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //���ô����û�
            resourceColumn.setCcreater(currentAdmin.getAid());
            //ִ�����
            Result result = resourceColumnService.addResourceColumn(resourceColumn);
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
     * ��ѯ��Դ��Ŀ��Ϣ
     */
    @GetMapping("/xk/super/resourceColumn")
    @ResponseBody
    public LayUIResult<LayUIResourceColumn> selectAdminsLikeAccount(ResourceColumn resourceColumn,
                                                           @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10")Integer limit) {
        //����Դ��Ŀ����ת��Ϊ��ѯģ�����
        ResourceColumnExample resourceColumnExample = resourceColumnService.transformResourceColumnToResourceColumnExample(resourceColumn);
        //��ѯ������
        Integer count = resourceColumnService.count(resourceColumnExample);
        //��ѯ��Դ��Ŀ�б�
        List<ResourceColumn> resourceColumnList = resourceColumnService.selectResourceColumns(resourceColumnExample, page, limit);
        //ִ����Դ��Ŀ��Ⱦ
        List<LayUIResourceColumn> layUIResourceColumnList = resourceColumnService.renderResourceColumnsForLayUI(resourceColumnList);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUIResourceColumnList);
    }

    /**
     * ���¹���Ա��Ϣ
     */
    @PutMapping("/xk/super/resourceColumn")
    @ResponseBody
    public Result updateResourceColumn(ResourceColumn resourceColumn) {
        //ִ�и���
        try {
            Result result = resourceColumnService.updateResourceColumn(resourceColumn);
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
     * ɾ����Դ��Ŀ
     */
    @DeleteMapping("/xk/super/resourceColumn/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable Integer id) {
        try {
            Result result = resourceColumnService.deleteResourceColumnById(id);
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
     * ҳ�涨��
     */
    @RequestMapping("/xk/super/resourceColumnPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/super/resourceColumnPage/" + page;
    }

}
