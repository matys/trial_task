package ee.playtech.trial.client.rest.balance;

import java.math.BigDecimal;

import ee.playtech.trial.client.rest.balance.request.ChangeBalanceInternalRequest;
import ee.playtech.trial.client.rest.balance.request.InternalRequest;

public class UserBalanceClient extends RESTClient {

	public void changeBalance(String userName, BigDecimal balanceChange,
			Long transactionId) throws Exception {
		InternalRequest request = new ChangeBalanceInternalRequest(userName,
				transactionId, balanceChange);
		executePostRequest(request);
	}
}
