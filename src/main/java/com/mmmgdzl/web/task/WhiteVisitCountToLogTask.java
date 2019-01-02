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
            //��ȡ�����ļ�·��
            String profilepath = InitApplicationContextListener.class.getResource("/").getPath()+"conf/resource.properties";
            //��ȡ��ǰ��������������
            String totalRequest =  servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST) + "";
            String totalVisitor =  servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR) + "";

            //����������д�������ļ�
            PropertiesConfiguration config  = new PropertiesConfiguration(profilepath);
            //�����Զ�����
            config.setAutoSave(true);
            //д����ʴ���
            config.setProperty("TOTAL_REQUEST", totalRequest);
            //д���������
            config.setProperty("TOTAL_VISITOR", totalVisitor);
            logger.info("����վ����������������ļ��ɹ�!");
        } catch (Exception e) {
            logger.error("����վ����������������ļ�ʧ��!");
            e.printStackTrace();
        }
    }

}
