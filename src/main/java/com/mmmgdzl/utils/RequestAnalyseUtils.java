package com.mmmgdzl.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.InetAddress;

/**
 * �ù��������ڷ���request�е���Ϣ
 */
public class RequestAnalyseUtils {

    //�������ݿ��ļ�
    private static File cityDatabase;

    private static Logger logger = LoggerFactory.getLogger(RequestAnalyseUtils.class);

    static {
        //��ȡ�������ݿ��ļ�
        cityDatabase = new File(RequestAnalyseUtils.class.getResource("/").getPath()+"etc/GeoLite2-City.mmdb");
    }

    /**
     * ��ȡIp��ַ
     */
    public static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //��η���������ж��ipֵ����һ��ip������ʵip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }


    /**
     * ͨ��ip��ַ��ѯ���е�ַ
     */
    public static String getCityAddress(String ip) {
        try {
            // ��ȡ���ݿ�����
            DatabaseReader reader = new DatabaseReader.Builder(cityDatabase).build();
            InetAddress ipAddress = InetAddress.getByName(ip);

            // ��ȡ��ѯ���
            CityResponse response = reader.city(ipAddress);

            // ��ȡ������Ϣ
            Country country = response.getCountry();
            String countryName = country.getNames().get("zh-CN");

            // ��ȡʡ��
            Subdivision subdivision = response.getMostSpecificSubdivision();
            String provinceName = subdivision.getNames().get("zh-CN");

            // ��ȡ����
            City city = response.getCity();
            String cityName = city.getNames().get("zh-CN");
            //��װ������������
            return countryName + "-" + provinceName + "-" + cityName;
        } catch (Exception e) {
            logger.error("��ȡ������Ϣʧ��:" + e.getMessage());
            return "δ֪�ص�";
        }
    }

    /**
     * ͨ��request��ѯ���е�ַ
     */
    public static String getCityAddress(HttpServletRequest request) {
        return getCityAddress(getIpAdrress(request));
    }

}
