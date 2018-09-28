package com.github.yxchange.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.metadata.entity.TransOrder;

@RestController
@RequestMapping("order")
public class TransOrderController {
	
//	@Autowired
//	private Tran
	
	public HttpResult<TransOrder> order(@RequestBody TransOrder transOrder) {
		return null;
	}

}
