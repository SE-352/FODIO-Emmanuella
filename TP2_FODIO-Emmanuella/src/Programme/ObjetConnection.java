package Programme;

import java.sql.Connection;
import java.sql.DriverManager;

public class ObjetConnection {
	
	private static Connection connection=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/federation","root","");
			
		} catch (Exception e) {
			
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
