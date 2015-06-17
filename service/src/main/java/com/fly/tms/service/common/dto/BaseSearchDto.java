package com.fly.tms.service.common.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by lixfn on 15-2-4.
 */
public class BaseSearchDto {
    private String searchType;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    private String sortString;

    public String getSortString() {
        if (StringUtils.isBlank(sortString)) {
            sortString = "CREATED_TIME.desc";//如果你想排序的话逗号分隔可以排序多列
        }
        return sortString;
    }

    public void setSortString(String sortString) {
        this.sortString = sortString;
    }


    private String createdTimeStart;

    private String createdTimeEnd;

    public String getCreatedTimeStart() {
        return createdTimeStart;
    }

    public void setCreatedTimeStart(String createdTimeStart) {
        this.createdTimeStart = createdTimeStart;
    }

    public String getCreatedTimeEnd() {
        return createdTimeEnd;
    }

    public void setCreatedTimeEnd(String createdTimeEnd) {
        this.createdTimeEnd = createdTimeEnd;
    }
}