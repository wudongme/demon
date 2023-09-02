package com.demon.io.inteceptor;
 import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
 import java.sql.Connection;
import java.util.Properties;
 @Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyInterceptor implements Interceptor {
     @Override
    public Object intercept(Invocation invocation) throws Throwable {
		 Object[] args = invocation.getArgs();
		 // 在这里可以对方法调用进行拦截和处理
        // ...
         // 调用原始方法
        return invocation.proceed();
    }
     @Override
    public Object plugin(Object target) {
        // 使用MyBatis提供的Plugin类包装自定义拦截器
        return Plugin.wrap(target, this);
    }
     @Override
    public void setProperties(Properties properties) {
        // 可以通过properties参数获取配置信息
        // ...
    }
}