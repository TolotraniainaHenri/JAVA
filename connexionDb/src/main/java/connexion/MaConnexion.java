package connexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import connexion.MaConnexion;

public class MaConnexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/inscription_db";
	private static final String USER = "root";
	private static final String PASSWORD = "henri1234";
	
	public static Connection getConnection() throws SQLException {
			
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch (ClassNotFoundException e) {
			throw new SQLException("Pilote JDBC Mysql introuvable", e);
		}
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
		
	}
			
  }
	
