package com.fly.tms.service.common.dto;

/**
 * Created by liyln on 15-3-9.
 */
public class ComboBoxDto extends InputDto {

    private String url;

    private String hintText;

    private String nextId;

    private String nextUrl;

    private String defaultId;

    private String multiple;

    private String editable;

    private String cascade;

    private String required;

    private String panelHeight;

    public ComboBoxDto() {
        init();
        this.setType("1");
    }


    public void init() {
        //字符串类型的需要前台页面加引号
        this.hintText = "";
        this.nextId = "";
        this.nextUrl = "";
        this.defaultId = "";
        this.multiple = "false";
        this.editable = "true";
        this.cascade = "false";
        this.required = "false";
        this.panelHeight = "auto";
    }

    public String getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(String panelHeight) {
        this.panelHeight = panelHeight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getDefaultId() {
        return defaultId;
    }

    public void setDefaultId(String defaultId) {
        this.defaultId = defaultId;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getCascade() {
        return cascade;
    }

    public void setCascade(String cascade) {
        this.cascade = cascade;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
