package com.weidong.blog.commons.until;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Random;

public class StringUtil {

	private static StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	public static String getInitialUpperCase(String str) {
		if (str != null && str.length() > 0) {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		return str;
	}

	/**
	 * Clob转换为String
	 * @author weidong
	 * @Description:
	 * @Param
	 * @Throws
	 * @Date 2018/5/17 0:13
	 * @return
	 **/
	public static String clobToString(Clob clob) {

		try {
			return (clob != null ? clob.getSubString(1, (int) clob.length())
					: null);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据指定字符串和分割字符串数组分割字符串
	 * @author weidong
	 * @Description:
	 * @Param  dist	  String 要分割的字符串
	 *          ss  String[] 分割字符串数组
	 * @Throws
	 * @Date 2018/5/17 0:14
	 * @return
	 **/
	public static String[] splitTrim(String dist, String[] ss) {
		if (dist == null || dist == "")
			return new String[] { dist };

		if (ss == null || ss.length == 0)
			return new String[] { dist };

		for (int i = 0; i < ss.length; i++) {
			dist = dist.replace(ss[i], ss[0]);
		}

		dist = dist.replace(" ", "");
		return dist.split(ss[0]);
	}

	/**
	 * 根据指定字符串和分割字符数组分割字符串
	 * 
	 * @param dist
	 *            String 要分割的字符串
	 * @param cs
	 *            char[] 分割字符数组
	 * @return String[] 分割的去掉空格的字符串数组
	 */
	public static String[] splitTrim(String dist, char[] cs) {
		if (dist == null || dist == "")
			return new String[] { dist };
		if (cs == null || cs.length == 0)
			return new String[] { dist };

		for (int i = 0; i < cs.length; i++) {
			dist = dist.replace(cs[i], cs[0]);
		}
		dist = dist.replace(" ", "");
		return split(dist, cs[0]);
	}

	/**
	 * 根据指定字符串和分割字符分割字符串
	 * 
	 * @param dist
	 *            String 要分割的字符串
	 * @param cs
	 *            char 分割字符
	 * @return String[] 分割的去掉空格的字符串数组
	 */
	public static String[] splitTrim(String dist, char c) {
		if (dist == null || dist == "")
			return new String[] { dist };
		dist = dist.replace(" ", "");
		return dist.split(String.valueOf(c));
	}

	/**
	 * 根据指定字符串和分割字符数组分割字符串
	 * 
	 * @param dist
	 *            String 要分割的字符串
	 * @param cs
	 *            String[] 分割字符串数组
	 * @return String[] 分割字符串数组
	 */
	public static String[] split(String dist, String[] ss) {
		if (dist == null || dist == "")
			return new String[] { dist };
		if (ss == null || ss.length == 0)
			return new String[] { dist };

		for (int i = 0; i < ss.length; i++) {
			dist = dist.replace(ss[i], ss[0]);
		}
		return dist.split(ss[0]);
	}

	/**
	 * 根据指定字符串和分割字符数组分割字符串
	 * 
	 * @param dist
	 *            String 要分割的字符串
	 * @param cs
	 *            char[] 分割字符数组
	 * @return String[] 分割字符串数组
	 */
	public static String[] split(String dist, char[] cs) {
		if (dist == null || dist == "")
			return new String[] { dist };
		if (cs == null || cs.length == 0)
			return new String[] { dist };

		for (int i = 0; i < cs.length; i++) {
			dist = dist.replace(cs[i], cs[0]);
		}
		return split(dist, cs[0]);
	}

	/**
	 * 根据指定字符串和分割字符分割字符串
	 * 
	 * @param dist
	 *            String 要分割的字符串
	 * @param cs
	 *            char 分割字符
	 * @return String[] 分割字符串数组
	 *
	 */
	public static String[] split(String dist, char c) {
		if (dist == null || dist == "")
			return new String[] { dist };
		return dist.split(String.valueOf(c));
	}

	public static String getString(String dist) {
		if (isEmpty(dist))
			return "";
		return dist;
	}

	/**
	 * 判断字符串是否为空
	 * @param dist
	 * @return
	 */
	public static boolean isEmpty(String dist) {
		if (dist == null)
			return true;
		return dist.length() == 0;
	}
	
	/**
	 * 判断字符串是否为空
	 * @param dist
	 * @return
	 */
	public static boolean isNotEmpty(String dist) {
		if (dist != null && dist.length()> 0)
			return true;
		return false;
	}
	/**
     * 切割字符串，将字符串切割成指定的长度，后面的用省略号补充
     * @param str
     * @param count
     * @return
     */
    public static String subString(String str,int count){
    	if(isEmpty(str))return null;
    	if(str.length() > count){
    		return str.substring(0,count) + "...";
    	}else{
    		return str;
    	}
    }
    
    /**
     * 切割字符串，将字符串切割成指定的长度，后面的直接去掉
     * @param str
     * @param count
     * @return
     */
    public static String subString1(String str,int count){
    	if(isEmpty(str))return null;
    	if(str.length() > count){
    		return str.substring(0,count);
    	}else{
    		return str;
    	}
    }
    
    /**
     * 切割字符串，将字符串切割成指定的长度，后面加上两个省略号
     * @param str
     * @param count
     * @return
     */
    public static String subString2(String str,int count){
    	if(isEmpty(str))return null;
    	if(str.length() > count){
    		return str.substring(0,count) + "..";
    	}else{
    		return str;
    	}
    }
    
    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){   
    	  for (int i = str.length();--i>=0;){     
    	   if (!Character.isDigit(str.charAt(i))){   
    	    return false;   
    	   }   
    	  }   
    	  return true;   
    	}  

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			
			System.out.println(getRandomString(10));
		}
	}
}
