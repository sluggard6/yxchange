package com.github.yxchange.match.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Token {
	
	private final String Name;
	
	private BigDecimal value;

}
