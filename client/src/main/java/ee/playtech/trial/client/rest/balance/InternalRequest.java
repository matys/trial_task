/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.client.rest.balance;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class InternalRequest {

	abstract String getUri();

	abstract JSONObject getBody() throws JSONException,
			UnsupportedEncodingException;

}
