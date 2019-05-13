package fr.openclassrooms.projet_6.business.impl.manager.pret;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.pret.PretManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>Implémentation de l'interface 'PretManager'</p>
 * <p>Dédié au traitement métier de la classe 'Pret'</p>
 * 
 * 
 * @see PretManager#getListPret(Utilisateur, String)
 * @see PretManager#getListPret(Utilisateur, String, String)
 * @see PretManager#getPret(Utilisateur, String)
 * @see PretManager#getCheckPret(String)
 * @see PretManager#ask(String, String, String, String, String)
 * @see PretManager#cancel(Pret, String, String, String, String)
 * @see PretManager#finish(Pret, String, String, String, String)
 * @see PretManager#decide(Pret, String, String, String, String, String)
 * @see PretManagerImpl#getListPret(Utilisateur, String)
 * @see PretManagerImpl#getListPret(Utilisateur, String, String)
 * @see PretManagerImpl#getPret(Utilisateur, String)
 * @see PretManagerImpl#getCheckPret(String)
 * @see PretManagerImpl#ask(String, String, String, String, String)
 * @see PretManagerImpl#cancel(Pret, String, String, String, String)
 * @see PretManagerImpl#finish(Pret, String, String, String, String)
 * @see PretManagerImpl#decide(Pret, String, String, String, String, String)
 * @see PretManagerImpl#getEtat(String)
 * @see ManagerFactory#getPretManager()
 * @see ManagerFactory#setPretManager(PretManager)
 * @see ManagerFactoryImpl#getPretManager()
 * @see ManagerFactoryImpl#setPretManager(PretManager)
 * @see Pret
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class PretManagerImpl extends AbstractManager implements PretManager {

	
	
	/**
	 * @see PretManager#getListPret(Utilisateur, String)
	 * @see Pret
	 */
	@Override
	public List<Pret> getListPret(Utilisateur utilisateur, String type) throws Exception {
						
		List <Pret> listPret = this.getDaoFactory().getPretDao().getListPret(String.valueOf(utilisateur.getIdUtilisateur()), type);

		if(listPret != null && !listPret.isEmpty()) {
				
			for(Pret pret : listPret) {
				pret.setTopo(this.getManagerFactory().getTopoManager().getTopo(String.valueOf(pret.getTopo().getIdTopo())));
				pret.setUtilisateur(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getUtilisateur().getIdUtilisateur()));
				pret.setProprietaire(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getProprietaire().getIdUtilisateur()));
			}
		}
				
		return listPret;
	}

	
	
	/**
	 * @see PretManager#getListPret(Utilisateur, String, String)
	 * @see Pret
	 */
	@Override
	public List<Pret> getListPret(Utilisateur utilisateur, String etat, String type) throws Exception {
			
		List<Pret> listPret = this.getDaoFactory().getPretDao().getListPret(String.valueOf(utilisateur.getIdUtilisateur()), etat, type);
				
			if(listPret != null && !listPret.isEmpty()) {
					
				for(Pret pret : listPret) {
					pret.setTopo(this.getManagerFactory().getTopoManager().getTopo(String.valueOf(pret.getTopo().getIdTopo())));
					pret.setUtilisateur(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getUtilisateur().getIdUtilisateur()));
					pret.setProprietaire(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getProprietaire().getIdUtilisateur()));
				}		
			}
		
		return listPret;
	}
	
	

	/**
	 * @see PretManager#getPret(Utilisateur, String)
	 * @see Pret
	 */
	@Override
	public Pret getPret(String idPret) throws Exception {
			
		Pret pret = this.getDaoFactory().getPretDao().getPret(idPret);
			
		pret.setTopo(this.getManagerFactory().getTopoManager().getTopo(String.valueOf(pret.getTopo().getIdTopo())));
		pret.setUtilisateur(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getUtilisateur().getIdUtilisateur()));
		pret.setProprietaire(this.getManagerFactory().getUtilisateurManager().getUtilisateur(pret.getProprietaire().getIdUtilisateur()));
				
		return pret;
	}

	
	
	/**
	 * @see PretManager#getCheckPret(String)
	 */
	@Override
	public boolean getCheckPret(String idPret) throws Exception {
		
		Boolean vResult = false;
		
		if(Integer.valueOf(this.getDaoFactory().getPretDao().getCountId(idPret)) == 1) {
				
				vResult = true;
		}
		
		
		return vResult;
	}

	
	
	/**
	 * @see PretManager#decide(Pret, String, String, String, String, String)
	 */
	@Override
	public boolean decide(Pret pret, String etat, String idUtilisateur, String etat1, String etat2, String etat5) throws Exception {
		
		Boolean vResult = false;
		
		if(((etat.equals(etat2) && pret.getProprietaire().getIdUtilisateur() == Integer.valueOf(idUtilisateur)) ||
						(etat.equals(etat5) && pret.getProprietaire().getIdUtilisateur() == Integer.valueOf(idUtilisateur)))) {
			
			
			if(etat.equals(etat2)  && this.getEtat(String.valueOf(pret.getIdPret())).equals(etat1)) {
				if(this.getDaoFactory().getPretDao().updateEtat(pret, etat)) {
					vResult = true;
				}
			}
			
			else if(etat.equals(etat5)  && this.getEtat(String.valueOf(pret.getIdPret())).equals(etat1)) {
				if(this.getManagerFactory().getTamponProprietaireTopoManager().addTampon(Integer.valueOf(pret.getProprietaire().getIdUtilisateur()), String.valueOf(pret.getTopo().getIdTopo()), 1)) {
					if(this.getDaoFactory().getPretDao().updateEtat(pret, etat)) {
						vResult = true;	
					}
				}	
			}
		}
		
		return vResult;
	}

	
	
	/**
	 * @see PretManager#cancel(Pret, String, String, String, String)
	 */
	@Override
	public boolean cancel(Pret pret, String etat, String idUtilisateur, String etat1, String etat4) throws Exception {
		
		Boolean vResult = false;

		if((etat.equals(etat4) && pret.getUtilisateur().getIdUtilisateur() == Integer.valueOf(idUtilisateur) && this.getEtat(String.valueOf(pret.getIdPret())).equals(etat1))) {
			
			
			if(this.getManagerFactory().getTamponProprietaireTopoManager().addTampon(Integer.valueOf(pret.getProprietaire().getIdUtilisateur()), String.valueOf(pret.getTopo().getIdTopo()), 1)) {
				if(this.getDaoFactory().getPretDao().updateEtat(pret, etat)) {
					vResult = true;
				}
			}			
		}
		
		return vResult;
	}

	
	
	/**
	 * @see PretManager#finish(Pret, String, String, String, String)
	 */
	@Override
	public boolean finish(Pret pret, String etat, String idUtilisateur, String etat2, String etat3) throws Exception {
		
		Boolean vResult = false;

		if((etat.equals(etat3) && pret.getProprietaire().getIdUtilisateur() == Integer.valueOf(idUtilisateur)) && this.getEtat(String.valueOf(pret.getIdPret())).equals(etat2)) {
			
			
			if(this.getManagerFactory().getTamponProprietaireTopoManager().addTampon(Integer.valueOf(pret.getProprietaire().getIdUtilisateur()), String.valueOf(pret.getTopo().getIdTopo()), 1)) {
				if(this.getDaoFactory().getPretDao().updateEtat(pret, etat)) {
					vResult = true;
				}
			}
		}
		
		return vResult;
	}

	
	
	/**
	 * <p>Recupère l'état du prêt correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idPret L'identifiant d'un pret
	 * @return L'etat du prêt
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#finish(Pret, String, String, String, String)
	 * @see PretManagerImpl#cancel(Pret, String, String, String, String)
	 * @see PretManagerImpl#decide(Pret, String, String, String, String, String)
	 */
	private String getEtat(String idPret) throws Exception{
	
		String vResult = this.getDaoFactory().getPretDao().getEtat(idPret);
	
		return vResult;
	}

	
	
	/**
	 * @see PretManager#ask(String, String, String, String, String)
	 */
	@Override
	public String ask(String idTopo, String idProprietaire, String idUtilisateur, String contenu, String etat1) throws Exception {
		
		String idPret = null;
		
		Timestamp date = new Timestamp(new Date().getTime());

		if(this.getDaoFactory().getPretDao().insert(date, idTopo, idProprietaire, idUtilisateur,   etat1)) {
			
			if(this.getManagerFactory().getTamponProprietaireTopoManager().removeTampon(Integer.valueOf(idProprietaire), idTopo, 1)) {
				
				String idPretBis = this.getDaoFactory().getPretDao().getIdPret(date, idTopo, idProprietaire, idUtilisateur);


				if(this.getManagerFactory().getMessagePretManager().addMessage(Integer.valueOf(idUtilisateur), idPretBis, contenu)) {
					idPret = idPretBis;
				}		
			}
		}
		
		return idPret;
	}

}
