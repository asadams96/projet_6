package fr.openclassrooms.projet_6.business.impl.manager.liaison;

import java.util.ArrayList;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponProprietaireTopoManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;



/**
 * <p>Implémentation de l'interface 'TamponProprietaireManager'</p>
 * <p>Dédié au traitement métier de la classe 'TamponProprietaireTopo'</p>
 * 
 * 
 * @see TamponProprietaireTopoManager#getList(String, String)
 * @see TamponProprietaireTopoManager#getCheckQuantity(int, String, int)
 * @see TamponProprietaireTopoManager#getBibliotheque(int)
 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int)
 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getList(String, String)
 * @see TamponProprietaireTopoManagerImpl#getCheckQuantity(int, String, int)
 * @see ManagerFactory#getTamponProprietaireTopoManager()
 * @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 * @see TamponProprietaireTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponProprietaireTopoManagerImpl extends AbstractManager implements TamponProprietaireTopoManager {

	
	
	/**
	 * @see TamponProprietaireTopoManager#getBibliotheque(int, String, String)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public List<TamponProprietaireTopo> getBibliotheque(int idUtilisateur, String etat1, String etat2) throws Exception {
		
		List<TamponProprietaireTopo> listTampons = null;
		
			
		List<TamponProprietaireTopo> tampons = this.getDaoFactory().getTamponProprietaireTopoDao().getTamponByUser(idUtilisateur);
			
		if(!tampons.isEmpty()) {
			listTampons = new ArrayList<TamponProprietaireTopo>();
				
			for(TamponProprietaireTopo tampon : tampons) {
				
				TamponProprietaireTopo tamponBis = new TamponProprietaireTopo();
				
				tamponBis.setProprietaire(this.getManagerFactory().getUtilisateurManager().getUtilisateur(tampon.getProprietaire().getIdUtilisateur()));
				tamponBis.setTopo(this.getManagerFactory().getTopoManager().getTopo(String.valueOf(tampon.getTopo().getIdTopo())));
				tamponBis.setQuantitePrete(this.getManagerFactory().getPretManager().getCountPret(idUtilisateur, tamponBis.getTopo().getIdTopo(), etat1, etat2 ));
				tamponBis.setQuantite(tampon.getQuantite()+tamponBis.getQuantitePrete());
				
				if(tamponBis.getQuantite() != 0) {
						
					
					
						
					listTampons.add(tamponBis);
				}
			}
		}	
		
		return listTampons;
	}

	
	
	/**
	 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public Boolean addTampon(int idUtilisateur, String idTopo, int quantite) throws Exception {
		
		Boolean vResult = false;
		
		if(this.getManagerFactory().getTopoManager().getTopo(idTopo) != null) {
	
			if(this.getDaoFactory().getTamponProprietaireTopoDao().addTampon(idUtilisateur, idTopo, quantite)) {
				vResult = true;
			}
		}
		
		return vResult;
	}

	
	
	/**
	 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public boolean removeTampon(int idUtilisateur, String idTopo, int quantite) throws Exception {
		
		Boolean vResult = false;
					
		int quantiteDispo = this.getDaoFactory().getTamponProprietaireTopoDao().getQuantity(idUtilisateur, idTopo);
			
		if(this.getDaoFactory().getTamponProprietaireTopoDao().removeTampon(idUtilisateur, idTopo, quantite, quantiteDispo)) {
				vResult = true;
				
		}
		return vResult;
		
	}

	
	
	/**
	 * @see TamponProprietaireTopoManager#getCheckQuantity(int, String, int)
	 */
	@Override
	public boolean getCheckQuantity(int idUtilisateur, String idTopo, int quantite) throws Exception {
		
		Boolean vResult = false;
					
		int quantiteDispo = this.getDaoFactory().getTamponProprietaireTopoDao().getQuantity(idUtilisateur, idTopo);
			
		if(quantiteDispo >= quantite && quantiteDispo != 0) {
			vResult = true;
		}
		return vResult;
	}



	/**
	 * @see TamponProprietaireTopoManager#getList(String, String)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public List<TamponProprietaireTopo> getList(String idTopo, String idUtilisateur) throws Exception {
		
		List<TamponProprietaireTopo> listTamponProprietaireTopo = null;
			
		List<TamponProprietaireTopo> listTamponProprietaireTopoProvisoire = this.getDaoFactory().getTamponProprietaireTopoDao().getList(idTopo);
			
		if(listTamponProprietaireTopoProvisoire != null && !listTamponProprietaireTopoProvisoire.isEmpty()) {
			listTamponProprietaireTopo = new ArrayList<TamponProprietaireTopo>();

			for(TamponProprietaireTopo tampon : listTamponProprietaireTopoProvisoire) {
				if(tampon.getQuantite() > 0 && !String.valueOf(tampon.getProprietaire().getIdUtilisateur()).equals(idUtilisateur)) {
						
					tampon.setProprietaire(this.getManagerFactory().getUtilisateurManager().getUtilisateur(tampon.getProprietaire().getIdUtilisateur()));
					tampon.setTopo(this.getManagerFactory().getTopoManager().getTopo(String.valueOf(tampon.getTopo().getIdTopo())));
					listTamponProprietaireTopo.add(tampon);
				}
			}
		}
				
		return listTamponProprietaireTopo;
	}

}
