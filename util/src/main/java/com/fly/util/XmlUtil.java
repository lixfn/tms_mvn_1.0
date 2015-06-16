package com.fly.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by lixfn on 14-11-19.
 */
public class XmlUtil {


    /**
     * 通过Object生成XML字符串，Object中需要写Xml注解
     *
     * @param obj
     * @return
     */
    public static String generateXmlFromObject(Object obj) {
        try {
            if (obj == null) {
                throw new Exception();
            }
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            String xml = sw.toString();
            System.out.println("Target Xml:" + xml);

            return xml;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过Xml字符串，生成相应的Object
     *
     * @param c   类型
     * @param xml xmL内容
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T generateObjectFromXml(Class<T> c, String xml) {
        try {

            System.out.println("Source XML:" + xml);
            T obj = c.newInstance();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sw = new StringReader(xml);
            obj = (T) unmarshaller.unmarshal(sw);

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * XML标签转为大写字母
     *
     * @param xml
     * @return
     */
    public static String xmlTagToUpper(String xml) {
        Pattern pattern = Pattern.compile("<.+?>");
        StringBuffer sb = new StringBuffer();
        int lastIdx = 0;
        Matcher matcher = pattern.matcher(xml);
        while (matcher.find()) {
            String str = matcher.group();
            if (str.startsWith("<?xml ")) {
                sb.append(str);
                lastIdx = matcher.end();
                continue;
            }
            sb.append(xml.substring(lastIdx, matcher.start()));
            sb.append(str.toUpperCase());
            lastIdx = matcher.end();
        }
        sb.append(xml.substring(lastIdx));
        return sb.toString();
    }

    /**
     * XML标签转为小写字母
     *
     * @param xml
     * @return
     */
    public static String xmlTagToLower(String xml) {
        Pattern pattern = Pattern.compile("<.+?>");
        StringBuffer sb = new StringBuffer();
        int lastIdx = 0;
        Matcher matcher = pattern.matcher(xml);
        while (matcher.find()) {
            String str = matcher.group();
            if (str.startsWith("<?xml ")) {
                sb.append(str);
                lastIdx = matcher.end();
                continue;
            }
            sb.append(xml.substring(lastIdx, matcher.start()));
            sb.append(str.toLowerCase());
            lastIdx = matcher.end();
        }
        sb.append(xml.substring(lastIdx));
        return sb.toString();
    }
}
