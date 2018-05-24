/**
 * Copyright (C), 2017-2018, 1130160475@qq.com
 * FileName: SecretNameFunc
 * Author:   ${1130160475@qq.com}
 * Date:     2018/4/7 0007 下午 8:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.weidong.blog.webservice.config.beetl.function;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 星号替换姓名
 * 例：**东
 */
public class SecretNameFunc implements Function {

    private static final Logger logger = LoggerFactory.getLogger(SecretNameFunc.class);
    @Override
    public Object call(Object[] objects, Context context){
        if (objects == null || objects.length != 1){
            throw new BeetlException("参数不正确！");
        }

        String name = (String) objects[0];
        if (StringUtils.hasText(name)){
            StringBuffer s = new StringBuffer();
            if (name.length() > 2){
                for (int i = 0;i < name.length() -1;i++){
                    s.append("*");
                }
                s.append(name.substring(name.length()-1,name.length()));
            }else{
                s.append("*").append(name.substring(name.length()-1,name.length()));
            }
            try {
                context.byteWriter.write(s.toString().getBytes());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}