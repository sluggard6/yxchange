package com.github.yxchange.metadata.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "account_address")
public class AccountAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 提币地址
     */
    private String address;

    /**
     * 状态，0-在用，1-已删除
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后更改时间
     */
    private Date modifytime;

    public AccountAddress(Integer id, Integer accountId, String address, Integer state, Date createtime, Date modifytime) {
        this.id = id;
        this.accountId = accountId;
        this.address = address;
        this.state = state;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public AccountAddress() {
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
     * 获取账户id
     *
     * @return account_id - 账户id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置账户id
     *
     * @param accountId 账户id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取提币地址
     *
     * @return address - 提币地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置提币地址
     *
     * @param address 提币地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取状态，0-在用，1-已删除
     *
     * @return state - 状态，0-在用，1-已删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态，0-在用，1-已删除
     *
     * @param state 状态，0-在用，1-已删除
     */
    public void setState(Integer state) {
        this.state = state;
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