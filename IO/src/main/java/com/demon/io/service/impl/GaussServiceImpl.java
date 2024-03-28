package com.demon.io.service.impl;

import com.audaque.cloud.common.utils.SnowflakeUtils;
import com.demon.io.mapper.TestMapper;
import com.demon.io.model.TczrkJbxx;
import com.demon.io.service.GaussService;
import com.huawei.gauss200.jdbc.copy.CopyManager;
import com.huawei.gauss200.jdbc.core.BaseConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @desc
 * @fileName GaussServiceImpl.java
 * @date 2023/7/26/0026 14:25
 * @author Dongmo.Wu
 */
@Service
@Slf4j
public class GaussServiceImpl implements GaussService {
	@Resource
	private TestMapper testMapper;
	@Autowired
	@Lazy
	GaussService gaussService;

	@Override
	public void insertBigDataToGauss(int suffix) {
		// todo 固定好大小
		//testCopyManager(prefix);
		copyManagerMultiThread(suffix);

	}

	@Value("${file.path}")
	private String filePathPrefix;
	@Value("${file.batch.size:200000}")
	private int fileBatchSize;
	@Value("${circle.start}")
	private int start;
	@Value("${circle.end}")
	private int end;

	@Override
	public void generateFile(String filePath) {
		String currentDir = System.getProperty("user.dir");
		log.info("当前路径：" + currentDir);
		try (FileWriter writer = new FileWriter(filePath)) {
			int batchSize = 5;
			for (int j = 0; j < batchSize; j++) {
				long l1 = System.currentTimeMillis();
				for (int i = 0; i < fileBatchSize; i++) {

					StringBuilder sb = new StringBuilder();
					TczrkJbxx tCzrkJbxx = new TczrkJbxx();
					//long l = SnowflakeUtils.nextId();
					//log.info("id={}", l);
					//tCzrkJbxx.setNid(l + "");
					//tCzrkJbxx.generateCsv(sb, tCzrkJbxx);
					writer.write(sb.toString());
				}
				long l2 = System.currentTimeMillis();
				log.info("第" + (j + 1) + "批次耗时：" + (l2 - l1) + "毫秒");
			}


			// 如果需要换行，可以使用以下代码
			// writer.write(System.lineSeparator());
			// writer.write("This is a new line.");

			log.info("Data has been written to the file.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final ExecutorService EXECUTORS = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS,
			new LinkedBlockingQueue(100));
	;

	int count;

	@Override
	public void copyManagerMultiThread(int suffix) {
		String currentDir = System.getProperty("user.dir");
		String startFilePath =
				currentDir + File.separator + filePathPrefix + File.separator + "file_" + (start) + ".txt";

		new Thread(() -> {
			log.info("初始化");
			generateFile(startFilePath);
			log.info("初始化完成");
			for (int i = start; i <= end; i++) {

				if (end != i) {
					String nextFilePath =
							currentDir + File.separator + filePathPrefix + File.separator + "file_" + (i + 1) + ".txt";
					EXECUTORS.execute(() -> generateFile(nextFilePath));
				}

				String curFilePath =
						currentDir + File.separator + filePathPrefix + File.separator + "file_" + i + ".txt";
				String tabName = "t_czrk_jbxx_" + i;
				new WriteFromFileByCopyManager(curFilePath, tabName).run();

				//EXECUTORS.execute(new WriteToCollectionFromTmp(tab1));

				/*EXECUTORS.execute(() -> generateFile(filePath1));
				new WriteFromFileByCopyManager(filePath2, tab2).run();*/
				//EXECUTORS.execute(new WriteToCollectionFromTmp(tab2));

			}
		}).start();


	}

	class WriteToCollectionFromTmp implements Runnable {
		private String tabName;

		public WriteToCollectionFromTmp(String tabName) {
			this.tabName = tabName;
		}

		@Override
		public void run() {
			Connection conn = null;
			try {
				Class.forName("com.huawei.gauss200.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:gaussdb://172.16.2.110:25308/dcf_user?currentSchema=dcf_lx",
						"dcf_user", "1qaz@WSX");
				PreparedStatement preparedStatement = conn.prepareStatement("");
				preparedStatement.execute();
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
			long l7 = System.currentTimeMillis();
			log.info("准备写入" + tabName);
			testMapper.insertBigDataToGauss("insert into t_czrk_jbxx_pk select * from " + tabName);
			long l8 = System.currentTimeMillis();
			log.info("写入完成，耗时：" + (l8 - l7) + " 毫秒");
			testMapper.truncate("truncate dcf_lx." + tabName);
			log.info("truncate 完成");
		}
	}

	class WriteFromFileByCopyManager implements Runnable {
		String filePath;
		String tabName;

		public WriteFromFileByCopyManager(String filePath, String tabName) {
			this.filePath = filePath;
			this.tabName = tabName;
		}

		public void testCopyManager() {
			String threadName = Thread.currentThread().getName();
			Connection conn = null;
			CopyManager copyManager = null;
			Reader reader = null;
			//log.info(threadName + "构建reader耗时{}毫秒", l5 -l4);
			long l4 = 0;
			//String tabName = "t_czrk_jbxx_" + +filePre;
			try {
				long l1 = System.currentTimeMillis();
				Class.forName("com.huawei.gauss200.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:gaussdb://172.16.2.110:25308/dcf_user?currentSchema=dcf_lx",
						"dcf_user", "1qaz@WSX");
				copyManager = new CopyManager((BaseConnection) conn);

				reader = new FileReader(filePath);
				l4 = System.currentTimeMillis();
				log.info(threadName + "获取连接、copyManger耗时{}ms", l4 - l1);

				copyManager.copyIn("COPY " + tabName + " FROM STDIN WITH CSV", reader);
				long l6 = System.currentTimeMillis();
				log.info(threadName + "copy耗时{}毫秒", l6 - l4);
				log.info(threadName + "===========================");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeResource(conn, reader);
			}

			deleteFile(filePath);

		}

		private void closeResource(Connection conn, Reader reader) {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			testCopyManager();
		}
	}

	public void deleteFile(String filePath) {
		File fileToDelete = new File(filePath);

		// 检查文件是否存在并且是一个文件
		if (fileToDelete.exists() && fileToDelete.isFile()) {
			// 尝试删除文件
			boolean deleted = fileToDelete.delete();

			if (deleted) {
				log.info("文件删除成功: " + filePath);
			} else {
				log.info("文件删除失败: " + filePath);
			}
		} else {
			log.info("文件不存在或者不是一个文件: " + filePath);
		}
	}

	class WriteByCopyManager implements Runnable {
		public void testCopyManager() {
			String threadName = Thread.currentThread().getName();
			StringBuilder sb = new StringBuilder();
			long l1 = System.currentTimeMillis();
			int batch = 1;
			int size = 5000;
			for (int j = 0; j < batch; j++) {
				Connection conn = null;
				CopyManager copyManager = null;
				for (int i = 0; i < size; i++) {
					TczrkJbxx tCzrkJbxx = new TczrkJbxx();
					long l = SnowflakeUtils.nextId();
					//log.info("id={}", l);
					//tCzrkJbxx.generateCsv(sb, tCzrkJbxx);
				}
				Reader stringReader = new StringReader(sb.toString());
				long l5 = System.currentTimeMillis();
				//log.info(threadName + "构建reader耗时{}毫秒", l5 -l4);
				try {
					Class.forName("com.huawei.gauss200.jdbc.Driver");
					conn = DriverManager.getConnection(
							"jdbc:gaussdb://172.16.2.110:25308/dcf_user?currentSchema=dcf_lx", "dcf_user", "1qaz@WSX");
					copyManager = new CopyManager((BaseConnection) conn);
					long l4 = System.currentTimeMillis();
					log.info(threadName + "获取连接、copyManger耗时{}ms", l4 - l1);
					copyManager.copyIn("COPY dont_delete_otherwise_fuck_your_ass FROM STDIN WITH CSV", stringReader);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				long l6 = System.currentTimeMillis();
				log.info(threadName + "写入耗时{}毫秒", l6 - l5);
			}
			log.info(threadName + "===========================");
		}

		@Override
		public void run() {
			testCopyManager();
		}
	}

	public static void main(String[] args) {
		new GaussServiceImpl().testCopyManager(null);
	}

	public void testCopyManager(String prefix) {
		StringBuilder sb = new StringBuilder();
		long l1 = System.currentTimeMillis();
		int size = 1000;
		for (int i = 0; i < size; i++) {
			TczrkJbxx tCzrkJbxx = new TczrkJbxx();
			long l = SnowflakeUtils.nextId();
			//log.info("id={}", l);
			//tCzrkJbxx.generateCsv(sb, tCzrkJbxx);
		}
		long l2 = System.currentTimeMillis();
		log.info("生成{}行sql用了{}毫秒", size, l2 - l1);
		sb.setLength(sb.length() - 2);
		long l3 = System.currentTimeMillis();
		log.info("setLength用了{}毫秒", l3 - l2);
		Connection conn = null;
		CopyManager copyManager;
		try {
			Class.forName("com.huawei.gauss200.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:gaussdb://172.16.2.112:25308/postgres?currentSchema=public",
					"dcf_user", "1qaz@WSX");
			copyManager = new CopyManager((BaseConnection) conn);
			long l4 = System.currentTimeMillis();
			log.info("获取连接、copyManger耗时{}ms", l4 - l3);
			Reader stringReader = new StringReader(sb.toString());
			long l5 = System.currentTimeMillis();
			log.info("构建reader耗时{}毫秒", l5 - l4);
			copyManager.copyIn(
					"COPY dont_delete_otherwise_fuck_your_ass (dsbm,dsdm,rkbm,gmsfhm,xm,x,m,hh,yhzgxdm,cym,xbdm,mzdm,csrq,cssj,csdgjhdqdm,csdssxqdm,csdqhnxxdz,jggjhdqdm,jgssxqdm,jgqhnxxdz,hjdzdzbm,hjdzssxqdm,hjdzqhnxxdz,hjdzxzjddm,hjdzsqjcwhdm,hjdzcxfldm,hjdzrhyzbs,xldm,hyzkdm,cyzkzagldwbm,cyzkdwmc,cyzkzy,cyzkzylbdm,zjxydm,byzkdm,sg,xxdm,jhrygmsfhm,jhryxm,jhrycyzjdm,jhryzjhm,jhrywwx,jhrywwm,jhryjhgxdm,jhrylxdh,jhregmsfhm,jhrexm,jhrecyzjdm,jhrezjhm,jhrewwx,jhrewwm,jhrejhgxdm,jhrelxdh,fqgmsfhm,fqxm,fqcyzjdm,fqzjhm,fqwwx,fqwwm,mqgmsfhm,mqxm,mqcyzjdm,mqzjhm,mqwwx,mqwwm,pogmsfhm,poxm,pocyzjdm,pozjhm,powwx,powwm,lbsqkqlrrq,lbsqkqyldyydm,lbsqklzdgjhdqdm,lbsqklzdssxqdm,lbsqklzdqhnxxdz,lkbsqkqlcrq,lkbsqkqyldyydm,lkbsqkqwdgjhdqdm,lkbsqkqwdssxqdm,lkbsqkqwdqhnxxdz,cyjmsfzqkqfjggajgmc,cyjmsfzqkyxqqsrq,cyjmsfzqkyxqjzrq,cyjmsfzqkdzmc,swrq,rkglswyydm,lxdh,rkxxjbdm,xmpy,rkglzxlbdm,zxsj,gxsj,sjgsdwdm,sjgsdwmc,rkzt,photoid,hckrksj,hckgxsj,dsbz,scol3) FROM STDIN WITH CSV",
					stringReader);
			long l6 = System.currentTimeMillis();
			log.info("写入耗时{}毫秒", l6 - l5);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		log.info("===========================");
	}

	private void extracted(String prefix) {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		long l1 = System.currentTimeMillis();
		int size = 100;
		for (int i = 0; i < size; i++) {
			TczrkJbxx tCzrkJbxx = new TczrkJbxx();
			//tCzrkJbxx.generateInsertSqlBatch(sb, tCzrkJbxx);
		}
		long l2 = System.currentTimeMillis();
		log.info("生成{}行sql用了{}毫秒", size, l2 - l1);
		sb.setLength(sb.length() - 2);
		long l3 = System.currentTimeMillis();
		log.info("setLength用了{}毫秒", l3 - l2);
		gaussService.insertOne(sb.toString());
		long l4 = System.currentTimeMillis();
		log.info("执行sql用了{}毫秒", l4 - l3);
		log.info("===========================");
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void insertOne(String sql) {
		testMapper.insertBigDataToGauss(sql);
	}


}
