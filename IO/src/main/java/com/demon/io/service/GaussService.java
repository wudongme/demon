package com.demon.io.service;

/**
 *
 * @desc
 * @fileName GaussService.java
 * @date 2023/7/26/0026 14:24
 * @author Dongmo.Wu
 */
public interface GaussService {
	void insertBigDataToGauss(int suffix);

	void generateFile(String filePath);

	void copyManagerMultiThread(int suffix);

	void insertOne(String sql);
}
