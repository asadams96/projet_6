package fr.openclassrooms.projet_6.consumer.contract.dao.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponSiteTopoDaoImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe TamponSiteTopo</p>
 * 
 * @see TamponSiteTopoDao#getTamponBySite(int)
 * @see TamponSiteTopoDao#getTamponByTopo(String)
 * @see TamponSiteTopoDaoImpl#getTamponBySite(int)
 * @see TamponSiteTopoDaoImpl#getTamponByTopo(String)
 * @see DaoFactory#getTamponSiteTopoDao()
 * @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
 * @see DaoFactoryImpl#getTamponSiteTopoDao()
 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
 * @see TamponSiteTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TamponSiteTopoDao {

	
	
	/**
	 * <p>Récupère une liste de 'TamponSiteTopo'en fonction d'un id de topo</p>
	 * 
	 * @param idTopo Un id de topo 
	 * @return Une liste de TamponSiteTopo
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponSiteTopoDaoImpl#getTamponByTopo(String)
	 * @see TamponSiteTopo
	 */
	List<TamponSiteTopo> getTamponByTopo(String idTopo) throws Exception;

	
	
	/**
	 * <p>Récupère une liste d'id de topo en fonction d'un id de site</p>
	 * 
	 * @param idSite Un id de site
	 * @return Une liste de TamponSiteTopo 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponSiteTopoDaoImpl#getTamponBySite(int)
	 * @see TamponSiteTopo
	 */
	List<TamponSiteTopo> getTamponBySite(int idSite) throws Exception;

}
