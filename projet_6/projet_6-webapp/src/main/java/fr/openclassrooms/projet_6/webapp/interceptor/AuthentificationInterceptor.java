package fr.openclassrooms.projet_6.webapp.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
  * Interceptor servant à vérifier qu'un utilisateur se trouve bien dans la session
  * et que son couple ID-PASS est le bon (via la bdd)
  * Si tel est le cas, autorisation de passer à l'interceptor suivant via "invocation.invoke()"
  * Sinon l'acces est interdit à l'utilisateur via le code erreur suivant : "error-forbidden"
  * 
  *  
  * @see ManagerFactory
  * @see ManagerFactoryImpl
  * @see AuthentificationInterceptor#setManagerFactory(ManagerFactory)
  * @see AuthentificationInterceptor#intercept(ActionInvocation)
  * @see AbstractInterceptor
  * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
  * 
  * @version 1.0
  * @author Ayrton De Abreu Miranda
  */
public class AuthentificationInterceptor extends AbstractInterceptor {
	
	
	
	/**
	 * <p>Objet 'ManagerFactory' gardant en stock l'instance 'ManagerFactoryImpl' qui lui a été injecté</p>
	 * 
	 * @see ManagerFactory
	 * @see ManagerFactoryImpl
	 * @see AuthentificationInterceptor#setManagerFactory(ManagerFactory)
	 * @see AuthentificationInterceptor#intercept(ActionInvocation))
	 */
	private ManagerFactory managerFactory;
	
	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'ManagerFactory'</p>
	 * 
	 * @param managerFactory Nouvelle instance de la classe 'ManagerFactoryImpl' qui est défini
	 * 
	 * @see ManagerFactory
	 * @see ManagerFactoryImpl
	 * @see AuthentificationInterceptor#managerFactory
	 * @see AuthentificationInterceptor#intercept(ActionInvocation)
	 */
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String vResult = "error-forbidden";
						
		// A activer pour simuler un utilisateur présent en bdd
		/*
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Utilisateur u = new Utilisateur();
		u.setIdUtilisateur(2);
		u.setMail("alexandra.deschamps@mail.fr");
		u.setPseudo("Alex");
		u.setCivilite("Mme");
		u.setNom("Deschamps");
		u.setPrenom("Alexandra");
		u.setLocalisation("65 - Hautes-Pyrénées");
		u.setPass("x&4.5d$@ù%v");
		session.put("utilisateur", u);
		*/
				
		if(invocation.getInvocationContext().getSession().get("utilisateur") != null) {
			Utilisateur utilisateur = (Utilisateur) invocation.getInvocationContext().getSession().get("utilisateur");
			
			if(utilisateur != null) {
				if(managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
					
					vResult = invocation.invoke();
				}
			}
		}
		return vResult;
	}

}