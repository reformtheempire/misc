package ht.tm.dev.currys.showhow.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ht.tm.dev.currys.showhow.db.util.SQLUtil;

public class SQLConnectionManager {

	public static int currentConnections;

	public static Connection getConnectionToDB() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(SQLUtil.DB_URL, SQLUtil.USER, SQLUtil.PASS);
		currentConnections++;
		if (conn == null) {
			throw new SQLException("Cannot get connection");
		}
		return conn;
	}

	public static boolean closeConnection(Connection conn) {

		try {
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
					currentConnections--;
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
