package ee.playtech.trial;

import ee.playtech.trial.client.rest.balance.BalanceChangeStrategyType;
import ee.playtech.trial.client.rest.balance.BalanceUpdater;
import ee.playtech.trial.client.rest.balance.TransactionIdGeneratorType;

public class ClientApp {
	public static void main(String[] args) throws InterruptedException {
		Thread balanceUpdater = new BalanceUpdater(BalanceChangeStrategyType.RANDOM.getInstance(), TransactionIdGeneratorType.INCREMENTAL.getInstance()); //change to properties + builder
		balanceUpdater.run();
		balanceUpdater.join(); //??
		//TODO frequency??
	}
}
