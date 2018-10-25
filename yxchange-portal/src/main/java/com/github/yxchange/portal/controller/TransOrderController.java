package com.github.yxchange.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.exception.OrderNotFoundException;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.portal.exception.ResourceNotFoundException;
import com.github.yxchange.service.TransOrderService;

@RestController
@RequestMapping("order")
public class TransOrderController {
	
	@Autowired
	private TransOrderService transOrderService;
	
	@RequestMapping(value="takeOrder", method=RequestMethod.POST)
	public HttpResult<TransOrder> takeOrder(@RequestBody TransOrder transOrder) {
//		transOrderService.
		return null;
	}
	
	@RequestMapping(value="cancelOrder", method=RequestMethod.POST)
	public HttpResult<TransOrder> cancalOrder(Integer orderId) {
		try {
			TransOrder transOrder = transOrderService.cancelOrder(orderId);
			return HttpResult.SUCCESS(transOrder);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("order not found", e);
		}
	}
	
	

}
