package com.mmmgdzl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class DeleteParameterSplitUtil {

    public static List<Integer> splitAsInteger(String str) throws UnsupportedEncodingException {
        //����
        str = URLDecoder.decode(str, "UTF-8");
        //���� xxx=[1,2,3] ����Ҫ+2
        str = str.substring(str.indexOf("=") + 2, str.length()-1);
        //�ָ�
        String[] strs = str.split(",");
        //ת��ΪInteger�б�
        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<strs.length; i++) {
            intList.add(Integer.parseInt(strs[i]));
        }
        //����Integer�б�
        return intList;
    }

}
