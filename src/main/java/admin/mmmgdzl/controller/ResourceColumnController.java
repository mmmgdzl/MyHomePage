package admin.mmmgdzl.controller;

import admin.mmmgdzl.service.ResourceColumnService;
import com.mmmgdzl.domain.LayUIResourceColumn;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.ResourceColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
            Admin currentAdmin = (Admin) session.getAttribute("admin");
            //���ô����û�
            resourceColumn.setCcreater(currentAdmin.getAid());
            resourceColumnService.addResourceColumn(resourceColumn);
            //���سɹ����
            return Result.OK();
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            e.printStackTrace();
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
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

        return resourceColumnService.selectResourceColumnsForLayUI(resourceColumn, page, limit);
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
            e.printStackTrace();
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }

    }

    /**
     * ɾ����Դ��Ŀ
     */
    @DeleteMapping("/xk/super/resourceColumn/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable String id) {
        try {
            resourceColumnService.deleteResourceColumnById(Integer.parseInt(id));
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
        return Result.OK();
    }

    /**
     * ҳ�涨��
     */
    @RequestMapping("/xk/super/resourceColumnPage/{page}")
    public String toAdminPage(@PathVariable String page) {
        return "xk/super/resourceColumnPage/" + page;
    }

}
