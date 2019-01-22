package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.utils.ConstantValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemResourceColumnController {

    @Autowired
    private SystemResourceColumnService systemResourceColumnService;

    /**
     * ���ϵͳ��Դ��Ŀ
     */
    @PostMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public Result addResourceColumn(SystemResourceColumn systemResourceColumn, HttpSession session) {
        try {
            //��ȡ��ǰ��¼�û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //���ô����û�
            systemResourceColumn.setSrccreater(currentAdmin.getAid());
            //ִ�����
            Result result = systemResourceColumnService.addResourceColumn(systemResourceColumn);
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
     * ��ѯϵͳ��Դ��Ŀ��Ϣ
     */
    @GetMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public LayUIResult<LayUISystemResourceColumn> selectSystemResourceColumn(SystemResourceColumn systemResourceColumn,
                                                                             @RequestParam(defaultValue = "1") Integer page,
                                                                             @RequestParam(defaultValue = "10")Integer limit) {
        //����Դ��Ŀ����ת��Ϊ��ѯģ�����
        SystemResourceColumnExample systemResourceColumnExample = systemResourceColumnService.transformResourceColumnToResourceColumnExample(systemResourceColumn);
        //��ѯ������
        Integer count = systemResourceColumnService.count(systemResourceColumnExample);
        //��ѯ��Դ��Ŀ�б�
        List<SystemResourceColumn> systemResourceColumnList = systemResourceColumnService.selectSystemResourceColumns(systemResourceColumnExample, page, limit);
        //ִ����Դ��Ŀ��Ⱦ
        List<LayUISystemResourceColumn> layUISystemResourceColumnList = systemResourceColumnService.renderSystemResourceColumnsForLayUI(systemResourceColumnList);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUISystemResourceColumnList);
    }

    /**
     * ����ϵͳ��Դ��Ŀ��Ϣ
     */
    @PutMapping("/xk/super/systemResourceColumn")
    @ResponseBody
    public Result updateSystemResourceColumn(SystemResourceColumn systemResourceColumn) {
        //ִ�и���
        try {
            Result result = systemResourceColumnService.updateSystemResourceColumn(systemResourceColumn);
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
     * ɾ��ϵͳ��Դ��Ŀ
     */
    @DeleteMapping("/xk/super/systemResourceColumn/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable Integer id) {
        try {
            Result result = systemResourceColumnService.deleteSystemResourceColumnById(id);
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
    @RequestMapping("/xk/super/systemResourceColumnPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/super/systemResourceColumnPage/" + page;
    }



}
