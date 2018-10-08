package com.github.yxchange.match;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@DubboComponentScan(basePackages = "com.github.yxchange.match")
public class MatchApplication {
	
	public static void main(String... args) {
		ConfigurableApplicationContext cac = SpringApplication.run(MatchApplication.class, args);
		cac.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {

			@Override
			public void onApplicationEvent(ContextClosedEvent event) {
				log.info("Context is closed.");
			}
			
		});
	}

}
