package ee.playtech.trial.server.ws.rest.monitoring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class AuthFilter extends HandlerInterceptorAdapter {


    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
    	System.out.println("TEEEEEEEEEEEEEEEEEEEEEEESJOHJIHJBJKSHBDHIGIYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY!!!!!!!!!!!!!!");
    	throw new NotImplementedException();

       
    }
}