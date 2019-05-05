package fr.openclassrooms.projet_6.business.contract.manager.site;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.VoieManagerImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Voie;

/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Voie'</p>
 * 
 * @see VoieManager#getMapSecteurListVoie(List)
 * @see VoieManagerImpl#getMapSecteurListVoie(List)
 * @see ManagerFactory#getVoieManager()
 * @see ManagerFactory#setVoieManager(VoieManager)
 * @see ManagerFactoryImpl#getVoieManager()
 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
 * @see Voie
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface VoieManager {
	
	
	
	/**
	 * <p>Récupère à partir d'une liste de secteur, leurs voies associés</p>
	 * 
	 * @param listSecteur Une liste de secteur
	 * @return	Une LinkedList d'Object ordonné de façon à alterner un 'Secteur' 
	 * 									et une (autre) 'LinkedList de Voie' (associé au secteur)
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see VoieManagerImpl#getMapSecteurListVoie(List)
	 * @see Secteur
	 * @see Voie
	 */
	List<Object> getSecteurListVoie(List<Secteur> listSecteur) throws Exception;
		
}
