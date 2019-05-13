package fr.openclassrooms.projet_6.business.contract.manager.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponSiteTopoManagerImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'TamponSiteTopo'</p>
 * 
 * 
 * @see TamponSiteTopoManager#getTamponBySite(int)
 * @see TamponSiteTopoManager#getTamponByTopo(String)
 * @see TamponSiteTopoManagerImpl#getTamponBySite(int)
 * @see TamponSiteTopoManagerImpl#getTamponByTopo(String)
 * @see ManagerFactory#getTamponSiteTopoManager()
 * @see ManagerFactory#setTamponSiteTopoManager(TamponSiteTopoManager)
 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
 * @see TamponSiteTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TamponSiteTopoManager {

	
	
	/**
	 * <p>Récupère tous les Sites (et l'objet Topo)  associés à l'identifiant de topo passé en paramètre de méthode </p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @return Une liste d'instance de la classe 'TamponSiteTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponSiteTopoManagerImpl#getTamponByTopo(String)
	 * @see TamponSiteTopo
	 * @see Site
	 * @see Topo
	 */
	List<TamponSiteTopo> getTamponByTopo(String idTopo) throws Exception;

	
	
	/**
	 * <p>Récupère tous les Topos (et l'objet Site)  associés à l'identifiant de site passé en paramètre de méthode </p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une liste d'instance de la classe 'TamponSiteTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponSiteTopoManagerImpl#getTamponBySite(int)
	 * @see TamponSiteTopo
	 * @see Site
	 * @see Topo
	 */
	List<TamponSiteTopo> getTamponBySite(int idSite) throws Exception;

	
	
}
