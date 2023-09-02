/*
package com.demon.io.inteceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterceptorConverterBito implements Converter<String, Interceptor> {
	@Override
   public Interceptor convert(String source) {
	   // 在这里根据source的值创建并返回对应的Interceptor实例
	   // 例如，可以使用反射来实例化Interceptor
	   // 注意：这里的示例仅供参考，具体实现根据自己的需求进行调整
	   try {
		   Class<?> interceptorClass = Class.forName(source);
		   return (Interceptor) interceptorClass.getDeclaredConstructor().newInstance();
	   } catch (Exception e) {
		   throw new IllegalArgumentException("Failed to convert String to Interceptor", e);
	   }
   }
}
*/
