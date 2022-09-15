package com.demon.design.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @desc
 * @fileName RestTestController.java
 * @date 2022/9/12/0012 16:44
 * @author Dongmo.Wu
 */
@RestController
public class RestTestController {
	@GetMapping("test1")
	public Object test1() {
		return new TestDo("11");
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class TestDo {
		private String name;
	}
}
