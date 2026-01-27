package com.mr.gof.creational.builder.bankreport;

/**
 * Director class.
 * Defines the order in which the building steps are executed.
 * The same sequence is used for all builders, but the output differs
 * because each builder implements the steps differently.
 */
public class BankReportDirector {

    private final BankReportBuilder builder;

    public BankReportDirector(BankReportBuilder builder) {
        this.builder = builder;
    }

    /**
     * Builds a complete report by executing the steps in a fixed order.
     * This ensures consistent construction logic regardless of builder type.
     */
    public BankReport buildReport() {
        builder.buildHeader();
        builder.buildBody();
        builder.buildFooter();
        return builder.getReport();
    }
}
