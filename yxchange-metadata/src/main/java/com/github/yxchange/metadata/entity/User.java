package com.github.yxchange.metadata.entity;

import java.util.Date;
import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name = "user")
public class User extends Base{

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 掩码
     */
    @JSONField(serialize=false, deserialize=false)
    private String salt;

    public User(Integer id, String username, String password, String salt, Date createtime, Date modifytime) {
        super(id, createtime, modifytime);
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public User() {
        super();
    }


    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取掩码
     *
     * @return salt - 掩码
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置掩码
     *
     * @param salt 掩码
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

}