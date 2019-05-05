package fr.openclassrooms.projet_6.consumer.contract.dao.site;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SiteDaoImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Site</p>
 * 
 * @see SiteDao#getSite(int)
 * @see SiteDao#getIdsSiteByLocalisation(String)
 * @see SiteDao#checkLocalisation(int)
 * @see SiteDao#getList()
 * @see SiteDaoImpl#getSite(int)
 * @see SiteDaoImpl#getIdsSiteByLocalisation(String)
 * @see SiteDaoImpl#checkLocalisation(int)
 * @see SiteDaoImpl#getList()
 * @see DaoFactory#getSiteDao()
 * @see DaoFactory#setSiteDao(SiteDao)
 * @see DaoFactoryImpl#getSiteDao()
 * @see DaoFactoryImpl#setSiteDao(SiteDao)
 * @see Site
 * @see Secteur
 * @see Voie
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface SiteDao {

	
	/**
	 * <p>Récupère un site en fonction du paramètre de méthode 'idSite'</p>
	 * 
	 * @param idSite L'identifiant du site
	 * @return Une instance de la classe 'Site'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteDaoImpl#getSite(int)
	 * @see Site
	 */
	Site getSite(int idSite) throws Exception;

	
	
	/**
	 * <p>Récupère une liste d'ID de site en fonction d'un critère de localisation</p>
	 * 
	 * @param critereLocalisation Critère de localisation choisi par l'utilisateur.
	 * @return Une liste d'iD de site.
	 * @throws Exception => Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SiteDaoImpl#getIdsSiteByLocalisation(String)
	 * @see Site
	 */
	List<Integer> getIdsSiteByLocalisation(String critereLocalisation) throws Exception;

	
	
	/**
	 * <p>Récupère la liste des localisations associé à l'id de site</p>
	 * 
	 * @param idSite Clef étrangère (fk) de la table public.site permettant d'identifier les sites d'un site.
	 * @return Une liste de localisation.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus.
	 * 
	 * @see SiteDaoImpl#checkLocalisation(int)
	 * @see Site
	 */
	String checkLocalisation(int idSite) throws Exception;

	
	
	/**
	 * <p>Récupère le catalogue de topo sans critère de recherche</p>
	 * 
	 * @return Une liste de le Topo
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see SiteDaoImpl#getList()
	 * @see Site
	 */
	List<Site> getList() throws Exception;

}
