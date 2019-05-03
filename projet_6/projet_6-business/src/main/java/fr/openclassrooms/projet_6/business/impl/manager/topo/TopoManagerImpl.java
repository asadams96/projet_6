package fr.openclassrooms.projet_6.business.impl.manager.topo;

import java.util.ArrayList;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.topo.TopoManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.topo.Topo;



/**
 * <p>Implémentation de l'interface 'TopoManager'</p>
 * <p>Dédié au traitement métier de la classe 'Topo'</p>
 * 
 * @see TopoManager#getTopo(String)
 * @see TopoManager#getCheckTopo(String)
 * @see TopoManager#getList(String, String, String)
 * @see TopoManagerImpl#getTopo(String)
 * @see TopoManagerImpl#getCheckTopo(String)
 * @see TopoManagerImpl#getList(String, String, String)
 * @see ManagerFactory#getTopoManager()
 * @see ManagerFactory#setTopoManager(TopoManager)
 * @see ManagerFactoryImpl#getTopoManager()
 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
 * @see Topo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TopoManagerImpl extends AbstractManager implements TopoManager {

	
	
	/**
	 * @see TopoManager#getList(String, String, String)
	 * @see Topo
	 */
	@Override
	public List<Topo> getList(String critereType, String critereOrientation, String critereLocalisation) throws Exception {
		
		/*
		 * Voir dernière condition avant le return
		 */
		List<Topo> listTopo = null;
		
		
		/*
		 * Récupération des IDs de site correspondant aux critères de recherche
		 */
		List<Integer> listIdsSiteProvisoire = new ArrayList<Integer>();
		List<Integer> listIdsSite = new ArrayList<Integer>();
		
		// Si au moins un critère est saisi, on l'instancie sinon list par défaut de tous les topo (dernier condition avant return)
		if((critereType != null && !critereType.isEmpty()) || 
				(critereOrientation != null && !critereOrientation.isEmpty()) || 
					(critereLocalisation != null && !critereLocalisation.isEmpty())) {
			listTopo = new ArrayList<Topo>();
		}
		
		if(critereType != null && !critereType.isEmpty()) {
			
				listIdsSite = this.getDaoFactory().getSecteurDao().getIdsSiteByType(critereType);	
				
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
		if(critereLocalisation != null && !critereLocalisation.isEmpty() && listIdsSite != null) {

				listIdsSiteProvisoire = this.getDaoFactory().getSiteDao().getIdsSiteByLocalisation(critereLocalisation);	
				
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
		 * => Récupéraion des ids de Topos correspondant à ces sites.
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
			
			List<Integer> listIdsTopoProvisoir = new ArrayList<Integer>();
			List<Integer> listIdsTopo = new ArrayList<Integer>();
				
			for(int idSite : newListIdsSite) {
				listIdsTopoProvisoir = this.getDaoFactory().getTamponSiteTopoDao().getTamponBySite(idSite);
					
				for(int idTopo : listIdsTopoProvisoir) {
					if(!listIdsTopo.contains(idTopo)) {
						listIdsTopo.add(idTopo);
					}
				}
			}
			
			/*
			 * Si des ids de topo ont été récupéré 
			 * => Récupération des topos correspondant aux ids
			 * 
			 * Sinon => Voir derniere condition avant le return
			 */
			if(!listIdsTopo.isEmpty()) {
				listTopo = new ArrayList<Topo>();
					
				for(int idTopo : listIdsTopo) {
					listTopo.add(this.getDaoFactory().getTopoDao().getTopo(String.valueOf(idTopo)));
				}
			}
		}
		
		/*
		 * Dernière condition avant le return =>
		 * Si => listTopo n'a pas rempli les condition est est null 
		 * => Valeur par défaut (renvoi tous les topos)
		 * 
		 * Sinon => le return n'est pas modifié
		 */
		if(listTopo == null) {
			listTopo = this.getDaoFactory().getTopoDao().getList();
		}
		
		return listTopo;
	}

	
	
	/**
	 * @see TopoManager#getTopo(String)
	 * @see Topo
	 */
	@Override
	public Topo getTopo(String idTopo) throws Exception {
		
		Topo topo = null;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			
			topo = this.getDaoFactory().getTopoDao().getTopo(idTopo);
		}
		
		return topo;
	}

	
	
	/**
	 * @see TopoManager#getCheckTopo(String)
	 * @see TopoManager#getTopo(String)
	 * @see TopoManagerImpl#getTopo(String)
	 */
	@Override
	public boolean getCheckTopo(String idTopo) throws Exception {
		
		Boolean vResult = false;
		
		Topo topo = this.getTopo(idTopo);
		
		if(topo != null) {
			vResult = true;
		}
		return vResult;
	}

}
