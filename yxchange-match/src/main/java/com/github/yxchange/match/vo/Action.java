package com.github.yxchange.match.vo;

import com.github.yxchange.match.entity.Order;

import lombok.Data;

@Data
public class Action {
	
	private Order order;

	private String orderId;
	
	private boolean cancal;
	
	private boolean ask;

	public Action(Order order, String orderId, boolean cancal) {
		super();
		this.order = order;
		this.orderId = orderId;
		this.cancal = cancal;
	}

	public Action(Order order) {
		this(order,null,false);
	}

	public Action(String orderId) {
		this(null,orderId,true);
	}

	public Action(Integer orderId, int category) {
		this.orderId = orderId.toString();
		this.ask = category == 0;
	}
	
	
}
