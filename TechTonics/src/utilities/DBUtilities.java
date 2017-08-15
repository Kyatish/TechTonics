package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtilities
{
	static String drvr = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/tech_tonics?useSSL=true";
	static String name = "root";
	static String pass = "";
	public static Connection getConnection() throws Exception
	{
		Class.forName(drvr);
		return DriverManager.getConnection(url,name,pass);
	}
}

