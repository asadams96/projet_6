package fr.openclassrooms.projet_6.webapp.bundle;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.webapp.action.GestionSiteAction;
import fr.openclassrooms.projet_6.webapp.action.GestionTopoAction;

/**
 * <p>
 * 	Classe permettant de récuperer les ressources bundle.
 * </p>
 * 
 * <p>Actuellement composé :<p>
 * <ul>
 * 		<li>d'un getter donnant accès à une liste de critère de localisation => getListLocalisation()</li>
 * 		<li>d'un getter donnant accès à une liste de critère de type => getListType()</li>
 * 		<li>d'un getter donnant accès à une liste de critère d'orientation => getListOrientation()</li>
 * 		<li>d'un getter donnant accès à une liste de type de prêt => getListTypesPret()</li>
 * 		<li>d'un getter donnant accès à une liste d'etat de prêt => getListEtatPret()</li>
 * 		<li>d'une méthode pour charger les listes => loadProperties</li>
 * </ul>
 * 
 * 
 * @see ResourcesBundle#getListLocalisation()
 * @see ResourcesBundle#getListType()
 * @see ResourcesBundle#getListOrientation()
 * @see ResourcesBundle#getListEtatPret()
 * @see ResourcesBundle#getListTypePret()
 * @see ResourcesBundle#loadProperties(String, int)
 * @see GestionTopoAction
 * @see GestionSiteAction
 * @see ActionSupport
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class ResourcesBundle extends ActionSupport {	
	
	
	
	/**
	 * 
	 * @return Retourne la liste de tous les critères de localisation.
	 * 
	 * @see ResourcesBundle#getListType()
	 * @see ResourcesBundle#getListOrientation()
	 * @see ResourcesBundle#loadProperties(String, int)
	 */
	public List<String> getListLocalisation() {
		return this.loadProperties("critere.localisation.france", 101);
	}

	
	
	/**
	 * 
	 * @return Retourne la liste de tous les critères de type.
	 * 
	 * @see ResourcesBundle#getListLocalisation()
	 * @see ResourcesBundle#getListOrientation()
	 * @see ResourcesBundle#loadProperties(String, int)
	 */
	public List<String> getListType() {
		return this.loadProperties("critere.type", 2);
	}
	
	
	
	/**
	 * 
	 * @return Retourne la liste de tous les critères d'orientation.
	 * 
	 * @see ResourcesBundle#getListType()
	 * @see ResourcesBundle#getListLocalisation()
	 * @see ResourcesBundle#loadProperties(String, int)
	 */
	public List<String> getListOrientation() {
		return this.loadProperties("critere.orientation", 4);
	}
	
	
	
	/**
	 * 
	 * @return Retourne la liste de tout les types de prêt
	 * 
	 * @see ResourcesBundle#getListEtatPret()
	 * @see ResourcesBundle#loadProperties(String, int)
	 */
	public List<String> getListTypePret() {
		return this.loadProperties("pret.type", 2);
	}
	
	
	
	/**
	 * 
	 * @return Retourne la liste de tout les états de prêt
	 * 
	 * @see ResourcesBundle#getListTypePret()
	 * @see ResourcesBundle#loadProperties(String, int)
	 */
	public List<String> getListEtatPret() {
		return this.loadProperties("pret.etat", 5);
	}

	
	
	/**
	 * 
	 * Méthode servant à aller chercher les critères dans le fichier 'ResourcesBundle.properties'
	 * 
	 * @param str => 'Clef des critères'
	 * @param count => 'Nombre de critère'
	 * 
	 * @return Retourne une liste de critères dépendant des paramètres saisis en entrée.
	 * 
	 * @see ResourcesBundle#getListType()
	 * @see ResourcesBundle#getListOrientation()
	 * @see ResourcesBundle#getListLocalisation()
	 * @see ResourcesBundle#getListEtatPret()
	 * @see ResourcesBundle#getListTypePret()
	 */
	public List<String> loadProperties(String str, int count){
		List<String> vResult = new ArrayList<String>();
		int i = 1;
		
		while(i <= count) {
			vResult.add(this.getText(str+i));
			i++;
		}
		
		return vResult;
	}
}
