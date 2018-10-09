package com.github.yxchange.match.event.impl;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.github.yxchange.match.entity.Trade;
import com.github.yxchange.match.event.EngineEvent;
import com.github.yxchange.match.event.EventService;
import com.github.yxchange.match.event.OrderEvent;
import com.github.yxchange.match.event.TradeEvent;
import com.github.yxchange.service.MatchCallbackService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventServiceImpl extends AbstractEventService implements EventService{
	
//	@Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
	
//	@Value("${engine.kafka.topic}")
//	private String topic;
	
//	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Reference(check=false)
	private MatchCallbackService matchCallbackService;
	

	@Override
	@Async
	public void publishEvent(EngineEvent event) {
		log.info(event.toString());
		if(event instanceof OrderEvent) {
			deployOrderEvent((OrderEvent) event);
		}else if(event instanceof TradeEvent) {
			deployTradeEvent((TradeEvent) event);
		}
	}

	@Override
	@Async
	public void deployOrderEvent(OrderEvent event) {
//		try {
//			kafkaTemplate.send(topic, objectMapper.writeValueAsString(event));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		matchCallbackService.
	}

	@Override
	@Async
	public void deployTradeEvent(TradeEvent event) {
//		try {
//			kafkaTemplate.send(topic, objectMapper.writeValueAsString(event));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		Trade trade = event.getTrade();
		com.github.yxchange.metadata.entity.Trade localTrade = new com.github.yxchange.metadata.entity.Trade(Integer.valueOf(trade.getId()), trade.getId(), Integer.valueOf(trade.getBidOrderId()), Integer.valueOf(trade.getAskOrderId()),Integer.valueOf(trade.getTakerOrderId()), Integer.valueOf(trade.getMakerOrderId()), trade.getPrice(), trade.getAmount());
		matchCallbackService.TradeCallBack(localTrade);
	}

}
