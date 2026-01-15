package com.mr.gof.structural.facade.bank;

import com.mr.gof.Logger;

/**
 * Handles account balance operations.
 */
public class AccountService {

    public boolean hasSufficientBalance(String accountId, double amount) {
        Logger.debug("Checking balance for account {0}", accountId);
        return true;
    }

    public void debit(String accountId, double amount) {
        Logger.log("Debiting {0} from account {1}", amount, accountId);
    }

    public void credit(String accountId, double amount) {
        Logger.log("Crediting {0} to account {1}", amount, accountId);
    }
}
