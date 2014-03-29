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
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class RESTClient {

	void executePostRequest(InternalRequest internalRequest) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:9999/"
				+ internalRequest.getUri());
		buildHeaders(postRequest);
		buildBody(internalRequest, postRequest);
		HttpResponse response = httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			handleErrors(response);
		} else {
			log(response);
		}
		httpClient.getConnectionManager().shutdown();
	}

	private void log(HttpResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
	}

	private void handleErrors(HttpResponse response) {
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}
	}

	private void buildBody(InternalRequest internalRequest, HttpPost postRequest)
			throws UnsupportedEncodingException, JSONException {
		StringEntity jsonEntity = new StringEntity(internalRequest.getBody()
				.toString());
		jsonEntity.setContentType("application/json");
		postRequest.setEntity(jsonEntity);
	}

	private void buildHeaders(HttpPost postRequest) {
		postRequest.addHeader("accept", "application/json");
		postRequest.addHeader("ContentType", "application/json");
	}

}
