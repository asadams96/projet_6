package fr.openclassrooms.projet_6.model.site;

public class Secteur {
	
	private int idSecteur;
	private String nom;
	private String type;
	private String orientation;
	private String info;
	private String urlImage;
	private Site site;
	
	
	public int getIdSecteur() {
		return idSecteur;
	}
	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	

}
