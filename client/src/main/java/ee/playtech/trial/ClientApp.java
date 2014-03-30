package ee.playtech.trial;

import ee.playtech.trial.client.rest.balance.BalanceUpdater;
import ee.playtech.trial.client.rest.balance.enums.BalanceChangeStrategyType;
import ee.playtech.trial.client.rest.balance.enums.TransactionIdGeneratorType;
import ee.playtech.trial.common.configuration.ConfigurationProperty;

public class ClientApp {
	public static void main(String[] args) throws InterruptedException {
		BalanceChangeStrategyType balanceChangeStrategy = BalanceChangeStrategyType
				.valueOf(ConfigurationProperty.BALANCE_STRATEGY_CHANGE
						.getValue());
		TransactionIdGeneratorType transactionIdGenerator = TransactionIdGeneratorType
				.valueOf(ConfigurationProperty.TRANSACTION_ID_GENERATOR
						.getValue());

		Thread balanceUpdater = new BalanceUpdater(
				balanceChangeStrategy.getInstance(),
				transactionIdGenerator.getInstance());
		balanceUpdater.run();
	}
}
