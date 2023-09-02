/*
package com.demon.io.inteceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class MyCustomConverters {
	@Bean
	public DefaultConversionService conversionService() {
		return new DefaultConversionService();
	}

	@Autowired
	public MyCustomConverters(DefaultConversionService conversionService, InterceptorConverter interceptorConverter) {
	   // 注册自定义的转换器
	   conversionService.addConverter(interceptorConverter);
   }
}*/
