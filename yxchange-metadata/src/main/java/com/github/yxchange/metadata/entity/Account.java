package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account")
public class Account extends Base{
    /**
     * 用户表id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 代币id
     */
    @Column(name = "coin_id")
    private Integer coinId;

    /**
     * 代币名称
     */
    @Column(name = "coin_name")
    private String coinName;

    /**
     * 可用资产
     */
    private BigDecimal available;

    /**
     * 可用资产
     */
    private BigDecimal freezed;

    /**
     * 充币地址
     */
    private String address;

    /**
     * 0-在用，1-禁用
     */
    private Integer state;

    public Account(Integer id, Integer userId, Integer coinId, String coinName, BigDecimal available, BigDecimal freezed, String address, Integer state, Date createtime, Date modifytime) {
        this.id = id;
        this.userId = userId;
        this.coinId = coinId;
        this.coinName = coinName;
        this.available = available;
        this.freezed = freezed;
        this.address = address;
        this.state = state;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public Account() {
        super();
    }
    
    public Account(Integer coinId, String coinName) {
    	this(null, null, coinId, coinName, BigDecimal.ZERO, BigDecimal.ZERO, null, 0, null, null);
    }

    public Account(Integer userId, Integer coinId, String coinName) {
    	this(null, userId, coinId, coinName, BigDecimal.ZERO, BigDecimal.ZERO, null, 0, null, null);
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
     * 获取用户表id
     *
     * @return user_id - 用户表id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户表id
     *
     * @param userId 用户表id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取代币id
     *
     * @return coin_id - 代币id
     */
    public Integer getCoinId() {
        return coinId;
    }

    /**
     * 设置代币id
     *
     * @param coinId 代币id
     */
    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

    /**
     * 获取代币名称
     *
     * @return coin_name - 代币名称
     */
    public String getCoinName() {
        return coinName;
    }

    /**
     * 设置代币名称
     *
     * @param coinName 代币名称
     */
    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    /**
     * 获取可用资产
     *
     * @return available - 可用资产
     */
    public BigDecimal getAvailable() {
        return available;
    }

    /**
     * 设置可用资产
     *
     * @param available 可用资产
     */
    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    /**
     * 获取可用资产
     *
     * @return freezed - 可用资产
     */
    public BigDecimal getFreezed() {
        return freezed;
    }

    /**
     * 设置可用资产
     *
     * @param freezed 可用资产
     */
    public void setFreezed(BigDecimal freezed) {
        this.freezed = freezed;
    }

    /**
     * 获取充币地址
     *
     * @return address - 充币地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置充币地址
     *
     * @param address 充币地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取0-在用，1-禁用
     *
     * @return state - 0-在用，1-禁用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0-在用，1-禁用
     *
     * @param state 0-在用，1-禁用
     */
    public void setState(Integer state) {
        this.state = state;
    }
    
    public boolean addAvailable(BigDecimal amount) {
    	if(amount == null) { throw new NullPointerException(); }
    	this.available = this.available.add(amount);
    	return checkAvailable();
    }
    
    public boolean addFreezed(BigDecimal amount) {
    	if(amount == null) { throw new NullPointerException(); }
    	if(addAvailable(amount.negate())){
    		this.freezed = this.freezed.add(amount);
        	return checkFreezed();
    	}else {
    		return false;
    	}
    	
    }
    
    public boolean checkAvailable() {
    	return this.available.compareTo(BigDecimal.ZERO) >= 0;
    }
    
    public boolean checkFreezed() {
    	return this.freezed.compareTo(BigDecimal.ZERO) >= 0;
    }

}