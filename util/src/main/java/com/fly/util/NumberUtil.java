package com.fly.util;

import java.math.BigDecimal;

/**
 * Created by lixfn on 14-11-28.
 */
public class NumberUtil {
    public static long getLong(Object obj) {
        if (obj.getClass() == String.class) {
            return Long.valueOf((String) obj).longValue();
        } else if (obj.getClass() == Double.class) {
            return ((Double) obj).longValue();
        } else if (obj.getClass() == Float.class) {
            return ((Float) obj).longValue();
        } else if (obj.getClass() == Integer.class) {
            return ((Integer) obj).longValue();
        } else if (obj.getClass() == Short.class) {
            return ((Short) obj).longValue();
        } else if (obj.getClass() == Long.class) {
            return ((Long) obj).longValue();
        } else {
            return ((Long) obj).longValue();
        }
    }

    public static BigDecimal getBigDecimal(Object obj) {
        BigDecimal bigDecimal = new BigDecimal(0f);
        if (obj.getClass() == String.class) {
            bigDecimal = new BigDecimal(Double.valueOf((String) obj));
        } else if (obj.getClass() == Double.class) {
            bigDecimal = new BigDecimal((Double) obj);
        } else if (obj.getClass() == Float.class) {
            bigDecimal = new BigDecimal((Float) obj);
        } else if (obj.getClass() == Integer.class) {
            bigDecimal = new BigDecimal((Integer) obj);
        } else if (obj.getClass() == Short.class) {
            bigDecimal = new BigDecimal(Short.valueOf((String) obj));
        } else if (obj.getClass() == Long.class) {
            bigDecimal = new BigDecimal(Long.valueOf((String) obj));
        } else {
            bigDecimal = ((BigDecimal) obj);
        }
        return bigDecimal;
    }


    public static String getDoubleString(Double num) {
        return String.format("%.8f", num);
    }

    /**
     * 获取非Null Double值，如果为null，返回0
     *
     * @param aDouble
     * @return
     */
    public static Double getNoNullDouble(Double aDouble) {
        return aDouble == null ? 0 : aDouble;
    }

    /**
     * 获取非Null Double值，如果为null，返回0
     *
     * @param strDouble
     * @return
     */
    public static Double getDouble(String strDouble) {
        return Double.valueOf(strDouble).doubleValue();
    }
}
