package ee.playtech.trial.client.rest.balance;

import java.math.BigDecimal;

public class UserBalanceClient extends RESTClient {

	public void changeBalance(String userName, BigDecimal balanceChange,
			Long transactionId) throws Exception {
		InternalRequest request = new ChangeBalanceInternalRequest(userName,
				transactionId, balanceChange);
		executePostRequest(request);
	}
}
