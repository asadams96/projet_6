package fr.openclassrooms.projet_6.model.liaison;

import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

public class TamponProprietaireTopo {
	
	private Utilisateur proprietaire;
	private Topo topo;
	private int quantite;
	
	
	public Utilisateur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
