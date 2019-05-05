package fr.openclassrooms.projet_6.business.contract.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SecteurManagerImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;

/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Secteur'</p>
 * 
 * @see SecteurManager#getList(String)
 * @see SecteurManagerImpl#getList(String)
 * @see ManagerFactory#getSecteurManager()
 * @see ManagerFactory#setSecteurManager(SecteurManager)
 * @see ManagerFactoryImpl#getSecteurManager()
 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
 * @see Secteur
 * @see Site
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface SecteurManager {

	/**
	 * <p>Récupère tous les secteurs appartenant à un site</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Un liste d'instance de la classe 'Secteur'
	 * 
	 * @see SecteurManagerImpl#getList(String)
	 * @see Secteur
	 */
	List<Secteur> getList(String idSite);

}
