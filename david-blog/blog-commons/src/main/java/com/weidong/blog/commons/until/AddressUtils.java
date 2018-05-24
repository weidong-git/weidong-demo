package com.weidong.blog.commons.until;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @ClassName AddressUtils
 * @Description TODO获取ip地址与地理位置
 *     淘宝API：http://ip.taobao.com/service/getIpInfo.php?ip=218.192.3.42
 *     新浪API：http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.192.3.42
 *     pconline API：http://whois.pconline.com.cn/
 *     百度API：http://api.map.baidu.com/location/ip?ip=218.192.3.42
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 17:57
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
public class AddressUtils {

    /** 
     *获取用户的真实的网络ip
     * @author weidong
     * @Description: 
     * @Param 
     * @Throws
     * @Date 2018/5/21 22:25 
     * @return 
     **/
    public static String getMyIP() throws IOException {
        String url="http://ip.chinaz.com/getip.aspx";
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
                System.out.println((char) cp);
            }
            String jsonText =  sb.toString();;
            jsonText=jsonText.replaceAll("'", "");
            jsonText=jsonText.substring(1,jsonText.length()-1);
           jsonText=jsonText.replaceAll(",", ",");
            System.out.println(jsonText);
            return jsonText;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }

    /** 
     *根据IP地址获取详细的地域信息
     * 淘宝API : http://ip.taobao.com/service/getIpInfo.php?ip=218.192.3.42
     * 新浪API : http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.192.3.42
     * @author weidong
     * @Description: 
     * @Param 
     * @Throws
     * @Date 2018/5/20 18:12 
     * @return 
     **/
    public static String getAddresses(String content, String encodingString)
            throws UnsupportedEncodingException {
        // 这里调用淘宝API
        String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
        // 从http://whois.pconline.com.cn取得IP所在的省市区信息
        String returnStr = getResult(urlStr, content, encodingString);
        if (returnStr != null) {
            // 处理返回的省市区信息
            System.out.println("(1) unicode转换成中文前的returnStr : " + returnStr);
            returnStr = decodeUnicode(returnStr);
            System.out.println("(2) unicode转换成中文后的returnStr : " + returnStr);
            String[] temp = returnStr.split(",");
            if(temp.length<3){
                return "0";//无效IP，局域网测试
            }
            return JSONObject.fromObject(returnStr).get("data").toString();
        }
        return null;
    }
    /** 
     *
     * @author weidong
     * @Description:  请求的地址
     * @Param 
     * @Throws
     * @Date 2018/5/20 18:14 
     * @return 
     **/
    private static String getResult(String urlStr, String content, String encoding) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());// 打开输出流往对端服务器写数据
            out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
            out.flush();// 刷新
            out.close();// 关闭输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
            // ,以BufferedReader流来读取
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();// 关闭连接
            }
        }
        return null;
    }


    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed      encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }
    // 测试
    public static void main(String[] args) {
        AddressUtils addressUtils = new AddressUtils();
        // 测试ip 219.136.134.157 中国=华南=广东省=广州市=越秀区=电信
        String ip = "119.162.32.150";
        Object address = "";
        try {
            System.out.println(AddressUtils.getMyIP());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            address = addressUtils.getAddresses("ip="+ip, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(address);
        // 输出结果为：广东省,广州市,越秀区
    }



}
