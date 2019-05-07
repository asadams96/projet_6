package fr.openclassrooms.projet_6.consumer.contract.dao.utilisateur;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Utilisateur</p>
 * 
 * @see UtilisateurDao#getPass(int)
 * @see UtilisateurDao#getUtilisateur(int)
 * @see UtilisateurDao#addUtilisateur(Utilisateur)
 * @see UtilisateurDao#getIdByMail(String)
 * @see UtilisateurDao#getCountMail(String)
 * @see UtilisateurDao#getCountId(String)
 * @see UtilisateurDao#setMailById(String, String)
 * @see UtilisateurDao#setPseudoById(String, String)
 * @see UtilisateurDao#setLocalisationById(String, String)
 * @see UtilisateurDao#setPassById(String, String, String)
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
 * @see UtilisateurDaoImpl#getIdByMail(String)
 * @see UtilisateurDaoImpl#getCountMail(String)
 * @see UtilisateurDaoImpl#getCountId(String)
 * @see UtilisateurDaoImpl#setMailById(String, String)
 * @see UtilisateurDaoImpl#setPseudoById(String, String)
 * @see UtilisateurDaoImpl#setLocalisationById(String, String)
 * @see UtilisateurDaoImpl#setPassById(String, String, String)
 * @see DaoFactory#getUtilisateurDao()
 * @see DaoFactory#setUtilisateurDao(UtilisateurDao)
 * @see DaoFactoryImpl#getUtilisateurDao()
 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
 * @see Utilisateur
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface UtilisateurDao {

	
	
	/**
	 * <p>Récupère  le mot de passe de l'utilisateur correspondant à l'idUtilisateur en paramètre de méthode</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur 
	 * @return Le mot de passe de l'utilisateur
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#getPass(int)
	 * @see Utilisateur
	 */
	String getPass(int idUtilisateur) throws Exception;

	
	
	/**
	 * <p>Retourne l'utilisateur correspondant au paramètre de méthode idTutilisateur</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @return Une instance de la classe 'Utilisateur'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#getUtilisateur(int)
	 * @see Utilisateur
	 */
	Utilisateur getUtilisateur(int idUtilisateur) throws Exception;



	/**
	 * <p>Enregistre un utilisateur</p>
	 * 
	 * @param utilisateur L'instance de la classe 'Utilisateur' représentant l'utilisateur à enregistrer
	 * @return Un boolean informant, en fonction de son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	boolean addUtilisateur(Utilisateur utilisateur) throws Exception;


	
	/**
	 * <p>Récupère l'identifiant d'un utilisateurà partir de son adresse mail</p>
	 * 
	 * @param mail L'adresse mail de l'utilisateur
	 * @return L'identifiant associé à l'adresse mail
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#getIdByMail(String)
	 * @see Utilisateur
	 */
	String getIdByMail(String mail) throws Exception;



	/**
	 * <p>Retourne le nombre d'utilisateur ayant l'adresse mail passé en paramètre</p>
	 * 
	 * @param mail L'adresse mail à compter
	 * @return Un entier informant sur le nombre d'utilisateur possédant l'adresse mail passé en paramètre
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#getCountMail(String)
	 * @see Utilisateur
	 */
	int getCountMail(String mail) throws Exception;



	/**
	 * <p>Retourne le nombre d'utilisateur ayant l'identifiant passé en paramètre</p>
	 * 
	 * @param idUtilisateur L'identifiant à compter
	 * @return Un entier informant sur le nombre d'utilisateur possédant l'identifiant passé en paramètre
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#getCountId(String)
	 * @see Utilisateur
	 */
	int getCountId(String idUtilisateur) throws Exception;


	
	/**
	 * <p>Met à jour l'adresse mail de l'utilisateur correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param mail La nouvelle adresse mail
	 * @return Un boolean informant, en fonction de son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#setMailById(String, String)
	 * @see Utilisateur
	 */
	boolean setMailById(String idUtilisateur, String mail) throws Exception;



	/**
	 * <p>Met à jour le pseudo de l'utilisateur correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param pseudo Le nouveau pseudo
	 * @return Un boolean informant, en fonction de son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception;



	/**
	 * <p>Met à jour la localisation de l'utilisateur correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param localisation La nouvelle localisation
	 * @return Un boolean informant, en fonction de son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception;



	/**
	 * <p>Met à jour le mot de passe de l'utilisateur correspondant à l'identifiant passé en paramètre</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur
	 * @param pass La nouveau mot de passe
	 * @param passBis La confirmation du mot de passe
	 * @return Un boolean informant, en fonction de son état, sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see UtilisateurDaoImpl#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception;
	
}
