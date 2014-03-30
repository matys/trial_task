package ee.playtech.trial.client.rest.balance.enums;

import ee.playtech.trial.client.util.IBalanceChangeStrategy;
import ee.playtech.trial.client.util.RandomBalanceChangeStrategy;

public enum BalanceChangeStrategyType implements InstantiableEnum<IBalanceChangeStrategy> {

	RANDOM {
		public IBalanceChangeStrategy getInstance() {
			return new RandomBalanceChangeStrategy();
		}
	}
	/***more strategies here***/;

}
