package com.mr.gof.creational.prototype.banking;

/**
 * Abstract tool in the banking application.
 *
 * Tools represent actions such as:
 *   - create account
 *   - create loan
 *   - create card
 *
 * Only creation tools use Prototype.
 */
public abstract class Tool {
    public abstract void onAction(BankingDocument document);
}
