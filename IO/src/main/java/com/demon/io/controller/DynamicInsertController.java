package com.demon.io.controller;

import com.demon.io.model.PrepareInsertModel;
import com.demon.io.service.DynamicInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @desc
 * @fileName DynamicInsertController.java
 * @date 2023/9/1/0001 23:08
 * @author Dongmo.Wu
 */
@RestController
public class DynamicInsertController {
	@Autowired
	private DynamicInsertService dynamicInsertService;

	@GetMapping("dynamicInsert")
	public void dynamicInsert() {
		PrepareInsertModel prepareInsertModel = new PrepareInsertModel();
		prepareInsertModel.setTableName("dynamic_insert_1");
		prepareInsertModel.setInsertColSql("id,name,update_time");
		List<List<Object>> list = new ArrayList<>();
		prepareInsertModel.setValuesList(list);

		List<Object> values = new ArrayList<>();
		list.add(values);

		values.add("1");
		values.add("name1");
		values.add(new Date());


		dynamicInsertService.dynamicInsert(prepareInsertModel);
	}

	private PrepareInsertModel getPrepareInsertModel() {
		PrepareInsertModel prepareInsertModel = new PrepareInsertModel();
		prepareInsertModel.setTableName("dynamic_insert");
		prepareInsertModel.setInsertColSql("id,name,update_time");
		List<List<Object>> list = new ArrayList<>();
		prepareInsertModel.setValuesList(list);

		List<Object> values = new ArrayList<>();
		list.add(values);

		values.add("1");
		values.add("name1");
		values.add(new Date());
		return prepareInsertModel;
	}
}
