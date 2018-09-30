package com.github.yxchange.match.event;

import com.github.yxchange.match.entity.Trade;

import lombok.Data;

@Data
public class TradeEvent implements EngineEvent{
	
	private final Trade trade;

	public TradeEvent(Trade trade) {
		super();
		this.trade = trade;
	}

}
