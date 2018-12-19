package com.mmmgdzl.utils;

import com.mmmgdzl.exception.XKException;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * 该工具类用于清除空值
 * @author mmmgdzl
 */
public class ClearBlankUtil {

    /**
     * 将对象中所有String类型的对象中的值为空的值设置为null
     * @param obj 要进行设置的对象
     * @param ignoreFields 要忽略的对象
     */
    public static Object clearStringBlank(Object obj, String...ignoreFields) {
        try {
            //获取属性数组
            Field[] objFields = obj.getClass().getDeclaredFields();
            //执行清空
            for (Field field : objFields) {
                //如果不在忽略列表中且为String类型且为空值则置为null
                if (!checkInArray(field.getName(), ignoreFields) && field.getType().toString().endsWith("java.lang.String")) {
                    //设置属性可访问
                    field.setAccessible(true);
                    if(field.get(obj) != null && StringUtils.isBlank(field.get(obj).toString()))
                        field.set(obj, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new XKException("置空错误");
        }
        return obj;
    }

    /**
     * 判断数组中是否含有某个值
     */
    private static boolean checkInArray(String value, String[] array) {
        if(array == null)
            return false;
        for(String str : array) {
            if(str.equals(value))
                return true;
        }
        return false;
    }
}
