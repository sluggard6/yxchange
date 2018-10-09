package com.github.yxchange.match.vo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.github.yxchange.match.entity.Order;

import lombok.Getter;
import lombok.Setter;

public class Action {
	
	@Getter
	@Setter
	private Order order;

	@Getter
	@Setter
	private String orderId;

	@Getter
	@Setter
	private boolean cancal;

	@Getter
	@Setter
	private boolean ask;
	
	private ActionFuture future;

	@Deprecated
	public Action(Order order, String orderId, boolean cancal) {
		super();
		this.order = order;
		this.orderId = orderId;
		this.cancal = cancal;
	}

	public Action(Order order, String orderId, boolean cancal, boolean ask) {
		super();
		this.order = order;
		this.orderId = orderId;
		this.cancal = cancal;
		this.ask = ask;
		if(cancal) {
			future = new ActionFuture();
		}
	}

	public Action(Order order) {
		this(order,null,false, order.isAsk());
	}

	public Action(String orderId) {
		this(null,orderId,true);
	}

	public Action(Integer orderId, int category) {
//		this.orderId = orderId.toString();
//		this.cancal = true;
//		this.ask = category == 0;
		this(null,orderId.toString(),true, category == 0);
	}
	
	public Future<Boolean> getFuture() {
		return future;
	}
	
	public void setFutureResult(boolean result) {
		future.success = result;
		future.done = true;
	}
	
	private class ActionFuture implements Future<Boolean> {

		boolean success;
		
		boolean done;
		
		@Override
		public boolean isDone() {
			return done;
		}
		
		@Override
		public boolean isCancelled() {
			return false;
		}
		
		@Override
		public Boolean get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Boolean get() throws InterruptedException, ExecutionException {
			return success;
		}
		
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
