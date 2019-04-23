package fr.openclassrooms.projet_6.model.communication;

import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

public class Message {
	
	private int idMessage;
	private String date;
	private String contenu;
	private Utilisateur auteur;
	
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
}
