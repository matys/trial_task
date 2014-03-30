package ee.playtech.trial.server.ws.rest.response;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.*;

@ApiModel(value = "Data describing result of changing balance")
@XmlRootElement
public class AddBalanceChangeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Value of wallet change", required = true)
	private BigDecimal balanceChange;
	
	@ApiModelProperty(value = "User wallet value after change", required = true)
	private BigDecimal balanceAfterChange;

	@ApiModelProperty(value = "Version of wallet, incremented after every"
			+ " change", required = true)
	private Long balanceVersion;

	@ApiModelProperty(value = "Id of transaction", required = true)
	private Long transactionId;

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

	@Override
	public String toString() {
		return "AddBalanceChangeResponse [transactionId=" + transactionId
				+ ", balanceChange=" + balanceChange + ", balanceAfterChange="
				+ balanceAfterChange + ", balanceVersion=" + balanceVersion
				+ "]";
	}

}
