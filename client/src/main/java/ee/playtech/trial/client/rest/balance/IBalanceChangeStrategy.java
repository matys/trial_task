/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.client.rest.balance;

import java.math.BigDecimal;

public interface IBalanceChangeStrategy {

	abstract BigDecimal getNextBalanceChange();
}
