package com.mr.gof.structural.facade.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Handles account balance operations.
 */
public class AccountService {

    public boolean hasSufficientBalance(String accountId, BigDecimal amount) {
        Logger.debug("Checking balance for account {0}", accountId);
        return true;
    }

    public void debit(String accountId, BigDecimal amount) {
        Logger.log("Debiting {0} from account {1}", amount, accountId);
    }

    public void credit(String accountId, BigDecimal amount) {
        Logger.log("Crediting {0} to account {1}", amount, accountId);
    }
}
