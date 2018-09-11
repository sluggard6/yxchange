package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "deposit")
public class Deposit extends Base{

	/**
     * 账户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 币种id
     */
    @Column(name = "coin_id")
    private Integer coinId;

    /**
     * 币种名称
     */
    @Column(name = "coin_name")
    private String coinName;

    /**
     * 充值金额
     */
    private BigDecimal amount;

    /**
     * 充币地址
     */
    private String address;

    /**
     * 交易hash
     */
    @Column(name = "trans_hash")
    private String transHash;

    /**
     * 块高
     */
    private Integer high;

    /**
     * 状态0-新建,1-安全块高确认中,2-待归集,3-完成
     */
    private Integer state;

    public Deposit(Integer accountId, Integer coinId, String coinName, BigDecimal amount, String address, String transHash, Integer high, Integer state) {
        this.accountId = accountId;
        this.coinId = coinId;
        this.coinName = coinName;
        this.amount = amount;
        this.address = address;
        this.transHash = transHash;
        this.high = high;
        this.state = state;
    }

    public Deposit() {
        super();
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
     * 获取币种id
     *
     * @return coin_id - 币种id
     */
    public Integer getCoinId() {
        return coinId;
    }

    /**
     * 设置币种id
     *
     * @param coinId 币种id
     */
    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

    /**
     * 获取币种名称
     *
     * @return coin_name - 币种名称
     */
    public String getCoinName() {
        return coinName;
    }

    /**
     * 设置币种名称
     *
     * @param coinName 币种名称
     */
    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    /**
     * 获取充值金额
     *
     * @return amount - 充值金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置充值金额
     *
     * @param amount 充值金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 获取交易hash
     *
     * @return trans_hash - 交易hash
     */
    public String getTransHash() {
        return transHash;
    }

    /**
     * 设置交易hash
     *
     * @param transHash 交易hash
     */
    public void setTransHash(String transHash) {
        this.transHash = transHash == null ? null : transHash.trim();
    }

    /**
     * 获取块高
     *
     * @return high - 块高
     */
    public Integer getHigh() {
        return high;
    }

    /**
     * 设置块高
     *
     * @param high 块高
     */
    public void setHigh(Integer high) {
        this.high = high;
    }

    /**
     * 获取状态
     *
     * @return state - 0-新建,1-交易池,2-有hash,3-完成
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 0-新建,1-交易池,2-有hash,3-完成
     */
    public void setState(Integer state) {
        this.state = state;
    }
    
    public void setState(State state) {
    	this.state = state.ordinal();
    }
    
    public enum State {
    	NEW,
    	PADDING,
    	WAIT_COLLECTION,
    	DOWN;
    }
    
}

