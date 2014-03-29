package ee.playtech.trial.server.ws.rest.response;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.*;

@ApiModel(value = "Data describing change of balance")
@XmlRootElement
public class AddBalanceChangeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Transaction Id. Ensure that one transaction won't be processed more than one time", required = true)
	private Long transactionId;
	private BigDecimal balanceChange;
	private BigDecimal balanceAfterChange;
	private Long balanceVersion;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getBalanceChange() {
		return balanceChange;
	}

	public void setBalanceChange(BigDecimal balanceChange) {
		this.balanceChange = balanceChange;
	}

	public BigDecimal getBalanceAfterChange() {
		return balanceAfterChange;
	}

	public void setBalanceAfterChange(BigDecimal balanceAfterChange) {
		this.balanceAfterChange = balanceAfterChange;
	}

	public Long getBalanceVersion() {
		return balanceVersion;
	}

	public void setBalanceVersion(Long balanceVersion) {
		this.balanceVersion = balanceVersion;
	}

}
