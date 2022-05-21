package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/PAO-EAP-db";
    private static final String USER = "root";
    private static final String PASSWORD = "alskdj22";
    private static Connection DBconnection;

	public static Connection getDBconnection() {
		try {
			if (DBconnection == null || DBconnection.isClosed()) {
				DBconnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				return DBconnection;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DBconnection;
	}
	
	public static void closeDBconnection() {
		try {
			if (DBconnection != null || !DBconnection.isClosed()) {
				DBconnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
