package com.moveone.app;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectTest extends MyTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
		Connection con = dataSource.getConnection();
		
		assertNotNull(con);
	}

}
