package com.fly.tms.service.common.dto;

import java.util.List;

/**
 * Created by liyln on 15-2-5.
 */
public class TableDto {

    private String id;

    private String url;

    private List<ColumnDto> columnDtoList;

    private String idField;

    private String isCheckbox;

    public String getIsCheckbox() {
        return isCheckbox;
    }

    public void setIsCheckbox(String isCheckbox) {
        this.isCheckbox = isCheckbox;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ColumnDto> getColumnDtoList() {
        return columnDtoList;
    }

    public void setColumnDtoList(List<ColumnDto> columnDtoList) {
        this.columnDtoList = columnDtoList;
    }
}
