package ht.tm.dev.currys.showhow.db.util;

public class SQLUtil {

	public static final String DB_HOSTNAME = "example";

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://" + DB_HOSTNAME + ":3306/example";

	public static final String USER = "example";
	public static final String PASS = "example";

	public static void loadDBDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

}
