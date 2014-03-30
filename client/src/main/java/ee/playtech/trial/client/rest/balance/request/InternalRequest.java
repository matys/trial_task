package ee.playtech.trial.client.rest.balance.request;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class InternalRequest {

	public abstract String getUri();

	public abstract JSONObject getBody() throws JSONException,
			UnsupportedEncodingException;

}
