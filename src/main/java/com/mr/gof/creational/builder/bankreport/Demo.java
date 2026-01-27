package com.mr.gof.creational.builder.bankreport;

import com.mr.gof.Logger;

/**
 * Demonstrates the Builder pattern using three different concrete builders:
 *
 *  - SummaryReportBuilder:     High-level executive summary
 *  - DetailedReportBuilder:    Full analytical breakdown
 *  - RegulatoryReportBuilder:  Compliance and audit-focused report
 *
 * The Director (BankReportDirector) orchestrates the build sequence.
 * Each builder produces a different report even though the sequence is identical.
 */
public class Demo {

    public static void main(String[] args) {

        // --- Summary Report ---
        Logger.log("Building Summary Report...");
        BankReportDirector summaryDirector =
                new BankReportDirector(new SummaryReportBuilder());
        BankReport summary = summaryDirector.buildReport();
        Logger.log(summary.toString());

        // --- Detailed Report ---
        Logger.log("Building Detailed Report...");
        BankReportDirector detailedDirector =
                new BankReportDirector(new DetailedReportBuilder());
        BankReport detailed = detailedDirector.buildReport();
        Logger.log(detailed.toString());

        // --- Regulatory Report ---
        Logger.log("Building Regulatory Report...");
        BankReportDirector regulatoryDirector =
                new BankReportDirector(new RegulatoryReportBuilder());
        BankReport regulatory = regulatoryDirector.buildReport();
        Logger.log(regulatory.toString());
    }
}
