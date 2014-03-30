package ee.playtech.trial.server.ws.rest.monitoring;

import java.lang.reflect.Method;

import org.apache.log4j.MDC;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WebserviceTimeMonitoringInterceptor implements MethodBeforeAdvice,
		AfterReturningAdvice {

	@Autowired
	private StatisticsCache statisticsCache;

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		MDC.put("startTimestamp", getCurrentTimestamp());
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		Long startTimestamp = (Long) MDC.get("startTimestamp");
		statisticsCache.addQueryStatistic(getCurrentTimestamp() - startTimestamp);
	}

	private long getCurrentTimestamp() {
		return System.currentTimeMillis();
	}

}
