package com.demon.io.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @desc
 * @fileName ApiTestController.java
 * @date 2024/1/29 10:24
 * @author Dongmo.Wu
 */
@RestController
public class ApiTestController {
	String ss = "{\n" + "\t\"errno\": \"0\",\n" + "\t\"errmsg\": \"正常\",\n" + "\t\"consume\": \"4\",\n"
			+ "\t\"total\": \"8272\",\n" + "\t\"data\": [\n" + "\t\t{\n" + "\t\t\t\"pid\": \"324771\",\n"
			+ "\t\t\t\"cid\": \"9\",\n" + "\t\t\t\"dl_cnt\": \"0\",\n" + "\t\t\t\"c_t\": \"2019-03-25 18:12:48\",\n"
			+ "\t\t\t\"imgcut\": \"0\",\n" + "\t\t\t\"url\": \"hsdsdsqh.jpg\",\n"
			+ "\t\t\t\"tempdata\": \"\",\n" + "\t\t\t\"fav_total\": \"8965\"\n" + "\t\t}\n" + "\t]\n" + "}";

	@PostMapping("db_api_all_field")
	public Object db_api_all_field(@RequestBody Map<String, Object> map) {
		List<Object> list = (List<Object>) map.get("data");
		if (list != null) {
			System.out.println("接收数组长度：" + list.size());
		}
		System.out.println(map);
		Object parse = JSONObject.parse(ss);
		return parse;
	}

	@GetMapping("oem0510")
	public Object oem0510() {
		Object parse = JSONObject.parse(ss);
		return parse;
	}

	@GetMapping("empty")
	public Object empty() {
		return Collections.emptyList();
	}

	@GetMapping("testapi")
	public Object testapi() {
		String res = "{\"code\":200,\"data\":[{\"id\":\"1\",\"formName\":\"name1\",\"fields\":[{\"fieldName\":\"企业名称1\",\"fieldTitle\":\"input843950\"},{\"fieldName\":\"企业名称2\",\"fieldTitle\":\"input843951\"}],\"datas\":[{\"id\":\"11\",\"reportDept\":\"部门1\",\"reportUser\":\"用户11\",\"reportMobile\":\"123333333\",\"createTime\":\"20240101\",\"content\":{}},{\"id\":\"12\",\"reportDept\":\"部门1\",\"reportUser\":\"用户11\",\"reportMobile\":\"123333333\",\"createTime\":\"20240101\",\"content\":{}}]}],\"errMsg\":\"成功\",\"success\":true}";
		Object parse = JSONObject.parse(res);
		return parse;
	}

