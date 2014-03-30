package ee.playtech.trial.client.util;

import java.math.BigDecimal;
import java.util.Random;

import ee.playtech.trial.common.configuration.ConfigurationProperty;

public class RandomBalanceChangeStrategy implements IBalanceChangeStrategy {

	private Random random = new Random(System.currentTimeMillis());
	private final static int MAX_BALANCE_CHANGE = Integer
			.parseInt(ConfigurationProperty.MAX_BALANCE_CHANGE.getValue());
	private final static int BALANCE_DECIMAL_PLACES_QUANTITY = 2;
	private final double DECIMAL_FRACTION = Math.pow(10,
			BALANCE_DECIMAL_PLACES_QUANTITY);

	public BigDecimal getNextBalanceChange() {
		double balanceChange = random.nextInt() % (MAX_BALANCE_CHANGE * DECIMAL_FRACTION);
		return new BigDecimal(balanceChange / DECIMAL_FRACTION).setScale(BALANCE_DECIMAL_PLACES_QUANTITY, BigDecimal.ROUND_HALF_UP);
	}
}
