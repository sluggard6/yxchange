package com.github.yxchange.metadata.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "trans_order")
public class TransOrder extends Base{

    /**
     * 账号id
     */
    @Column(name = "account_id")
    private Integer accountId;
    
    /**
     * 要买/卖的币种id
     */
    @Column(name = "base_id")
    private Integer baseId;
    
    /**
     * 要支付/收到的币种id
     */
    @Column(name = "counter_id")
    private Integer counterId;

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
    private BigDecimal amount;

    /**
     * 状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单
     */
    private Integer state;
    
    public TransOrder(Integer id, Integer accountId, Integer category, BigDecimal price, BigDecimal amount, Integer state) {
        this.id = id;
        this.accountId = accountId;
        this.category = category;
        this.price = price;
        this.amount = amount;
        this.state = state;
    }

    public TransOrder() {
        super();
    }

    public boolean isAsk() {
    	return category == Category.ASK.ordinal();
    }
    
    public boolean isBid() {
    	return category == Category.BID.ordinal();
    }
    
    public enum Category {
    	ASK,BID;
    }

	public boolean isDone() {
		return State.values()[state] == State.DONE;
	}
	
	public enum State {
    	NEW,
    	PARTIAL_MATCH,
    	MATCH_DONE,
    	DONE,
    	CANCELED;
    }
	
	public boolean isCanCancel() {
		return State.values()[state] == State.NEW || State.values()[state] == State.PARTIAL_MATCH;
	}

	public void setState(State state) {
		this.state = state.ordinal();
		
	}
    
}