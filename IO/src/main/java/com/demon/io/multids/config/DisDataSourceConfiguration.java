//package com.demon.io.multids.config;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.ibatis.mapping.DatabaseIdProvider;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.scripting.LanguageDriver;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.TypeHandler;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
//import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
//import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.springframework.beans.BeanWrapperImpl;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
//import javax.sql.DataSource;
//import java.beans.PropertyDescriptor;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @see com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure
// * @see org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
// * @see MybatisAutoConfiguration
// *  平台4.1.2.0的方言处理有问题，暂时自己处理，如果下次平台改了，这个可以删除
// *
// */
//@org.springframework.context.annotation.Configuration
//@EnableConfigurationProperties({MybatisProperties.class})
//@AutoConfigureBefore({MybatisAutoConfiguration.class})
//public class DisDataSourceConfiguration {
//
//	@Value("${spring.transaction.aop-pointcut-expression:execution(* com.audaque.cloud..*.service.*.*(..))}")
//	private String aopPointcutExpression = "execution(* com.demon..*.service.*.*(..))";
//	@Value("${spring.datasource.db-type-name:#{null}}")
//	private String dbTypeName;
//	@Value("${spring.datasource.reuse-db-type-name:#{null}}")
//	private String reuseDbTypeName;
//
//	private final DataSourceProperties dataSourceProperties;
//
//	private final MybatisProperties properties;
//
//	private final Interceptor[] interceptors;
//
//	@SuppressWarnings("rawtypes")
//	private final TypeHandler[] typeHandlers;
//
//	private final LanguageDriver[] languageDrivers;
//
//	private final ResourceLoader resourceLoader;
//
//	private final DatabaseIdProvider databaseIdProvider;
//
//	private final List<ConfigurationCustomizer> configurationCustomizers;
//
//	@SuppressWarnings("rawtypes")
//	public DisDataSourceConfiguration(DataSourceProperties dataSourceProperties, MybatisProperties properties,
//			ObjectProvider<Interceptor[]> interceptorsProvider, ObjectProvider<TypeHandler[]> typeHandlersProvider,
//			ObjectProvider<LanguageDriver[]> languageDriversProvider, ResourceLoader resourceLoader,
//			ObjectProvider<DatabaseIdProvider> databaseIdProvider,
//			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
//		this.dataSourceProperties = dataSourceProperties;
//		this.properties = properties;
//		this.interceptors = interceptorsProvider.getIfAvailable();
//		this.typeHandlers = typeHandlersProvider.getIfAvailable();
//		this.languageDrivers = languageDriversProvider.getIfAvailable();
//		this.resourceLoader = resourceLoader;
//		this.databaseIdProvider = databaseIdProvider.getIfAvailable();
//		this.configurationCustomizers = configurationCustomizersProvider.getIfAvailable();
//
//		// 设置默认值
//		if (properties.getMapperLocations() == null || properties.getMapperLocations().length == 0) {
//			properties.setMapperLocations(new String[]{"classpath*:com/demon/**/mapper/*.xml"});
//		}
//		/*if (!StringUtils.hasText(properties.getTypeHandlersPackage())) {
//			properties.setTypeHandlersPackage("com.audaque.cloud.common.persistence.mybatis.handler");
//		}*/
//	}
//
//	@Bean
//	@Primary
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource/*,
//			@Qualifier("defaultDisDialect") SQLDialect defaultDapDialect*/) throws Exception {
//
//		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//		factory.setDataSource(dataSource);
//		factory.setVfs(SpringBootVFS.class);
//		if (StringUtils.hasText(this.properties.getConfigLocation())) {
//			factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
//		}
//		applyConfiguration(factory);
//		if (this.properties.getConfigurationProperties() != null) {
//			factory.setConfigurationProperties(this.properties.getConfigurationProperties());
//		}
//
//		// 增加内置的分页拦截器
//		/*String[] defaultDbType = SQLDialectFactory.getDbTypeNames(dataSourceProperties.getUrl(), dbTypeName,
//				reuseDbTypeName, "spring.datasource");
//		PaginationInterceptor pageInt = new PaginationInterceptor(defaultDapDialect);*/
//
//		/*if (!ObjectUtils.isEmpty(this.interceptors)) {
//			factory.setPlugins(ArrayUtils.add(this.interceptors, pageInt));
//		} else {
//			factory.setPlugins(new Interceptor[]{pageInt});
//		}*/
//		if (this.databaseIdProvider != null) {
//			factory.setDatabaseIdProvider(this.databaseIdProvider);
//		}
//		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
//			factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//		}
//		if (this.properties.getTypeAliasesSuperType() != null) {
//			factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
//		}
//		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//			factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//		}
//		if (!ObjectUtils.isEmpty(this.typeHandlers)) {
//			factory.setTypeHandlers(this.typeHandlers);
//		}
//
//		// 处理Mapper方言
//		/*MapperDialectHandler handler = new MapperDialectHandler(defaultDbType);
//		factory.setMapperLocations(handler.resolveMapperLocations(this.properties.getMapperLocations()));*/
//
//		Set<String> factoryPropertyNames = Stream.of(
//						new BeanWrapperImpl(SqlSessionFactoryBean.class).getPropertyDescriptors())
//				.map(PropertyDescriptor::getName).collect(Collectors.toSet());
//		Class<? extends LanguageDriver> defaultLanguageDriver = this.properties.getDefaultScriptingLanguageDriver();
//		if (factoryPropertyNames.contains("scriptingLanguageDrivers") && !ObjectUtils.isEmpty(this.languageDrivers)) {
//			// Need to mybatis-spring 2.0.2+
//			factory.setScriptingLanguageDrivers(this.languageDrivers);
//			if (defaultLanguageDriver == null && this.languageDrivers.length == 1) {
//				defaultLanguageDriver = this.languageDrivers[0].getClass();
//			}
//		}
//		if (factoryPropertyNames.contains("defaultScriptingLanguageDriver")) {
//			// Need to mybatis-spring 2.0.2+
//			factory.setDefaultScriptingLanguageDriver(defaultLanguageDriver);
//		}
//
//		return factory.getObject();
//	}
//
//	private void applyConfiguration(SqlSessionFactoryBean factory) {
//		Configuration configuration = this.properties.getConfiguration();
//		if (configuration == null && !StringUtils.hasText(this.properties.getConfigLocation())) {
//			configuration = new Configuration();
//		}
//		if (configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers)) {
//			for (ConfigurationCustomizer customizer : this.configurationCustomizers) {
//				customizer.customize(configuration);
//			}
//		}
//		factory.setConfiguration(configuration);
//	}
//
//}