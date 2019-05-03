package fr.openclassrooms.projet_6.business.contract.manager.utilisateur;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.utilisateur.UtilisateurManagerImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Interface de la couche manager</p>
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
public interface UtilisateurManager {

	
	
	/**
	 * <p>Verifie que l'identifiant et le mot de passe de l'utilisateur correspondent bien</p>
	 * 
	 * @param utilisateur L'utilisateur 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getCheckCoupleIdPass(Utilisateur)
	 * @see Utilisateur
	 */
	boolean getCheckCoupleIdPass(Utilisateur utilisateur) throws Exception;

}
