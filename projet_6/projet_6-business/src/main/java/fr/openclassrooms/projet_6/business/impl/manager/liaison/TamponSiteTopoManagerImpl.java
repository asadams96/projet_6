package fr.openclassrooms.projet_6.business.impl.manager.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponSiteTopoManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;



/**
 * <p>Implémentation de l'interface 'TamponSiteTopoManager'</p>
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
public class TamponSiteTopoManagerImpl extends AbstractManager implements TamponSiteTopoManager {

	
	
	/**
	 * @see TamponSiteTopoManager#getTamponByTopo(String)
	 * @see TamponSiteTopo
	 * @see Site
	 * @see Topo
	 */
	@Override
	public List<TamponSiteTopo> getTamponByTopo(String idTopo) throws Exception {
		
		return this.getDaoFactory().getTamponSiteTopoDao().getTamponByTopo(idTopo);
	}

	
	
	/**
	 * @see TamponSiteTopoManager#getTamponBySite(int)
	 * @see TamponSiteTopo
	 * @see Site
	 * @see Topo
	 */
	@Override
	public List<TamponSiteTopo> getTamponBySite(int idSite) throws Exception {

		return this.getDaoFactory().getTamponSiteTopoDao().getTamponBySite(idSite);
	}

}
