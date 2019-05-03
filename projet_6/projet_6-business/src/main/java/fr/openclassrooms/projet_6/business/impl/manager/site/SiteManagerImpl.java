package fr.openclassrooms.projet_6.business.impl.manager.site;

import java.util.ArrayList;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.site.SiteManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>Implémentation de l'interface 'SiteManager'</p>
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
public class SiteManagerImpl extends AbstractManager implements SiteManager {

	
	
	/**
	 * @see SiteManager#getList(String)
	 * @see Site
	 */
	@Override
	public List<Site> getList(String idTopo) throws Exception {
		
		List<Site> listSite = null;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			List<TamponSiteTopo> tampons = this.getDaoFactory().getTamponSiteTopoDao().getTamponByTopo(idTopo);
			
			listSite = new ArrayList<Site>();
			
			for(TamponSiteTopo tampon : tampons) {
				
				listSite.add(this.getDaoFactory().getSiteDao().getSite(tampon.getSite().getIdSite()));
			}
		}
		
		return listSite;
	}

}
