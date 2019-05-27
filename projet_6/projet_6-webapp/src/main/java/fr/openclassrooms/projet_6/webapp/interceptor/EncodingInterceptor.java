package fr.openclassrooms.projet_6.webapp.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <p>
 * 	Interceptor servant à encoder en 'UTF-8' les requêtes
 * 	de façon à permettre le bon traitement des caractère spéciaux.
 * </p>
 * 
 * @see EncodingInterceptor#logger
 * @see EncodingInterceptor#intercept(ActionInvocation)
 * @see AbstractInterceptor
 * @see HttpServletRequest
 * @see HttpServletResponse
 * @see Logger
 * @see LogManager#getLogger(Class)
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class EncodingInterceptor extends AbstractInterceptor{
	
	
	
	/**
	 * <p>Logger de la classe 'EncodingInterceptor'</p>
	 * 
	 * @see Logger
	 * @see LogManager#getLogger(Class)
	 */
	private static Logger logger = LogManager.getLogger(EncodingInterceptor.class);
	
	
	
	@Override
	public String intercept(ActionInvocation invocation) {
						
		String vResult = "error";
	    HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
	    HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
	    
	    if(request != null && response != null) {
	    	try {
	    		
				request.setCharacterEncoding("UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				StringWriter stackTrace = new StringWriter();
				e.printStackTrace(new PrintWriter(stackTrace));
				logger.error(stackTrace.toString());
			}
	    	response.setContentType("text/html; charset=UTF-8");
	    	
	    	Map<String, Object> contextMap = new HashMap<String, Object>();
	    	contextMap.put(ServletActionContext.HTTP_REQUEST, request);
	    	contextMap.put(ServletActionContext.HTTP_RESPONSE, response);
	    	
	    	invocation.getInvocationContext().getContextMap().putAll(contextMap);
	    }

		try {
			
			vResult = invocation.invoke();
			
		} catch (Exception e) {
			StringWriter stackTrace = new StringWriter();
			e.printStackTrace(new PrintWriter(stackTrace));
			logger.error(stackTrace.toString());
		}
		
        return vResult;
        
	}
}
