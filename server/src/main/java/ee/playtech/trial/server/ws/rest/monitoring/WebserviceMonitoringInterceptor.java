package ee.playtech.trial.server.ws.rest.monitoring;

import java.lang.reflect.Method;

import org.apache.log4j.MDC;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WebserviceMonitoringInterceptor implements MethodBeforeAdvice, AfterReturningAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		MDC.put("startTimestamp", System.currentTimeMillis());
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		Long startTimestamp = (Long) MDC.get("startTimestamp");
		System.out.println("starttttt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + startTimestamp);
	}

}
