package com.demon.io.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @desc
 * @fileName RedicController.java
 * @date 2022/9/12/0012 17:33
 * @author Dongmo.Wu
 */
@RestController
public class RedicController {
	@RequestMapping(
			value = "/downloadAll", method = {RequestMethod.POST})
	public void downLoadAll(@RequestBody UrlQo urlQo, HttpServletRequest request, HttpServletResponse response) {
		String urlStr = urlQo.getUrl();
		String fileName = urlStr;
		response.addHeader("Content-Disposition",
				"attachment;fileName=" + fileName);// 设置文件名
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			// 测试用的内网资源
			URL url = new URL(urlStr);
			// 连接类的父类，抽象类
			URLConnection urlConnection = url.openConnection();
			// http的连接类
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			// 设定请求的方法，默认是GET
			httpURLConnection.setRequestMethod("GET");
			// 设置字符编码
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			// 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
			httpURLConnection.connect();
			httpURLConnection.setConnectTimeout(100);
			httpURLConnection.setReadTimeout(100);
			// 文件大小
			//              int fileLength = httpURLConnection.getContentLength();

			// 文件名
			//              String filePathUrl = httpURLConnection.getURL().getFile();
			//              String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);

			//              System.out.println("file length---->" + fileLength);
			OutputStream os = response.getOutputStream();
			bis = new BufferedInputStream(httpURLConnection.getInputStream());
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}


		} catch (Exception e) {
			// handle exception
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

@Data
class UrlQo {
	private String url;
}
