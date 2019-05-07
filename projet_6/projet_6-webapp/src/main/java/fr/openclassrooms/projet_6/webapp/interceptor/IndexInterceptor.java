package fr.openclassrooms.projet_6.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

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
