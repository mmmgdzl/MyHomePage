package com.mmmgdzl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class DeleteParameterSplitUtil {

    public static List<Integer> splitAsInteger(String str) throws UnsupportedEncodingException {
        //解码
        str = URLDecoder.decode(str, "UTF-8");
        //剪切 xxx=[1,2,3] 所以要+2
        str = str.substring(str.indexOf("=") + 2, str.length()-1);
        //分割
        String[] strs = str.split(",");
        //转换为Integer列表
        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<strs.length; i++) {
            intList.add(Integer.parseInt(strs[i]));
        }
        //返回Integer列表
        return intList;
    }

}
