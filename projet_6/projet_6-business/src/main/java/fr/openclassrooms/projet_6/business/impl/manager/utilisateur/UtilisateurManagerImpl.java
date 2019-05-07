package fr.openclassrooms.projet_6.business.impl.manager.utilisateur;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;


/**
 * <p>Implémentation de l'interface 'UtilisateurManager'</p>
 * <p>Dédié au traitement métier de la classe 'Utilisateur'</p>
 * 
 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
 * @see UtilisateurManager#addUtilisateur(Utilisateur)
 * @see UtilisateurManager#getUtilisateur(int)
 * @see UtilisateurManager#getIdbyMail(String)
 * @see UtilisateurManager#getCheckMail(String)
 * @see UtilisateurManager#getCheckUtilisateur(String)
 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
 * @see UtilisateurManager#setMailById(String, String)
 * @see UtilisateurManager#setPseudoById(String, String)
 * @see UtilisateurManager#setLocalisationById(String, String)
 * @see UtilisateurManager#setPassById(String, String, String)
 * @see UtilisateurManagerImpl#getCheckCoupleIdPass(Utilisateur)
 * @see UtilisateurManagerImplImpl#addUtilisateur(Utilisateur)
 * @see UtilisateurManagerImplImpl#getUtilisateur(int)
 * @see UtilisateurManagerImplImpl#getIdbyMail(String)
 * @see UtilisateurManagerImplImpl#getCheckMail(String)
 * @see UtilisateurManagerImplImpl#getCheckUtilisateur(String)
 * @see UtilisateurManagerImplImpl#getCheckUtilisateur(Utilisateur)
 * @see UtilisateurManagerImplImpl#setMailById(String, String)
 * @see UtilisateurManagerImplImpl#setPseudoById(String, String)
 * @see UtilisateurManagerImplImpl#setLocalisationById(String, String)
 * @see UtilisateurManagerImplImpl#setPassById(String, String, String)
 * @see ManagerFactory#getUtilisateurManager()
 * @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
 * @see ManagerFactoryImpl#getUtilisateurManager()
 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
 * @see Utilisateur
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'mail'</p>
	 * 
	 * @see UtilisateurDaoImpl#mail
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_MAIL = 10;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'nom'</p>
	 * 
	 * @see UtilisateurManagerImpl#nom
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_NOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'prenom'</p>
	 * 
	 * @see UtilisateurManagerImpl#prenom
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_PRENOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'civilite'</p>
	 * 
	 * @see UtilisateurManagerImpl#civilite
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_CIVILITE = 1;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'pseudo'</p>
	 * 
	 * @see UtilisateurManagerImpl#pseudo
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_PSEUDO = 5;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour les paramètres 'pass'et 'pasBis'</p>
	 * 
	 * @see UtilisateurManagerImpl#pass
	 * @see UtilisateurManagerImpl#passBis
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_PASS = 8;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'localisation'</p>
	 * 
	 * @see UtilisateurManagerImpl#localisation
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MIN_LOCA = 8;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'mail'</p>
	 * 
	 * @see UtilisateurManagerImpl#mail
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_MAIL = 50;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'nom'</p>
	 * 
	 * @see UtilisateurManagerImpl#nom
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_NOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'prenom'</p>
	 * 
	 * @see UtilisateurManagerImpl#prenom
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_PRENOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'civilite'</p>
	 * 
	 * @see UtilisateurManagerImpl#civilite
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_CIVILITE = 10;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pseudo'</p>
	 * 
	 * @see UtilisateurManagerImpl#pseudo
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_PSEUDO = 20;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pass'</p>
	 * 
	 * @see UtilisateurManagerImpl#pass
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_PASS = 30;
		
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'localisation'</p>
	 * 
	 * @see UtilisateurManagerImpl#pseudo
	 * @see UtilisateurManagerImpl#validation(String, int, int)
	 */
	private final int MAX_LOCA = 75;
	
	
	
	/**
	 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckCoupleIdPass(Utilisateur utilisateur) throws Exception {
		Boolean vResult = false;
		
		if(utilisateur != null 
				&& utilisateur.getPass() != null && !utilisateur.getPass().isEmpty()
				&&  String.valueOf(utilisateur.getIdUtilisateur()) != null && !String.valueOf(utilisateur.getIdUtilisateur()).isEmpty()) {

			String pass = getDaoFactory().getUtilisateurDao().getPass(utilisateur.getIdUtilisateur());

			if(pass.equals(utilisateur.getPass())) {

				vResult = true;
			}
		}
		return vResult;
	}



	/**
	 * @see UtilisateurManager#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean addUtilisateur(Utilisateur utilisateur) throws Exception {
		
		Boolean vResult = false;
		
		if(utilisateur != null) {
			
			if(utilisateur.getMail() != null || this.validation(utilisateur.getMail(), MIN_MAIL, MAX_MAIL) 
			&& utilisateur.getCivilite() != null || this.validation(utilisateur.getCivilite(), MIN_CIVILITE, MAX_CIVILITE)
			&& utilisateur.getNom() != null || this.validation(utilisateur.getNom(), MIN_NOM, MAX_NOM)
			&& utilisateur.getPrenom() != null || this.validation(utilisateur.getPrenom(), MIN_PRENOM, MAX_PRENOM)
			&& utilisateur.getPseudo() != null || this.validation(utilisateur.getPseudo(), MIN_PSEUDO, MAX_PSEUDO)
			&& utilisateur.getPass() != null || this.validation(utilisateur.getPass(), MIN_PASS, MAX_PASS)
			&& utilisateur.getLocalisation() != null || this.validation(utilisateur.getLocalisation(), MIN_LOCA, MAX_LOCA)) {
				
				if(this.getDaoFactory().getUtilisateurDao().addUtilisateur(utilisateur)) {
					vResult = true;
				}
				
				
			}
		}
			
		
		return vResult;
	}
	
	
	
	/**
	 * @see UtilisateurManager#getUtilisateur(int)
	 * @see Utilisateur
	 */
	@Override
	public Utilisateur getUtilisateur(int idUtilisateur) throws Exception {

		Utilisateur utilisateur = null;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			utilisateur = this.getDaoFactory().getUtilisateurDao().getUtilisateur(idUtilisateur);
		}
		
		return utilisateur;
	}



	/**
	 * @see UtilisateurManager#getIdbyMail(String)
	 * @see Utilisateur
	 */
	@Override
	public String getIdbyMail(String mail) throws Exception {
		String idUtilisateur = null;
		
		if(mail != null && !mail.isEmpty()) {
			idUtilisateur = this.getDaoFactory().getUtilisateurDao().getIdByMail(mail);
		}
		
		return idUtilisateur;
	}



	/**
	 * <p>Méthode servant à valider les input<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs</li>
	 * 		<li>La taille maximal du champss (lié à l'espace alloué)</li>
	 * </ul>
	 * 
	 * @param input  Le contenu de l'input
	 * @param longueurMin La longueur minimal du champs
	 * @param longueurMax La longueur maximal du champs
	 * @return Retourne le résultat de la validation => validée (=true) / refusée (=false)
	 * 
	 * @see UtilisateurManagerImpl#addUtilisateur(Utilisateur)
	 * @see UtilisateurManagerImpl#MIN_MAIL
	 * @see UtilisateurManagerImpl#MIN_NOM
	 * @see UtilisateurManagerImpl#MIN_PRENOM
	 * @see UtilisateurManagerImpl#MIN_CIVILITE
	 * @see UtilisateurManagerImpl#MIN_PSEUDO
	 * @see UtilisateurManagerImpl#MIN_PASS
	 * @see UtilisateurManagerImpl#MIN_LOCA
	 * @see UtilisateurManagerImpl#MAX_MAIL
	 * @see UtilisateurManagerImpl#MAX_NOM
	 * @see UtilisateurManagerImpl#MAX_PRENOM
	 * @see UtilisateurManagerImpl#MAX_CIVILITE
	 * @see UtilisateurManagerImpl#MAX_PSEUDO
	 * @see UtilisateurManagerImpl#MAX_PASS
	 * @see UtilisateurManagerImpl#MAX_LOCA
	 */
	public Boolean validation(String input, int longueurMin, int longueurMax) {
				
		Boolean vReturn = false;
		
		
		if(input.length() >= longueurMin && input.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}



	/**
	 * @see UtilisateurManager#getCheckMail(String)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckMail(String mail) throws Exception {
		
		Boolean vResult = false;
		int count;
		
		if(mail != null && !mail.isEmpty()) {
			count = this.getDaoFactory().getUtilisateurDao().getCountMail(mail);
			
			if(count == 0) {
				vResult = true;
			}
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckUtilisateur(Utilisateur utilisateur) throws Exception {
		
		Boolean vResult = false;
			
			if(utilisateur != null 
					&& String.valueOf(utilisateur.getIdUtilisateur()) != null && !String.valueOf(utilisateur.getIdUtilisateur()).isEmpty()
					&& utilisateur.getMail() != null && !utilisateur.getMail() .isEmpty()
					&& utilisateur.getPseudo() != null && !utilisateur.getPseudo().isEmpty()
					&& utilisateur.getCivilite() != null && !utilisateur.getCivilite() .isEmpty()
					&& utilisateur.getNom() != null && !utilisateur.getNom() .isEmpty()
					&& utilisateur.getPrenom() != null && !utilisateur.getPrenom() .isEmpty()
					&& utilisateur.getLocalisation() != null && !utilisateur.getLocalisation() .isEmpty()) {
				
				Utilisateur utilisateurBis = this.getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateur.getIdUtilisateur());
				
				if(utilisateur.getMail().equals(utilisateurBis.getMail())
						&& utilisateur.getPseudo().equals(utilisateurBis.getPseudo())
						&& utilisateur.getCivilite().equals(utilisateurBis.getCivilite())
						&& utilisateur.getNom().equals(utilisateurBis.getNom())
						&& utilisateur.getPrenom().equals(utilisateurBis.getPrenom())
						&& utilisateur.getLocalisation().equals(utilisateurBis.getLocalisation())) {
					
					vResult = true;
				}
			}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#getCheckUtilisateur(String)
	 * @see Utilisateur
	 */
	@Override
	public boolean getCheckUtilisateur(String idUtilisateur) throws Exception {
		
		Boolean vResult = false;
		
			if(idUtilisateur != null && !idUtilisateur.isEmpty()) {
				int count = this.getDaoFactory().getUtilisateurDao().getCountId(idUtilisateur);

				if(count == 1) {
					vResult = true;
				}
				
			}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setMailById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setMailById(String idUtilisateur, String mail) throws Exception {
		
		Boolean vResult = false ;

		if(idUtilisateur != null && !idUtilisateur.isEmpty() && this.getCheckUtilisateur(idUtilisateur)
				&& mail != null && !mail.isEmpty() && this.validation(mail, MIN_MAIL, MAX_MAIL)) {

			if(this.getDaoFactory().getUtilisateurDao().setMailById(idUtilisateur, mail)) {

				vResult = true;
			}
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception {
		
		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() &&  this.getCheckUtilisateur(idUtilisateur)
				&& pseudo != null && !pseudo.isEmpty() && this.validation(pseudo, MIN_PSEUDO, MAX_PSEUDO)) {
			
			if(this.getDaoFactory().getUtilisateurDao().setPseudoById(idUtilisateur, pseudo)) {
				
				vResult = true;
			}
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception {
		
		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() &&  this.getCheckUtilisateur(idUtilisateur) 
				&& localisation != null && !localisation.isEmpty() && this.validation(localisation, MIN_LOCA, MAX_LOCA)) {
			
			if(this.getDaoFactory().getUtilisateurDao().setLocalisationById(idUtilisateur, localisation)) {
				
				vResult = true;
			}
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurManager#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception {
		
		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() &&  this.getCheckUtilisateur(idUtilisateur)
				&& pass != null && !pass.isEmpty() && this.validation(pass, MIN_PASS, MAX_PASS)
				&& passBis != null && !passBis.isEmpty() && this.validation(passBis, MIN_PASS, MAX_PASS)) {
			
			if(this.getDaoFactory().getUtilisateurDao().setPassById(idUtilisateur, pass, passBis)) {
				
				vResult = true;
			}
		}
		
		return vResult;
	}
}
