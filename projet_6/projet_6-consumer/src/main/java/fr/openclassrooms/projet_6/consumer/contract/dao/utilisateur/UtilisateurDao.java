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
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
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

}
