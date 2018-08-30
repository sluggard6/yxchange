package com.github.yxchange.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextClosedEvent;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
@ComponentScan("com.github.yxchange")
@MapperScan("com.github.yxchange.metadata.mapper")
public class YxchangeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(YxchangeApplication.class, args);
		cac.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {

			@Override
			public void onApplicationEvent(ContextClosedEvent event) {
				log.info("Context is closed.");
			}
			
		});
	}

}
