# Adapter Pattern — Class Adapter (Banking Example)
**Package:** `com.mr.gof.structural.adapter.bank.classadapter`

## 📘 Overview
The **Adapter Pattern** enables incompatible interfaces to work together by converting one interface into another that clients expect.  
This package demonstrates the **Class Adapter** variant, where the adapter uses **inheritance** to adapt a legacy banking API to a modern service interface.

In contrast to the Object Adapter (composition‑based) version, the Class Adapter:

- **Extends** the legacy class directly
- **Implements** the modern interface
- Provides tighter coupling and direct access to legacy behavior
- Is useful when the adaptee must be subclassed or overridden

---

## 🧩 Pattern Structure

### **Target Interface (Modern API)**
`BankAccountService`  
Defines the clean, domain‑friendly operations expected by modern banking services:

- `getBalance(accountId)`
- `deposit(accountId, amount)`
- `withdraw(accountId, amount)`

### **Adaptee (Legacy System)**
`LegacyCoreBankingAPI`  
Represents an older system with incompatible method names:

- `fetchBalance(acct)`
- `makeDeposit(acct, amt)`
- `makeWithdrawal(acct, amt)`

This system cannot be modified.

### **Class Adapter**
`LegacyBankClassAdapter`  
Bridges the modern interface to the legacy API using **inheritance**:

- Extends `LegacyCoreBankingAPI`
- Implements `BankAccountService`
- Translates modern calls into legacy calls

### **Client**
`ClassAdapterBankDemo`  
Uses only the modern interface and is completely unaware of the legacy system behind it.

---

## 📂 Class Diagram (Conceptual)

```
                ┌──────────────────────────────┐
                │     BankAccountService       │  (Target Interface)
                └───────────────┬──────────────┘
                                │ implements
                                ▼
                ┌──────────────────────────────┐
                │   LegacyBankClassAdapter     │  (Class Adapter)
                └───────────────┬──────────────┘
                                │ extends
                                ▼
                ┌──────────────────────────────┐
                │   LegacyCoreBankingAPI       │  (Adaptee)
                └──────────────────────────────┘
```

---

## 🧪 Example Usage

```java
BankAccountService service = new LegacyBankClassAdapter();

Logger.log("Balance: " + service.getBalance("ACC-1001"));
service.deposit("ACC-1001", new BigDecimal("250.00"));
service.withdraw("ACC-1001", new BigDecimal("100.00"));
```

Expected output:

```
Balance: 1000.00
[LEGACY] Deposited 250.00 into ACC-1001
[LEGACY] Withdrew 100.00 from ACC-1001
```

---

## 🎯 When to Use a Class Adapter

### ✔ Advantages
- Direct access to legacy methods
- Slightly faster than delegation (no extra indirection)
- Allows overriding legacy behavior
- Clean and compact implementation

### ✘ Limitations
- Cannot adapt multiple classes (single inheritance)
- Tightly couples adapter to legacy system
- Not suitable when the adaptee is `final`
- Less flexible than the Object Adapter variant

---

## 📦 Package Structure

```
com.mr.gof.structural.adapter.bank.classadapter
│
├── BankAccountService.java
├── LegacyCoreBankingAPI.java
├── LegacyBankClassAdapter.java
└── ClassAdapterBankDemo.java
```

---

## ✔ Summary

This package provides a **fully implemented Class Adapter** for integrating a legacy banking API into a modern service interface.  
It demonstrates:

- Clean inheritance‑based adaptation
- Transparent client usage
- Realistic banking domain integration
- A textbook example of the GoF Class Adapter variant

This complements the Object Adapter version and completes your Adapter Pattern coverage.

---