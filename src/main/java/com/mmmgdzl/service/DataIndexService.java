package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.DataIndex;

public interface DataIndexService {

    /**
     * 通过索引名获取索引对象
     */
    DataIndex getDataIndexByDiname(String diname);

    /**
     * 更新索引值
     */
    Result updateDivalue(String diname, String newDivalue);

}
