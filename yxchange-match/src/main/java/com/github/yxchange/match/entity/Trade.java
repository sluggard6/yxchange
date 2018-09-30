package com.github.yxchange.match.entity;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Trade{
	
	private final String id = UUID.randomUUID().toString().replaceAll("-", "");
	
	private final String bidOrderId;
	
	private final String askOrderId;
	
	private final BigDecimal price;
	
	private final BigDecimal amount;
	
	private final String takerOrderId;
	
	private final String makerOrderId;
	
	private final long timestamp = System.currentTimeMillis();

	public Trade(String bidOrderId, String askOrderId, BigDecimal price, BigDecimal amount, String makerOrderId, String takerOrderId) {
		super();
		this.bidOrderId = bidOrderId;
		this.askOrderId = askOrderId;
		this.price = price;
		this.amount = amount;
		this.makerOrderId = makerOrderId;
		this.takerOrderId = takerOrderId;
	}

}
