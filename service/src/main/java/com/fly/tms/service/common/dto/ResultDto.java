package com.fly.tms.service.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lixfn on 15-2-4.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDto {

    @JsonProperty("flag")
    private String flag;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private Object data;

    public static class FlagType {
        public static final String Flag_SUCCESS = "S";
        public static final String Flag_ERROR = "E";
    }

    @JsonIgnore
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @JsonIgnore
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    //@JsonIgnore
    //    public Object getData() {
    //        return data;
    //    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return FlagType.Flag_SUCCESS.equals(getFlag());
    }

    public void setSuccess(boolean success) {
        if (success) {
            setFlag(FlagType.Flag_SUCCESS);
        } else {
            setFlag(FlagType.Flag_ERROR);
        }
    }


    public ResultDto(String message) {
        this.flag = FlagType.Flag_ERROR;
        this.msg = message;
    }

    public ResultDto(Boolean flag) {
        if (flag) {
            setFlag(FlagType.Flag_SUCCESS);
        } else {
            setFlag(FlagType.Flag_ERROR);
        }
    }

    public ResultDto(String flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultDto(Boolean flag, String msg) {
        this.flag = flag ? FlagType.Flag_SUCCESS : FlagType.Flag_ERROR;
        this.msg = msg;
    }

    @JsonIgnore
    public <T> T getData() {
        if (data == null) {
            return null;
        } else {
            return (T) data;
        }
    }
}
