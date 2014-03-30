package ee.playtech.trial.server.ws.rest.request;

import java.io.Serializable;
import com.wordnik.swagger.annotations.*;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@ApiModel(value = "Data describing change of balance")
@XmlRootElement
public class AddBalanceChangeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id of transaction", required = true)
	private Long transactionId;
	@ApiModelProperty(value = "Amount by which wallet is to be changed", required = true)
	private BigDecimal amount;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AddBalanceChangeRequest [transactionId=" + transactionId
				+ ", amount=" + amount + "]";
	}

}
