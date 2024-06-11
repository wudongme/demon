package com.demon.io.service.impl;

import com.demon.io.mapper.TestMapper;
import com.demon.io.model.RequestParam;
import com.demon.io.model.TczrkJbxx;
import com.demon.io.service.MysqlService;
import com.demon.io.service.TestMapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @desc
 * @fileName MysqlServiceImpl.java
 * @date 2023/8/22/0022 13:53
 * @author Dongmo.Wu
 */
@Service
@Slf4j
public class MysqlServiceImpl implements MysqlService {
	@Resource
	private TestMapper testMapper;
	@Autowired
	private TestMapperService testMapperService;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void insertToTable100Columns(RequestParam requestParam) {
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		/*Connection connection = null;
		PreparedStatement preparedStatement = null;*/
		try {
			/*connection = DriverManager.getConnection(url, user, password);*/
			Long paramStartId = requestParam.getStartId();
			Long paramBatchSize = requestParam.getBatchSize();

			int spiltSize = (int) Math.ceil(paramBatchSize / 1000);
			Long startId;
			for (int i = 0; i < spiltSize; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO dont_delete_otherwise_fuck_your_ass (dsbm,nid,dsdm,rkbm,gmsfhm,xm,x,m,hh,yhzgxdm,cym,xbdm,mzdm,csrq,cssj,csdgjhdqdm,csdssxqdm,csdqhnxxdz,jggjhdqdm,jgssxqdm,jgqhnxxdz,hjdzdzbm,hjdzssxqdm,hjdzqhnxxdz,hjdzxzjddm,hjdzsqjcwhdm,hjdzcxfldm,hjdzrhyzbs,xldm,hyzkdm,cyzkzagldwbm,cyzkdwmc,cyzkzy,cyzkzylbdm,zjxydm,byzkdm,sg,xxdm,jhrygmsfhm,jhryxm,jhrycyzjdm,jhryzjhm,jhrywwx,jhrywwm,jhryjhgxdm,jhrylxdh,jhregmsfhm,jhrexm,jhrecyzjdm,jhrezjhm,jhrewwx,jhrewwm,jhrejhgxdm,jhrelxdh,fqgmsfhm,fqxm,fqcyzjdm,fqzjhm,fqwwx,fqwwm,mqgmsfhm,mqxm,mqcyzjdm,mqzjhm,mqwwx,mqwwm,pogmsfhm,poxm,pocyzjdm,pozjhm,powwx,powwm,lbsqkqlrrq,lbsqkqyldyydm,lbsqklzdgjhdqdm,lbsqklzdssxqdm,lbsqklzdqhnxxdz,lkbsqkqlcrq,lkbsqkqyldyydm,lkbsqkqwdgjhdqdm,lkbsqkqwdssxqdm,lkbsqkqwdqhnxxdz,cyjmsfzqkqfjggajgmc,cyjmsfzqkyxqqsrq,cyjmsfzqkyxqjzrq,cyjmsfzqkdzmc,swrq,rkglswyydm,lxdh,rkxxjbdm,xmpy,rkglzxlbdm,zxsj,gxsj,sjgsdwdm,sjgsdwmc,rkzt,photoid,dsbz,scol3) VALUES ");
				startId = paramStartId + i * 1000;
				Long end = startId + 1000;
				for (long j = startId; j < end; j++) {
					TczrkJbxx.generateInsertSqlBatch(sb, j);
				}
				sb.setLength(sb.length() - 1);


				String sql = sb.toString();
				long l1 = System.currentTimeMillis();

				testMapperService.batchInsert(sql);
				/*preparedStatement = connection.prepareStatement(sql);
				preparedStatement.execute();
				connection.commit();*/

				long l2 = System.currentTimeMillis();
				log.info("写入1000条，耗时"+(l2 - l1)+"ms");
				log.info("本次请求累计写到第{}行", end);

			}
		} catch (Exception ex ) {
			log.error(ex.getMessage(), ex);
		} /*finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}*/
	}

	@Override
	public void concatTest(String test_str) {
		testMapper.concatTest(test_str);
	}

}
