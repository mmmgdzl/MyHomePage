package com.mmmgdzl.controller;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnExample;
import com.mmmgdzl.pojo.SystemResource;
import com.mmmgdzl.service.SystemResourceService;
import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.web.listener.InitApplicationContextListener;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemConfigController {

    @Autowired
    private SystemResourceService systemResourceService;

    /**
     * 前往主页设置
     */
    @RequestMapping("/xk/super/systemConfigPage/indexConfig")
    public String toIndexConfig(Model model, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        //获取主页背景音频名称并放入
        SystemResource backgroundMusic = systemResourceService.selectSystemResourceBySrfilename(servletContext.
                getAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME).toString());
        model.addAttribute("backgroundMusicName", backgroundMusic.getSrname());
        //获取主页背景视频名称并放入
        SystemResource backgroundVideo = systemResourceService.selectSystemResourceBySrfilename(servletContext.
                getAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME).toString());
        model.addAttribute("backgroundVideoName", backgroundVideo.getSrname());

        return "xk/super/systemConfigPage/indexConfig";
    }

    /**
     * 更新主页背景音乐
     */
    @RequestMapping("/xk/super/indexConfig/updateIndexMusic")
    @ResponseBody
    public Result updateIndexMusic(Integer srid, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        try {
            //根据srid查询系统资源对象
            SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(srid);
            //将更改更新至配置文件
            String profilepath = SystemConfigController.class.getResource("/").getPath() + "conf/resource.properties";
            PropertiesConfiguration config = new PropertiesConfiguration(profilepath);
            //设置自动保存
            config.setAutoSave(true);
            //写入访问次数
            config.setProperty(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, systemResource.getSrfilename());
            //写入servletcontext域
            servletContext.setAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, systemResource.getSrfilename());

            return Result.OK();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 更新主页背景视频
     */
    @RequestMapping("/xk/super/indexConfig/updateIndexVideo")
    @ResponseBody
    public Result updateIndexVideo(Integer srid, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        try {
            //根据srid查询系统资源对象
            SystemResource systemResource = systemResourceService.selectSystemResourceBySrid(srid);
            //将更改更新至配置文件
            String profilepath = SystemConfigController.class.getResource("/").getPath() + "conf/resource.properties";
            PropertiesConfiguration config = new PropertiesConfiguration(profilepath);
            //设置自动保存
            config.setAutoSave(true);
            //写入访问次数
            config.setProperty(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, systemResource.getSrfilename());
            //写入servletcontext域
            servletContext.setAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, systemResource.getSrfilename());

            return Result.OK();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "未知错误");
        }
    }

    /**
     * 页面定向
     */
    @RequestMapping("/xk/super/systemConfigPage/{page}")
    public String toSystemConfigPage(@PathVariable String page) {
        return "xk/super/systemConfigPage/" + page;
    }
}
