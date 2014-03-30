package ee.playtech.trial.client.rest.balance.request;

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
		return userName + "/wallet/balanceChange/";
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
