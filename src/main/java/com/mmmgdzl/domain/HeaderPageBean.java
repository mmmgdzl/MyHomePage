package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.ResourceColumn;
import com.mmmgdzl.pojo.ResourceColumnWebsite;

import java.util.List;
import java.util.Map;

public class HeaderPageBean {

    private List<ResourceColumn> resourceColumnList;
    private Map<Integer, List<ResourceColumnWebsite>> resourceColumnWebsiteMap;

    public List<ResourceColumn> getResourceColumnList() {
        return resourceColumnList;
    }

    public void setResourceColumnList(List<ResourceColumn> resourceColumnList) {
        this.resourceColumnList = resourceColumnList;
    }

    public Map<Integer, List<ResourceColumnWebsite>> getResourceColumnWebsiteMap() {
        return resourceColumnWebsiteMap;
    }

    public void setResourceColumnWebsiteMap(Map<Integer, List<ResourceColumnWebsite>> resourceColumnWebsiteMap) {
        this.resourceColumnWebsiteMap = resourceColumnWebsiteMap;
    }
}
