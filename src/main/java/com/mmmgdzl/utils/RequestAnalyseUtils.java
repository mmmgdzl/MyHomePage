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
 * 该工具类用于分析request中的信息
 */
public class RequestAnalyseUtils {

    //城市数据库文件
    private static File cityDatabase;

    private static Logger logger = LoggerFactory.getLogger(RequestAnalyseUtils.class);

    static {
        //获取城市数据库文件
        cityDatabase = new File(RequestAnalyseUtils.class.getResource("/").getPath()+"etc/GeoLite2-City.mmdb");
    }

    /**
     * 获取Ip地址
     */
    public static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
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
     * 通过ip地址查询城市地址
     */
    public static String getCityAddress(String ip) {
        try {
            // 读取数据库内容
            DatabaseReader reader = new DatabaseReader.Builder(cityDatabase).build();
            InetAddress ipAddress = InetAddress.getByName(ip);

            // 获取查询结果
            CityResponse response = reader.city(ipAddress);

            // 获取国家信息
            Country country = response.getCountry();
            String countryName = country.getNames().get("zh-CN");

            // 获取省份
            Subdivision subdivision = response.getMostSpecificSubdivision();
            String provinceName = subdivision.getNames().get("zh-CN");

            // 获取城市
            City city = response.getCity();
            String cityName = city.getNames().get("zh-CN");
            //组装城市名并返回
            return countryName + "-" + provinceName + "-" + cityName;
        } catch (Exception e) {
            logger.error("读取城市信息失败:" + e.getMessage());
            return "未知地点";
        }
    }

    /**
     * 通过request查询城市地址
     */
    public static String getCityAddress(HttpServletRequest request) {
        return getCityAddress(getIpAdrress(request));
    }

}