	@GetMapping("time_test")
	public Object time_test() {
		String json = "[\n" + "  {\n" + "    \"id\": 11001,\n" + "    \"createUser\": 1,\n"
				+ "    \"createTime\": \"2024-02-22 00:36:55.264\",\n" + "    \"updateUser\": null,\n"
				+ "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n" + "    \"dataVersion\": 1,\n"
				+ "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n" + "    \"deleteTime\": null,\n"
				+ "    \"remark\": null,\n" + "    \"optContext\": null,\n" + "    \"appType\": 1,\n"
				+ "    \"appKey\": \"adqcloud\",\n" + "    \"appName\": \"adqcloud\",\n"
				+ "    \"appFullName\": null,\n" + "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://172.16.1.67:9443/\",\n"
				+ "    \"loginUrl\": \"http://172.16.1.67:9443/back/common/auth/login/cas\",\n"
				+ "    \"mainUrl\": \"http://172.16.1.67:9443\"\n" + "  },\n" + "  {\n" + "    \"id\": 11002,\n"
				+ "    \"createUser\": 1,\n" + "    \"createTime\": \"2024-02-22 13:47:51.966\",\n"
				+ "    \"updateUser\": null,\n" + "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n"
				+ "    \"dataVersion\": 1,\n" + "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n"
				+ "    \"deleteTime\": null,\n" + "    \"remark\": null,\n" + "    \"optContext\": null,\n"
				+ "    \"appType\": 1,\n" + "    \"appKey\": \"AudaqueDQMS\",\n" + "    \"appName\": \"AudaqueDQMS\",\n"
				+ "    \"appFullName\": null,\n" + "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://192.168.10.63:8081/DQMS_test/casLogin/\",\n"
				+ "    \"loginUrl\": \"http://192.168.10.63:8081/DQMS_test/casLogin\",\n"
				+ "    \"mainUrl\": \"http://192.168.10.63:8081/DQMS_test/casLogin\"\n" + "  },\n" + "  {\n"
				+ "    \"id\": 11003,\n" + "    \"createUser\": 1,\n"
				+ "    \"createTime\": \"2024-02-23 11:39:54.724\",\n" + "    \"updateUser\": null,\n"
				+ "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n" + "    \"dataVersion\": 1,\n"
				+ "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n" + "    \"deleteTime\": null,\n"
				+ "    \"remark\": null,\n" + "    \"optContext\": null,\n" + "    \"appType\": 1,\n"
				+ "    \"appKey\": \"AudaqueDSES_chenpy\",\n" + "    \"appName\": \"AudaqueDSES_chenpy\",\n"
				+ "    \"appFullName\": null,\n" + "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://192.168.10.15:8888/casLogin.html/\",\n"
				+ "    \"loginUrl\": \"http://192.168.10.15:8888/casLogin.html\",\n"
				+ "    \"mainUrl\": \"http://192.168.10.15:8888/\"\n" + "  },\n" + "  {\n" + "    \"id\": 11004,\n"
				+ "    \"createUser\": 1,\n" + "    \"createTime\": \"2024-02-23 15:13:02.699\",\n"
				+ "    \"updateUser\": null,\n" + "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n"
				+ "    \"dataVersion\": 1,\n" + "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n"
				+ "    \"deleteTime\": null,\n" + "    \"remark\": null,\n" + "    \"optContext\": null,\n"
				+ "    \"appType\": 1,\n" + "    \"appKey\": \"AudaqueDSES_cx2001\",\n"
				+ "    \"appName\": \"AudaqueDSES_cx2001\",\n" + "    \"appFullName\": null,\n"
				+ "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://192.168.10.31:8888/casLogin.html/\",\n"
				+ "    \"loginUrl\": \"http://192.168.10.31:8888/casLogin.html\",\n"
				+ "    \"mainUrl\": \"http://192.168.10.31:8888/\"\n" + "  },\n" + "  {\n" + "    \"id\": 11005,\n"
				+ "    \"createUser\": 11004,\n" + "    \"createTime\": \"2024-02-26 09:41:52.633\",\n"
				+ "    \"updateUser\": null,\n" + "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n"
				+ "    \"dataVersion\": 1,\n" + "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n"
				+ "    \"deleteTime\": null,\n" + "    \"remark\": null,\n" + "    \"optContext\": null,\n"
				+ "    \"appType\": 1,\n" + "    \"appKey\": \"AudaqueDQMS_hxf\",\n"
				+ "    \"appName\": \"AudaqueDQMS_hxf\",\n" + "    \"appFullName\": null,\n"
				+ "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://192.168.10.62:8401/DQMS_test/casLogin/\",\n"
				+ "    \"loginUrl\": \"http://192.168.10.62:8401/DQMS_test/casLogin\",\n"
				+ "    \"mainUrl\": \"http://192.168.10.62:8401/DQMS_test/casLogin\"\n" + "  },\n" + "  {\n"
				+ "    \"id\": 11006,\n" + "    \"createUser\": 1,\n"
				+ "    \"createTime\": \"2024-02-26 11:10:12.128\",\n" + "    \"updateUser\": null,\n"
				+ "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n" + "    \"dataVersion\": 1,\n"
				+ "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n" + "    \"deleteTime\": null,\n"
				+ "    \"remark\": null,\n" + "    \"optContext\": null,\n" + "    \"appType\": 1,\n"
				+ "    \"appKey\": \"AudaqueDQMS_shf\",\n" + "    \"appName\": \"AudaqueDQMS_shf\",\n"
				+ "    \"appFullName\": null,\n" + "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://192.168.10.100:9527/audaque-web-dqms/casLogin/\",\n"
				+ "    \"loginUrl\": \"http://192.168.10.100:9527/audaque-web-dqms/casLogin\",\n"
				+ "    \"mainUrl\": \"http://192.168.10.100:9527/audaque-web-dqms/casLogin\"\n" + "  },\n" + "  {\n"
				+ "    \"id\": 11007,\n" + "    \"createUser\": 11007,\n"
				+ "    \"createTime\": \"2024-02-26 14:30:35.947\",\n" + "    \"updateUser\": null,\n"
				+ "    \"updateTime\": null,\n" + "    \"tenantId\": null,\n" + "    \"dataVersion\": 1,\n"
				+ "    \"dataState\": \"1\",\n" + "    \"deleteUser\": null,\n" + "    \"deleteTime\": null,\n"
				+ "    \"remark\": null,\n" + "    \"optContext\": null,\n" + "    \"appType\": 1,\n"
				+ "    \"appKey\": \"AudaqueGDRS_2001_ll\",\n" + "    \"appName\": \"AudaqueGDRS_2001_ll\",\n"
				+ "    \"appFullName\": null,\n" + "    \"smallIcon\": null,\n" + "    \"largeIcon\": null,\n"
				+ "    \"contextUrl\": \"http://10.0.10.24:2001/gdrs\",\n"
				+ "    \"loginUrl\": \"http://10.0.10.24:2001/gdrs/casLogin\",\n"
				+ "    \"mainUrl\": \"http://10.0.10.24:2001/gdrs\"\n" + "  }\n" + "]";
		return JSONObject.parse(json);
	}

