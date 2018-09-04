package com.github.yxchange.metadata.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;

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
    private String salt;

    /**
     * 创建时间
     */
    @Column(insertable=false, updatable=false)
    private Date createtime;

    /**
     * 最后更改时间
     */
    @Column(insertable=false, updatable=false)
    private Date modifytime;

    public User(Integer id, String username, String password, String salt, Date createtime, Date modifytime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public User() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取最后更改时间
     *
     * @return modifytime - 最后更改时间
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * 设置最后更改时间
     *
     * @param modifytime 最后更改时间
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}