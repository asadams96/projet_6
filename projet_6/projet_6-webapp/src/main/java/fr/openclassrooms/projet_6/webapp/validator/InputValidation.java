package fr.openclassrooms.projet_6.webapp.validator;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.webapp.action.GestionPretAction;
import fr.openclassrooms.projet_6.webapp.action.GestionSiteAction;
import fr.openclassrooms.projet_6.webapp.action.GestionTopoAction;
import fr.openclassrooms.projet_6.webapp.action.GestionUtilisateurAction;



/**
 * <p>Classe de formattage et de validation des entrées (en écriture seulement)</p>
 * <p>Valide les champs :</p>
 * <ul>
 * 		<li>de l'adresse mail</li>
 * 		<li>du nom</li>
 * 		<li>du prenom</li>
 * 		<li>de la civilité</li>
 * 		<li>du pseudo</li>
 * 		<li>du mot de passe</li>
 * 		<li>du contenu des commentaires et messages</li>
 * </ul>
 * 
 *
 * @see InputValidation#getMIN_MAIL()
 * @see InputValidation#getMIN_NOM()
 * @see InputValidation#getMIN_PRENOM()
 * @see InputValidation#getMIN_CIVILITE()
 * @see InputValidation#getMIN_PSEUDO()
 * @see InputValidation#getMIN_PASS()
 * @see InputValidation#getMIN_CONTENU()
 * @see InputValidation#getMAX_MAIL()
 * @see InputValidation#getMAX_NOM()
 * @see InputValidation#getMAX_PRENOM()
 * @see InputValidation#getMAX_CIVILITE()
 * @see InputValidation#getMAX_PSEUDO()
 * @see InputValidation#getMAX_PASS()
 * @see InputValidation#getMAX_CONTENU()
 * @see InputValidation#inputFormat(String)
 * @see InputValidation#mailValidation(String)
 * @see InputValidation#nomValidation(String)
 * @see InputValidation#prenomValidation(String)
 * @see InputValidation#civiliteValidation(String)
 * @see InputValidation#pseudoValidation(String)
 * @see InputValidation#passValidation(String)
 * @see InputValidation#messageValidation(String)
 * @see InputValidation#validation(String, String, String)
 * @see GestionPretAction
 * @see GestionSiteAction
 * @see GestionTopoAction
 * @see GestionUtilisateurAction
 * 
 * @see ActionSupport
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class InputValidation extends ActionSupport {
	
	
	
	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs de l'adresse mail</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyMail() 
	 */
	public String getMIN_MAIL() {
		return this.getText("input.validation.min.mail");
	}



	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs du nom</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMIN_NOM() {
		return this.getText("input.validation.min.nom");
	}


	
	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs du prenom</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMIN_PRENOM() {
		return this.getText("input.validation.min.prenom");
	}



	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs de la civilité</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMIN_CIVILITE() {
		return this.getText("input.validation.min.civilite");
	}


	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs du pseudo</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPseudo()
	 */
	public String getMIN_PSEUDO() {
		return this.getText("input.validation.min.pseudo");
	}


	
	/**
	 * <p>Getter de la contrainte de taille minimale pour le champs du mot de passe</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPass()
	 */
	public String getMIN_PASS() {
		return this.getText("input.validation.min.pass");
	}


	
	/**
	 * <p>Getter de la contrainte de taille minimale pour les champs de commentaire et de message</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionSiteAction#doAddComment()
	 * @see GestionTopoAction#doAddComment()
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doAsk()
	 */
	public String getMIN_CONTENU() {
		return this.getText("input.validation.min.message");
	}

	

	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs de l'adresse mail</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyMail() 
	 */
	public String getMAX_MAIL() {
		return this.getText("input.validation.max.mail");
	}



	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs du nom</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMAX_NOM() {
		return this.getText("input.validation.max.nom");
	}



	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs du prenom</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMAX_PRENOM() {
		return this.getText("input.validation.max.prenom");
	}

	

	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs de la civilité</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getMAX_CIVILITE() {
		return this.getText("input.validation.max.civilite");
	}



	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs du pseudo</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPseudo()
	 */
	public String getMAX_PSEUDO() {
		return this.getText("input.validation.max.pseudo");
	}



	/**
	 * <p>Getter de la contrainte de taille maximale pour le champs du mot de passe</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPass()
	 */
	public String getMAX_PASS() {
		return this.getText("input.validation.max.pass");
	}



	/**
	 * <p>Getter de la contrainte de taille maximale pour les champs de commentaire et de message</p>
	 * 
	 * @return La valeur de la contrainte
	 * 
	 * @see GestionSiteAction#doAddComment()
	 * @see GestionTopoAction#doAddComment()
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doAsk()
	 */
	public String getMAX_CONTENU() {
		return this.getText("input.validation.max.message");
	}


	
	/**
	 * 
	 * <p>Méthode servant à formatter toutes les entrées saisi par l'utilisateur</p>
	 * <p>Vérification de l'entrée puis formattage en retirant tous les espaces superflus</p>
	 * 
	 * @param input La saisi de l'utilisateur
	 * @return La saisi de l'utilisateur à présent formatté
	 * 
	 * @see GestionPretAction#setContenu(String)
	 * @see GestionSiteAction#setContenu(String)
	 * @see GestionSiteAction#setCriteresType(String)
	 * @see GestionSiteAction#setCriteresLocalisation(String)
	 * @see GestionSiteAction#setCriteresOrientation(String)
	 * @see GestionTopoAction#setContenuCom(String)
	 * @see GestionTopoAction#setContenu(String)
	 * @see GestionTopoAction#setQuantiteTopo(String)
	 * @see GestionTopoAction#setCriteresType(String)
	 * @see GestionTopoAction#setCriteresLocalisation(String)
	 * @see GestionTopoAction#setCriteresOrientation(String)
	 * @see GestionUtilisateurAction#setMail(String)
	 * @see GestionUtilisateurAction#setPseudo(String)
	 * @see GestionUtilisateurAction#setCivilite(String)
	 * @see GestionUtilisateurAction#setNom(String)
	 * @see GestionUtilisateurAction#setPrenom(String)
	 * @see GestionUtilisateurAction#setLocalisation(String)
	 * @see GestionUtilisateurAction#setIdUtilisateur(String)
	 */
	public String inputFormat(String input) {
		
		if(input != null && !input.isEmpty()) {
			for(int i = 0; i < input.length()-1; i++) {
				String character = input.substring(i, i+1);
				String characterBis = input.substring(i+1, i+2);
							
				if(character.equals(" ") && characterBis.equals(" ")) {
					input = input.substring(0, i)+input.substring(i+1, input.length());
					i--;
				}
			}
			if(input.startsWith(" ")) {
				input = input.substring(1);
			}
			
			if(input.endsWith(" ")) {
				input = input.substring(0, input.length()-1);
			}
		}
		
		return input;
	} 

	
	
	/**
	 * <p>Méthode de validation concernant le champs de l'adresse mail</p>
	 * 
	 * @param mail L'adresse mail à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyMail()
	 */
	public boolean mailValidation(String mail) {
		
		Boolean vResult = this.validation(mail, this.getText("input.validation.min.mail"), this.getText("input.validation.max.mail"));
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode de validation concernant le champs du nom</p>
	 * 
	 * @param nom Le nom à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public boolean nomValidation(String nom) {
		
		Boolean vResult = this.validation(nom, this.getText("input.validation.min.nom"), this.getText("input.validation.max.nom"));
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode de validation concernant le champs du prenom</p>
	 * 
	 * @param prenom Le prenom à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public boolean prenomValidation(String prenom) {
	
		Boolean vResult = this.validation(prenom, this.getText("input.validation.min.prenom"), this.getText("input.validation.max.prenom"));
		
		return vResult;
	}



	/**
	 * <p>Méthode de validation concernant le champs de la civilité</p>
	 * 
	 * @param civilite La civilité à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public boolean civiliteValidation(String civilite) {
		
		Boolean vResult = this.validation(civilite, this.getText("input.validation.min.civilite"), this.getText("input.validation.max.civilite"));
	
		return vResult;
		}



	/**
	 * <p>Méthode de validation concernant le champs du pseudo</p>
	 * 
	 * @param pseudo Le pseudo à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPseudo()
	 */
	public boolean pseudoValidation(String pseudo) {
	
		Boolean vResult = this.validation(pseudo, this.getText("input.validation.min.pseudo"), this.getText("input.validation.max.pseudo"));
	
		return vResult;
	}


	/**
	 * <p>Méthode de validation concernant le champs du mot de passe</p>
	 * 
	 * @param pass Le mot de passe à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doModifyPass()
	 */
	public boolean passValidation(String pass) {
	
		Boolean vResult = this.validation(pass, this.getText("input.validation.min.pass"), this.getText("input.validation.max.pass"));
	
		return vResult;
	}


	/**
	 * <p>Méthode de validation concernant les champs de commentaire et message</p>
	 * 
	 * @param message Le message à valider
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see GestionSiteAction#doAddComment()
	 * @see GestionTopoAction#doAddComment()
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doAsk()
	 */
	public boolean messageValidation(String message) {
	
		Boolean vResult = this.validation(message, this.getText("input.validation.min.message"), this.getText("input.validation.max.message"));
	
		return vResult;
	}


	/**
	 * <p>Méthode générique de validation des champs</p>
	 * 
	 * @param input Le contenu du champs
	 * @param longueurMin La longueur minimale du champs
	 * @param longueurMax La longueur maximale du champs
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * 
	 * @see InputValidation#mailValidation(String)
	 * @see InputValidation#nomValidation(String)
	 * @see InputValidation#prenomValidation(String)
	 * @see InputValidation#civiliteValidation(String)
	 * @see InputValidation#pseudoValidation(String)
	 * @see InputValidation#passValidation(String)
	 * @see InputValidation#messageValidation(String)
	 */
	private boolean validation(String input, String longueurMin, String longueurMax) {
		
		Boolean vResult = false;
		
		if(input.length() >= Integer.valueOf(longueurMin) && input.length() <= Integer.valueOf(longueurMax)) {
			vResult = true;
		}
		
		return vResult;
	}
}
