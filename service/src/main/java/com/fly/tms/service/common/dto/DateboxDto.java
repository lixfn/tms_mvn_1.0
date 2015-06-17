package com.fly.tms.service.common.dto;

/**
 * Created by liyln on 15-3-10.
 */
public class DateboxDto extends InputDto {

    private String timeType;

    /**
     * 相对时间 0000-00-00 00:00:00
     * <p/>
     * 默认不带时分秒
     * <p/>
     * 默认是当前时间之前 0001-00-00 一年之前
     * <p/>
     * 如果是之后加"P" P0001-00-00 一年之后
     */
    private String relativeTime;

    private String relativeTimeDesc;

    public String getRelativeTimeDesc() {
        return relativeTimeDesc;
    }

    public void setRelativeTimeDesc(String relativeTimeDesc) {
        this.relativeTimeDesc = relativeTimeDesc;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }

    public DateboxDto() {
        this.setType("2");
    }
}
