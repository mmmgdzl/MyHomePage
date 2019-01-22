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
            //ִ�в�ѯ�Լ���
            superService.selectAdminById(1);
            logger.info("���ݿ����Ӽ���ɹ�!");
        } catch (Exception e) {
            logger.error("���ݿ����Ӽ���ʧ��:" + e.getMessage());
        }
    }

}
