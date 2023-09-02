package com.demon.io.utils;

import com.huawei.gauss200.jdbc.copy.CopyManager;
import com.huawei.gauss200.jdbc.core.BaseConnection;

import java.sql.*;
import java.io.*;
import java.util.UUID;

public class GpJdbcCopy {

	public void writeEntry2File(FileWriter out, ResultSet rs) throws Exception {
		int i = 1;
		ResultSetMetaData meta = rs.getMetaData();
		while (rs.next()) {
			for (int colIdx = 1; colIdx <= meta.getColumnCount(); colIdx++) {
				out.write(rs.getString(colIdx) == null ? "null" : rs.getString(colIdx));
				if (colIdx != meta.getColumnCount())
					out.write("\u0001");
				else
					out.write("\n");
			}
			if (i % 50000 == 0) {
				System.out.println(i + " rows writed to file");
				out.flush();
			}
			i++;
		}
		System.out.println(i + " rows writed to file");
	}

	public File writeFile(ResultSet rs) {
		FileWriter out = null;
		String filePath = "E:/test/pg" + UUID.randomUUID();
		File file = new File(filePath);
		try {
			out = new FileWriter(file);
			writeEntry2File(out, rs);
			out.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return file;
	}

	public void copyTest(String tablename, ResultSet rs) {
		Connection conn = null;
		CopyManager copyManager = null;
		FileReader reader = null;
		
		try {
			File file = writeFile(rs);
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://172.16.1.166:25308/adq_gldm",
					"adqdim", "ADQDIM_2018");
			copyManager = new CopyManager((BaseConnection) conn);
			reader = new FileReader(file);
			copyManager.copyIn("copy " + tablename + " from stdin delimiter as '\u0001' NULL as 'null'",
					reader);
			file.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		long time1 = System.currentTimeMillis();
		Class.forName("oracle.jdbc.OracleDriver");
		Connection oraConn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.1.89:1521:test",
				"ADQGAJ_TEST", "ADQGAJ_TEST");
		Statement st = oraConn.createStatement();
		ResultSet rs = st.executeQuery("select * from bm_user_diy11");
		
		new GpJdbcCopy().copyTest("bm_user_diy11", rs);
		long time2 = System.currentTimeMillis();
		System.out.println("Time comsumed:" + (time2 - time1) / 1000);
		rs.close();
		st.close();
		oraConn.close();
	}
}
