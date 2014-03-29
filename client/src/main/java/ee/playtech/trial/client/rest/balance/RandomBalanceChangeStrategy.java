package ee.playtech.trial.client.rest.balance;

import java.math.BigDecimal;
import java.util.Random;

public class RandomBalanceChangeStrategy implements IBalanceChangeStrategy{

	private Random random = new Random(); //TODO seed
	private final static int MAX_BALANCE_CHANGE = 250; //configuration
	private final static int BALANCE_DECIMAL_NUMBER = 100; //rename
	
	public BigDecimal getNextBalanceChange() {
		return new BigDecimal(random.nextInt() % MAX_BALANCE_CHANGE / BALANCE_DECIMAL_NUMBER);
	}

}
