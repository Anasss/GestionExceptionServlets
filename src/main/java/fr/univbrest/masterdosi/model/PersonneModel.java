package fr.univbrest.masterdosi.model;

public class PersonneModel {

	private String id;
	private String nom;
	private String prenom;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "PersonneModel [id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
	
	
}