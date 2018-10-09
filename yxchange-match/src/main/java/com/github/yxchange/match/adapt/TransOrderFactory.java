package com.github.yxchange.match.adapt;

import org.springframework.stereotype.Component;

import com.github.yxchange.match.entity.AskOrder;
import com.github.yxchange.match.entity.BidOrder;
import com.github.yxchange.match.entity.Order;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.metadata.entity.TransOrder.Category;

@Component
public class TransOrderFactory implements OrderFactory<TransOrder> {

	@Override
	public Order getOrder(TransOrder transOrder) {
		if(transOrder == null) throw new NullPointerException();
		Order order;
		if(Category.ASK.ordinal() == transOrder.getCategory()) {
			order = new AskOrder(transOrder.getId().toString());
		}else if(Category.BID.ordinal() == transOrder.getCategory()) {
			order = new BidOrder(transOrder.getId().toString());
		}else {
			throw new IllegalArgumentException("unknow category : " + transOrder.getCategory());
		}
		order.setAmount(transOrder.getAmount());
		order.setPrice(transOrder.getPrice());
		order.setUserId(Long.valueOf(transOrder.getAccountId()));
		return order;
	}

}
