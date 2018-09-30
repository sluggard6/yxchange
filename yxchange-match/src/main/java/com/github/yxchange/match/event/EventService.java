package com.github.yxchange.match.event;

import java.util.Set;

public interface EventService {

	void addListener(EngineListener<? extends EngineEvent> listener);
	
	void removeListener(EngineListener<? extends EngineEvent> listener);
	
	int countLinsteners();
	
	Set<EngineListener<? extends EngineEvent>> getLinsteners();

	void publishEvent(EngineEvent event);
	
	void deployOrderEvent(OrderEvent event);
	
	void deployTradeEvent(TradeEvent event);


}
