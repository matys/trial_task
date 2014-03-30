package ee.playtech.trial.client.util;

import java.math.BigDecimal;

public interface IBalanceChangeStrategy {

	abstract BigDecimal getNextBalanceChange();
}
