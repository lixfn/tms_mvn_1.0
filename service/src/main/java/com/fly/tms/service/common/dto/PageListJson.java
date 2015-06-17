package com.fly.tms.service.common.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by lixfn on 15-2-4.
 */
public class PageListJson<T> {


    private Long total;

    private List<T> rows;

    /**
     * @param total
     * @param rows
     */
    public PageListJson(Long total, List<T> rows) {
        super();
        this.total = total;
        if (rows == null) {
            rows = Lists.newArrayList();
        }
        this.rows = rows;
    }

    /**
     * 构造函数
     */
    public PageListJson() {
        super();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
