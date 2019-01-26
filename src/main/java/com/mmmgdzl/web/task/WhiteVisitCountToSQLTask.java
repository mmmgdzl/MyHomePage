package com.mmmgdzl.web.task;

import com.mmmgdzl.service.DataIndexService;
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
public class WhiteVisitCountToSQLTask {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private DataIndexService dataIndexService;

    private Logger logger = LoggerFactory.getLogger(WhiteVisitCountToSQLTask.class);

    @Scheduled(cron = "0 0/1 * * * ?")
    public void whiteVisitorCountToLogTask() {
        try {
            //获取当前服务器访问数据
            String totalRequest =  servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST) + "";
            String totalVisitor =  servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR) + "";

            //将访问数据写入数据库
            //写入访问次数
            dataIndexService.updateDivalue(ConstantValueUtil.TOTAL_REQUEST, totalRequest);
            //写入访问人数
            dataIndexService.updateDivalue(ConstantValueUtil.TOTAL_VISITOR, totalVisitor);

            logger.info("更新站点访问数据至数据库成功!");
        } catch (Exception e) {
            logger.error("更新站点访问数据至数据库失败!");
            e.printStackTrace();
        }
    }

}
