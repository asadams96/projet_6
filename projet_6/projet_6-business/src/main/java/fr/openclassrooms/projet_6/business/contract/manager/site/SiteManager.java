package fr.openclassrooms.projet_6.business.contract.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SecteurManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SiteManagerImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SecteurDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SiteDaoImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Site'</p>
 * 
 * @see SiteManagerImpl#getList(String)
 * @see SiteManagerImpl#getList(String, String, String)
 * @see SiteManagerImpl#getSite(String)
 * @see SiteManagerImpl#getCheckSite(String)
 * @see SiteManagerImpl#checkLocalisation(int)
 * @see SiteManagerImpl#getIdsSiteByLocalisation(String)
 * @see SiteManager#getList(String)
 * @see SiteManager#getList(String, String, String)
 * @see SiteManager#getSite(String)
 * @see SiteManager#checkLocalisation(int)
 * @see SiteManager#getIdsSiteByLocalisation(String)
 * @see SiteManager#getCheckSite(String)
 * @see ManagerFactory#getSiteManager()
 * @see ManagerFactory#setSiteManager(SiteManager)
 * @see ManagerFactoryImpl#getSiteManager()
 * @see ManagerFactoryImpl#setSiteManager(SiteManager)
 * @see Site
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface SiteManager {

	
	
	/**
	 * <p>Récupère à partir d'un identifiant de topo, la liste des sites qui lui sont associés</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @return Une liste d'instance de la classe 'Site'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#getList(String)
	 * @see Site
	 */
	List<Site> getList(String idTopo) throws Exception;
	
	
	
	/**
	 * <p>
	 * 	Verifie la validité des critères puis récupère la liste des sites associés à ces critères
	 * </p>
	 * <p>Les critères peuvent être vide, dans ce cas, tous les sites sont directement récupéré</p>
	 * 
	 * @param critereType Un critère de type
	 * @param critereOrientation Un critère d'orientation
	 * @param critereLocalisation Un critère de localisation
	 * @return Une liste d'instance de la classe Site
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#getList(String, String, String)
	 * @see Site
	 */
	List<Site> getList(String critereType, String critereOrientation, String critereLocalisation) throws Exception;

	
	
	/**
	 * <p>Transmet l'identifiant du site à la couche du dessous puis récupère une instance de la classe Site</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une instance de la classe 'Site'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#getSite(String)
	 * @see Site
	 */
	Site getSite(String idSite) throws Exception;

	
	
	/**
	 * <p>Vérifie qu'un site existe bien<p>
	 * <p>A besoin de getSite(String idSite) pour fonctionner</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#getCheckSite(String)
	 * @see SiteManagerImpl#getSite(String)
	 * @see SiteManager#getSite(String)
	 */
	boolean getCheckSite(String idSite) throws Exception;



	/**
	 * <p>Récupère la localisation du site correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idSite un identifiant de site
	 * @return Une localisation
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#checkLocalisation(int)
	 */
	String checkLocalisation(int idSite) throws Exception;


	
	/**
	 * <p>Récupère la liste des identifiant de site ayant la localisation passé en paramètre</p>
	 * 
	 * @param critereLocalisation Un critère de localisation
	 * @return Une liste d'identifiant de site
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteManagerImpl#getIdsSiteByLocalisation(String)
	 */
	List<Integer> getIdsSiteByLocalisation(String critereLocalisation) throws Exception;

}
