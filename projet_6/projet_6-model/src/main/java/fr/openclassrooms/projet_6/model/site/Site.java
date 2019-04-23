package fr.openclassrooms.projet_6.model.site;

public class Site {
	
	private int idSite;
	private String nom;
	private String description;
	private String infoAcces;
	private String infoProximite;
	private String urlImageSite;
	private String urlImageAcces;
	
	
	public int getIdSite() {
		return idSite;
	}
	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInfoAcces() {
		return infoAcces;
	}
	public void setInfoAcces(String infoAcces) {
		this.infoAcces = infoAcces;
	}
	public String getInfoProximite() {
		return infoProximite;
	}
	public void setInfoProximite(String infoProximite) {
		this.infoProximite = infoProximite;
	}
	public String getUrlImageSite() {
		return urlImageSite;
	}
	public void setUrlImageSite(String urlImageSite) {
		this.urlImageSite = urlImageSite;
	}
	public String getUrlImageAcces() {
		return urlImageAcces;
	}
	public void setUrlImageAcces(String urlImageAcces) {
		this.urlImageAcces = urlImageAcces;
	}
}
