package fr.openclassrooms.projet_6.consumer.contract.dao.topo;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SiteDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.topo.TopoDaoImpl;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Topo</p>
 * 
 * @see TopoDao#getTopo(String)
 * @see TopoDao#getList()
 * @see TopoDaoImpl#getTopo(String)
 * @see TopoDaoImpl#getList()
 * @see DaoFactory#getTopoDao()
 * @see DaoFactory#setTopoDao(TopoDao)
 * @see DaoFactoryImpl#getTopoDao()
 * @see DaoFactoryImpl#setTopoDao(TopoDao)
 * @see Topo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TopoDao {

	
	
	/**
	 * <p>Récupère le topo en fonction du paramètre de méthode 'idTopo'</p>
	 * 
	 * @param idTopo L'identifiant du topo
	 * @return Une instance de la classe 'Topo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TopoDaoImpl#getTopo(String)
	 * @see Topo
	 */
	Topo getTopo(String idTopo) throws Exception;

	/**
	 * <p>Récupère le catalogue de topo sans critère de recherche</p>
	 * 
	 * @return Une liste de le Topo
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TopoDaoImpl#getList()
	 * @see Topo
	 */
	List<Topo> getList() throws Exception;

}
