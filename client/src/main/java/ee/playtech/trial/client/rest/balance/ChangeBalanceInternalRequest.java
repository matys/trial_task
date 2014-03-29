/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.client.rest.balance;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangeBalanceInternalRequest extends InternalRequest {

	private String userName;
	private Long transactionId;
	private BigDecimal balanceChange;

	public ChangeBalanceInternalRequest(String userName, Long transactionId,
			BigDecimal balanceChange) {
		this.userName = userName;
		this.transactionId = transactionId;
		this.balanceChange = balanceChange;
	}

	@Override
	public String getUri() {
		return userName + "/balanceChange/";
	}

	@Override
	public JSONObject getBody() throws JSONException,
			UnsupportedEncodingException {
		JSONObject json = new JSONObject();
		json.put("transactionId", transactionId);
		json.put("amount", balanceChange);
		return json;
	}
}
