package com.fly.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Created by lixfn on 14-11-19.
 */
public class HttpUtil {
    public static String http(String url, Map<String, String> params) {
        URL u = null;
        HttpURLConnection con = null;
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            for (Entry<String, String> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
//        System.out.println("send_url:" + url);
//        System.out.println("send_data:" + sb.toString());
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public static String httpPost(String url, String paraString) {
        URL u = null;
        HttpURLConnection con = null;

//        System.out.println("send_url:" + url);
//        System.out.println("send_data:" + paraString);

        try {
            u = new URL(url);

//			Properties props = System.getProperties();
//			props.setProperty("proxySet", "true");
//			props.setProperty("http.proxyHost", "10.1.180.24");
//			props.setProperty("http.proxyPort", "3128");
//			Authenticator.setDefault(new Authenticator() {
//			   protected PasswordAuthentication getPasswordAuthentication() {
//			   return new PasswordAuthentication("lixfn",
//			   new String("*********").toCharArray());
//			}
//			});

            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(paraString);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }


        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("receive_data:" + buffer.toString());
        return buffer.toString();
    }
}
