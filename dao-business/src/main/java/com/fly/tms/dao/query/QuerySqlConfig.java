package com.fly.tms.dao.query;

import com.fly.util.annotation.WhereCondition;

import java.util.Map;

/**
 * 实体类查询配置
 * Created by lixfn on 15-2-12.
 */
public class QuerySqlConfig {

    private String sql = "";
    private String rowCountSql = "";
    private String sortWith;
    private Map<String, WhereCondition> mapCondition;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<String, WhereCondition> getMapCondition() {
        return mapCondition;
    }

    public void setMapCondition(Map<String, WhereCondition> mapCondition) {
        this.mapCondition = mapCondition;
    }

    public String getSortWith() {
        return sortWith;
    }

    public void setSortWith(String sortWith) {
        this.sortWith = sortWith;
    }

    public String getRowCountSql() {
        return rowCountSql;
    }

    public void setRowCountSql(String rowCountSql) {
        this.rowCountSql = rowCountSql;
    }
}
