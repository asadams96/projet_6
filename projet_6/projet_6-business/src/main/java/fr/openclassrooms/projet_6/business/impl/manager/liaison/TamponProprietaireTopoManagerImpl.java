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
 * @see TamponProprietaireTopoManager#getBibliotheque(int)
 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int)
 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
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
	 * @see TamponProprietaireTopoManager#getBibliotheque(int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public List<TamponProprietaireTopo> getBibliotheque(int idUtilisateur) throws Exception {
		
		List<TamponProprietaireTopo> listTampons = null;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			List<TamponProprietaireTopo> tampons = this.getDaoFactory().getTamponProprietaireTopoDao().getTamponByUser(idUtilisateur);
			
			if(!tampons.isEmpty()) {
				listTampons = new ArrayList<TamponProprietaireTopo>();
				
				for(TamponProprietaireTopo tampon : tampons) {
					
					if(tampon.getQuantite() != 0) {
						
						TamponProprietaireTopo tamponBis = new TamponProprietaireTopo();
						
						tamponBis.setProprietaire(this.getDaoFactory().getUtilisateurDao().getUtilisateur(tampon.getProprietaire().getIdUtilisateur()));
						tamponBis.setTopo(this.getDaoFactory().getTopoDao().getTopo(String.valueOf(tampon.getTopo().getIdTopo())));
						tamponBis.setQuantite(tampon.getQuantite());
						
						listTampons.add(tamponBis);
					}
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
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
								&& String.valueOf(quantite) != null && !String.valueOf(quantite).isEmpty() && quantite > 0
																							&& idTopo != null && !idTopo.isEmpty()) {
			if(this.getDaoFactory().getTopoDao().getTopo(idTopo) != null) {
				
				if(this.getDaoFactory().getTamponProprietaireTopoDao().addTampon(idUtilisateur, idTopo, quantite)) {
					vResult = true;
				}
			}
		}
		return vResult;
	}

	
	
	/**
	 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
	 * @see TamponProprietaireTopoManagerImpl#getCheckQuantity(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public boolean removeTampon(int idUtilisateur, String idTopo, int quantite) throws Exception {
		
		Boolean vResult = false;
		
		if(this.getCheckQuantity(idUtilisateur, idTopo, quantite)) {
			
			int quantiteDispo = this.getDaoFactory().getTamponProprietaireTopoDao().getQuantity(idUtilisateur, idTopo);
			
			if(this.getDaoFactory().getTamponProprietaireTopoDao().removeTampon(idUtilisateur, idTopo, quantite, quantiteDispo)) {
				vResult = true;
				
			}
		}
		
		return vResult;
		
	}

	/**
	 *<p>
	 *	Méthode interne dédié à vérifier la quantité d'un topo posséder 
	 *	par	l'utilisateur de façon a vérifier qu'il puisse bien retirer
	 *</p>
	 *
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantite de topo a supprimé
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la méthode du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
	 */
	public boolean getCheckQuantity(int idUtilisateur, String idTopo, int quantite) throws Exception {
		
		Boolean vResult = false;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
				&& String.valueOf(quantite) != null && !String.valueOf(quantite).isEmpty() && quantite > 0
																				&& idTopo != null && !idTopo.isEmpty()) {
			
			int quantiteDispo = this.getDaoFactory().getTamponProprietaireTopoDao().getQuantity(idUtilisateur, idTopo);
			
			if(quantiteDispo >= quantite && quantiteDispo != 0) {
				vResult = true;
			}
		}
		return vResult;
	}

}
