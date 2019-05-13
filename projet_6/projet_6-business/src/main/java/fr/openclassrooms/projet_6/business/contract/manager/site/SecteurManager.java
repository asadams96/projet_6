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
	List<Secteur> getList(String idSite)  throws Exception;

	
	
	/**
	 * <p>Récupère la liste des identifiant de site ayant un secteur correspondant au critère d'orientation passé en paramètre</p>
	 * 
	 * @param critereOrientation Un critère d'orientation
	 * @return Une liste d'identifiant de site
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SecteurManagerImpl#getIdsSiteByOrientation(String)
	 */
	List<Integer> getIdsSiteByOrientation(String critereOrientation) throws Exception;

		
	
	/**
	 * <p>Récupère la liste des identifiant de site ayant un secteur correspondant au critère de type passé en paramètre</p>
	 * 
	 * @param critereType Un critère de type
	 * @return Une liste d'identifiant de site
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SecteurManagerImpl#getIdsSiteByType(String)
	 */
	List<Integer> getIdsSiteByType(String critereType) throws Exception;

	
	
	/**
	 * <p>Récupère la liste des types du site correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idSite un identifiant de site
	 * @return Un liste de type
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SecteurManagerImpl#checkType(int)
	 */
	List<String> checkType(int idSite) throws Exception;
	
	
	
	/**
	 * <p>Récupère la liste des orientations du site correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idSite un identifiant de site
	 * @return Un liste d'orientation
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SecteurManagerImpl#checkOrientation(int)
	 */
	List<String> checkOrientation(int idSite) throws Exception;

	
	
}
