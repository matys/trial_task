package ee.playtech.trial;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import ee.playtech.trial.client.rest.balance.BalanceClient;

/**
 * Hello world!
 * 
 */
public class ClientApp {
	public static void main(String[] args) {
		BalanceClient balanceClient = new BalanceClient();
		try {
			balanceClient.changeBalance("Test", new BigDecimal(123));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
