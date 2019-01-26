package com.mmmgdzl.service.impl;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.DataIndexMapper;
import com.mmmgdzl.pojo.DataIndex;
import com.mmmgdzl.pojo.DataIndexExample;
import com.mmmgdzl.service.DataIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataIndexServiceImpl implements DataIndexService {

    @Autowired
    private DataIndexMapper dataIndexMapper;

    @Override
    public DataIndex getDataIndexByDiname(String diname) {
        DataIndexExample dataIndexExample = new DataIndexExample();
        DataIndexExample.Criteria criteria = dataIndexExample.createCriteria();
        //添加查询条件
        criteria.andDinameEqualTo(diname);
        //执行查询
        List<DataIndex> dataIndexList = dataIndexMapper.selectByExample(dataIndexExample);
        if(dataIndexList.size() == 0) {
            return null;
        } else {
            return dataIndexList.get(0);
        }
    }

    @Override
    public Result updateDivalue(String diname, String newDivalue) {
        DataIndex dataIndex = this.getDataIndexByDiname(diname);
        dataIndex.setDivalue(newDivalue);
        dataIndexMapper.updateByPrimaryKey(dataIndex);
        return Result.OK();
    }



}
