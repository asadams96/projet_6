package fr.openclassrooms.projet_6.model.site;

public class Voie {
	
	private int idVoie;
	private int numero;
	private String nom;
	private String cotation;
	private String longueur;
	private String hauteur;
	private String nbrPoint;
	private String typePoint;
	private String remarque;
	private Secteur secteur;
	
	
	public int getIdVoie() {
		return idVoie;
	}
	public void setIdVoie(int idVoie) {
		this.idVoie = idVoie;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public String getLongueur() {
		return longueur;
	}
	public void setLongueur(String longueur) {
		this.longueur = longueur;
	}
	public String getHauteur() {
		return hauteur;
	}
	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}
	public String getNbrPoint() {
		return nbrPoint;
	}
	public void setNbrPoint(String nbrPoint) {
		this.nbrPoint = nbrPoint;
	}
	public String getTypePoint() {
		return typePoint;
	}
	public void setTypePoint(String typePoint) {
		this.typePoint = typePoint;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

}
