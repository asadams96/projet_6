package fr.openclassrooms.projet_6.business.impl.manager;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireSiteManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessageManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessagePretManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponProprietaireTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponSiteTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.pret.PretManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SecteurManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SiteManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.VoieManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.topo.TopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.utilisateur.UtilisateurManagerImpl;
import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;

/**
 * <p>Classe mère de toutes les classes Manager</p>
 * <p>Permet de partager la DaoFactory et donc d'avoir accès à toutes les classes Dao</p>
 * 
 * @see AbstractManager#daoFactory
 * @see AbstractManager#getDaoFactory()
 * @see AbstractManager#setDaoFactory(DaoFactory)
 * @see UtilisateurManagerImpl
 * @see TopoManagerImpl
 * @see VoieManagerImpl
 * @see SecteurManagerImpl
 * @see SiteManagerImpl
 * @see PretManagerImpl
 * @see TamponProprietaireTopoManagerImpl
 * @see TamponSiteTopoManagerImpl
 * @see MessagePretManagerImpl
 * @see MessageManagerImpl
 * @see CommentaireTopoManagerImpl
 * @see CommentaireSiteManagerImpl
 * @see ManagerFactory
 * @see ManagerFactoryImpl
 * @see DaoFactory
 * @see DaoFactoryImpl
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public abstract class AbstractManager {
	
	/**
	 * <p>Représente une instance de la classe 'DaoFactory'</p>
	 * 
	 * @see AbstractManager#getDaoFactory()
	 * @see AbstractManager#setDaoFactory(DaoFactory)
	 * @see DaoFactory
	 * @see DaoFactoryImpl
	 */
	private DaoFactory daoFactory;
	
	
	
	/**
	 * <p>
	 * 	Getter permettant à tous les enfants de la classe AbstractManager 
	 * (tout les Manager) d'avoir accès à une instance de la 'DaoFactory'
	 * </p>
	 * 
	 * @return Une instance de la classe 'DaoFactoryImpl'
	 * 
	 * @see AbstractManager#daoFactory
	 * @see AbstractManager#setDaoFactory(DaoFactory)
	 * @see DaoFactory
	 * @see DaoFactoryImpl
	 */
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}

	
	
	/**
	 * <p>
	 * 	Setter utilisé par Spring pour définir une instance de
	 * 	la 'DaoFactory'
	 * </p>
	 * 
	 * @param daoFactory Nouvelle instance de la classe 'DaoFactoryImpl'
	 * 
	 * @see AbstractManager#daoFactory
	 * @see AbstractManager#getDaoFactory()
	 * @see DaoFactory
	 * @see DaoFactoryImpl
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
}
