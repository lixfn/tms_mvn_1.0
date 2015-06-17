package com.fly.tms.service.common.dto;

/**
 * Created by liyln on 15-3-10.
 */
public class ComboDto extends InputDto {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ComboDto() {
        this.setType("3");
    }
}
