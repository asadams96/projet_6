package fr.openclassrooms.projet_6.model.communication;

import fr.openclassrooms.projet_6.model.site.Site;

public class CommentaireSite extends Message{
	
	private Site site;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
