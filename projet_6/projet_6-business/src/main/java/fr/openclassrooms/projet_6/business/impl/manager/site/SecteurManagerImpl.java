package fr.openclassrooms.projet_6.business.impl.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.site.SecteurManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>Implémentation de l'interface 'SecteurManager'</p>
 * <p>Dédié au traitement métier de la classe 'Secteur'</p>
 * 
 * @see SecteurManager#getList(String)
 * @see SecteurManager#getIdsSiteByOrientation(String)
 * @see SecteurManager#getIdsSiteByType(String)
 * @see SecteurManager#checkType(int)
 * @see SecteurManager#checkOrientation(int)
 * @see SecteurManagerImpl#getList(String)
 * @see SecteurManagerImpl#getIdsSiteByOrientation(String)
 * @see SecteurManagerImpl#getIdsSiteByType(String)
 * @see SecteurManagerImpl#checkType(int)
 * @see SecteurManagerImpl#checkOrientation(int)
 * @see ManagerFactory#getSecteurManager()
 * @see ManagerFactory#setSecteurManager(SecteurManager)
 * @see ManagerFactoryImpl#getSecteurManager()
 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
 * @see Secteur
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

	
	
	/**
	 * @see SecteurManager#getList(String)
	 * @see Secteur
	 */
	@Override
	public List<Secteur> getList(String idSite) {
				
		return this.getDaoFactory().getSecteurDao().getList(idSite);
	}

	
	
	/**
	 * @see SecteurManager#getIdsSiteByOrientation(String)
	 */
	@Override
	public List<Integer> getIdsSiteByOrientation(String critereOrientation) throws Exception {

		return this.getDaoFactory().getSecteurDao().getIdsSiteByOrientation(critereOrientation);
	}

	
	
	/**
	 * @see SecteurManager#getIdsSiteByType(String)
	 */
	@Override
	public List<Integer> getIdsSiteByType(String critereType) throws Exception {

		return this.getDaoFactory().getSecteurDao().getIdsSiteByType(critereType);
	}

	
	
	/**
	 * @see SecteurManager#checkType(int)
	 */
	@Override
	public List<String> checkType(int idSite) throws Exception {

		return this.getDaoFactory().getSecteurDao().checkType(idSite);
	}

	
	
	/**
	 * @see SecteurManager#checkOrientation(int)
	 */
	@Override
	public List<String> checkOrientation(int idSite) throws Exception {

		return this.getDaoFactory().getSecteurDao().checkOrientation(idSite);
	}

}
