package ee.playtech.trial.server.ws.rest.monitoring;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WebserviceDataMonitoringInterceptor implements
		AfterReturningAdvice {
	private static String ARGS_SEPARATOR = ",";

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		Logger logger = Logger.getLogger(target.getClass());
		StringBuffer infoMessageBuffer = new StringBuffer();
		logMethodName(method, infoMessageBuffer);
		logInParameters(args, infoMessageBuffer);
		logReturnValue(returnValue, infoMessageBuffer);
		logger.info(infoMessageBuffer.toString());
	}

	private void logMethodName(Method method, StringBuffer infoMessageBuffer) {
		infoMessageBuffer.append("Called method: ").append(method.toString());
	}

	private void logReturnValue(Object returnValue,
			StringBuffer infoMessageBuffer) {
		infoMessageBuffer.append(" OUT value: ").append(returnValue.toString());		
	}

	private void logInParameters(Object[] args, StringBuffer infoMessageBuffer) {
		infoMessageBuffer.append(" IN parameters: ");
		for (int argIndex = 0; argIndex < args.length; argIndex++) {
			infoMessageBuffer.append(args[argIndex].toString());
			infoMessageBuffer.append(ARGS_SEPARATOR);
		}
		if (args.length > 0) {
			infoMessageBuffer.deleteCharAt(infoMessageBuffer.length() - 1);
		}
	}

}
