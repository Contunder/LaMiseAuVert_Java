package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TypeGardiennageDAO {
	
	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public TypeGardiennageDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}
	
	public int[] getAllGardiennage() {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
				String requete = "CALL getAllGardiennage()";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
			
				
				int i = 0;
				int[] typeGardiennageId = new int[3];
				while (ResultSet.next()) {
					typeGardiennageId[i] =  ((Number) ResultSet.getInt("Id")).intValue();
					i++;
				}
				 return typeGardiennageId;
			
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return null;
		
	}

}
