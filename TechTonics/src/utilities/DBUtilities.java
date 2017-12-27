package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtilities {
	static String drvr = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://10.128.158.1:3306/tech_tonics";
	static String name = "root";
	static String pass = "asdf123";

	public static Connection getConnection() throws Exception {
		Class.forName(drvr);
		return DriverManager.getConnection(url, name, pass);
	}
}
