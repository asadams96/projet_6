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

	
	
	/**
	 * <p>Demande l'enregistrement d'un utilisateur</p>
	 * 
	 * @param utilisateur Une instance de la classe 'Utilisateur'
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	boolean addUtilisateur(Utilisateur utilisateur) throws Exception;
	
	
	
	/**
	 * <p>Récupère un utilisateur à partir de son identifiant</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @return Une instance de la classe utilisateur
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getUtilisateur(int)
	 * @see Utilisateur
	 */
	Utilisateur getUtilisateur(int idUtilisateur) throws Exception;
	
	
	
	/**
	 * <p>Récupère l'identifiant d'un utilisateur à partir de son adresse mail</p>
	 * 
	 * @param mail L'adresse mail de l'utilisateur
	 * @return L'identifiant d'un utilisateur
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getIdbyMail(String)
	 * @see Utilisateur
	 */
	String getIdbyMail(String mail) throws Exception;

	
	
	/**
	 * <p>Vérifie si une adresse mail existe</p>
	 * 
	 * @param mail L'adresse mail de l'utilisateur
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getCheckMail(String)
	 * @see Utilisateur
	 */
	boolean getCheckMail(String mail) throws Exception;

	
	
	/**
	 * <p>Vérifie intégralement toutes les informations de l'utilisateur</p>
	 * 
	 * @param utilisateur Une instance de la classe 'Utilisateur'
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getCheckUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	boolean getCheckUtilisateur(Utilisateur utilisateur) throws Exception;

	
	
	/**
	 * <p>Vérifie si une identifiant d'utilisateur existe</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#getCheckUtilisateur(String)
	 * @see Utilisateur
	 */
	boolean getCheckUtilisateur(String idUtilisateur) throws Exception;

	
	
	/**
	 * <p>Demande la mise à jour de l'adresse mail de l'utilisateur ayant pour identifiant le paramètre de méthode 'idUtilisateur'</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param mail La nouvelle adresse mail
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#setMailById(String, String)
	 * @see Utilisateur
	 */
	boolean setMailById(String idUtilisateur, String mail) throws Exception;

	
	
	/**
	 * <p>Demande la mise à jour du pseudo de l'utilisateur ayant pour identifiant le paramètre de méthode 'idUtilisateur'</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param pseudo Le nouveau pseudo
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception;

	
	
	/**
	 * <p>Demande la mise à jour de la localisation de l'utilisateur ayant pour identifiant le paramètre de méthode 'idUtilisateur'</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param localisation La nouvelle localisation
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception;

	
	
	/**
	 * <p>Demande la mise à jour du mot de passe de l'utilisateur ayant pour identifiant le paramètre de méthode 'idUtilisateur'</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param pass Le nouveau mot de passe
	 * @param passBis La confirmation du nouveau mot de passe
	 * @return Un boolean informant, par son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurManagerImpl#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception;

}
