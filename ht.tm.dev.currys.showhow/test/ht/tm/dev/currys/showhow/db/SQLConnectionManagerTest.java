package ht.tm.dev.currys.showhow.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class SQLConnectionManagerTest {

	@Test
	public void testGetConnectionToDB() {
		Connection conn;
		try {
			conn = SQLConnectionManager.getConnectionToDB();
			if(conn == null || conn.isClosed()){
				fail();
			}
			
			assertEquals(1, SQLConnectionManager.currentConnections);
			
			SQLConnectionManager.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
