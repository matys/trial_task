package ee.playtech.trial.client.rest.balance;

public enum BalanceChangeStrategyType implements InstantiableEnum<IBalanceChangeStrategy> {

	RANDOM {
		public IBalanceChangeStrategy getInstance() {
			return new RandomBalanceChangeStrategy();
		}
	}
	/***more strategies here***/;

}
