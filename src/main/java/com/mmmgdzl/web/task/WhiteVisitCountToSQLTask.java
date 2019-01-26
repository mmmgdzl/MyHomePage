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
            //��ȡ��ǰ��������������
            String totalRequest =  servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST) + "";
            String totalVisitor =  servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR) + "";

            //����������д�����ݿ�
            //д����ʴ���
            dataIndexService.updateDivalue(ConstantValueUtil.TOTAL_REQUEST, totalRequest);
            //д���������
            dataIndexService.updateDivalue(ConstantValueUtil.TOTAL_VISITOR, totalVisitor);

            logger.info("����վ��������������ݿ�ɹ�!");
        } catch (Exception e) {
            logger.error("����վ��������������ݿ�ʧ��!");
            e.printStackTrace();
        }
    }

}
