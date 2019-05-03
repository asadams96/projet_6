package fr.openclassrooms.projet_6.business.contract.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SiteManagerImpl;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Site'</p>
 * 
 * 
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


}
