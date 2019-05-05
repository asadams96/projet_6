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
 * @see SiteManagerImpl#getList(String)
 * @see SiteManagerImpl#getList(String, String, String)
 * @see SiteManagerImpl#getSite(String)
 * @see SiteManagerImpl#getCheckSite(String)
 * @see SiteManager#getList(String)
 * @see SiteManager#getList(String, String, String)
 * @see SiteManager#getSite(String)
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

	
	
	/**
	 * @see SiteManager#getList(String, String, String)
	 * @see Site
	 */
	@Override
	public List<Site> getList(String critereType, String critereOrientation, String critereLocalisation) throws Exception {
		
		/*
		 * Voir dernière condition avant le return
		 */
		List<Site> listSite = null;
		
		
		/*
		 * Récupération des IDs de site correspondant aux critères de recherche
		 */
		List<Integer> listIdsSiteProvisoire = new ArrayList<Integer>();
		List<Integer> listIdsSite = new ArrayList<Integer>();
		
		// Si au moins un critère est saisi, on l'instancie sinon list par défaut de tous les sites (dernier condition avant return)
		if((critereType != null && !critereType.isEmpty()) || 
				(critereOrientation != null && !critereOrientation.isEmpty()) || 
					(critereLocalisation != null && !critereLocalisation.isEmpty())) {
			listSite = new ArrayList<Site>();
		}
		
		if(critereLocalisation != null && !critereLocalisation.isEmpty()) {
			
				listIdsSite = this.getDaoFactory().getSiteDao().getIdsSiteByLocalisation(critereLocalisation);
				
				
		}
		if(critereOrientation != null && !critereOrientation.isEmpty() && listIdsSite != null) {
			
				listIdsSiteProvisoire = this.getDaoFactory().getSecteurDao().getIdsSiteByOrientation(critereOrientation);	
				
				if(listIdsSiteProvisoire != null) {
					for(int idSite : listIdsSiteProvisoire) {
						if(!listIdsSite.contains(idSite)) {
							listIdsSite.add(idSite);
						}
					}
				}
		}
		if(critereType != null && !critereType.isEmpty() && listIdsSite != null) {

				listIdsSiteProvisoire = this.getDaoFactory().getSecteurDao().getIdsSiteByType(critereType);	
				
				if(listIdsSiteProvisoire != null) {
					for(int idSite : listIdsSiteProvisoire) {
						if(!listIdsSite.contains(idSite)) {
							listIdsSite.add(idSite);
						}
					}
				}
		}
			
			
		/*
		 * Si des ids de site ont été récupéré et que tous c'est bien passé
		 * => Récupéraion des Sites correspondant à ces identifiants.
		 * 
		 * Sinon => Voir dernière condition avant le return	
		 */
		if(listIdsSite != null && !listIdsSite.isEmpty()) {
			
			List<Integer> newListIdsSite = new ArrayList<Integer>();
			
			for(int idSite : listIdsSite) {
				if((this.getDaoFactory().getSecteurDao().checkType(idSite).contains(critereType) || critereType.isEmpty()) &&
					(this.getDaoFactory().getSecteurDao().checkOrientation(idSite).contains(critereOrientation) || critereOrientation.isEmpty()) &&
						(this.getDaoFactory().getSiteDao().checkLocalisation(idSite).equals(critereLocalisation) || critereLocalisation.isEmpty())) {
				
					newListIdsSite.add(idSite);
				}
			}
					
			for(int idSite : newListIdsSite) {
				listSite.add(this.getDaoFactory().getSiteDao().getSite(idSite));
			}
		}
		
		/*
		 * Dernière condition avant le return =>
		 * Si => listSite n'a pas rempli les condition est est null 
		 * => Valeur par défaut (renvoi tous les sites)
		 * 
		 * Sinon => le return n'est pas modifié
		 */
		if(listSite == null) {
			listSite = this.getDaoFactory().getSiteDao().getList();
		}
		
		return listSite;
	}
	
	
	
	/**
	 * @see SiteManager#getSite(String)
	 * @see Site
	 */
	@Override
	public Site getSite(String idSite) throws Exception {
		
		Site site = null;
		
		if(idSite != null && !idSite.isEmpty()) {
			
			site = this.getDaoFactory().getSiteDao().getSite(Integer.valueOf(idSite));
		}
		
		return site;
	}

	
	
	/**
	 * @see SiteManager#getCheckSite(String)
	 * @see SiteManager#getSite(String)
	 * @see SiteManagerImpl#getSite(String)
	 */
	@Override
	public boolean getCheckSite(String idSite) throws Exception {
		
		Boolean vResult = false;
		
		Site site = this.getSite(idSite);
		
		if(site != null) {
			vResult = true;
		}
		return vResult;
	}
}
