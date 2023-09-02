package com.demon.io.model;

import lombok.Data;

import java.util.List;

@Data
public class PrepareInsertModel {
	public String tableName;
	public String insertColSql;
	public List<List<Object>> valuesList;
}
