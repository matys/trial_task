package ee.playtech.trial.client.rest.balance;

public enum TransactionIdGeneratorType  implements InstantiableEnum<ITransactionIdGenerator> {

	INCREMENTAL {
		public ITransactionIdGenerator getInstance() {
			return new IncrementalTransactionIdGenerator();
		}
	}
	/***more generators types here***/;
}
