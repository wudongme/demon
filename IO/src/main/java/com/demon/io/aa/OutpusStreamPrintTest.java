package com.demon.io.aa;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @desc
 * @fileName OutpusStreamPrintTest.java
 * @date 2023/9/24 10:19
 * @author Dongmo.Wu
 */
public class OutpusStreamPrintTest {
	public static void main(String[] args) {
		PrintWriter out = null;/*new PrintWriter(new OutputStreamWriter(chanel.getOutputStream(), StandardCharsets.UTF_8));*/
		String example = "hello world" + System.lineSeparator() + "hello dm";
		out.println(example);
		out.close();
	}
}
