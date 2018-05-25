package com.weidong.blog.webservice.controller;

import com.weidong.blog.commons.api.UserServiceApi;
import com.weidong.blog.commons.entity.BlogUser;
import com.weidong.blog.commons.until.JsonResult;
import com.weidong.blog.commons.until.RequestUtil;
import com.weidong.blog.commons.until.ValidateImgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 19:08
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Controller
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = Logger.getLogger(String.valueOf(AuthController.class));

    @Autowired
    private UserServiceApi userServiceApi;
    /** 
     * 图片验证码
     * @author weidong
     * @Description: 
     * @Param 
     * @Throws
     * @Date 2018/5/20 19:08 
     * @return 
     **/
    @RequestMapping(value="/validateImgCode")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateImgCode vCode = new ValidateImgCode(100,30,5,50);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }

    /**
     * 用户添加
     * @param blogUser
     * @param request
     * @return
     */
    @RequestMapping(value="/insertUser")
    @ResponseBody
    public JsonResult insertUser(BlogUser blogUser, HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        blogUser.setRegIp(RequestUtil.getClientIp(request));
        //注册
        int res=0;
        try {
            res = userServiceApi.insertUser(blogUser);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonResult.setState(0);
            jsonResult.setMessage("用户插入失败!");
            return jsonResult;
        }
        //登录
       if (res>0){
           jsonResult.setState(1);
           jsonResult.setMessage("用户插入成功!");
           return jsonResult;
       }else{
           jsonResult.setState(0);
           jsonResult.setMessage("用户插入失败!");
           return jsonResult;
       }
    }
    @RequestMapping(value="/login")
    @ResponseBody
   public  JsonResult Login(BlogUser blogUser){
       JsonResult jsonResult = new JsonResult();
       BlogUser user = userServiceApi.Login(blogUser);
       return  jsonResult;
   }


}
