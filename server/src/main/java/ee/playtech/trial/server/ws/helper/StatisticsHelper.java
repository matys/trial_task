package ee.playtech.trial.server.ws.helper;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StatisticsHelper {

	public BigDecimal calculateAverage(List<Long> list) {
		BigDecimal averageProcessingTime = null;
		if (list.size() != 0) {
			averageProcessingTime = new BigDecimal(sum(list) / list.size());
		} else {
			averageProcessingTime = new BigDecimal(0);
		}
		return averageProcessingTime;
	}

	public Long sum(List<Long> list) {
		Long sum = 0L;
		for (Long element : list) {
			sum += element;
		}
		return sum;
	}
}
