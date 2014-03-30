package ee.playtech.trial.server.ws.rest.monitoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.playtech.trial.server.database.ProcessedQueriesStatisticsEntitiesManager;
import ee.playtech.trial.server.model.entity.ProcessedQueriesStatistics;
import ee.playtech.trial.server.ws.helper.StatisticsHelper;

@Service
public class StatisticsCache {

	private final List<Long> processingTimes = new ArrayList<Long>();

	@Autowired
	private ProcessedQueriesStatisticsEntitiesManager statisticsEntityManger;

	@Autowired
	private StatisticsHelper statisticsHelper;

	// TODO: differentiate between methods should be considered
	public void addQueryStatistic(Long processingTime) {
		synchronized (processingTimes) {
			processingTimes.add(processingTime);
		}
	}

	public void persitCurrentStatistics() {
		if (processingTimes.size() > 0) {
			ProcessedQueriesStatistics enity = new ProcessedQueriesStatistics();
			synchronized (processingTimes) {
				enity.setProcessedQueriesQuantity((long) processingTimes.size());
				enity.setMinProcessingTime(Collections.min(processingTimes));
				enity.setMaxProcessingTime(Collections.max(processingTimes));
				enity.setAverageProcessingTime(statisticsHelper
						.calculateAverage(processingTimes));
				processingTimes.clear();
			}

			statisticsEntityManger.saveStatistics(enity);
		}
	}

}
