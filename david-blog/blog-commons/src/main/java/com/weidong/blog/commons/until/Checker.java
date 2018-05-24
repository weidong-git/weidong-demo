package com.weidong.blog.commons.until;

import com.weidong.blog.commons.exception.EnhanceException;

/**
 * @ClassName Checker
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/22 22:06
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
public class Checker {

    public static void require(boolean require,String format,String ...args){
        if (!require){
            throw new EnhanceException(String.format(format,args));
        }
    }
}
