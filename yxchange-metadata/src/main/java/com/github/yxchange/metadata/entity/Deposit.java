package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 充值金额
     */
    private BigDecimal amount;

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
     * 0-新建,1-交易池,2-有hash,3-完成
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

    public Deposit(Integer id, Integer accountId, BigDecimal amount, String transHash, Integer high, Integer state, Date createtime, Date modifytime) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.transHash = transHash;
        this.high = high;
        this.state = state;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public Deposit() {
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
     * 获取0-新建,1-交易池,2-有hash,3-完成
     *
     * @return state - 0-新建,1-交易池,2-有hash,3-完成
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0-新建,1-交易池,2-有hash,3-完成
     *
     * @param state 0-新建,1-交易池,2-有hash,3-完成
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