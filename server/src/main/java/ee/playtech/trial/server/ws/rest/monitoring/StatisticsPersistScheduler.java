package ee.playtech.trial.server.ws.rest.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StatisticsPersistScheduler {

	private final static long STATISTICS_PERSIST_FREQUENCY = 60000L;

	@Autowired
	private StatisticsCache statisticsCache;

	@Scheduled(fixedDelay = STATISTICS_PERSIST_FREQUENCY)
	public void persistStatistics() {
		statisticsCache.persitCurrentStatistics();
	}
}
