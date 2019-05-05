package fr.openclassrooms.projet_6.consumer.contract.dao.site;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SecteurDaoImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Secteur</p>
 * 
 * @see SecteurDao#getIdsSiteByOrientation(String)
 * @see SecteurDao#getIdsSiteByType(String)
 * @see SecteurDao#checkType(int)
 * @see SecteurDao#checkOrientation(int)
 * @see SecteurDao#getList(String)
 * @see SecteurDaoImpl#getIdsSiteByOrientation(String)
 * @see SecteurDaoImpl#getIdsSiteByType(String)
 * @see SecteurDaoImpl#checkType(int)
 * @see SecteurDaoImpl#checkOrientation(int)
 * @see SecteurDaoImpl#getList(String)
 * @see DaoFactory#getSecteurDao()
 * @see DaoFactory#setSecteurDao(SecteurDao)
 * @see DaoFactoryImpl#getSecteurDao()
 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
 * @see Secteur
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface SecteurDao {

	
	
	/**
	 * <p>Récupère une liste d'ID de site en fonction d'un critère de type</p>
	 * 
	 * @param critereType Critère de type choisi par l'utilisateur.
	 * @return Une liste d'iD de site.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SecteurDaoImpl#getIdsSiteByType(String)
	 * @see Secteur
	 * @see Site
	 */
	List<Integer> getIdsSiteByType(String critereType) throws Exception;

	
	
	/**
	 * <p>Récupère une liste d'ID de site en fonction d'un critère d'orientation</p>
	 * 
	 * @param critereOrientation Critère d'orientation choisi par l'utilisateur.
	 * @return Une liste d'iD de site.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SecteurDaoImpl#getIdsSiteByOrientation(String)
	 * @see Secteur
	 * @see Site
	 */
	List<Integer> getIdsSiteByOrientation(String critereOrientation) throws Exception;

	
		
	/**
	 * <p>Récupère la liste des types associé à l'id de topo</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une liste de type.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SecteurDaoImpl#checkType(int)
	 * @see Secteur
	 * @see Site
	 */
	List<String> checkType(int idSite) throws Exception;

	
	
	/**
	 * <p>Récupère la liste des orientations associé à l'id de topo</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une liste d'orientation.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SecteurDaoImpl#checkOrientation(int)
	 * @see Secteur
	 * @see Site
	 */
	List<String> checkOrientation(int idSite) throws Exception;


	/**
	 * <p>Récupère la liste des secteurs en fonction d'un identifiant de site</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une liste d'instance de la classe 'Secteur'
	 * 
	 * @see SecteurDaoImpl#getList(String)
	 * @see Secteur
	 * @see Site
	 */
	List<Secteur> getList(String idSite);

}
