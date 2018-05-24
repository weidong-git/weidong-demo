package com.weidong.blog.commons.until;


import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;


/**
 * @ClassName JSONUtil
 * @Description json转换
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/16 21:58
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
public class JSONUtil<T> {

    /**
     *  将字符串转换为json
     * @author weidong
     * @Description: str="{sid:'no1',sname:'kity',age:11}";
     * @Param
     * @Throws
     * @Date 2018/5/16 23:14
     * @return
     **/
    public static JSONObject strToJson(String str){
        return JSONObject.fromObject(str);
    }
    /**
     * 將json字符串数组转为json数组
     * @author weidong
     * @Description:String str1 = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]"
     * @Param
     * @Throws
     * @Date 2018/5/16 22:42
     * @return
     **/
    public static JSONArray getStringArryToJson(String str){
       return JSONArray.fromObject(str);
    }

    /**
     *  将java对象转换成json字符串
     * @author weidong
     * @Description: java实体对象转换为json对象
     * @Param
     * @Throws
     * @Date 2018/5/16 23:15
     * @return
     **/
    public static String getJsonStringFromObject(Object javaObj) {
        JSONObject json;
        json = JSONObject.fromObject(javaObj);
        return json.toString();
    }
    /**
     *  从Map对象得到Json字串
     * @author weidong
     * @Description:
     * @Param
     * @Throws
     * @Date 2018/5/16 23:21
     * @return
     **/
    public static String getJsonStringFromMap(Map map) {
        JSONObject json = JSONObject.fromObject(map);
        return json.toString();
    }
    /**
     * @author weidong
     * @Description: like "[\"李斯\",100]"
     * @Param
     * @Throws
     * @Date 2018/5/17 0:02
     * @return
     **/
    public static Object[] getObjectArrayFromJsonString(String jsonString) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();
    }
    /**
     *  将list转换成String
     * @author weidong
     * @Description:
     * @Param
     * @Throws
     * @Date 2018/5/17 0:00
     * @return
     **/
    public static String getJsonStringFromList(List list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    /**
     * 将List<T>转换为Json
     * @author weidong
     * @Description:
     * @Param
     * @Throws
     * @Date 2018/5/17 22:04
     * @return
     **/
    public JSONArray ListToJson(List<T> list){
        JSONArray json = JSONArray.fromObject(list);
        return json;
    }
    public static void main(String[] args) {
        String  str="{sid:'no1',sname:'kity',age:11}";
        String str1 = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]" ;  // 一个未转化的字符串
        System.out.println(JSONUtil.strToJson(str).get("sid"));
    }

}