	@GetMapping("xingguo")
	public Object xingguo() {
		String res = "{\n" + "    \"code\": 0,\n" + "    \"data\": [\n" + "        {\n" + "            \"id\": 105,\n"
				+ "            \"formName\": \"企业备案情况\",\n" + "            \"fields\": [\n" + "                {\n"
				+ "                    \"fieldTitle\": \"企业名称\",\n"
				+ "                    \"fieldName\": \"input63356\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"注册号\",\n"
				+ "                    \"fieldName\": \"input71249\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"统一社会信用代码\",\n"
				+ "                    \"fieldName\": \"input53009\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"住所\",\n"
				+ "                    \"fieldName\": \"input68216\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"备案事项\",\n"
				+ "                    \"fieldName\": \"input43416\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"备案前内容\",\n"
				+ "                    \"fieldName\": \"input78017\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"备案后内容\",\n"
				+ "                    \"fieldName\": \"input105652\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"登记机关\",\n"
				+ "                    \"fieldName\": \"input121800\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"企业类型\",\n"
				+ "                    \"fieldName\": \"input96880\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"企业状态\",\n"
				+ "                    \"fieldName\": \"input114380\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"备案日期\",\n"
				+ "                    \"fieldName\": \"input59619\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"成立日期\",\n"
				+ "                    \"fieldName\": \"input68411\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"无效列\",\n"
				+ "                    \"fieldName\": \"input44345\"\n" + "                }\n" + "            ],\n"
				+ "            \"datas\": []\n" + "        },\n" + "        {\n" + "            \"id\": 106,\n"
				+ "            \"formName\": \"企业变更情况查询\",\n" + "            \"fields\": [\n" + "                {\n"
				+ "                    \"fieldTitle\": \"企业名称\",\n"
				+ "                    \"fieldName\": \"input44597\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"注册号\",\n"
				+ "                    \"fieldName\": \"input92713\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"统一社会信用代码\",\n"
				+ "                    \"fieldName\": \"input31966\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"法定代表人\",\n"
				+ "                    \"fieldName\": \"input89551\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"行业代码\",\n"
				+ "                    \"fieldName\": \"input32934\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"行业门类\",\n"
				+ "                    \"fieldName\": \"input43588\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"住所\",\n"
				+ "                    \"fieldName\": \"input103068\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"变更事项\",\n"
				+ "                    \"fieldName\": \"input101001\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"变更前内容\",\n"
				+ "                    \"fieldName\": \"input67141\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"变更后内容\",\n"
				+ "                    \"fieldName\": \"input95800\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"登记机关\",\n"
				+ "                    \"fieldName\": \"input98059\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"管辖机关\",\n"
				+ "                    \"fieldName\": \"input90979\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"企业类型\",\n"
				+ "                    \"fieldName\": \"input92666\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"变更时间\",\n"
				+ "                    \"fieldName\": \"input79001\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"企业状态\",\n"
				+ "                    \"fieldName\": \"input41155\"\n" + "                },\n" + "                {\n"
				+ "                    \"fieldTitle\": \"成立日期\",\n"
				+ "                    \"fieldName\": \"input100493\"\n" + "                },\n"
				+ "                {\n" + "                    \"fieldTitle\": \"无效列\",\n"
				+ "                    \"fieldName\": \"input63967\"\n" + "                }\n" + "            ],\n"
				+ "            \"datas\": []\n" + "        }\n" + "    ],\n" + "    \"msg\": \"成功\",\n"
				+ "    \"success\": true\n" + "}";
		Object parse = JSONObject.parse(res);
		return parse;
	}

}
