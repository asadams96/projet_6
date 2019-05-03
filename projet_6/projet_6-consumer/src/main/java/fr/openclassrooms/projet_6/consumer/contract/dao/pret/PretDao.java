package fr.openclassrooms.projet_6.consumer.contract.dao.pret;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.pret.PretDaoImpl;
import fr.openclassrooms.projet_6.model.pret.Pret;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Pret</p>
 * 
 * @see PretDaoImpl
 * @see DaoFactory#getPretDao()
 * @see DaoFactory#setPretDao(PretDao)
 * @see DaoFactoryImpl#getPretDao()
 * @see DaoFactoryImpl#setPretDao(PretDao)
 * @see Pret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface PretDao {

}
