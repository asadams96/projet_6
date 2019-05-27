package fr.openclassrooms.projet_6.webapp.interceptor;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>
  * Interceptor servant à vérifier qu'un utilisateur se trouve bien dans la session
  * et que son couple ID-PASS est le bon (via la bdd)
  * Si tel est le cas, autorisation de passer à l'interceptor suivant via "invocation.invoke()"
  * Sinon l'acces est interdit à l'utilisateur via le code erreur suivant : "error-forbidden"
  * </p>
  * 
  *  
  * @see ManagerFactory
  * @see ManagerFactoryImpl
  * @see AuthentificationInterceptor#managerFactory
  * @see AuthentificationInterceptor#logger
  * @see AuthentificationInterceptor#setManagerFactory(ManagerFactory)
  * @see AuthentificationInterceptor#intercept(ActionInvocation)
  * @see AbstractInterceptor
  * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
  * @see Logger
  * @see LogManager#getLogger(Class)
  * 
  * @version 1.0
  * @author Ayrton De Abreu Miranda
  */
public class AuthentificationInterceptor extends AbstractInterceptor {
	
	
	
	/**
	 * <p>Logger de la classe 'AuthentificationInterceptor'</p>
	 * 
	 * @see Logger
	 * @see LogManager#getLogger(Class)
	 */
	private static Logger logger = LogManager.getLogger(AuthentificationInterceptor.class);
	
	
	
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
	public String intercept(ActionInvocation invocation) {
		String vResult = "error-forbidden";
									
		if(invocation.getInvocationContext().getSession().get("utilisateur") != null) {
			Utilisateur utilisateur = (Utilisateur) invocation.getInvocationContext().getSession().get("utilisateur");
			
			if(utilisateur != null) {
				try {
					if(managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
						
						vResult = invocation.invoke();
					}
				} catch (Exception e) {
					StringWriter stackTrace = new StringWriter();
					e.printStackTrace(new PrintWriter(stackTrace));
					logger.error(stackTrace.toString());
				}
			}
		}
		return vResult;
	}

}