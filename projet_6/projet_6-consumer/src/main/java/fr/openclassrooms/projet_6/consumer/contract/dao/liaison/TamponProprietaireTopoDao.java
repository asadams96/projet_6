package fr.openclassrooms.projet_6.consumer.contract.dao.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe TamponProprietaireTopo</p>
 * 
 * @see TamponProprietaireTopoDao#getTamponByUser(int)
 * @see TamponProprietaireTopoDao#getQuantity(int, String)
 * @see TamponProprietaireTopoDao#addTampon(int, String, int)
 * @see TamponProprietaireTopoDao#removeTampon(int, String, int, int)
 * @see TamponProprietaireTopoDao#getList(String)
 * @see TamponProprietaireTopoDaoImpl#getList(String)
 * @see TamponProprietaireTopoDaoImpl#getTamponByUser(int)
 * @see TamponProprietaireTopoDaoImpl#getQuantity(int, String)
 * @see TamponProprietaireTopoDaoImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoDaoImpl#removeTampon(int, String, int, int)
 * @see DaoFactory#getTamponProprietaireTopoDao()
 * @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 * @see TamponProprietaireTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TamponProprietaireTopoDao {

	
	
	/**
	 * <p>Récupère une liste de 'TamponProprietaireTopo' en fonction d'un id d'utilisateur</p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur
	 * @return Une liste de TamponProprietaireTopo
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#getTamponByUser(int)
	 * @see TamponProprietaireTopo
	 */
	List<TamponProprietaireTopo> getTamponByUser(int idUtilisateur) throws Exception;

	/**
	 * <p>Récupère un entier 'quantite'en fonction d'un id d'utilisateur et d'un id de topo</p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur
	 * @param idTopo Un id de topo
	 * 
	 * @return La quantite de topo possédé par l'utilisateur
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#getQuantity(int, String)
	 * @see TamponProprietaireTopo
	 */
	int getQuantity(int idUtilisateur, String idTopo) throws Exception;

	
	
	/**
	 * <p>Ajoute la quantité souhaité du topo désiré dans la bibliothèque d'un utilisateur</p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur
	 * @param idTopo Un id de topo
	 * @param quantite La quantité à ajouté
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non. 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#addTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	boolean addTampon(int idUtilisateur, String idTopo, int quantite) throws Exception;

	
	
	/**
	 * <p>Supprime de la bibliothèque d'un utilisateur, la quantité souhaité pour le topo désiré </p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur => Clef primaire étrangère de la table
	 * @param idTopo Un id de topo => Clef primaire étrangère de la table
	 * @param quantite La quantité à supprimer
	 * @param quantiteDispo La nombre de topo déjà présent dans la bibliothèque de l'utilisateur 
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#removeTampon(int, String, int, int)
	 * @see TamponProprietaireTopo
	 */
	boolean removeTampon(int idUtilisateur, String idTopo, int quantite, int quantiteDispo) throws Exception;

	
	
	/**
	 * <p>Récupère tous les proprietaire concerné par un topo</p>
	 * 
	 * @param idTopo l'identifiant d'un topo
	 * @return Une liste d'instance de classe 'TamponProprietaireTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#getList(String)
	 * @see TamponProprietaireTopo
	 */
	List<TamponProprietaireTopo> getList(String idTopo) throws Exception;

}
