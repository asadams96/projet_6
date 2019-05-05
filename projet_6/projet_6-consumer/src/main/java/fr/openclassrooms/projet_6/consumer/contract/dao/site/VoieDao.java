package fr.openclassrooms.projet_6.consumer.contract.dao.site;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.VoieDaoImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Voie;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Voie</p>
 * 
 *
 * @see VoieDao#getVoies(int)
 * @see VoieDaoImpl#getVoies(int)
 * @see DaoFactory#getVoieDao()
 * @see DaoFactory#setVoieDao(VoieDao)
 * @see DaoFactoryImpl#getVoieDao()
 * @see DaoFactoryImpl#setVoieDao(VoieDao)
 * @see Voie
 * @see Secteur
 * @see Voie
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface VoieDao {

	
	
	/**
	 * <p>Récupère toutes les voies qui ont pour identifiant de secteur le paramètre de méthode 'idSecteur'</p>
	 * 
	 * @param idSecteur L'identifiant de secteur
	 * @return Une liste d'instance de la classe 'Voie'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see VoieDaoImpl#getVoies(int)
	 * @see Secteur
	 */
	List<Voie> getVoies(int idSecteur) throws Exception;

}
