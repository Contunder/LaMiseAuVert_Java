package Modele;

public class Prix {
	
	private int Id;
	private int Tarif;
	private String TypeGardiennage;
	private String Ville;
	private int PensionId;
	private int TypeGardiennageId;
	
	public Prix() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getTarif() {
		return Tarif;
	}

	public void setTarif(int tarif) {
		Tarif = tarif;
	}
	
	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}
	
	public String getTypeGardiennage() {
		return TypeGardiennage;
	}

	public void setTypeGardiennage(String typeGardiennage) {
		TypeGardiennage = typeGardiennage;
	}

	public int getPensionId() {
		return PensionId;
	}

	public void setPensionId(int pensionId) {
		PensionId = pensionId;
	}

	public int getTypeGardiennageId() {
		return TypeGardiennageId;
	}

	public void setTypeGardiennageId(int typeGardiennageId) {
		TypeGardiennageId = typeGardiennageId;
	}
	
}
