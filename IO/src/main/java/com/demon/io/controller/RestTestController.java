package com.demon.io.controller;

import com.demon.io.model.TestBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@Autowired
	private TestBean testBean;

	@GetMapping("/test1")
	//@ResponseBody
	public String test1() {
		System.out.println("testBean :" + testBean);
		return "11";
		//return new TestDo("11");
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class TestDo {
		private String name;
	}

	public static void main(String[] args) {
		int i = 1;
		switch (i) {
			case 1 :
				System.out.println(i);
				break;
			case 2 :
				System.out.println(i);
				break;
		}
	}
}
