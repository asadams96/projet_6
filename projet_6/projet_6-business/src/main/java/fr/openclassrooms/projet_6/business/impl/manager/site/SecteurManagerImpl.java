package fr.openclassrooms.projet_6.business.impl.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.site.SecteurManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;



/**
 * <p>Implémentation de l'interface 'SecteurManager'</p>
 * <p>Dédié au traitement métier de la classe 'Secteur'</p>
 * 
 * @see SecteurManagerImpl#getList(String)
 * @see SecteurManager#getList(String)
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

		List<Secteur> listSecteur = null;
		
		if(idSite != null && !idSite.isEmpty()) {
			listSecteur = this.getDaoFactory().getSecteurDao().getList(idSite);
		}

		return listSecteur;
	}

}
