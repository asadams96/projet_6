package fr.openclassrooms.projet_6.business.impl.manager.utilisateur;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;


/**
 * <p>Implémentation de l'interface 'UtilisateurManager'</p>
 * <p>Dédié au traitement métier de la classe 'Utilisateur'</p>
 * 
 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
 * @see UtilisateurManagerImpl#getCheckCoupleIdPass(Utilisateur)
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
		
		if(utilisateur != null 
				&& utilisateur.getPass() != null && !utilisateur.getPass().isEmpty()
				&&  String.valueOf(utilisateur.getIdUtilisateur()) != null && !String.valueOf(utilisateur.getIdUtilisateur()).isEmpty()) {
			
			String pass = getDaoFactory().getUtilisateurDao().getPass(utilisateur.getIdUtilisateur());
			
			if(pass.equals(utilisateur.getPass())) {
				vResult = true;
			}
		}
		
		return vResult;
	}

}
