package com.example;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public class AbstractTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void classSetUp() {
	}
	
	@Before
	public void setUp(){
		// 開始ログ
		logger.info("");
        logger.info("*** " + getClass().getSimpleName()  +" start");
        
//		// DDL再作成
//		logger.info("ddl execute start");
//		executeScript("/data/db/schema/ddl.sql");
//		logger.info("ddl execute end");
//		
//		// SQL再実行
//		logger.info("sql execute start");
//		executeScript("/data/db/exec/sample1.sql");
//		logger.info("sql execute end");
	}
	
	@After
	public void tearDown(){
		// 終了ログ
		logger.info("*** " + getClass().getSimpleName()  + " end");
		logger.info("");
	}
	
	@AfterClass
	public static void classtearDown() {
	}
	
	/**
	 * SQLファイルを実行する
	 * @param file
	 */
	public void executeScript(String file) {
		
        Resource resource = new ClassPathResource(file, getClass());
        logger.info(resource.toString());
        
        ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
        rdp.addScript(resource);
        rdp.setSqlScriptEncoding("UTF-8");
        rdp.setIgnoreFailedDrops(true);
        rdp.setContinueOnError(false);
        
        Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        rdp.populate(conn);
        
    }
	
}
