package com.demon.io.inteceptor;

import org.springframework.core.convert.converter.Converter;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class InterceptorConverter implements Converter<String, Interceptor> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Interceptor convert(String source) {
        // 从ApplicationContext获取拦截器的Bean实例
        return applicationContext.getBean(source, Interceptor.class);
    }
}
