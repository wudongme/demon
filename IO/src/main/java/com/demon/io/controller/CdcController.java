package com.demon.io.controller;

import com.demon.io.service.cdc.CdcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @desc
 * @fileName CdcController.java
 * @date 2024/2/27 12:46
 * @author Dongmo.Wu
 */
@RestController
@RequestMapping("cdc")
public class CdcController {
	@Autowired
	CdcService cdcService;

	@GetMapping("mysql")
	public Object testMysql() {
		cdcService.test1();
		return "111";
	}

	public static void main(String[] args) {
		int a = 65;
		int b = 28500;
		int c = a * b;
		System.out.println(c);

		double d = c * 0.3;
		System.out.println(d);

	}

}
