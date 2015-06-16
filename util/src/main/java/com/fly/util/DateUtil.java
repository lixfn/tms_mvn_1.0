package com.fly.util;

import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lixfn on 14-11-19.
 */

public class DateUtil {
    public static final String DateFormatString = "yyyy-MM-dd HH:mm:ss";
    public static final String DateFormatString_17 = "yyyyMMddHHmmssSSS";

    public static String getCurrentDateString() {
        return getString(new Date());
    }

    public static String getCurrentDateString(String dateFormat) {
        DateTime dateTime = new DateTime();
        return dateTime.toString(dateFormat);
    }

    public static Date getDate(String dateString) throws Exception {
        return getDate(dateString, DateFormatString);
    }

    public static Date getDate(String dateString, String dateformat) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        return format.parse(dateString);
    }

    public static String getString(Date date) {
        return getString(date, DateFormatString);
    }

    private static Map<String, SimpleDateFormat> simpleDateFormatMap = Maps.newHashMap();

    public static String getString(Date date, String DateFormatString) {
        if (simpleDateFormatMap.containsKey(DateFormatString)) {
            return simpleDateFormatMap.get(DateFormatString).format(date);
        } else {
            SimpleDateFormat format = new SimpleDateFormat(DateFormatString);
            simpleDateFormatMap.put(DateFormatString, format);
            return format.format(date);
        }
    }

    public static String formatDateString(String dateString, String dateFormat) {
        if (dateString == null || dateString.isEmpty() == true) {
            return "";
        }
        try {
            String[] datetimeStrings = dateString.split("[ ]");
            if (dateString.contains("CST") && datetimeStrings.length == 2 && datetimeStrings[1].equals("CST") && datetimeStrings[0].length() > 10) {
                datetimeStrings[1] = datetimeStrings[0].substring(10);
                datetimeStrings[0] = datetimeStrings[0].substring(0, 10);
            }
            String[] dateStrings;
            String[] timeStrings;
            if (datetimeStrings.length > 1) {
                dateStrings = datetimeStrings[0].split("[-]");
                if (dateStrings.length == 1) {
                    dateStrings = datetimeStrings[0].split("[/]");
                }
                if (dateStrings.length == 1) {
                    dateStrings = datetimeStrings[0].split("[.]");
                }
                if (dateStrings.length == 1) {
                    dateStrings = datetimeStrings[0].split("[年|月|日]");
                }
                if (dateStrings.length == 1) {
                    if (datetimeStrings[0].length() != 8) {
                        return dateString;
                    }
                    dateStrings = new String[3];
                    dateStrings[0] = datetimeStrings[0].substring(0, 4);
                    dateStrings[1] = datetimeStrings[0].substring(4, 6);
                    dateStrings[2] = datetimeStrings[0].substring(6, 8);
                }

                timeStrings = datetimeStrings[1].split("[:|.]");
                if (timeStrings.length == 1) {
                    timeStrings = datetimeStrings[1].split("[时|分|秒]");
                }
                if (timeStrings.length == 1) {
                    if (datetimeStrings[1].length() < 6) {
                        return dateString;
                    }
                    timeStrings = new String[3];
                    timeStrings[0] = datetimeStrings[1].substring(0, 2);
                    timeStrings[1] = datetimeStrings[1].substring(2, 4);
                    timeStrings[2] = datetimeStrings[1].substring(4, 6);
                }
            } else {
                dateStrings = datetimeStrings[0].split("[-]");
                timeStrings = new String[]{"0", "0", "0"};
                if (dateStrings.length == 1) {
                    dateStrings = datetimeStrings[0].split("[/]");
                    timeStrings = new String[]{"0", "0", "0"};
                }
                if (dateStrings.length == 1) {
                    dateStrings = datetimeStrings[0].split("[年|月|日]");
                    timeStrings = new String[]{"0", "0", "0"};
                }
                if (dateStrings.length == 1) {
                    if (datetimeStrings[0].length() < 8) {
                        return dateString;
                    } else if (datetimeStrings[0].length() == 8) {
                        dateStrings = new String[3];
                        dateStrings[0] = datetimeStrings[0].substring(0, 4);
                        dateStrings[1] = datetimeStrings[0].substring(4, 6);
                        dateStrings[2] = datetimeStrings[0].substring(6, 8);
                        timeStrings = new String[]{"0", "0", "0"};
                    } else if (datetimeStrings[0].length() < 14) {
                        return dateString;
                    } else if (datetimeStrings[0].length() >= 14) {
                        dateStrings = new String[3];
                        dateStrings[0] = datetimeStrings[0].substring(0, 4);
                        dateStrings[1] = datetimeStrings[0].substring(4, 6);
                        dateStrings[2] = datetimeStrings[0].substring(6, 8);
                        timeStrings = new String[3];
                        timeStrings[0] = datetimeStrings[0].substring(8, 10);
                        timeStrings[1] = datetimeStrings[0].substring(10, 12);
                        timeStrings[2] = datetimeStrings[0].substring(12, 14);
                    }
                }
            }

            Integer year = Integer.valueOf(dateStrings[0]);
            Integer month = Integer.valueOf(dateStrings[1]);
            Integer day = Integer.valueOf(dateStrings[2]);

            if (day > 31 && year > 0 && year < 13 && month > 0 && month < 32) {
                Integer temp = year;
                year = day;
                day = month;
                month = temp;
            }

            Integer hour = Integer.valueOf(timeStrings[0]);
            Integer minute;
            if (timeStrings.length > 1) {
                minute = Integer.valueOf(timeStrings[1]);
            } else {
                minute = 0;
            }
            Integer second;
            if (timeStrings.length > 2) {
                second = Integer.valueOf(timeStrings[2]);
            } else {
                second = 0;
            }

            Calendar c = Calendar.getInstance();
            c.set(year, month - 1, day, hour, minute, second);
            return getString(c.getTime(), dateFormat);
        } catch (Exception e) {
            return dateString;
        }
    }

    public static String formatDateString(String dateString) {
        return formatDateString(dateString, DateFormatString);
    }


    public static String formatDateTime(DateTime dateTime, String style, String lang) {
        DateTimeFormatter formatter = DateTimeFormat.forStyle(style).withLocale(new Locale(lang));
        return dateTime.toString(formatter);
    }

    /**
     * 相对时间 0000-00-00-00-00-00
     * <p/>
     * 默认不带时分秒
     * <p/>
     * 默认是当前时间之前 0001-00-00 一年之前
     * <p/>
     * 如果是之后加"P" P0001-00-00 一年之后
     */

    public static DateTime getCustDateTime(String relativeTime) {
        DateTime dateTime = new DateTime();
        if (relativeTime.startsWith("P")) {
            String plusTimes[] = relativeTime.substring(1).split("-");
            for (int i = 0; i < plusTimes.length; i++) {
                dateTime = plusTime(dateTime, Integer.valueOf(plusTimes[i]), i);
            }
        } else {
            String minusTimes[] = relativeTime.split("-");
            for (int i = 0; i < minusTimes.length; i++) {
                dateTime = minusTimesTime(dateTime, Integer.valueOf(minusTimes[i]), i);
            }
        }
        return dateTime;
    }

    public static DateTime minusTimesTime(DateTime datatime, int time, int index) {
        if (index == 0) {
            return datatime.minusYears(time);
        } else if (index == 1) {
            return datatime.minusMonths(time);
        } else if (index == 2) {
            return datatime.minusDays(time);
        } else if (index == 3) {
            return datatime.minusDays(time);
        } else if (index == 4) {
            return datatime.minusHours(time);
        } else if (index == 5) {
            return datatime.minusMinutes(time);
        } else if (index == 6) {
            return datatime.minusSeconds(time);
        }
        return datatime;
    }

    public static DateTime plusTime(DateTime datatime, int time, int index) {
        if (index == 0) {
            return datatime.plusYears(time);
        } else if (index == 1) {
            return datatime.plusMonths(time);
        } else if (index == 2) {
            return datatime.plusDays(time);
        } else if (index == 3) {
            return datatime.plusDays(time);
        } else if (index == 4) {
            return datatime.plusHours(time);
        } else if (index == 5) {
            return datatime.plusMinutes(time);
        } else if (index == 6) {
            return datatime.plusSeconds(time);
        }
        return datatime;
    }

}
