package fr.openclassrooms.projet_6.model.communication;

import fr.openclassrooms.projet_6.model.topo.Topo;

public class CommentaireTopo extends Message {

	private Topo topo;

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
}
