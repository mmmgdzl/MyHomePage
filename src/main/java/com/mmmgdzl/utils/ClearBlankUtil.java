package com.mmmgdzl.utils;

import com.mmmgdzl.exception.XKException;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * �ù��������������ֵ
 * @author mmmgdzl
 */
public class ClearBlankUtil {

    /**
     * ������������String���͵Ķ����е�ֵΪ�յ�ֵ����Ϊnull
     * @param obj Ҫ�������õĶ���
     * @param ignoreFields Ҫ���ԵĶ���
     */
    public static Object clearStringBlank(Object obj, String...ignoreFields) {
        try {
            //��ȡ��������
            Field[] objFields = obj.getClass().getDeclaredFields();
            //ִ�����
            for (Field field : objFields) {
                //������ں����б�����ΪString������Ϊ��ֵ����Ϊnull
                if (!checkInArray(field.getName(), ignoreFields) && field.getType().toString().endsWith("java.lang.String")) {
                    //�������Կɷ���
                    field.setAccessible(true);
                    if(field.get(obj) != null && StringUtils.isBlank(field.get(obj).toString()))
                        field.set(obj, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new XKException("�ÿմ���");
        }
        return obj;
    }

    /**
     * �ж��������Ƿ���ĳ��ֵ
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
