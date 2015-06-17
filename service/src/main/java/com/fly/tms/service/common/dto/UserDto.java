package com.fly.tms.service.common.dto;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by lixfn on 15-3-19.
 */
public class UserDto {
    private String userId;
    private String userName;
    private String notesId;
    private String loginIp;
    private String mobile;
    private String managerId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNotesId() {
        return notesId;
    }

    public void setNotesId(String notesId) {
        this.notesId = notesId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public UserDto() {
    }


    public <T> void putCreatorData(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getName().equals("creator")) {
                    field.setAccessible(true);
                    field.set(t, getUserId());
                } else if (field.getName().equals("createdTime")) {
                    field.setAccessible(true);
                    field.set(t, new Date());
                } else if (field.getName().equals("lastLogIp")) {
                    field.setAccessible(true);
                    field.set(t, getLoginIp());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> void putModifierData(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getName().equals("modifier")) {
                    field.setAccessible(true);
                    field.set(t, getUserId());
                } else if (field.getName().equals("lastModTime")) {
                    field.setAccessible(true);
                    field.set(t, new Date());
                } else if (field.getName().equals("lastLogIp")) {
                    field.setAccessible(true);
                    field.set(t, getLoginIp());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
