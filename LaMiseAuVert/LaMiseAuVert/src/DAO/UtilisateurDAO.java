package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Controller.Crypt;
import Modele.Utilisateur;

public class UtilisateurDAO {

	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public UtilisateurDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}
	
	/* public void newUtilisateur(Utilisateur utilisateur) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (utilisateur.getProprietaireId() != 0) {
				
			}else {
				String requete = "CALL getUtilisateur(" + utilisateur.getProprietaireId() + ")";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet recordset = stmt.executeQuery(requete);
			}
			
		} catch(Exception sqle) {
			sqle.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
	} */
	
	public Utilisateur getUtilisateurByProprietaireId(int Id) {
		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (Id != 0) {
				String requete = "CALL getUtilisateur(" + Id + ")";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				Utilisateur utilisateur = new Utilisateur();
				
				while (ResultSet.next()) {
					utilisateur.setId(ResultSet.getInt("Id"));
					utilisateur.setProprietaireId(ResultSet.getInt("ProprietaireId"));
					utilisateur.setPassword(ResultSet.getString("Password"));
					utilisateur.setRole(ResultSet.getString("Role"));
				}
				
				return utilisateur;
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
	
	public Utilisateur getUtilisateurByPassword(String userPassword) {

		try {
			Connection conn = (Connection) DriverManager.getConnection(url + dbName , userName, password);
			
			if (userPassword != null) {
				String requete = "CALL getRoleByPassword('" + userPassword + "')";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet ResultSet = stmt.executeQuery(requete);
				
				Utilisateur utilisateur = new Utilisateur();
				
				while (ResultSet.next()) {
					utilisateur.setId(ResultSet.getInt("Id"));
					utilisateur.setProprietaireId(ResultSet.getInt("ProprietaireId"));
					utilisateur.setPassword(ResultSet.getString("Password"));
					utilisateur.setRole(ResultSet.getString("Role"));
				}
				
				return utilisateur;
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
