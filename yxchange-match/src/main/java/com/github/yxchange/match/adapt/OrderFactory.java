package com.github.yxchange.match.adapt;

import com.github.yxchange.match.entity.Order;

public interface OrderFactory<T> {
	
	Order getOrder(T t);

}
