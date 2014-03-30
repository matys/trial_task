package ee.playtech.trial.server.model;

import java.math.BigDecimal;

public class BalanceChangeInfo {

	private Long version;
	private BigDecimal balanceChange;
	private BigDecimal currentBalance;

	public BalanceChangeInfo(Long version, BigDecimal balanceChange,
			BigDecimal currentBalance) {
		this.version = version;
		this.balanceChange = balanceChange;
		this.currentBalance = currentBalance;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public BigDecimal getBalanceChange() {
		return balanceChange;
	}

	public void setBalanceChange(BigDecimal balanceChange) {
		this.balanceChange = balanceChange;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

}
