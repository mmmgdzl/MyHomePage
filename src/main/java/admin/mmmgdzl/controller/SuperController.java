package admin.mmmgdzl.controller;

import admin.mmmgdzl.service.SuperService;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.List;

/**
 * ��Controller�ṩ����Ա�������
 */
@Controller
public class SuperController {

    @Autowired
    private SuperService superService;

    /**
     * ���
     */
    @PostMapping("/xk/super/admin")
    @ResponseBody
    public Result addAdmin(Admin admin) {
        //����û�
        try {
            superService.addAdmin(admin);
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        }
        //���سɹ����
        return Result.OK();
    }

    /**
     * ��ѯ����Ա��Ϣ
     */
    @GetMapping("/xk/super/admin")
    @ResponseBody
    public LayUIResult<Admin> selectAdminsLikeAccount(Admin admin,
                                           @RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10")Integer limit) {
        return superService.selectAdmins(admin, page, limit);
    }

    /**
     * ��ת���༭����
     */
    @GetMapping("/xk/super/admin/{id}")
    public String toEditPage(@PathVariable Integer id, Model data) {
        //��ѯid��Ӧ�Ĺ���Ա��Ϣ
        Admin admin = superService.selectAdminById(id);
        //��������
        admin.setPassword(null);
        //�����ݴ���
        data.addAttribute("editAdmin", admin);
        return "xk/super/editAdmin";
    }

    /**
     * ���¹���Ա��Ϣ
     */
    @PutMapping("/xk/super/admin")
    @ResponseBody
    public Result updateAdmin(Admin admin) {
        //ִ�и���
        try {
            superService.updateAdminSelective(admin);
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        }
        //���سɹ����
        return Result.OK();
    }

    /**
     * ɾ������Ա
     */
    @DeleteMapping("/xk/super/admin")
    @ResponseBody
    public Result deleteAdmin(@RequestBody String ids) {
        try {
            //����
            ids = URLDecoder.decode(ids, "UTF-8");
            ids = ids.substring(5, ids.length()-1);
            //�ָ�
            String[] ids2 = ids.split(",");
            //ת��ΪInteger����
            Integer[] idArray = new Integer[ids2.length];
            for(int i=0; i<idArray.length; i++) {
                idArray[i] = Integer.parseInt(ids2[i]);
            }
            //ִ��ɾ��
            superService.deleteAdminsByIds(idArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.build(500, "����ʧ��!");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����!");
        }
        return Result.OK();
    }

}
