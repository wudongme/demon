package com.demon.io.controller;

import com.demon.io.model.RequestParam;
import com.demon.io.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @desc
 * @fileName MysqlController.java
 * @date 2023/8/22/0022 14:56
 * @author Dongmo.Wu
 */
@RestController
@RequestMapping("mysql")
public class MysqlController {
	@Autowired
	MysqlService mysqlService;
	@PostMapping("/first")
	public void writeToMysql(@RequestBody RequestParam requestParam) {
		new Thread(() -> mysqlService.insertToTable100Columns(requestParam)).start();
	}

}
