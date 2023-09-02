package com.demon.io.aa;

import java.sql.*;

public class SQLServerConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://192.168.10.62:1433;databaseName=debeziumtest;integratedSecurity=false;trustServerCertificate=true";
        String username = "sa";
        String password = "qwe20211114.";

        try {
            // 加载 SQL Server 驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 建立连接
            Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("schema=" + conn.getSchema() != null ? conn.getSchema() : conn.getCatalog());
			PreparedStatement preparedStatement = conn.prepareStatement("select * from area");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("area_code=" + resultSet.getString("area_code"));
			}

			if (conn != null) {
                System.out.println("成功连接到 SQL Server 数据库！");
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到 SQL Server 驱动程序！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接 SQL Server 数据库时发生错误！");
            e.printStackTrace();
        }
    }
}
