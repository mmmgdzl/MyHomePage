package com.mmmgdzl.utils;

public class SystemUtil {

    /**
     * �жϲ���ϵͳ��Windowsϵͳ����Linuxϵͳ
     */
    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();//��ȡ����ϵͳ����
        if(os.indexOf("windows") >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
