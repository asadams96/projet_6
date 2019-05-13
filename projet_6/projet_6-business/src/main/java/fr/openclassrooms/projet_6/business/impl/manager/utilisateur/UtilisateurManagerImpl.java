package fr.openclassrooms.projet_6.business.impl.manager.utilisateur;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;


/**
 * <p>Implémentation de l'interface 'UtilisateurManager'</p>
 * <p>Dédié au traitement métier de la classe 'Utilisateur'</p>
 * 
 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
 * @see UtilisateurManager#addUtilisateur(Utilisateur)
 * @see UtilisateurManager#getUtilisateur(int)
 * @see UtilisateurManager#getIdbyMail(String)
 * @see UtilisateurManager#getCheckMail(String)
 * @see UtilisateurManager#getCheckUtilisateur(String)
 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
 * @see UtilisateurManager#setMailById(String, String)
 * @see UtilisateurManager#setPseudoById(String, String)
 * @see UtilisateurManager#setLocalisationById(String, String)
 * @see UtilisateurManager#setPassById(String, String, String)
 * @see UtilisateurManagerImpl#getCheckCoupleIdPass(Utilisateur)
 * @see UtilisateurManagerImplImpl#addUtilisateur(Utilisateur)
 * @see UtilisateurManagerImplImpl#getUtilisateur(int)
 * @see UtilisateurManagerImplImpl#getIdbyMail(String)
 * @see UtilisateurManagerImplImpl#getCheckMail(String)
 * @see UtilisateurManagerImplImpl#getCheckUtilisateur(String)
 * @see UtilisateurManagerImplImpl#getCheckUtilisateur(Utilisateur)
 * @see UtilisateurManagerImplImpl#setMailById(String, String)
 * @see UtilisateurManagerImplImpl#setPseudoById(String, String)
 * @see UtilisateurManagerImplImpl#setLocalisationById(String, String)
 * @see UtilisateurManagerImplImpl#setPassById(String, String, String)
 * @see ManagerFactory#getUtilisateurManager()
 * @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
 * @see ManagerFactoryImpl#getUtilisateurManager()
 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
 * @see Utilisateur
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	
	
	/**
	 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckCoupleIdPass(Utilisateur utilisateur) throws Exception {
		
		Boolean vResult = false;

		String pass = getDaoFactory().getUtilisateurDao().getPass(utilisateur.getIdUtilisateur());

		if(pass.equals(utilisateur.getPass())) {

			vResult = true;
		}
		return vResult;
	}



	/**
	 * @see UtilisateurManager#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean addUtilisateur(Utilisateur utilisateur) throws Exception {
		
		Boolean vResult = false;
				
		if(this.getDaoFactory().getUtilisateurDao().addUtilisateur(utilisateur)) {
			vResult = true;
		}
			
		return vResult;
	}
	
	
	
	/**
	 * @see UtilisateurManager#getUtilisateur(int)
	 * @see Utilisateur
	 */
	@Override
	public Utilisateur getUtilisateur(int idUtilisateur) throws Exception {

		Utilisateur utilisateur = this.getDaoFactory().getUtilisateurDao().getUtilisateur(idUtilisateur);
			
		return utilisateur;
	}



	/**
	 * @see UtilisateurManager#getIdbyMail(String)
	 * @see Utilisateur
	 */
	@Override
	public String getIdbyMail(String mail) throws Exception {
		
		String idUtilisateur = this.getDaoFactory().getUtilisateurDao().getIdByMail(mail);

		return idUtilisateur;
	}



	/**
	 * @see UtilisateurManager#getCheckMail(String)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckMail(String mail) throws Exception {
		
		Boolean vResult = false;
		
		int count = this.getDaoFactory().getUtilisateurDao().getCountMail(mail);
			
		if(count == 0) {
			vResult = true;
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckUtilisateur(Utilisateur utilisateur) throws Exception {
		
		Boolean vResult = false;
			
		Utilisateur utilisateurBis = this.getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateur.getIdUtilisateur());
				
		if(utilisateurBis != null
					&& utilisateur.getMail().equals(utilisateurBis.getMail())
					&& utilisateur.getPseudo().equals(utilisateurBis.getPseudo())
					&& utilisateur.getCivilite().equals(utilisateurBis.getCivilite())
					&& utilisateur.getNom().equals(utilisateurBis.getNom())
					&& utilisateur.getPrenom().equals(utilisateurBis.getPrenom())
					&& utilisateur.getLocalisation().equals(utilisateurBis.getLocalisation())) {
					
			vResult = true;
			}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#getCheckUtilisateur(String)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckUtilisateur(String idUtilisateur) throws Exception {
		
		Boolean vResult = false;
		
		int count = this.getDaoFactory().getUtilisateurDao().getCountId(idUtilisateur);

		if(count == 1) {
			vResult = true;
		}
				
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setMailById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setMailById(String idUtilisateur, String mail) throws Exception {
		
		Boolean vResult = false ;
		
		if(this.getDaoFactory().getUtilisateurDao().setMailById(idUtilisateur, mail)) {

			vResult = true;
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception {
		
		Boolean vResult = false ;
					
		if(this.getDaoFactory().getUtilisateurDao().setPseudoById(idUtilisateur, pseudo)) {
				
			vResult = true;
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception {
		
		Boolean vResult = false ;
	
		if(this.getDaoFactory().getUtilisateurDao().setLocalisationById(idUtilisateur, localisation)) {
				
			vResult = true;
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception {
		
		Boolean vResult = false ;
			
		if(this.getDaoFactory().getUtilisateurDao().setPassById(idUtilisateur, pass, passBis)) {
				
			vResult = true;
		}
				
		return vResult;
	}
}
