package ee.playtech.trial.client.rest.balance.enums;

import ee.playtech.trial.client.util.ITransactionIdGenerator;
import ee.playtech.trial.client.util.IncrementalTransactionIdGenerator;

public enum TransactionIdGeneratorType  implements InstantiableEnum<ITransactionIdGenerator> {

	INCREMENTAL {
		public ITransactionIdGenerator getInstance() {
			return new IncrementalTransactionIdGenerator();
		}
	}
	/***more generators types here***/;
}
