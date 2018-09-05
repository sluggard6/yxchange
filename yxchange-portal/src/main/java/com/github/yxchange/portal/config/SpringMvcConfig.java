package com.github.yxchange.portal.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.LabelFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.yxchange.metadata.serialize.SerializeInfo;

@Configuration
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializeFilters(new LabelFilter() {
			
			@Override
			public boolean apply(String label) {
				if(SerializeInfo.LableView.equals(label)) {
					return false;
				}else {
					return true;
				}
			}
		});
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
