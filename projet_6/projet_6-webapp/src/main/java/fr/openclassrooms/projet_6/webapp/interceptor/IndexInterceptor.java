package fr.openclassrooms.projet_6.webapp.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import fr.openclassrooms.projet_6.webapp.action.GestionUtilisateurAction;
/**
 * <p>
 * 	Interceptor redirigeant vers l'index lorsqu'une action n'est plus autorisé une fois connecté.
 * 	Liste des actions
 * </p>
 * <ul>
 * 		<li>Se connecter => login</li>
 * 		<li>S'inscrire => inscription</li>
 * </ul>
 * 
 * @see GestionUtilisateurAction#doLogin()
 * @see GestionUtilisateurAction#doInscription()
 * @see IndexInterceptor#logger
 * @see IndexInterceptor#intercept(ActionInvocation)
 * @see AbstractInterceptor
 * @see Logger
 * @see LogManager#getLogger(Class)
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class IndexInterceptor extends AbstractInterceptor {
	
	
	
	/**
	 * <p>Logger de la classe 'IndexInterceptor'</p>
	 * 
	 * @see Logger
	 * @see LogManager#getLogger(Class)
	 */
	private static Logger logger = LogManager.getLogger(IndexInterceptor.class);
	
	

	@Override
	public String intercept(ActionInvocation invocation) {
		
		String vResult = "error-forbidden-bis";
		
		if(!invocation.getInvocationContext().getSession().containsKey("utilisateur")) {
			try {
				
				vResult = invocation.invoke();
				
			} catch (Exception e) {
				StringWriter stackTrace = new StringWriter();
				e.printStackTrace(new PrintWriter(stackTrace));
				logger.error(stackTrace.toString());
			}
		}
		
		return vResult;
	}

}
