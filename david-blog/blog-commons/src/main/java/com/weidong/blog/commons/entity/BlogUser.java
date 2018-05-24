package com.weidong.blog.commons.entity;

import java.io.Serializable;
import java.util.Date;

public class BlogUser implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 用户账号
     */
    private String phoneNum;

    /**
     * 用户密码
     */
    private String password;

    private String pwdSalt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * ip地址
     */
    private String regIp;

    /**
     * 
     */
    private String lastIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastTime;

    private String thisIp;

    private Date thisTime;

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public String getThisIp() {
        return thisIp;
    }

    public void setThisIp(String thisIp) {
        this.thisIp = thisIp;
    }

    public Date getThisTime() {
        return thisTime;
    }

    public void setThisTime(Date thisTime) {
        this.thisTime = thisTime;
    }

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户账号
     * @return phone_num 用户账号
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 用户账号
     * @param phoneNum 用户账号
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 昵称
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * ip地址
     * @return reg_ip ip地址
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * ip地址
     * @param regIp ip地址
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    /**
     * 
     * @return last_ip 
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 
     * @param lastIp 
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后登录时间
     * @return last_time 最后登录时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 最后登录时间
     * @param lastTime 最后登录时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}