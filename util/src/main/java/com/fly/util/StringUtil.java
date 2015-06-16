package com.fly.util;

/**
 * Created by lixfn on 14-11-19.
 */
public class StringUtil {

    public static String string2unicode(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>> 8);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        return (new String(sb));
    }

    public static String chinese2unicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {// 姹夊瓧鑼冨洿 \u4e00-\u9fa5 (涓枃)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static String unicode2string(String str) {
        str = (str == null ? "" : str);
        if (str.indexOf("\\u") == -1)
            return str;

        StringBuffer sb = new StringBuffer(1000);

        for (int i = 0; i <= str.length() - 6; ) {
            String strTemp = str.substring(i, i + 6);
            String value = strTemp.substring(2);
            int c = 0;
            for (int j = 0; j < value.length(); j++) {
                char tempChar = value.charAt(j);
                int t = 0;
                switch (tempChar) {
                    case 'a':
                        t = 10;
                        break;
                    case 'b':
                        t = 11;
                        break;
                    case 'c':
                        t = 12;
                        break;
                    case 'd':
                        t = 13;
                        break;
                    case 'e':
                        t = 14;
                        break;
                    case 'f':
                        t = 15;
                        break;
                    default:
                        t = tempChar - 48;
                        break;
                }

                c += t * ((int) Math.pow(16, (value.length() - j - 1)));
            }
            sb.append((char) c);
            i = i + 6;
        }
        return sb.toString();
    }

    public static String getNotNullString(Object o) {
        if (o == null) {
            return "";
        } else {
            return String.valueOf(o);
        }
    }


    public static boolean isEmpty(String o) {
        if (o == null) {
            return true;
        } else {
            return o.isEmpty();
        }
    }

    /**
     * doId---->DO_ID转换
     *
     * @param field
     * @return
     */
    public static String fieldToColumn(String field) {
        StringBuffer column = new StringBuffer();
        for (int i = 0; i < field.length(); i++) {
            char a = field.charAt(i);
            if (a >= 'A' && a <= 'Z') {
                column.append('_');
                column.append(a);
            } else {
                column.append(a);
            }
        }
        return column.toString().toUpperCase();
    }

    /**
     * @param str       目标字符串
     * @param strLength 字符最大长度（不加前后缀）
     * @param isRight   补位方向（true-从右补，false-从左补）
     * @param strArg    补足的字符串
     * @return
     * @author liyiliang
     * @date 2012-8-3
     * @discription 不足长度补字符
     */

    public static String addStr(String str, int strLength, boolean isRight, String strArg) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                if (isRight) {
                    sb.append(str).append(strArg);// 右补0
                } else {
                    sb.append(strArg).append(str);// 左补0
                }
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }
}