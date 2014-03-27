package ee.playtech.trial.server.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StatisticsScheduler {
	
	@Scheduled(fixedDelay = 5000)
	public void Bar() {
		System.out.println("test!!!!!!!!!!!!");
	}
}
