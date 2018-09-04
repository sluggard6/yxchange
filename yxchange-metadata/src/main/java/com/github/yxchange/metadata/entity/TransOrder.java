package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "trans_order")
public class TransOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账号id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 交易类型，0-ask,1-bid
     */
    private Integer category;

    /**
     * 交易价格
     */
    private BigDecimal price;

    /**
     * 交易数量
     */
    private BigDecimal lots;

    /**
     * 状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
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

    public TransOrder(Integer id, Integer accountId, Integer category, BigDecimal price, BigDecimal lots, Integer state, Date createtime, Date modifytime) {
        this.id = id;
        this.accountId = accountId;
        this.category = category;
        this.price = price;
        this.lots = lots;
        this.state = state;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public TransOrder() {
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
     * 获取账号id
     *
     * @return account_id - 账号id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置账号id
     *
     * @param accountId 账号id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取交易类型，0-ask,1-bid
     *
     * @return category - 交易类型，0-ask,1-bid
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置交易类型，0-ask,1-bid
     *
     * @param category 交易类型，0-ask,1-bid
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取交易价格
     *
     * @return price - 交易价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置交易价格
     *
     * @param price 交易价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取交易数量
     *
     * @return lots - 交易数量
     */
    public BigDecimal getLots() {
        return lots;
    }

    /**
     * 设置交易数量
     *
     * @param lots 交易数量
     */
    public void setLots(BigDecimal lots) {
        this.lots = lots;
    }

    /**
     * 获取状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
     *
     * @return state - 状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
     *
     * @param state 状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
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