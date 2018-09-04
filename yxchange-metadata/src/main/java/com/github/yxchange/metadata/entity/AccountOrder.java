package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_order")
public class AccountOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 变更订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 系统来源
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 变更前可用资产
     */
    @Column(name = "available_before")
    private BigDecimal availableBefore;

    /**
     * 变更后可用资产
     */
    @Column(name = "available_after")
    private BigDecimal availableAfter;

    /**
     * 变更前冻结资产
     */
    @Column(name = "freezed_before")
    private BigDecimal freezedBefore;

    /**
     * 变更后冻结资产
     */
    @Column(name = "freezed_after")
    private BigDecimal freezedAfter;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后更改时间
     */
    private Date modifytime;

    public AccountOrder(Integer id, Integer accountId, String orderId, Integer channelId, BigDecimal availableBefore, BigDecimal availableAfter, BigDecimal freezedBefore, BigDecimal freezedAfter, Date createtime, Date modifytime) {
        this.id = id;
        this.accountId = accountId;
        this.orderId = orderId;
        this.channelId = channelId;
        this.availableBefore = availableBefore;
        this.availableAfter = availableAfter;
        this.freezedBefore = freezedBefore;
        this.freezedAfter = freezedAfter;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public AccountOrder() {
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
     * 获取变更订单号
     *
     * @return order_id - 变更订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置变更订单号
     *
     * @param orderId 变更订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取系统来源
     *
     * @return channel_id - 系统来源
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置系统来源
     *
     * @param channelId 系统来源
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取变更前可用资产
     *
     * @return available_before - 变更前可用资产
     */
    public BigDecimal getAvailableBefore() {
        return availableBefore;
    }

    /**
     * 设置变更前可用资产
     *
     * @param availableBefore 变更前可用资产
     */
    public void setAvailableBefore(BigDecimal availableBefore) {
        this.availableBefore = availableBefore;
    }

    /**
     * 获取变更后可用资产
     *
     * @return available_after - 变更后可用资产
     */
    public BigDecimal getAvailableAfter() {
        return availableAfter;
    }

    /**
     * 设置变更后可用资产
     *
     * @param availableAfter 变更后可用资产
     */
    public void setAvailableAfter(BigDecimal availableAfter) {
        this.availableAfter = availableAfter;
    }

    /**
     * 获取变更前冻结资产
     *
     * @return freezed_before - 变更前冻结资产
     */
    public BigDecimal getFreezedBefore() {
        return freezedBefore;
    }

    /**
     * 设置变更前冻结资产
     *
     * @param freezedBefore 变更前冻结资产
     */
    public void setFreezedBefore(BigDecimal freezedBefore) {
        this.freezedBefore = freezedBefore;
    }

    /**
     * 获取变更后冻结资产
     *
     * @return freezed_after - 变更后冻结资产
     */
    public BigDecimal getFreezedAfter() {
        return freezedAfter;
    }

    /**
     * 设置变更后冻结资产
     *
     * @param freezedAfter 变更后冻结资产
     */
    public void setFreezedAfter(BigDecimal freezedAfter) {
        this.freezedAfter = freezedAfter;
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