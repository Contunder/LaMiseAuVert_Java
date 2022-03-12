package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Modele.Prix;

public class PrixDAO {

	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public PrixDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}
	
	public Prix getPrixByVilleAndLibelle(String Ville, String Libelle) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (Ville != null) {
				String requete = "CALL getPrix('" + Ville + "' , '" + Libelle + "')";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				Prix prix = new Prix();
				
				while (ResultSet.next()) {
					prix.setId(ResultSet.getInt("Id"));
					prix.setTarif(ResultSet.getInt("Tarif"));
					prix.setTypeGardiennage(Libelle);
					prix.setVille(Ville);
					prix.setTypeGardiennageId(ResultSet.getInt("TypeGardiennageId"));
					prix.setPensionId(ResultSet.getInt("PensionId"));
				}
				 return prix;
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
	
	public String editPrixByPension(int paramTarif, int paramPension, int paramTypeGardiennage) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (paramPension != 0) {
				String requete = "CALL updatePrix('" + paramTarif + "' , '" + paramPension + "' , '" + paramTypeGardiennage + "' )";
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
	
}
