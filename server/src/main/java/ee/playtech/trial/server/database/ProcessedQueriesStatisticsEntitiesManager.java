package ee.playtech.trial.server.database;

import java.util.List;

import org.springframework.stereotype.Service;

import ee.playtech.trial.server.model.entity.ProcessedQueriesStatistics;

@Service
public class ProcessedQueriesStatisticsEntitiesManager extends EntitiesManager {

	public void saveStatistics(ProcessedQueriesStatistics entity) {
		super.save(entity);
	}

	public List<ProcessedQueriesStatistics> listStatistics() {
		return super.list(ProcessedQueriesStatistics.class);
	}

}
