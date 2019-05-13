package fr.openclassrooms.projet_6.webapp.interceptor;

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
 * @see IndexInterceptor#intercept(ActionInvocation)
 * @see AbstractInterceptor
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class IndexInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String vResult = "error-forbidden-bis";
		
		if(!invocation.getInvocationContext().getSession().containsKey("utilisateur")) {
			vResult = invocation.invoke();
		}
		
		return vResult;
	}

}
