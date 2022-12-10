package Programme;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {

	private static Dao connection =null;
	
	static {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection= (Dao) DriverManager.getConnection("jdbc:mysql://localhost:3306/federation","root","");
				
		} catch (Exception e) {
			
		}
	}
	
	public static Dao getConnection() {
		return connection;
	}
}

	

