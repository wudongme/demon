package com.demon.io.http.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static void main(String[] args) {
        //String input = "Hello, MD5!";
		String appkey = "dcf5a8177275a69e";
		String appsecret = "262110c5ea524465504908a0c79d14aa";
		String requestTime = "20240229150000";
		String input = appkey + requestTime + appsecret;

		try {
            // 获取 MD5 摘要算法的 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将输入字符串转换为字节数组
            byte[] inputBytes = input.getBytes();

            // 计算 MD5 散列值
            byte[] md5Bytes = md.digest(inputBytes);

            // 将字节数组转换为十六进制字符串表示
            StringBuilder sb = new StringBuilder();
            for (byte b : md5Bytes) {
                sb.append(String.format("%02x", b));
            }

            String md5Result = sb.toString();

            System.out.println("Original: " + input);
            System.out.println("MD5 Hash: " + md5Result);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
