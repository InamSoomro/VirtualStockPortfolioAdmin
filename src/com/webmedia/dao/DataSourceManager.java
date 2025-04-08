/**
 * 
 */
package com.webmedia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * DataSourceManager manages a Data source connection pool  
 */
public class DataSourceManager {

	private DataSource dataSource = null;
	private DataSourceManager(String userName, String password, String uri) {
		dataSource = setupDataSource(userName,password,uri);
	}

	private static DataSourceManager dataSourceManager = null;
	/**
	 * 
	 * @return DataSourceManager singleton object
	 */
	public static DataSourceManager getDataSourceManagerInstance(String userName, String password, String uri) {
		if (dataSourceManager == null) {
			dataSourceManager = new DataSourceManager(userName,password,uri);
		}
		return dataSourceManager;
	}
    /**
     * 
     * @return connection from dataSource
     * @throws SQLException
     */
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	/**
	 * 
	 * @return DataSource Object after setting database connection properties
	 * note: database connection properties can also be set in properties file.
	 */
	public static DataSource setupDataSource(String username, String password, String uri) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(uri);
		return ds;
	}

	/**
	 * 
	 * @param ds
	 * @throws SQLException
	 * method will close the DataSource object 
	 */
	public static void shutdownDataSource(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		bds.close();
	}

	
	
	
	
}
