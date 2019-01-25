package com.mmmgdzl.controller;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.service.SystemResourceService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.utils.SystemUtil;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.management.ManagementFactory;

@Controller
public class SystemConfigController {

    @Autowired
    private SystemResourceService systemResourceService;

    /**
     * ǰ����ҳ����
     */
    @RequestMapping("/xk/super/systemConfigPage/indexConfig")
    public String toIndexConfig(Model model, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        //��ȡ��ҳ������Ƶ���Ʋ�����
        SystemResource backgroundMusic = systemResourceService.selectSystemResourceBySrfilename(servletContext.
                getAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME).toString());
        model.addAttribute("backgroundMusicName", backgroundMusic.getSrname());
        //��ȡ��ҳ������Ƶ���Ʋ�����
        SystemResource backgroundVideo = systemResourceService.selectSystemResourceBySrfilename(servletContext.
                getAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME).toString());
        model.addAttribute("backgroundVideoName", backgroundVideo.getSrname());

        return "xk/super/systemConfigPage/indexConfig";
    }

    /**
     * ������ҳ��������
     */
    @RequestMapping("/xk/super/indexConfig/updateIndexMusic")
    @ResponseBody
    public Result updateIndexMusic(Integer srid, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        try {
            //����srid��ѯϵͳ��Դ����
            SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(srid);
            //�����ĸ����������ļ�
            String profilepath = SystemConfigController.class.getResource("/").getPath() + "conf/resource.properties";
            PropertiesConfiguration config = new PropertiesConfiguration(profilepath);
            //�����Զ�����
            config.setAutoSave(true);
            //д����ʴ���
            config.setProperty(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, systemResource.getSrfilename());
            //д��servletcontext��
            servletContext.setAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, systemResource.getSrfilename());

            return Result.OK();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ������ҳ������Ƶ
     */
    @RequestMapping("/xk/super/indexConfig/updateIndexVideo")
    @ResponseBody
    public Result updateIndexVideo(Integer srid, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        try {
            //����srid��ѯϵͳ��Դ����
            SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(srid);
            //�����ĸ����������ļ�
            String profilepath = SystemConfigController.class.getResource("/").getPath() + "conf/resource.properties";
            PropertiesConfiguration config = new PropertiesConfiguration(profilepath);
            //�����Զ�����
            config.setAutoSave(true);
            //д����ʴ���
            config.setProperty(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, systemResource.getSrfilename());
            //д��servletcontext��
            servletContext.setAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, systemResource.getSrfilename());

            return Result.OK();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ����������
     */
    @RequestMapping("/xk/restartTomcatServer")
    @ResponseBody
    public Result restartTomcat(HttpSession session) {
        try {
            //��ȡ��ǰ�û��ж��Ƿ�Ϊ��������Ա
            Admin currentAdmin = (Admin) session.getAttribute(ConstantValueUtil.ADMIN);
            if(currentAdmin.getAlevel() != 0)
                throw new XKException("ֻ�г�������Ա�ܹ�ִ����������������!");

            File directory = new File("");//�趨Ϊ��ǰ�ļ���
            String binPath = directory.getAbsolutePath();
            String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            System.out.println("---------pid:" + pid);
            //�ж���Windowsϵͳ����linuxϵͳ
            if(SystemUtil.isWindows()) {
                File restart = new File(binPath + "\\restart.bat");
                String bats = "call taskkill /F /PID " + pid + " && call ping -n 5 127.0.0.1>nul && "
                        + "call " + binPath + "\\catalina.bat start";
                FileOutputStream fos = new FileOutputStream(restart);
                fos.write(bats.getBytes());
                fos.flush();
                fos.close();

                File restartVbs = new File(binPath + "\\restart.vbs");
                String vbs = "Set ws = CreateObject(\"Wscript.Shell\") \n" +
                        "ws.run \"cmd /c restart/bat\",0";
                fos = new FileOutputStream(restartVbs);
                fos.write(vbs.getBytes());
                fos.flush();
                fos.close();
                Runtime.getRuntime().exec("cmd /c start " + binPath + "\\restart.vbs");
            } else {
                String scriptString = "#!/bin/bash \n" +
                        "tomcatpid=`ps -ef|grep " + binPath + " |grep java | awk ' { print $2 } '` \n"+
                        "echo $tomcatpid \n" +
                        "if [ $tomcatpid -eq 0 ];then \n" +
                        "    echo 'tomcat is stop' \n" +
                        "else \n" +
                        "    kill -9 $tomcatpid & \n" +
                        "    sleep 5 & \n" +
                        "    cd " + binPath + " & \n" +
                        "    rm -rf ../work/* & \n" +
                        "fi \n" +
                        "nohup sh " + binPath + "/startup.sh &";
                File restart = new File(binPath + "/restart.sh");
                FileOutputStream stream = new FileOutputStream(restart);
                stream.write(scriptString.getBytes());
                stream.flush();
                stream.close();
                try {
                    //�޸�restart.sh���ļ�����Ȩ��
                    Process proc = Runtime.getRuntime().exec("chmod a+x " + binPath + "/restart.sh");
                    //����ֱ����������ִ����
                    proc.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //���سɹ����
            return Result.OK();
        } catch (XKException e) {
            return Result.build(500, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "δ֪����");
        }
    }

    /**
     * ���Է������Ƿ��Ѿ�����
     */
    @RequestMapping("/xk/testServer")
    @ResponseBody
    public Result testServer() {
        return Result.OK();
    }

    /**
     * ҳ�涨��
     */
    @RequestMapping("/xk/super/systemConfigPage/{page}")
    public String toSystemConfigPage(@PathVariable String page) {
        return "xk/super/systemConfigPage/" + page;
    }
}
