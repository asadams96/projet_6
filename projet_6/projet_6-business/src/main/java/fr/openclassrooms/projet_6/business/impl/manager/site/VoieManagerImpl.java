package fr.openclassrooms.projet_6.business.impl.manager.site;

import java.util.LinkedList;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.site.VoieManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Voie;



/**
 * <p>Implémentation de l'interface 'VoieManager'</p>
 * <p>Dédié au traitement métier de la classe 'Voie'</p>
 * 
 * @see VoieManagerImpl#getSecteurListVoie(List)
 * @see VoieManager#getSecteurListVoie(List)
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
public class VoieManagerImpl extends AbstractManager implements VoieManager {

	
	
	/**
	 * @see VoieManager#getMapSecteurListVoie(List)
	 * @see Secteur
	 * @see Voie
	 */
	@Override
	public List<Object> getSecteurListVoie(List<Secteur> listSecteur) throws Exception {

		List<Object> linkedListSecteurtVoie = null;
		
		if(listSecteur != null && !listSecteur.isEmpty()) {
			
			int index = 0;
			List<Secteur> listSecteurOrdonne = new LinkedList<Secteur>();
			List<Secteur> listSecteurBis = new LinkedList<Secteur>();
			
		// Ordonne les secteurs selon leurs numero pour un affichage dans lebon ordre dans les vue
			while(!listSecteur.isEmpty()) {
				
				listSecteurBis.clear();
				listSecteurBis.addAll(listSecteur);
				boolean add = false;
										
				for(Secteur secteur : listSecteur) {
					if((secteur.getNumero())-1 == index) {
						
						listSecteurOrdonne.add(index, secteur);
						listSecteurBis.remove(secteur);
						index++;
						add = true;
						break;
					}															
				}
				if(add) {
					listSecteur.clear();
					listSecteur.addAll(listSecteurBis);
				}
			}
			
		// Pour chaque secteur, recupère ses voies associes et les ordonnes de même manière que les secteurs	
			linkedListSecteurtVoie = new LinkedList<Object>();
			List<Voie> listVoie = null;
			int indexBis = 0;
						
			for(Secteur secteur : listSecteurOrdonne) {
				listVoie = this.getDaoFactory().getVoieDao().getVoies(secteur.getIdSecteur());
			
				if(listVoie != null && !listVoie.isEmpty()) {
					
					List<Voie> listVoieOrdonne = new LinkedList<Voie>();
					List<Voie> listVoieBis = new LinkedList<Voie>();
					int indexTer = 0;
					
					while(!listVoie.isEmpty()) {
						
						listVoieBis.clear();
						listVoieBis.addAll(listVoie);
						boolean add = false;
												
						for(Voie voie : listVoie) {
							if((voie.getNumero())-1 == indexTer) {
								
								listVoieOrdonne.add(indexTer, voie);
								listVoieBis.remove(voie);
								indexTer++;
								add = true;
								break;
							}															
						}
						if(add) {
							listVoie.clear();
							listVoie.addAll(listVoieBis);
						}
							
					}
					// Ajout également ordonée:
					// index pair => Secteur
					// index impaire => List de 'Voie' (associé au secteur)
					linkedListSecteurtVoie.add(indexBis, secteur); // Pair (cf site.jsp if(%2))
					indexBis++;
					linkedListSecteurtVoie.add(indexBis, listVoieOrdonne); // Impair (cf site.jsp if(%2))
					indexBis++;
				}
			}		
		}

		return linkedListSecteurtVoie;
	}

}
