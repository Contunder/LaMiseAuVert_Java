package Controller;
import java.sql.*;

public class DBConnect {
	
	public static DBConnect db;

	public static void main(String[] args) {
		
		String url="jdbc:mysql://127.0.0.1/";
		String dbName = "lamiseauvert";
		String userName = "Valentin";
		String password = "kilabilon";
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			System.out.println("Connecter");
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		

	}

}
