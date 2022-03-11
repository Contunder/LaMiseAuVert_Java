package Modele;

public class Utilisateur {
	
	private int Id;
	private int ProprietaireId;
	private String Password;
	private String Role;
	
	public Utilisateur() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getProprietaireId() {
		return ProprietaireId;
	}

	public void setProprietaireId(int proprietaireId) {
		ProprietaireId = proprietaireId;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	public String toString() {
		return this.Role;
	}

}
