package com.weidong.blog.commons.until;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**Base64Util工具类
 * 
 * @Date 2017年9月23日  下午10:38:26
 * @Note <这里是该类的使用注意事项>
 */
public class Base64Util {
		/**  
	    * 编码  
	    * @param bstr  
	    * @return String  
	    */    
	   public static String encode(byte[] bstr){    
		   return new BASE64Encoder().encode(bstr);
	   }    
	   
	   
	   /**  
	    * 解码  
	    * @param str  
	    * @return string  
	    */    
	   public static byte[] decode(String str){    
		   byte[] bt = null;    
		   try {    
		       BASE64Decoder decoder = new BASE64Decoder();
		       bt = decoder.decodeBuffer( str );    
		   } catch (Exception e) {    
		       e.printStackTrace();    
		   }    
		   return bt;    
	   }    
	   
	   
	   	//加密  
	    public static String getBase64(String str) {  
	        byte[] b = null;  
	        String s = null;  
	        try {  
	            b = str.getBytes("utf-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        if (b != null) {  
	            s = new BASE64Encoder().encode(b);  
	        }  
	        return s;  
	    }  
	  
	    
	    //解密  
	    public static String getFromBase64(String s) {  
	    	//js加密后，提交到后台，加密字符串中的“+”号变成了空格，所以将空格替换成"+"
	    	s=s.replace(" ", "+");
			s=s.replace("\n", "");
	        byte[] b = null;  
	        String result = null;  
	        if (s != null) {  
	            BASE64Decoder decoder = new BASE64Decoder();  
	            try {  
	                b = decoder.decodeBuffer(s);  
	                result = new String(b, "utf-8");  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return result;  
	    }  
	    
	    public static void main(String[] args) {
			String str = "我";  //5piv
			System.out.println(getBase64(str));
			System.out.println(getFromBase64(getBase64(str)));
			System.out.println(getFromBase64("W3siY29tbW9kaXR5X2lkIjoiN2MxNTdlNzZlNjFmNGUwNDk3MDAwZTZmZjc0MWUyYTEiLCJzcGVjaWZpY2F0aW9uX3ZhbHVlX2lkIjoiMTMsMTUsOSIsImFtb3VudCI6IjEiLCJ1bml0X3ByaWNlIjoiNS4wMCIsInN0b3JlX2NvdW50IjoiMTciLCJjb21tb2RpdHlfbmFtZSI6IuOAkCDpobrkuLDljIXpgq4gNuebkuijheOAkUdBQkHoh6rnhLbphpLOsy3msKjln7rkuIHphbgxODBn5rCo5Z+6IiwiaW1nX3BhdGhfc3RyIjoiaHR0cDovL3N5cy1yZXNvdXJjZS5vc3MtY24tYmVpamluZy5hbGl5dW5jcy5jb20vc2hvcEFkbWluL2ltZy8yMDE3MDkxNDEwMDkxNDI0MjAwMDAwMDQuanBnIiwic3BlY2lmaWNhdGlvbnNfbmFtZSI6IjIwMG1s6JOd6ImyMjDnm5IifV0="));
		}
}
