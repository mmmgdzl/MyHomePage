package com.mmmgdzl.web.task;

import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.web.listener.InitApplicationContextListener;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class WhiteVisitCountToLogTask {

    @Autowired
    private ServletContext servletContext;

    private Logger logger = LoggerFactory.getLogger(WhiteVisitCountToLogTask.class);

    @Scheduled(cron = "0 * * * * ?")
    public void whiteVisitorCountToLogTask() {
        try {
            //获取配置文件路径
            String profilepath = InitApplicationContextListener.class.getResource("/").getPath()+"conf/resource.properties";
            //获取当前服务器访问数据
            String totalRequest =  servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST) + "";
            String totalVisitor =  servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR) + "";

            //将访问数据写入配置文件
            PropertiesConfiguration config  = new PropertiesConfiguration(profilepath);
            //设置自动保存
            config.setAutoSave(true);
            //写入访问次数
            config.setProperty("TOTAL_REQUEST", totalRequest);
            //写入访问人数
            config.setProperty("TOTAL_VISITOR", totalVisitor);
            logger.info("更新站点访问数据至配置文件成功!");
        } catch (Exception e) {
            logger.error("更新站点访问数据至配置文件失败!");
            e.printStackTrace();
        }
    }

}
