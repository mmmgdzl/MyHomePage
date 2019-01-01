package com.mmmgdzl.controller;

import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.utils.DeleteParameterSplitUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * ��Controller�ṩ�û��������ǰ�˷��ʽӿ�
 */
@Controller
public class SuperController {

    @Autowired
    private SuperService superService;

    /**
     * ����û�
     */
    @PostMapping("/xk/super/admin")
    @ResponseBody
    public Result addAdmin(Admin admin, HttpSession session) {
        try {
            //��ȡ��ǰ��¼�û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //����û�
            Result result = superService.addAdmin(admin, currentAdmin);
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
     * ��ѯ�û��б�
     */
    @GetMapping("/xk/super/admin")
    @ResponseBody
    public LayUIResult<LayUIAdmin> selectAdminsLikeAccount(Admin admin,
                                                           @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10")Integer limit) {
        //���û�����ת��Ϊ��ѯģ�����
        AdminExample adminExample = superService.transformAdminToAdminExample(admin);
        //���ݲ�ѯ������ѯ������
        Integer count = superService.count(adminExample);
        //���ݲ�ѯ������ѯ�û��б�
        List<Admin> admins = superService.selectAdmins(adminExample, page, limit);
        //���û��б���ȾΪLayUI�û��б�
        List<LayUIAdmin> layUIAdmins = superService.renderAdminsForLayUI(admins);
        //���ؽ��
        return new LayUIResult<>(0, count, layUIAdmins);
    }

    /**
     * ��ת���û��༭����
     */
    @GetMapping("/xk/super/admin/{id}")
    public String toEditPage(@PathVariable Integer id, Model data) {
        //��ѯid��Ӧ�Ĺ���Ա��Ϣ
        Admin admin = superService.selectAdminById(id);
        //��������
        admin.setApassword(null);
        //�����ݴ���
        data.addAttribute("editAdmin", admin);
        return "xk/super/adminPage/editAdmin";
    }

    /**
     * �����û���Ϣ
     */
    @PutMapping("/xk/super/admin")
    @ResponseBody
    public Result updateAdmin(Admin admin, HttpSession session) {
        //ִ�и���
        try {
            Admin checkAdmin = superService.updateAdminSelective(admin);
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //������µ��û��ǵ�ǰ��¼�û���ͬ�����µ�ǰ��¼�û���Ϣ
            if(checkAdmin.getAid() == currentAdmin.getAid()) {
                session.setAttribute("admin", checkAdmin);
            }
            //���سɹ����
            return Result.OK(checkAdmin);
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ɾ���û�
     */
    @DeleteMapping("/xk/super/admin")
    @ResponseBody
    public Result deleteAdmin(@RequestBody String ids) {
        try {
            //��ȡid�б�
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //ִ��ɾ��
            Result result = superService.deleteAdminsByIds(idList);
            //���ؽ��
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "����ʧ��");
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        }  catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ҳ�涨��
     */
    @RequestMapping("/xk/super/adminPage/{path}")
    public String toSuperPage(@PathVariable String path) {
        return "xk/super/adminPage/" + path;
    }

}
