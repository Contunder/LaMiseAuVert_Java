package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Modele.Pension;

public class PensionDAO {
	
	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public PensionDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}
	
	public Pension getPensionByVille(String Ville) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (Ville != null) {
				String requete = "CALL getPension('" + Ville + "')";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				Pension pension = new Pension();
				
				while (ResultSet.next()) {
					pension.setId(ResultSet.getInt("Id"));
					pension.setVille(ResultSet.getString("Ville"));
					pension.setAdresse(ResultSet.getString("Adresse"));
					pension.setTelephone(ResultSet.getString("Telephone"));
					pension.setResponsable(ResultSet.getString("Responsable"));
					pension.setDescription(ResultSet.getString("Description"));
					pension.setImage(ResultSet.getString("Image"));
				}
				 return pension;
			}else {
				return null;
			}
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return null;
		
	}

}
