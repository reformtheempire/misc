package ht.tm.dev.currys.showhow.db.util;

public class SQLUtil {
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "DB_URL";

	public static final String USER = "USER";
	public static final String PASS = "PASS";

	public static void loadDBDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

}
