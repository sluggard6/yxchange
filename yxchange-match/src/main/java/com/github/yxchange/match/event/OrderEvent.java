package com.github.yxchange.match.event;

import com.github.yxchange.match.entity.Order;

import lombok.ToString;

@ToString
public class OrderEvent implements EngineEvent {
	
	private final Order order;
	
	public OrderEvent(Order order) {
		super();
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}
	
}
