package com.mmmgdzl.controller;

import com.mmmgdzl.service.AdminService;
import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * ��Controller�����ṩ��̨����Ա������ǰ�˷��ʽӿ�
 */

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private SuperService superService;
    @Autowired
    private FileService fileService;

    /**
     * �û���¼
     */
    @RequestMapping("/xk/adminLogin")
    @ResponseBody
    public Result adminLogin(String account, String password, HttpSession session) {
        try{
            //У���˺�����
            Admin admin = adminService.adminLogin(account, password);
            //����½�Ĺ���Ա��Ϣ����session��
            session.setAttribute(ConstantValueUtil.ADMIN, admin);
            return Result.OK();
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.build(500, "δ֪����");
        }
    }

    /**
     * �û�ע��
     */
    @RequestMapping("/xk/doRegister")
    @ResponseBody
    public Result adminRegister(Admin admin) {
        try{
            Result result = adminService.adminRegister(admin);
            return result;
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.build(500, "δ֪����");
        }
    }

    /**
     * �û�����
     */
    @RequestMapping(value="/xk/activeAccount/{activeCode}")
    public String activeAccount(@PathVariable String activeCode, Model model) {
        try{
            Result result = adminService.adminActive(activeCode);
            model.addAttribute("activeAdminAccount", result.getData());
            model.addAttribute("activeResult", "����ɹ�");
        } catch (XKException e) {
            model.addAttribute("activeResult", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("activeResult", "δ֪����");
        }
        return "xk/login";
    }

    /**
     * �û��ǳ�
     */
    @RequestMapping("/xk/protect/adminLogout")
    @ResponseBody
    public Result adminLogout(HttpSession httpSession) {
        //ɾ��session���е��û���Ϣ
        httpSession.setAttribute(ConstantValueUtil.ADMIN, null);
        //���سɹ����
        return Result.OK();
    }

    /**
     * �û��޸�����
     */
    @RequestMapping("/xk/protect/doChangePassword")
    @ResponseBody
    public Result changePassword(Admin admin, String newPassword) {
        try{
            Result result = adminService.adminChangePassword(admin, newPassword);
            return result;
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.build(500, "δ֪����");
        }
    }

    /**
     * �ϴ�/����ͷ��
     */
    @RequestMapping("/xk/protect/upload/headImage")
    @ResponseBody
    public Result uploadHeadImage(@RequestParam("file") MultipartFile multipartFile, HttpSession session) {
        try {
            //��session���л�ȡ��ǰ��¼�û�
            Admin admin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //��ȡ��ǰ�û���aid
            Integer aid = admin.getAid();
            //���µ�ǰ��¼�û���ͷ��
            Result result = fileService.updateHeadImage(multipartFile, aid);
            //���µ�ǰsession�еĹ���Աͷ����Ϣ
            Admin refreshAdmin = superService.selectAdminById(admin.getAid());
            session.setAttribute(ConstantValueUtil.ADMIN, refreshAdmin);
            return result;
        } catch(XKException e) {
            return  Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * �û��޸ĸ�����Ϣ
     */
    @RequestMapping("/xk/protect/doChangeUserInfo")
    @ResponseBody
    public Result doChangeUserInfo(Admin admin, HttpSession session) {
        try {
            //��session�л�ȡ��ǰ��¼�û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //�����û�aid
            admin.setAid(currentAdmin.getAid());
            //�����û���Ϣ
            adminService.adminUpdateInfo(admin);
            //��ȡ���º���û���Ϣ
            currentAdmin = superService.selectAdminById(currentAdmin.getAid());
            //ȥ������
            currentAdmin.setApassword(null);
            //�����º���û���Ϣ����session����
            session.setAttribute("admin", currentAdmin);
            return Result.OK(currentAdmin);
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ҳ�涨��
     */
    @RequestMapping("/xk")
    public String toAdminLogin() {
        return "xk/login";
    }

    @RequestMapping("/xk/{path}")
    public String toPage(@PathVariable String path) {
        return "xk/" + path;
    }

    @RequestMapping("/xk/index")
    public String toStartPage() {
        return "xk/outside";
    }

    @RequestMapping("/xk/protect/personalPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/protect/personalPage/" + page;
    }

}
