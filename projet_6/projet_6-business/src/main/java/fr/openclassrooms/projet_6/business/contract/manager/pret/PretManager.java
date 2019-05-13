package fr.openclassrooms.projet_6.business.contract.manager.pret;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.pret.PretManagerImpl;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>Interface de la couche manager</p>
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
 * @see ManagerFactory#getPretManager()
 * @see ManagerFactory#setPretManager(PretManager)
 * @see ManagerFactoryImpl#getPretManager()
 * @see ManagerFactoryImpl#setPretManager(PretManager)
 * @see Pret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface PretManager {

	
	
	/**
	 * <p>Récupère la liste des prêts ou emprunts d'un utilisateur selon l'etat qu'il a choisi</p>
	 * 
	 * @param utilisateur L'utilisateur concerné
	 * @param etat L'etat des prets demandé
	 * @param type Le type de pret demandé
	 * @return Une liste d'instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#getListPret(Utilisateur, String, String)
	 * @see Pret
	 */
	List<Pret> getListPret(Utilisateur utilisateur, String etat, String type) throws Exception;

	
	
	/**
	 * <p>Récupère un prêt via son identifiant</p>
	 * 
	 * @param idPret L'identifiant du pret souhaité
	 * @return Une instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#getPret(Utilisateur, String)
	 * @see Pret
	 */
	Pret getPret(String idPret) throws Exception;

	
	
	/**
	 * <p>Verifie si un prêt existe</p>
	 * 
	 * @param idPret L'identifiant d'un pret
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#getCheckPret(String)
	 */
	boolean getCheckPret(String idPret) throws Exception;

	
	
	/**
	 * <p>Récupère la liste des prêts ou emprunts d'un utilisateur</p>
	 * 
	 * @param utilisateur L'utilisateur concerné
	 * @param type Le type de pret demandé
	 * 
	 * @return Une liste d'instance de la classe 'Pret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#getListPret(Utilisateur, String)
	 * @see Pret
	 */
	List<Pret> getListPret(Utilisateur utilisateur, String type) throws Exception;

	
	
	/**
	 * <p>Demande un prêt, accompagné d'un message de prêt</p>
	 * <p>Il n'est évidemment pas possible de se demander un prêt à soi même</p>
	 * <p>Actuellement, etat1 = Demandé</p>
	 * 
	 * @param idTopo L'identifiant du topo concerné
	 * @param idProprietaire L'identifiant du proprietaire concerné
	 * @param idUtilisateur L'identifiant de l'utilisateur à l'origine de la demande
	 * @param contenu Le contenu du message de pret neccessaire à la demande
	 * @param etat1 L'etat numéro 1, le nouvel état du prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * 
	 * @return L'identifiant du nouveau pret crée
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#ask(String, String, String, String, String)
	 */
	String ask(String idTopo, String idProprietaire, String idUtilisateur, String contenu, String etat1) throws Exception;

	
	
	/**
	 * <p>Annule une demande de prêt</p>
	 * <p>Seulement possible par l'utilisateur à l'origine de la demande de prêt et quand son état est toujours à "Demandé"</p>
	 * <p>Actuellement, etat1 = Demandé / etat4 = Annulé</p>
	 * 
	 * @param pret Le prêt concerné
	 * @param etat L'état actuel du prêt
	 * @param idUtilisateur L'utilisateur à l'origine de l'action
	 * @param etat1 L'état numéro 1, l'état que dois avoir le prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * @param etat4 L'état numéro 4, le nouvel état du prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#cancel(Pret, String, String, String, String)
	 */
	boolean cancel(Pret pret, String etat, String idUtilisateur, String etat1, String etat4) throws Exception;

	
	
	/**
	 * <p>Clôture un prêt</p>
	 * <p>Seulement accessible au proprietaire concerné par le prêt lorque l'état est à "En cours"</p>
	 * <p>Actuellement, etat2 = En cours / etat3 = Terminé</p>
	 * 
	 * @param pret Le prêt concerné
	 * @param etat L'état actuel du prêt
	 * @param idUtilisateur L'utilisateur à l'origine de l'action
	 * @param etat2 L'état numéro 2, l'état que dois avoir le prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * @param etat3 L'état numéro 3, le nouvel état du prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#finish(Pret, String, String, String, String)
	 */
	boolean finish(Pret pret, String etat, String idUtilisateur, String etat2, String etat3) throws Exception;

	
	
	/**
	 * <p>Décide de l'issu d'une demande de prêt</p>
	 * <p>Seulement accessible au proprietaire concerné par le prêt lorque l'état est encore à "Demandé"</p>
	 * <p>Actuellement, etat1 = Demandé / etat2 = En cours / etat5 = Refusé</p>
	 * 
	 * @param pret Le prêt concerné
	 * @param etat L'état actuel du prêt
	 * @param idUtilisateur L'utilisateur à l'origine de l'action
	 * @param etat1 L'état numéro 1, l'état que dois avoir le prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * @param etat2 L'état numéro 2, le nouvel état potentiel du prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * @param etat5 L'état numéro 5, le nouvel état potentiel du prêt (cf : 'ResourcesBundles.java' & bundles.properties)
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see PretManagerImpl#decide(Pret, String, String, String, String, String)
	 */
	boolean decide(Pret pret, String etat, String idUtilisateur, String etat1, String etat2, String etat5) throws Exception;

}
