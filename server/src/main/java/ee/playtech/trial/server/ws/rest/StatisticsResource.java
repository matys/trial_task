package ee.playtech.trial.server.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;

import ee.playtech.trial.server.database.ProcessedQueriesStatisticsEntitiesManager;
import ee.playtech.trial.server.model.entity.Player;
import ee.playtech.trial.server.model.entity.ProcessedQueriesStatistics;

@Path("/statistics")
@Api(value = "/", description = "processing queries statistics")
@Component
public class StatisticsResource {

	@Autowired
	ProcessedQueriesStatisticsEntitiesManager statisticsEntitiesManager;

	@GET
	@Path("/")
	@Produces("application/json")
	public List<ProcessedQueriesStatistics> getStatistics() {
		return statisticsEntitiesManager.listStatistics();
	}

}
