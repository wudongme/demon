package com.demon.io.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxSpeedExtractor {
    public static void main(String[] args) {
		int length = args.length;
		System.out.println(length);
		if (length != 1) {
			System.out.println("参数有误");
			return;
		}
		if (length == 1) {
			System.out.println(args[0]);
		}
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);

		String filePath = "C:\\Users\\HP\\Desktop\\aa.log"; // 替换为实际的文件路径
        double maxSpeed = 0;
        Pattern pattern = Pattern.compile("Speed ([\\d.]+)([A-Za-z]+)/s");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    double value = Double.parseDouble(matcher.group(1));
                    String unit = matcher.group(2);
                    double speed = convertToBytes(value, unit);
                    maxSpeed = Math.max(maxSpeed, speed);
                }
            }

            displayMaxSpeed(maxSpeed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double convertToBytes(double value, String unit) {
        switch (unit) {
            case "B":
                return value;
            case "KB":
                return value * 1024;
            case "MB":
                return value * 1024 * 1024;
            default:
                return 0;
        }
    }

    private static void displayMaxSpeed(double maxSpeed) {
        if (maxSpeed >= 1024 * 1024) {
            System.out.printf("The maximum speed is: %.2f MB/s\n", maxSpeed / (1024 * 1024));
        } else if (maxSpeed >= 1024) {
            System.out.printf("The maximum speed is: %.2f KB/s\n", maxSpeed / 1024);
        } else {
            System.out.printf("The maximum speed is: %.2f B/s\n", maxSpeed);
        }
    }
}
