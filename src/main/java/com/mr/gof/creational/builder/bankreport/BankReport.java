package com.mr.gof.creational.builder.bankreport;

/**
 * The complex object being built.
 * A bank report typically has multiple sections that may vary
 * depending on the type of report (summary, detailed, regulatory, etc.).
 */
public class BankReport {

    private String header;
    private String body;
    private String footer;

    public void setHeader(String header) { this.header = header; }
    public void setBody(String body) { this.body = body; }
    public void setFooter(String footer) { this.footer = footer; }

    @Override
    public String toString() {
        return """
                ===== BANK REPORT =====
                %s

                %s

                %s
                """.formatted(header, body, footer);
    }
}
