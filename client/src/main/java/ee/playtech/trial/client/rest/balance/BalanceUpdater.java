package ee.playtech.trial.client.rest.balance;

import java.math.BigDecimal;

import ee.playtech.trial.client.util.IBalanceChangeStrategy;
import ee.playtech.trial.client.util.ITransactionIdGenerator;
import ee.playtech.trial.common.configuration.ConfigurationProperty;

public class BalanceUpdater extends Thread {

	private IBalanceChangeStrategy balanceChangeGenerator;

	private ITransactionIdGenerator transactionIdGenerator;

	private UserBalanceClient balanceClient = new UserBalanceClient();

	public BalanceUpdater(IBalanceChangeStrategy balanceChangeGenerator,
			ITransactionIdGenerator transactionIdGenerator) {
		this.balanceChangeGenerator = balanceChangeGenerator;
		this.transactionIdGenerator = transactionIdGenerator;
	}

	@Override
	public void run() {
		while (true) {
			BigDecimal balanceChange = balanceChangeGenerator
					.getNextBalanceChange();
			try {
				balanceClient.changeBalance(ConfigurationProperty.USER_NAME.getValue(), balanceChange,
						transactionIdGenerator.generateNext()); 
			} catch (Exception e) {
				System.out.println("Error happened while changing balance");
				e.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(Integer.parseInt(ConfigurationProperty.UPDATES_BREAK_LENGTH.getValue())); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
