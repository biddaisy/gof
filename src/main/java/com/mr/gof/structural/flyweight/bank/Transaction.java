package com.mr.gof.structural.flyweight.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.text.DateFormat.getDateTimeInstance;

/**
 * Represents a bank transaction using multiple flyweights:
 * - CurrencyFlyweight
 * - TransactionTypeFlyweight
 * - BankBranchFlyweight
 *
 * Only extrinsic state is stored here.
 */
public class Transaction {

    private final String accountId;
    private final BigDecimal amount;
    private final long timestamp;

    private final CurrencyFlyweight currency;
    private final TransactionTypeFlyweight type;
    private final BankBranchFlyweight branch;

    public Transaction(String accountId,
                       BigDecimal amount,
                       String currencyCode,
                       String typeCode,
                       String branchId) {

        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();

        this.currency = CurrencyFactory.getCurrency(currencyCode);
        this.type = TransactionTypeFactory.get(typeCode);
        this.branch = BankBranchFactory.get(branchId);
    }

    public void print() {
        Logger.log(
                "Transaction: account={0}, amount={1}{2}, type={3}, branch={4} ({5}, {6}), currency={7}, time={8}",
                accountId,
                currency.symbol(),
                amount,
                type.code(),
                branch.branchId(),
                branch.city(),
                branch.country(),
                currency.code(),
                getDateTimeInstance().format(new Date(timestamp))
        );
    }
}
