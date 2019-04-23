package fr.openclassrooms.projet_6.business.impl.manager;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;

public abstract class AbstractManager {
	
	private DaoFactory daoFactory;

	
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
}
