package com.demon.io.controller;

import com.demon.io.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @desc
 * @fileName MysqlFunctionTestController.java
 * @date 2024/4/30 17:22
 * @author Dongmo.Wu
 */
@RestController
@RequestMapping("mysql_function")
public class MysqlFunctionTestController {
	@Autowired
	MysqlService mysqlService;

	@GetMapping("concatTest")
	public void concatTest() {
		mysqlService.concatTest("test_str");
	}
}
