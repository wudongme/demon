package com.demon.io.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.audaque.cloud.common.utils.SecureRandomUtils;
import com.audaque.cloud.common.utils.sign.SecurityReq;
import com.audaque.cloud.common.utils.sign.SecurityResp;
import com.audaque.cloud.common.utils.sign.SecuritySignReq;
import com.audaque.cloud.common.utils.sign.SecuritySignResp;
import com.audaque.cloud.common.utils.sign.SecurityTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jcajce.provider.digest.MD5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

/**
 *
 * @desc
 * @fileName ApacheHttpTest.java
 * @date 2023/11/18 9:55
 * @author Dongmo.Wu
 */
public class ApacheHttpTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//		1.创建CloseableHttpClient
		//		2.创建httpPost：
		//		设置url，entity，config，header
		String priKey = KeyUtil.getPriKey();
		String nonce = SecureRandomUtils.getInstance().nextInt() + "";
		// E:\dis\2023-11\test1.json
		String body = null;
		ObjectMapper mapper = new ObjectMapper();

		/*LinkedHashMap<String,Object> dataMap = mapper.readValue(new File("E:\\dis\\2023-11\\100051TO100053.json"),
				LinkedHashMap.class);*/
		LinkedHashMap<String,Object> dataMap = null;

		try {
			body = mapper.writeValueAsString(dataMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		// 文件
		System.out.println("打印转化后的字符串");
		System.out.println(body.hashCode());
		System.out.println(body);


		JSONObject msg = new JSONObject();
		long l1 = System.currentTimeMillis();
		String time = String.valueOf(l1 / 1000);
		l1 = Long.parseLong(time);
		msg.put("X-TIMESTAMP", l1);
		msg.put("X-NONCE", nonce);
		msg.put("X-DATA", body);

		// 生成签名请求对象
		SecuritySignReq signReq = new SecuritySignReq();
		// data为要加密的报文字符串
		signReq.setData(JSON.toJSONString(msg));
		// 为rsa私钥
		signReq.setPrikey(priKey);

		SecuritySignResp sign = SecurityTools.sign(signReq);
		String signData = sign.getSignData();
		if (StringUtils.isBlank(signData)) {
			throw new RuntimeException("Signing failed!");
		}

		testDecode(l1, nonce, body, signData);

		System.out.println("hashcode=" + body.hashCode());


//		String url = "http://127.0.0.1:32127/datax/external/build/callbackId";
		String url = "http://127.0.0.1:32127/datax/external/execute";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("X-TIMESTAMP", time);
		httpPost.setHeader("X-SIGN", signData);
		httpPost.setHeader("X-NONCE", nonce);
		httpPost.setHeader("adq-tenant-id", "0");
		httpPost.setHeader("Content-Type", "application/json;charset=utf8");

		httpPost.setEntity(new StringEntity(body));
		//		3.创建CloseableHttpResponse
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			response = httpClient.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			System.out.println("code=" + response.getStatusLine());

			if (responseEntity != null) {
				System.out.println("内容=" + EntityUtils.toString(responseEntity));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(httpClient);
			IOUtils.closeQuietly(response);
		}

	}

	public static void testDecode(long requestTime, String nonce, String bodyStr, String paramSign) {
		System.out.println(bodyStr.hashCode());
		JSONObject msg = new JSONObject();
		msg.put("X-TIMESTAMP", requestTime);
		msg.put("X-NONCE", nonce);
		if (StringUtils.isNotBlank(bodyStr)) {
			msg.put("X-DATA", bodyStr);
		}
		System.out.println("hashcode=" + bodyStr.hashCode());


		String pubKey = KeyUtil.getPublicKey();
		// 验签解密部分
		SecurityReq req = new SecurityReq();
		//对方传过来的数据一一对应
		// todo 调用对象修改
		String reqData = JSONObject.toJSONString(msg);
		System.out.println("reqData=" + reqData);
		System.out.println("reqData.hashcode=" + reqData.hashCode());
		req.setData(reqData);
		System.out.println("req.getData() = " + req.getData());
		req.setSignData(paramSign);
		req.setPubKey(pubKey);
		SecurityResp valid = SecurityTools.valid(req);
		if (!valid.getSuccess()) {
			System.out.println("[SignatureAspect] ######################  Signature verification failed! paramSign:" +paramSign+ ", sign:" + req.getData());
			throw new RuntimeException("验签失败");
		}
	}

}
