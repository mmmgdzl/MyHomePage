package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.DataIndex;

public interface DataIndexService {

    /**
     * ͨ����������ȡ��������
     */
    DataIndex getDataIndexByDiname(String diname);

    /**
     * ��������ֵ
     */
    Result updateDivalue(String diname, String newDivalue);

}
