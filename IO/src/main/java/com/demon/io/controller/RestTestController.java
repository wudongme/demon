package com.demon.io.controller;

import com.demon.io.mapper.TestMapper;
import com.demon.io.model.TestBean;
import com.demon.io.service.GaussService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @desc
 * @fileName RestTestController.java
 * @date 2022/9/12/0012 16:44
 * @author Dongmo.Wu
 */
@RestController
@Slf4j
public class RestTestController {
	@Autowired
	private TestBean testBean;
	@Resource
	private TestMapper testMapper;

	@GetMapping("/test1")
	//@ResponseBody
	public String test1() {
		List<Map<String, Object>> maps = testMapper.test1();
		System.out.println("testBean :" + testBean);
		return "11";
		//return new TestDo("11");
	}

	@GetMapping(value = "/endpoint", produces = MediaType.TEXT_PLAIN_VALUE)
	public void exampleEndpoint(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType(MediaType.TEXT_PLAIN_VALUE);

		String content = "你好，世界！"; // 这是GBK编码的字符串
		response.getWriter().write(content);
	}

	@GetMapping("/disTask/page")
	//@ResponseBody
	public Map<String, Object> test_api() {
		List<Map<String, Object>> maps = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("tota喝了吗l", "你好阿斯蒂芬卡士都分就开了");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("id", 1);
		map2.put("remark", "1");
		map2.put("createUser", "1");
		map1.put("datas", map2);


		return map1;
	}

	@Autowired
	GaussService gaussService;
	@GetMapping("copy/{suffix}")
	public void insertToGauss(@PathVariable int suffix) {
		gaussService.insertBigDataToGauss(suffix);
	}

	@GetMapping("generate/{suffix}")
	public void generate(@PathVariable int suffix) {
		//gaussService.generateFile(suffix);
	}

	@GetMapping("insertGeneralMap")
	public void insertGeneralMap() {
		List<String> colList = Arrays.asList("log_id", "task");
		List<Map<String, Object>> mapList =  new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("task", "1");
		map.put("log_id", 2);
		map.put("update_time", new Date(System.currentTimeMillis()));
		map.put("task_type", "3");
		mapList.add(map);

		String colStr = map.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.joining(","));
		testMapper.insertGeneralMap("test_map_mybatis", colStr, colList, mapList);
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
