package com.fly.tms.service.common.dto;

import java.util.List;

/**
 * Created by liyln on 15-2-5.
 */
public class PageContextDto {

    private String contextId;

    private List<BtnDto> btnDtoList;

    private List<InputDto> inputDtoList;

    private TableDto tableDto;

    private List<StaticDto> staticDtoList;

    public List<StaticDto> getStaticDtoList() {
        return staticDtoList;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public void setStaticDtoList(List<StaticDto> staticDtoList) {
        this.staticDtoList = staticDtoList;
    }

    public TableDto getTableDto() {
        return tableDto;
    }

    public void setTableDto(TableDto tableDto) {
        this.tableDto = tableDto;
    }

    public List<InputDto> getInputDtoList() {
        return inputDtoList;
    }

    public void setInputDtoList(List<InputDto> inputDtoList) {
        this.inputDtoList = inputDtoList;
    }

    public List<BtnDto> getBtnDtoList() {
        return btnDtoList;
    }

    public void setBtnDtoList(List<BtnDto> btnDtoList) {
        this.btnDtoList = btnDtoList;
    }
}
