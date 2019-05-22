package fr.openclassrooms.projet_6.business.contract.manager.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponProprietaireTopoManagerImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'TamponProprietaireTopo'</p>
 * 
 * 
 * @see TamponProprietaireTopoManager#getList(String, String)
 * @see TamponProprietaireTopoManager#getCheckQuantity(int, String, int)
 * @see TamponProprietaireTopoManager#getBibliotheque(int)
 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int)
 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getList(String, String)
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
public interface TamponProprietaireTopoManager {

	
	
	/**
	 * <p>Récupère la bibliothèque de l'utilisateur en paramètre de méthode</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * @param etat1 Etat de pret où la quantite de topo de l'objet 'Topo' lui meme de l'objet 'TamponProprietaireTopo' a été modifié
	 * @param etat2 Etat de pret où la quantite de topo de l'objet 'Topo' lui meme de l'objet 'TamponProprietaireTopo' a été modifié
	 * @return Une liste d'instance de la classe 'TamponProprietaireTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int, String, String)
	 * @see TamponProprietaireTopo
	 */
	List<TamponProprietaireTopo> getBibliotheque(int idUtilisateur, String etat1, String etat2) throws Exception;
	
	
	/**
	 * <p>
	 * 	Demande l'ajout, à la couche du dessous, d'un topo 
	 * 	en x quantité dans la bibliothèque de l'utilisateur.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantité désiré
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	Boolean addTampon(int idUtilisateur, String idTopo, int quantite) throws Exception;

	
	
	/**
	 * <p>
	 * 	Demande la suppression, à la couche du dessous, d'un topo 
	 * 	en x quantité dans la bibliothèque de l'utilisateur.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantité désiré
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	boolean removeTampon(int idUtilisateur, String idTopo, int quantite) throws Exception;


	
	/**
	 * <p>Récupère la liste des liaison topos-proprietaire où les topos pouvent être échangé puis la traite en fonction de la quantité disponible (quantité 0 => supprimé)</p>
	 * <p>L'idUtilisateur sert simplement a vérifier que l'utilisateur demande la liste ne soit pas lui même dedans</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @param idUtilisateur L'identifiant de l'utilisateur voulant récupérer la liste
	 * 
	 * @return Une liste d'instance de la classe 'TamponProprietaireTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#getList(String, String)
	 * @see TamponProprietaireTopo
	 */
	List<TamponProprietaireTopo> getList(String idTopo, String idUtilisateur) throws Exception;


	
	/**
	 *<p>
	 *	Méthode dédié à vérifier la quantité d'un topo posséder 
	 *	par	l'utilisateur de façon a vérifier qu'il puisse bien retirer
	 *</p>
	 *
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantite de topo a supprimé
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la méthode du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#getCheckQuantity(int, String, int)
	 */
	boolean getCheckQuantity(int idUtilisateur, String idTopo, int quantite) throws Exception;

	
	
}
