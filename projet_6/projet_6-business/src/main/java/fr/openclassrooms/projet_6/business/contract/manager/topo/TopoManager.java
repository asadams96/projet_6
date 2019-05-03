package fr.openclassrooms.projet_6.business.contract.manager.topo;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.topo.TopoManagerImpl;
import fr.openclassrooms.projet_6.model.topo.Topo;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Topo'</p>
 * 
 * @see TopoManager#getTopo(String)
 * @see TopoManager#getCheckTopo(String)
 * @see TopoManager#getList(String, String, String)
 * @see TopoManagerImpl#getTopo(String)
 * @see TopoManagerImpl#getCheckTopo(String)
 * @see TopoManagerImpl#getList(String, String, String)
 * @see ManagerFactory#getTopoManager()
 * @see ManagerFactory#setTopoManager(TopoManager)
 * @see ManagerFactoryImpl#getTopoManager()
 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
 * @see Topo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TopoManager {

	
	
	/**
	 * <p>Transmet l'identifiant du topo à la couche du dessous puis récupère une instance de la classe Topo</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @return Une instance de la classe 'Topo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TopoManagerImpl#getTopo(String)
	 * @see Topo
	 */
	Topo getTopo(String idTopo) throws Exception;

	
	
	/**
	 * <p>Vérifie qu'un topo existe bien<p>
	 * <p>A besoin de getTopo(String idTopo) pour fonctionner</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TopoManagerImpl#getCheckTopo(String)
	 * @see TopoManagerImpl#getTopo(String)
	 * @see TopoManager#getTopo(String)
	 */
	boolean getCheckTopo(String idTopo) throws Exception;

	
	
	/**
	 * <p>
	 * 	Verifie la validité des critères puis récupère la liste des sites associés à ces critères
	 * 	et enfin les topos associés à ces sites
	 * </p>
	 * <p>Les critères peuvent être vide, dans ce cas, tous les topos sont directement récupéré</p>
	 * 
	 * @param critereType Un critère de type
	 * @param critereOrientation Un critère d'orientation
	 * @param critereLocalisation Un critère de localisation
	 * @return Une liste d'instance de la classe Topo
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TopoManagerImpl#getList(String, String, String)
	 * @see Topo
	 */
	List<Topo> getList(String critereType, String critereOrientation, String critereLocalisation) throws Exception;

}
