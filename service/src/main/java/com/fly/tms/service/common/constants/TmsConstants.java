package com.fly.tms.service.common.constants;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by liyln on 14-12-3.
 */
public class TmsConstants {


    //权限系统的SystemId
    public static final String SYSTEM_ID = "21";

    //分隔符
    public static final String SPLIT_FLAG = ",";

    public static final String END_TIME = "T23:59:59";
    public static final String VIEW_DEFAULT_TIME_FORMAT = "yyyy-MM-dd";

    public static final String STR_TRUE = "true";
    public static final String STR_FALSE = "false";


    public static class UiPageInput {
        public static enum UiPageInputType {
            COMMONINPUT("0", "普通输入"),
            COMBOBOXINPUT("1", "下拉框"),
            DATAINPUT("2", "时间输入框"),
            COMBOINPUT("3", "弹出查询框");

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            private String key;
            private String text;

            UiPageInputType(String key, String text) {
                this.key = key;
                this.text = text;
            }

            public static Map<String, String> mapConfigType = Maps.newLinkedHashMap();

            static {
                for (UiPageInputType e : UiPageInputType.values()) {
                    mapConfigType.put(e.getKey(), e.getText());
                }
            }
        }
    }


}
