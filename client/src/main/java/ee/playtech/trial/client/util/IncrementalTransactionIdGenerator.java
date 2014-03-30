package ee.playtech.trial.client.util;


public class IncrementalTransactionIdGenerator implements ITransactionIdGenerator {

	Long transactionId = 1L;
	
	public Long generateNext() {
		return transactionId++;
	}

}
