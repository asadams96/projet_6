package fr.openclassrooms.projet_6.model.topo;

public class Topo {

	private int idTopo;
	private String titre;
	private String auteur;
	private String annee;
	private String description;
	private String urlImage;
	
	
	public int getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(int idTopo) {
		this.idTopo = idTopo;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
