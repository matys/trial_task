package ee.playtech.trial.client.rest.balance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class BalanceUpdater extends Thread {

	private IBalanceChangeStrategy balanceChangeGenerator;

	private ITransactionIdGenerator transactionIdGenerator;

	private UserBalanceClient balanceClient = new UserBalanceClient();

	public BalanceUpdater(IBalanceChangeStrategy balanceChangeGenerator,
			ITransactionIdGenerator transactionIdGenerator) {
		this.balanceChangeGenerator = balanceChangeGenerator;
		this.transactionIdGenerator = transactionIdGenerator;
	}

	@Override
	public void run() {
		while (true) {
			BigDecimal balanceChange = balanceChangeGenerator
					.getNextBalanceChange();
			try {
				balanceClient.changeBalance("Test", balanceChange,
						transactionIdGenerator.generateNext()); // Configuration
			} catch (Exception e) {
				// add loging
				System.out.println("Error happened while changing balance");
				e.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(10000); // Conf (do konf mozna
														// dodac typ obiektu
														// zeby oknfiguracja
														// mogla zwracac enumy
														// np.). W razie zlego
														// typu rzucac wyjatkiem
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
