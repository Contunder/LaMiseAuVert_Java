package Modele;

public class Animal {

	private int Id;
	private String NomAnimal;
	private int ProprietaireId;
	private int EspeceId;
	
	public Animal () {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNomAnimal() {
		return NomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}

	public int getProprietaireId() {
		return ProprietaireId;
	}

	public void setProprietaireId(int proprietaireId) {
		ProprietaireId = proprietaireId;
	}

	public int getEspeceId() {
		return EspeceId;
	}

	public void setEspeceId(int especeId) {
		EspeceId = especeId;
	}
	
	
}
