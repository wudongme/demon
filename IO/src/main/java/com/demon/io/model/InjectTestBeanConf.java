package com.demon.io.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @desc
 * @fileName InjectTestBeanConf.java
 * @date 2022/9/15/0015 17:17
 * @author Dongmo.Wu
 */
@Configuration
public class InjectTestBeanConf {

	@Bean
	TestBean testBean() {
		TestBean testBean = new TestBean();
		testBean.setName("xiaoming");
		testBean.setIsFemale(Boolean.TRUE);
		return testBean;
	}
}
