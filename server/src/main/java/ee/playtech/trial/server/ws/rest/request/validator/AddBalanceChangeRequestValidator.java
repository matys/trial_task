package ee.playtech.trial.server.ws.rest.request.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import ee.playtech.trial.server.ws.rest.request.AddBalanceChangeRequest;

@Service
public class AddBalanceChangeRequestValidator {

	public static final int NO_USER_NAME_ERROR_CODE = 431;
	public static final String NO_USER_NAME_ERROR_DESCRIPTION = "No user name specified";

	public static final int NO_AMOUNT_ERROR_CODE = 432;
	public static final String NO_AMOUNT_ERROR_DESCRIPTION = "No amount specified";

	public static final int NO_TRANSACTION_ID_ERROR_CODE = 433;
	public static final String NO_TRANSACTION_ID_ERROR_DESCRIPTION = "No transaction id specified";
	public static final int OK_STATUS_CODE = 200;

	public int validate(AddBalanceChangeRequest request, String userName) {
		if (userName == null || StringUtils.isBlank(userName)) {
			return NO_USER_NAME_ERROR_CODE;
		}
		if (request.getAmount() == null) {
			return NO_AMOUNT_ERROR_CODE;
		}
		if (request.getTransactionId() == null) {
			return NO_TRANSACTION_ID_ERROR_CODE;
		}
		return OK_STATUS_CODE;
	}
}
