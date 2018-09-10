package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_operation")
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 操作类型，0-加减仓，1-冻结/解冻资金
     */
    private Integer operation;

    /**
     * 变更数量
     */
    private BigDecimal amount;

    /**
     * 冻结订单号
     */
    @Column(name = "freeze_order_id")
    private String freezeOrderId;

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
     * 说明
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后更改时间
     */
    private Date modifytime;

    public AccountOperation(Integer id, String orderId, Integer operation, BigDecimal amount, String freezeOrderId, BigDecimal availableBefore, BigDecimal availableAfter, BigDecimal freezedBefore, BigDecimal freezedAfter, String description, Date createtime, Date modifytime) {
        this.id = id;
        this.orderId = orderId;
        this.operation = operation;
        this.amount = amount;
        this.freezeOrderId = freezeOrderId;
        this.availableBefore = availableBefore;
        this.availableAfter = availableAfter;
        this.freezedBefore = freezedBefore;
        this.freezedAfter = freezedAfter;
        this.description = description;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public AccountOperation() {
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
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取操作类型，0-加减仓，1-冻结/解冻资金
     *
     * @return operation - 操作类型，0-加减仓，1-冻结/解冻资金
     */
    public Integer getOperation() {
        return operation;
    }

    /**
     * 设置操作类型，0-加减仓，1-冻结/解冻资金
     *
     * @param operation 操作类型，0-加减仓，1-冻结/解冻资金
     */
    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    /**
     * 获取变更数量
     *
     * @return amount - 变更数量
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置变更数量
     *
     * @param amount 变更数量
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取冻结订单号
     *
     * @return freeze_order_id - 冻结订单号
     */
    public String getFreezeOrderId() {
        return freezeOrderId;
    }

    /**
     * 设置冻结订单号
     *
     * @param freezeOrderId 冻结订单号
     */
    public void setFreezeOrderId(String freezeOrderId) {
        this.freezeOrderId = freezeOrderId == null ? null : freezeOrderId.trim();
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
     * 获取说明
     *
     * @return description - 说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置说明
     *
     * @param description 说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
    
	public void setOperation(Operation operation) {
		this.operation = operation.ordinal();
	}
	
    public enum Operation {
    	FUND,
    	FREEZE;
    }

}