package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import Modele.Proprietaire;

public class ProprietaireDAO {
	
	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public ProprietaireDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}
	
	public void newProprietaire(String paramNom, String paramPrenom, String paramAdresse, String paramTelephone, String paramEmail) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (paramEmail != null) {
				String requete = "CALL getUtilisateur('" + paramNom + "' , '" + paramPrenom + "' , '" + paramAdresse + "' ,"
						+ " '" + paramTelephone + "' , '" + paramEmail + "' )";
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeQuery(requete);
			} else {
				
			}
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
	}
	
	public Proprietaire getProprietaireByEmail(String Email) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (Email != null) {
				String requete = "CALL getUtilisateur('" + Email + "')";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				Proprietaire proprietaire = new Proprietaire();
				
				while (ResultSet.next()) {
					proprietaire.setId(ResultSet.getInt("Id"));
					proprietaire.setNom(ResultSet.getString("Nom"));
					proprietaire.setPrenom(ResultSet.getString("Prenom"));
					proprietaire.setAdresse(ResultSet.getString("Adresse"));
					proprietaire.setTelephone(ResultSet.getString("Telephone"));
					proprietaire.setEmail(ResultSet.getString("Email"));
				}
				 return proprietaire;
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
