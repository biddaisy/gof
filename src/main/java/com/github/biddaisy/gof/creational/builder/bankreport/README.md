# Bank Report Builder — GoF Builder Pattern
**Package:** `com.github.biddaisy.gof.creational.builder.bankreport`

## 📘 Overview
This module demonstrates the **GoF Builder pattern** using a realistic banking scenario:  
constructing different types of **bank reports**.

A bank report is a complex object composed of multiple sections:

- Header
- Body
- Footer

Different business units require different report styles:

- **Summary Report** — high‑level executive overview
- **Detailed Report** — analytical, data‑rich breakdown
- **Regulatory Report** — compliance‑driven, audit‑ready

The Builder pattern allows the system to construct these reports using the **same sequence of steps**, while each concrete builder produces a **different representation**.

---

## 🧩 Pattern Structure

### **1. Product — `BankReport`**
A simple POJO representing the final report.  
It exposes setters for the builder and a formatted `toString()` for output.

### **2. Builder Interface — `BankReportBuilder`**
Defines the steps required to build a report:

```java
void buildHeader();
void buildBody();
void buildFooter();
BankReport getReport();
```

Each concrete builder implements these steps differently.

---

## 🧱 Concrete Builders

### **SummaryReportBuilder**
Produces a lightweight, high‑level report suitable for executives or dashboards.

### **DetailedReportBuilder**
Produces a full analytical report with breakdowns, metrics, and risk indicators.

### **RegulatoryReportBuilder**
Produces a compliance‑oriented report containing mandatory disclosures  
(Basel III, IFRS9, AML/KYC, audit trail, etc.).

Each builder fills the report sections with different content.

---

## 🎛 Director — `BankReportDirector`
The Director defines the **construction sequence**:

```java
builder.buildHeader();
builder.buildBody();
builder.buildFooter();
return builder.getReport();
```

The Director is independent of concrete builders.  
This ensures consistent construction logic across all report types.

---

## 📝 Logger — `Logger`
A minimal logging utility used by the demo.  
In a real banking system, this would delegate to SLF4J, Log4J2, or a custom audit logger.

---

## 🧪 Demo — `Demo.java`
Demonstrates building three different reports using the same Director:

- Summary Report
- Detailed Report
- Regulatory Report

All output is logged using `Logger.log()`.

---

## 🏗 Example Usage

```java
BankReportDirector director =
        new BankReportDirector(new DetailedReportBuilder());

BankReport report = director.buildReport();
Logger.log(report.toString());
```

---

## 🎯 Why This Module Is a Strong GoF Example

### ✔ Same construction sequence, different results
The Director always calls the same steps, but each builder produces a unique report.

### ✔ Clean separation of concerns
- Director → *how* to build
- Builder → *what* to build
- Product → final representation

### ✔ Realistic banking domain
Banks generate summary, detailed, and regulatory reports daily.

### ✔ Extensible
Adding a new report type is as simple as creating a new builder:

```
ExecutiveReportBuilder
RiskReportBuilder
AMLReportBuilder
```

No changes to the Director or existing builders.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.builder.bankreport
│
├── BankReport.java
├── BankReportBuilder.java
├── BankReportDirector.java
│
├── SummaryReportBuilder.java
├── DetailedReportBuilder.java
├── RegulatoryReportBuilder.java
│
├── Logger.java
└── Demo.java
```

---

## ✔ Summary
This module provides a **complete, GoF‑faithful implementation** of the Builder pattern in a banking context.  
It demonstrates:

- Multiple concrete builders
- A shared construction sequence
- A realistic, domain‑specific product
- Clean extensibility and maintainability

A strong reference implementation for enterprise‑grade Builder usage.

---
