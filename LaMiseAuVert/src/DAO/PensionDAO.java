package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			} else {
				return null;
			}
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return null;
		
	}
	
	public List<String> getAllPension() {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
				String requete = "CALL getAllPension()";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				//Pension pension[] = new Pension();
				
				List<String> pension = new ArrayList<String>();
				
				while (ResultSet.next()) {
					pension.add(ResultSet.getString("Ville"));
				}
				 return pension;
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return null;
		
	}
	
	public String editPensionByVille(String paramDescription, String paramAdresse, String paramResponsable, String paramTelephone, String paramVille) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (paramVille != null) {
				String requete = "CALL updatePension('" + paramDescription + "' , '" + paramAdresse + "' , '" + paramResponsable + "' ,"
						+ "'" + paramTelephone + "' , '" + paramVille + "' )";
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeQuery(requete);
				
				return "Pension modifier";
			} else {
				return "Une erreur c'est produite";
			}
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return "Une erreur c'est produite";
	}
	
	public String createPensionByVille(String paramVille, String paramDescription, String paramAdresse, String paramResponsable, String paramTelephone, String paramImage) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (paramImage != null) {
				String requete = "CALL addPension('" + paramVille + "' , '" + paramDescription + "' , '" + paramAdresse + "' , '" + paramResponsable + "' ,"
						+ "'" + paramTelephone + "' , '" + paramImage + "' )";
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeQuery(requete);
				
				return "Pension modifier";
			} else {
				paramImage = "assets/uploads/pension/pension-default.jpg";
				String requete = "CALL addPension('" + paramVille + "' , '" + paramDescription + "' , '" + paramAdresse + "' , '" + paramResponsable + "' ,"
						+ "'" + paramTelephone + "' , '" + paramImage + "' )";
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeQuery(requete);
				return "Pension modifier";
			}
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return "Une erreur c'est produite";
	}

}
