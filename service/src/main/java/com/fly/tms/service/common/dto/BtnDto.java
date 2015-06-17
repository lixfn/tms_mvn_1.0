package com.fly.tms.service.common.dto;

/**
 * Created by liyln on 15-2-5.
 */
public class BtnDto {

    private String id;

    private String text;

    private String roleBtnId;

    public String getRoleBtnId() {
        return roleBtnId;
    }

    public void setRoleBtnId(String roleBtnId) {
        this.roleBtnId = roleBtnId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
