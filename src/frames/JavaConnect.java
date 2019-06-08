package frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnect {
	static Connection conn = null;
	
	public static Connection ConnectDB() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net/po_test_db", "vvojty98", "2K9dBzcLygxbr3t");		
			return conn;
		}
		finally {
			if (conn!= null){
				conn.close();
			}
		}
		}
	}