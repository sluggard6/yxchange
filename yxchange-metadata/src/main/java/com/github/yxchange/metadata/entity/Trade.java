package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 撮合id
     */
    @Column(name = "match_id")
    private String matchId;

    /**
     * 卖方id
     */
    @Column(name = "ask_order_id")
    private Integer askOrderId;

    /**
     * 买方id
     */
    @Column(name = "bid_order_id")
    private Integer bidOrderId;

    /**
     * 成交方id
     */
    @Column(name = "taker_order_id")
    private Integer takerOrderId;

    /**
     * 做市方id
     */
    @Column(name = "maker_order_id")
    private Integer makerOrderId;

    /**
     * 成交价格
     */
    private BigDecimal price;

    /**
     * 成交数量
     */
    private BigDecimal lots;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后更改时间
     */
    private Date modifytime;

    public Trade(Integer id, String matchId, Integer askOrderId, Integer bidOrderId, Integer takerOrderId, Integer makerOrderId, BigDecimal price, BigDecimal lots, Date createtime, Date modifytime) {
        this.id = id;
        this.matchId = matchId;
        this.askOrderId = askOrderId;
        this.bidOrderId = bidOrderId;
        this.takerOrderId = takerOrderId;
        this.makerOrderId = makerOrderId;
        this.price = price;
        this.lots = lots;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public Trade() {
        super();
    }

    public Trade(Integer bidOrderId, Integer askOrderId, BigDecimal price, BigDecimal lots) {
    	this.bidOrderId = bidOrderId;
    	this.askOrderId = askOrderId;
    	this.price = price;
    	this.lots = lots;
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
     * 获取撮合id
     *
     * @return match_id - 撮合id
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * 设置撮合id
     *
     * @param matchId 撮合id
     */
    public void setMatchId(String matchId) {
        this.matchId = matchId == null ? null : matchId.trim();
    }

    /**
     * 获取卖方id
     *
     * @return ask_order_id - 卖方id
     */
    public Integer getAskOrderId() {
        return askOrderId;
    }

    /**
     * 设置卖方id
     *
     * @param askOrderId 卖方id
     */
    public void setAskOrderId(Integer askOrderId) {
        this.askOrderId = askOrderId;
    }

    /**
     * 获取买方id
     *
     * @return bid_order_id - 买方id
     */
    public Integer getBidOrderId() {
        return bidOrderId;
    }

    /**
     * 设置买方id
     *
     * @param bidOrderId 买方id
     */
    public void setBidOrderId(Integer bidOrderId) {
        this.bidOrderId = bidOrderId;
    }

    /**
     * 获取成交方id
     *
     * @return taker_order_id - 成交方id
     */
    public Integer getTakerOrderId() {
        return takerOrderId;
    }

    /**
     * 设置成交方id
     *
     * @param takerOrderId 成交方id
     */
    public void setTakerOrderId(Integer takerOrderId) {
        this.takerOrderId = takerOrderId;
    }

    /**
     * 获取做市方id
     *
     * @return maker_order_id - 做市方id
     */
    public Integer getMakerOrderId() {
        return makerOrderId;
    }

    /**
     * 设置做市方id
     *
     * @param makerOrderId 做市方id
     */
    public void setMakerOrderId(Integer makerOrderId) {
        this.makerOrderId = makerOrderId;
    }

    /**
     * 获取成交价格
     *
     * @return price - 成交价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置成交价格
     *
     * @param price 成交价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取成交数量
     *
     * @return lots - 成交数量
     */
    public BigDecimal getLots() {
        return lots;
    }

    /**
     * 设置成交数量
     *
     * @param lots 成交数量
     */
    public void setLots(BigDecimal lots) {
        this.lots = lots;
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