package fr.openclassrooms.projet_6.model.communication;

import fr.openclassrooms.projet_6.model.pret.Pret;

public class MessagePret extends Message {
	
	private Pret pret;

	public Pret getPret() {
		return pret;
	}

	public void setPret(Pret pret) {
		this.pret = pret;
	}
}
