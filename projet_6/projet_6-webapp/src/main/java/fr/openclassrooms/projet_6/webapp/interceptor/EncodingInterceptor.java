package fr.openclassrooms.projet_6.webapp.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <p>
 * 	Interceptor servant à encoder en 'UTF-8' les requêtes
 * 	de façon à permettre le bon traitement des caractère spéciaux.
 * </p>
 * 
 * @see EncodingInterceptor#intercept(ActionInvocation)
 * @see AbstractInterceptor
 * @see HttpServletRequest
 * @see HttpServletResponse
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class EncodingInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
						
	    HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
	    HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
	    
	    if(request != null && response != null) {
	    	request.setCharacterEncoding("UTF-8");
	    	response.setContentType("text/html; charset=UTF-8");
	    	
	    	Map<String, Object> contextMap = new HashMap<String, Object>();
	    	contextMap.put(ServletActionContext.HTTP_REQUEST, request);
	    	contextMap.put(ServletActionContext.HTTP_RESPONSE, response);
	    	
	    	invocation.getInvocationContext().getContextMap().putAll(contextMap);
	    }
		String vResult = invocation.invoke();
		
        return vResult;
        
	}
}
