package com.weidong.blog.commons.until;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Jinping<jinping_125@qq.com> on 2017/6/13.
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
    /**
     * 获取
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * http与https协议
     * @param request
     * @return
     */
    public static String getHttpScheme(HttpServletRequest request){
        return request.getScheme();
    }

    public static boolean isHttpsRequest(HttpServletRequest request){
        String scheme = getHttpScheme(request);
        scheme = StringUtils.trimToNull(scheme);
        if (scheme == null){
            return false;
        }
        scheme = scheme.toLowerCase();
        return "https".equals(scheme);
    }

    /**
     * 返回域名来源
     * @param request
     * @return
     */
    public static String getOriginDomain(HttpServletRequest request){
        String originDomain = request.getHeader("Origin");
        if (null == originDomain || "".equals(originDomain)){
            originDomain =  request.getHeader("Referer");
            if (null != originDomain && !"".equals(originDomain)){
                int end = originDomain.indexOf("/",originDomain.indexOf("/",originDomain.indexOf("/")+1)+1);
                originDomain = originDomain.substring(0,end);
            }
        }
        return originDomain;
    }
}
