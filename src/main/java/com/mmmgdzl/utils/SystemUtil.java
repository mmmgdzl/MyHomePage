package com.mmmgdzl.utils;

public class SystemUtil {

    /**
     * 判断操作系统是Windows系统还是Linux系统
     */
    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();//获取操作系统名称
        if(os.indexOf("windows") >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
