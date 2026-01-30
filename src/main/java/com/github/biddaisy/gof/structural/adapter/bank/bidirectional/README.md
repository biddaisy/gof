# Bi‑Directional Adapter Pattern — Banking Integration Example
**Package:** `com.github.biddaisy.gof.structural.adapter.bank.bidirectional`

## 📘 Overview
A **Bi‑Directional Adapter** is an advanced variation of the Adapter Pattern that allows **two incompatible interfaces to communicate with each other in both directions**.

This is especially valuable in banking environments where:

- A **legacy core‑banking system** must call a **modern service**, and
- The **modern service** must also call the legacy system

…all without modifying either side.

This package demonstrates a fully functional bi‑directional adapter that bridges:

- `BankAccountService` (modern API)
- `LegacyBankingOperations` (legacy API)

The adapter implements **both interfaces**, enabling seamless interoperability.

---

## 🧩 Pattern Structure

### **Modern Interface (Target A)**
`BankAccountService`  
Defines the clean, domain‑friendly API used by new microservices:

- `getBalance(accountId)`
- `deposit(accountId, amount)`
- `withdraw(accountId, amount)`

### **Legacy Interface (Target B)**
`LegacyBankingOperations`  
Represents the older system’s API:

- `fetchBalance(acct)`
- `makeDeposit(acct, amt)`
- `makeWithdrawal(acct, amt)`

### **Bi‑Directional Adapter**
`BiDirectionalBankAdapter`  
Implements **both** interfaces:

- When used as `BankAccountService`, it delegates to legacy‑style methods
- When used as `LegacyBankingOperations`, it delegates to modern‑style methods

This enables **Modern → Legacy** and **Legacy → Modern** communication.

### **Client**
`BiDirectionalAdapterDemo`  
Demonstrates both directions of adaptation.

---

## 📂 Class Diagram (Conceptual)

```
          Modern System                      Legacy System
     ┌────────────────────┐            ┌────────────────────────┐
     │ BankAccountService │            │ LegacyBankingOperations│
     └───────────┬────────┘            └─────────────┬──────────┘
                 │                                     │
                 │ implements                          │ implements
                 │                                     │
                 ▼                                     ▼
          ┌──────────────────────────────────────────────────────┐
          │              BiDirectionalBankAdapter                 │
          │   (implements BOTH modern and legacy interfaces)      │
          └──────────────────────────────────────────────────────┘
```

---

## 🧪 Example Usage

```java
BiDirectionalBankAdapter adapter = new BiDirectionalBankAdapter();

// Modern system calling legacy operations
BankAccountService modern = adapter;
modern.deposit("ACC-1001", new BigDecimal("200.00"));
modern.withdraw("ACC-1001", new BigDecimal("50.00"));

// Legacy system calling modern operations
LegacyBankingOperations legacy = adapter;
legacy.makeDeposit("ACC-1001", new BigDecimal("300.00"));
legacy.makeWithdrawal("ACC-1001", new BigDecimal("100.00"));
```

Expected output:

```
[ADAPTER] Deposit: +200.00 → New balance: 1200.00
[ADAPTER] Withdrawal: -50.00 → New balance: 1150.00
[ADAPTER] Deposit: +300.00 → New balance: 1450.00
[ADAPTER] Withdrawal: -100.00 → New balance: 1350.00
```

---

## 🎯 Why Use a Bi‑Directional Adapter?

### ✔ Enables two systems to interoperate
Modern ↔ Legacy communication without rewriting either side.

### ✔ Perfect for gradual migration
Banks rarely replace core systems all at once.

### ✔ Supports backward compatibility
Legacy systems can call new APIs without modification.

### ✔ Clean separation of concerns
Each system continues using its own interface.

### ✔ Realistic banking use case
Used in:

- Core banking modernization
- Payment gateway migrations
- SWIFT ↔ REST transitions
- Risk engine upgrades

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.adapter.bank.bidirectional
│
├── BankAccountService.java
├── LegacyBankingOperations.java
├── BiDirectionalBankAdapter.java
└── BiDirectionalAdapterDemo.java
```

---

## ✔ Summary

This package provides a **fully implemented bi‑directional adapter**, enabling two incompatible banking interfaces to communicate seamlessly.  
It demonstrates:

- Dual‑interface implementation
- Two‑way method translation
- Realistic financial domain behavior
- A powerful extension of the classic Adapter Pattern

This completes your Adapter Pattern suite with a rare but highly practical variant.

---