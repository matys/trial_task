/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.client.rest.balance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class BalanceClient {

	public void changeBalance(String userName, BigDecimal balanceChange)
			throws ClientProtocolException, IOException, JSONException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:9999/" + userName
				+ "/balanceChange/");
		postRequest.addHeader("accept", "application/json");
		postRequest.addHeader("ContentType", "application/json");
		JSONObject json = new JSONObject();
		json.put("transactionId", 22);
		json.put("amount", balanceChange);
		StringEntity jsonEntity = new StringEntity(json.toString());
		jsonEntity.setContentType("application/json");
		postRequest.setEntity(jsonEntity);
		HttpResponse response = httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		httpClient.getConnectionManager().shutdown();

	}
}
