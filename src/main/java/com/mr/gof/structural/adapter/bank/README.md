# Adapter Pattern — Banking Integration Example
**Package:** `com.mr.gof.structural.adapter.bank`

## 📘 Overview
The **Adapter Pattern** allows incompatible interfaces to work together by converting one interface into another that clients expect.  
In banking systems, this pattern is essential for integrating **legacy core‑banking systems** with **modern service layers** without rewriting old code.

This example demonstrates how a modern `BankAccountService` interface can be backed by a legacy API (`LegacyCoreBankingAPI`) using an adapter (`LegacyBankAdapter`).

---

## 🧩 Pattern Structure

### **Target Interface (Modern API)**
`BankAccountService`  
Defines clean, domain‑friendly operations:

- `getBalance(accountId)`
- `deposit(accountId, amount)`
- `withdraw(accountId, amount)`

This is the interface expected by new microservices, REST controllers, and business logic.

---

### **Adaptee (Legacy System)**
`LegacyCoreBankingAPI`  
Represents an old system that:

- Cannot be modified
- Uses outdated method names
- Has different semantics
- Is still critical to business operations

Example legacy methods:

- `fetchBalance(acct)`
- `makeDeposit(acct, amt)`
- `makeWithdrawal(acct, amt)`

---

### **Adapter (Bridge Between New and Old)**
`LegacyBankAdapter`  
Implements the modern interface while internally delegating to the legacy API.

Responsibilities:

- Translate method names
- Convert parameters
- Preserve legacy behavior
- Expose a clean interface to clients

---

### **Client**
`AdapterBankDemo`  
Uses only the modern interface (`BankAccountService`) and is completely unaware of the legacy system behind it.

---

## 🏦 Banking Scenario

Banks often run:

- COBOL mainframes
- Legacy SOAP services
- Old proprietary APIs
- Systems with outdated naming conventions

Modernizing these systems requires **adapters**, not rewrites.

This example models exactly that scenario:

- New services expect `BankAccountService`
- Legacy system exposes incompatible methods
- Adapter bridges the gap

---

## 📂 Class Diagram (Conceptual)

```
                ┌──────────────────────────────┐
                │     BankAccountService       │  (Target Interface)
                └───────────────┬──────────────┘
                                │
                                ▼
                ┌──────────────────────────────┐
                │      LegacyBankAdapter       │  (Adapter)
                └───────────────┬──────────────┘
                                │ delegates to
                                ▼
                ┌──────────────────────────────┐
                │   LegacyCoreBankingAPI       │  (Adaptee)
                └──────────────────────────────┘
```

---

## 🧪 Example Usage

```java
LegacyCoreBankingAPI legacy = new LegacyCoreBankingAPI();
BankAccountService service = new LegacyBankAdapter(legacy);

Logger.log("Balance: " + service.getBalance("ACC-1001"));
service.deposit("ACC-1001", new BigDecimal("250.00"));
service.withdraw("ACC-1001", new BigDecimal("100.00"));
```

Output (conceptual):

```
Balance: 1000.00
[LEGACY] Deposited 250.00 into ACC-1001
[LEGACY] Withdrew 100.00 from ACC-1001
```

---

## 🎯 Why This Is a True GoF Adapter

### ✔ Converts one interface into another
Legacy → Modern.

### ✔ Client remains unchanged
Client depends only on the target interface.

### ✔ Legacy system remains untouched
No modifications to `LegacyCoreBankingAPI`.

### ✔ Clean separation of concerns
Modern code stays modern; legacy code stays isolated.

### ✔ Realistic banking use case
Banks rely heavily on adapters to integrate decades‑old systems.

---

## 📦 Package Structure

```
com.mr.gof.structural.adapter.bank
│
├── BankAccountService.java        (Target Interface)
├── LegacyCoreBankingAPI.java      (Adaptee)
├── LegacyBankAdapter.java         (Adapter)
└── AdapterBankDemo.java           (Client)
```

---

## ✔ Summary

This package provides a **realistic, domain‑accurate implementation** of the Adapter Pattern in a banking context.  
It demonstrates how to:

- Integrate legacy systems
- Expose clean modern interfaces
- Avoid rewriting old code
- Maintain backward compatibility
- Support modernization efforts

A textbook example of the Adapter Pattern applied to real‑world financial systems.

---