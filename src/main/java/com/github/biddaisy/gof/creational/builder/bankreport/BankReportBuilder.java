package com.github.biddaisy.gof.creational.builder.bankreport;

/**
 * Builder interface defining the steps required to build a bank report.
 * Each concrete builder will implement these steps differently.
 */
public interface BankReportBuilder {

    /** Builds the header section of the report */
    void buildHeader();

    /** Builds the main body section of the report */
    void buildBody();

    /** Builds the footer section of the report */
    void buildFooter();

    /** Returns the fully constructed report */
    BankReport getReport();
}
