package fr.openclassrooms.projet_6.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;

public class GestionPretAction extends ActionSupport {
	
	private ManagerFactory managerFactory;

	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
