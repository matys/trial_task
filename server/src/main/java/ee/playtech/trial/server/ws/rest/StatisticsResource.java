package ee.playtech.trial.server.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import ee.playtech.trial.server.database.ProcessedQueriesStatisticsEntitiesManager;
import ee.playtech.trial.server.model.entity.Player;
import ee.playtech.trial.server.model.entity.ProcessedQueriesStatistics;
import ee.playtech.trial.server.ws.rest.response.AddBalanceChangeResponse;

@Path("/statistics")
@Api(value = "/", description = "processing queries statistics")
@Component
public class StatisticsResource {

	@Autowired
	ProcessedQueriesStatisticsEntitiesManager statisticsEntitiesManager;

	@GET
	@Path("/")
	@ApiOperation(value = "return list of all current statistics", notes = "Method for getting all statistics about query execution (every statistic describes one minute), sorted with id (the greater id the later minute description)", response = ProcessedQueriesStatistics.class)
	@Produces("application/json")
	public List<ProcessedQueriesStatistics> getStatistics() {
		return statisticsEntitiesManager.listStatistics();
	}

}
