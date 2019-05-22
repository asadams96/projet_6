package fr.openclassrooms.projet_6.consumer.contract.dao.pret;

import java.sql.Timestamp;
import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.pret.PretDaoImpl;
import fr.openclassrooms.projet_6.model.pret.Pret;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Pret</p>
 * 
 * @see PretDaoImpl#getCountId(String)
 * @see PretDaoImpl#getPret(String)
 * @see PretDaoImpl#getListPret(String, String)
 * @see PretDaoImpl#getListPret(String, String, String)
 * @see PretDaoImpl#updateEtat(Pret, String, String)
 * @see PretDaoImpl#getEtat(String)
 * @see PretDaoImpl#insert(Timestamp, String, String, String, String)
 * @see PretDaoImpl#getIdPret(Timestamp, String, String, String)
 * @see PretDaoImpl#getCountPret(int, int, String, String)
 * @see PretDao#getCountId(String)
 * @see PretDao#getPret(String)
 * @see PretDao#getListPret(String, String)
 * @see PretDao#getListPret(String, String, String)
 * @see PretDao#updateEtat(Pret, String, String)
 * @see PretDao#getEtat(String)
 * @see PretDao#insert(Timestamp, String, String, String, String)
 * @see PretDao#getIdPret(Timestamp, String, String, String)
 * @see PretDao#getCountPret(int, int, String, String)
 * @see DaoFactory#getPretDao()
 * @see DaoFactory#setPretDao(PretDao)
 * @see DaoFactoryImpl#getPretDao()
 * @see DaoFactoryImpl#setPretDao(PretDao)
 * @see Pret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface PretDao {

	
	
	/**
	 * <p>Récupère le nombre de prêt portant l'identifiant passé en paramètre </p>
	 * 
	 * @param idPret L'identifiant d'un prêt
	 * 
	 * @return Un String représentant le nombre de pret
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getCountId(String)
	 */
	String getCountId(String idPret) throws Exception;

	
	
	/**
	 * <p>Récupère le pret correspondant à l'identifiant de pret passé en paramètre</p>
	 * 
	 * @param idPret L'identifiant d'un prêt
	 * 
	 * @return Une instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getPret(String)
	 * @see Pret
	 */
	Pret getPret(String idPret) throws Exception;

	
	
	/**
	 * <p>Récupère la liste des prêts / emprunts correspondant aux paramètres</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * @param etat L'etat d'un prêt
	 * @param type Le type d'un prêt
	 * 
	 * @return Une liste d'instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getListPret(String, String, String)
	 * @see Pret
	 */
	List<Pret> getListPret(String idUtilisateur, String etat, String type) throws Exception;
	
	
	
	/**
	 * <p>Récupère la liste des prêts / emprunts correspondant aux paramètres</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * @param type Le type de prêt
	 * 
	 * @return Une liste d'instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getListPret(String, String)
	 * @see Pret
	 */
	List<Pret> getListPret(String idUtilisateur, String type) throws Exception;

	
	
	/**
	 * <p>Met à jour l'état d'un prêt</p>
	 * 
	 * @param pret Une instance de la classe 'Pret'
	 * @param etat Le nouvel etat du pret
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#updateEtat(Pret, String)
	 */
	boolean updateEtat(Pret pret, String etat) throws Exception;

	
	
	/**
	 * <p>Récupère l'état d'un pret correspondant à l'identifiant passé en paramètre</p>
	 *  
	 * @param idPret L'identifiant d'un prêt
	 * 
	 * @return L'etat d'un prêt
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getEtat(String)
	 */
	String getEtat(String idPret) throws Exception;
	
	
	
	/**
	 * <p>Enregistre un nouveau pret</p>
	 * 
	 * @param date La date de création du prêt
	 * @param idTopo L'identifiant d'un topo
	 * @param idProprietaire L'identifiant d'un utilisateur proprietaire
	 * @param idUtilisateur L'identifiant d'un utilisateur emprunteur
	 * @param etat1 L'état du nouveau prêt
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#insert(Timestamp, String, String, String, String)
	 * @see Timestamp
	 */
	boolean insert(Timestamp date, String idTopo, String idProprietaire, String idUtilisateur, String etat1) throws Exception;

	
	
	/**
	 * <p>Récupère l'identifiant d'un prêt, en fonction des paramètres</p>
	 * 
	 * @param date La date de création du prêt
	 * @param idTopo L'identifiant d'un topo
	 * @param idProprietaire L'identifiant d'un utilisateur proprietaire
	 * @param idUtilisateur L'identifiant d'un utilisateur emprunteur
	 * 
	 * @return Un string représentant l'identifiant d'un prêt
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getIdPret(Timestamp, String, String, String)
	 */
	String getIdPret(Timestamp date, String idTopo, String idProprietaire, String idUtilisateur) throws Exception;

	

	/**
	 * <p>Récupère le nombre de pret ayant pour caractéristiques les paramètres passés en méthodes</p>
	 * 
	 * @param idProprietaire L'identifiant du proprietaire du pret
	 * @param idTopo L'identifiant du topo concerné par le pret
	 * @param etat1 Un état de pret désiré
	 * @param etat2  Un état de pret désiré
	 * @return Le nombre de pret répondant aux caractéristiques
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretDaoImpl#getCountPret(int, int, String, String)
	 */
	int getCountPret(int idProprietaire, int idTopo, String etat1, String etat2) throws Exception;

}
