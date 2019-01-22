package com.mmmgdzl.controller;

import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.domain.LayUISystemResource;
import com.mmmgdzl.domain.LayUISystemResourceColumn;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.*;
import com.mmmgdzl.service.FileService;
import com.mmmgdzl.service.SystemResourceColumnService;
import com.mmmgdzl.service.SystemResourceService;
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
public class SystemResourceController {

    @Autowired
    private FileService fileService;
    @Autowired
    private SystemResourceService systemResourceService;
    @Autowired
    private SystemResourceColumnService systemResourceColumnService;

    @PostMapping("/xk/super/systemResource")
    @ResponseBody
    public Result addSystemResource(Integer srcolumn, String srdesc, MultipartFile srfile, HttpSession session) {
        try {
            //��ȡ��ǰ��¼�û�
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            //����ϵͳ��Դ�ļ�
            Result uploadResult = fileService.uploadSystemResource(srfile);
            //���ϵͳ��Դ��Ϣ
            SystemResource systemResource = new SystemResource();
            systemResource.setSrcolumn(srcolumn);
            systemResource.setSrdesc(srdesc);
            systemResource.setSrname(srfile.getOriginalFilename());
            systemResource.setSrfilename(uploadResult.getData().toString());
            //���ô����û�
            systemResource.setSrcreater(currentAdmin.getAid());
            //ִ�в���
            Result result = systemResourceService.addSystemResource(systemResource);
            return result;
        } catch (XKException e) {
            //���ִ�г����쳣�򷵻��쳣ԭ��
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    @GetMapping("/xk/super/systemResource")
    @ResponseBody
    public LayUIResult<LayUISystemResource> getSystemResourceList(SystemResource systemResource,
                                                                  @RequestParam(defaultValue = "1") Integer page,
                                                                  @RequestParam(defaultValue = "10")Integer limit) {
        //����Դ��Ŀ����ת��Ϊ��ѯģ�����
        SystemResourceExample systemResourceExample = systemResourceService.transformResourceToSystemResourceExample(systemResource);
        //��ѯ������
        Integer count = systemResourceService.count(systemResourceExample);
        //��ѯ��Դ��Ŀ�б�
        List<SystemResource> systemResourceList = systemResourceService.selectSystemResources(systemResourceExample, page, limit);
        //ִ����Դ��Ŀ��Ⱦ
        List<LayUISystemResource> layUISystemResourceList = systemResourceService.renderSystemResourcesForLayUI(systemResourceList);
        //���ز�ѯ���
        return new LayUIResult<>(0, count, layUISystemResourceList);
    }

    /**
     * ��ת���û��༭����
     */
    @GetMapping("/xk/super/systemResource/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        //��ʼ��model
        this.initModel(model);
        //��ѯid��Ӧ��ϵͳ��Դ��Ϣ
        SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(id);
        //�����ݴ���
        model.addAttribute("editSystemResource", systemResource);
        return "xk/super/systemResourcePage/editSystemResource";
    }

    /**
     * �����û���Ϣ
     */
    @PutMapping("/xk/super/systemResource")
    @ResponseBody
    public Result updateAdmin(SystemResource systemResource) {
        //ִ�и���
        try {
            //ִ�и���
            Result result = systemResourceService.updateSystemResource(systemResource);
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
    @DeleteMapping("/xk/super/systemResource")
    @ResponseBody
    public Result deleteSystemResource(@RequestBody String ids) {
        try {
            //ִ�м���
            List<Integer> idList = DeleteParameterSplitUtil.splitAsInteger(ids);
            //ִ��ɾ��
            Result result = systemResourceService.deleteSystemResourceByIds(idList);
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

    @RequestMapping("/xk/super/systemResourcePage/{page}")
    public String toSystemResourcePage(@PathVariable String page, Model model) {
        //��ȡ��Ҫ����
        this.initModel(model);

        return "xk/super/systemResourcePage/" + page;
    }

    private void initModel(Model model) {
        //��ӿ���ϵͳ��Դ��Ŀ�б�
        SystemResourceColumn systemResourceColumn = new SystemResourceColumn();
        systemResourceColumn.setSrcenable(1);
        List<SystemResourceColumn> systemResourceColumnList = systemResourceColumnService.selectSystemResourceColumns(systemResourceColumn, null, null);
        model.addAttribute("systemResourceColumnList", systemResourceColumnList);
    }

}
