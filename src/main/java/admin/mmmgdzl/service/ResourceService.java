package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;

public interface ResourceService {

    /**
     * 将栏目一的资源全部给予栏目二
     */
    Result transportFromC1ToC2(Integer c1, Integer c2);

}
