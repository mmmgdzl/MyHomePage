package com.mmmgdzl.web.task;

import com.mmmgdzl.service.SuperService;
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
public class SQLActiveTask {

    @Autowired
    private SuperService superService;

    private Logger logger = LoggerFactory.getLogger(SQLActiveTask.class);

    @Scheduled(cron = "0 0 0/6 * * ?")
    public void SQLActive() {
        try {
            //执行查询以激活
            superService.selectAdminById(1);
            logger.info("数据库连接激活成功!");
        } catch (Exception e) {
            logger.error("数据库连接激活失败:" + e.getMessage());
        }
    }

}
