# Flyweight Pattern — Banking Example
**Package:** `com.github.biddaisy.gof.structural.flyweight.bank`

## 📘 Overview
The **Flyweight Pattern** is a structural design pattern from the *Gang of Four (GoF)*.  
Its purpose is to **minimize memory usage** by sharing immutable, intrinsic state across many objects.

In banking systems, millions of transactions may reference the same:

- Currency metadata
- Transaction types
- Bank branch information

Duplicating this data for every transaction would waste memory.  
The Flyweight pattern solves this by storing shared data once and reusing it.

This example demonstrates a realistic multi‑flyweight banking model.

---

## 🧩 Pattern Structure

### **Flyweights (Intrinsic State)**
Immutable, shared objects:

- `CurrencyFlyweight`
    - code, symbol, decimals, country
- `TransactionTypeFlyweight`
    - code, description, approval requirement
- `BankBranchFlyweight`
    - branchId, address, city, country

### **Factories**
Ensure flyweights are created once and reused:

- `CurrencyFactory`
- `TransactionTypeFactory`
- `BankBranchFactory`

### **Context Object (Extrinsic State)**
- `Transaction`
    - accountId
    - amount (`BigDecimal`)
    - timestamp
    - references to flyweights

### **Client**
- `FlyweightBankDemo`

---

## 🏦 Why This Fits Banking Perfectly

Banking systems process **millions of transactions per day**.  
Each transaction references:

- A **currency** (USD, EUR, JPY…)
- A **transaction type** (DEPOSIT, WITHDRAW, TRANSFER…)
- A **bank branch** (BR‑001, BR‑002…)

These values are:

- Identical across many transactions
- Immutable
- Expensive to duplicate

The Flyweight pattern ensures each unique value is stored **once**.

---

## 📂 Class Diagram (Conceptual)

```
                         ┌──────────────────────────┐
                         │        Transaction        │
                         │ (extrinsic state only)    │
                         └───────────┬──────────────┘
                                     │
     ┌───────────────────────────────┼────────────────────────────────┐
     │                               │                                │
┌───────────────┐            ┌───────────────┐               ┌────────────────┐
│CurrencyFactory│            │TransactionType│               │BankBranchFactory│
└───────┬───────┘            └───────┬──────┘               └────────┬────────┘
        │                              │                               │
┌───────▼────────┐            ┌────────▼────────┐            ┌────────▼────────┐
│CurrencyFlyweight│            │TransactionTypeFly│            │BankBranchFlyweight│
└─────────────────┘            └──────────────────┘            └───────────────────┘
```

---

## 🧪 Example Usage

```java
Transaction t1 = new Transaction(
    "ACC-1001",
    new BigDecimal("150.75"),
    "USD",
    "DEPOSIT",
    "BR-001"
);

Transaction t2 = new Transaction(
    "ACC-2002",
    new BigDecimal("99.99"),
    "USD",
    "WITHDRAW",
    "BR-001"
);

Transaction t3 = new Transaction(
    "ACC-3003",
    new BigDecimal("5000"),
    "JPY",
    "TRANSFER",
    "BR-003"
);
```

Each transaction shares:

- The same **USD** flyweight
- The same **DEPOSIT/WITHDRAW/TRANSFER** flyweights
- The same **BR‑001 / BR‑003** flyweights

---

## 🎯 Benefits

### **1. Massive Memory Savings**
Instead of storing:

- `"USD"`
- `"$"`
- `"United States"`
- `"DEPOSIT"`
- `"BR‑001"`

…thousands of times, each is stored **once**.

### **2. Immutable, Thread‑Safe Shared Objects**
Flyweights are perfect for concurrent banking systems.

### **3. Clean Separation of Intrinsic vs Extrinsic State**
- Intrinsic → shared, immutable
- Extrinsic → unique per transaction

### **4. Realistic Banking Domain Modeling**
This example mirrors real financial systems where metadata is reused extensively.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.flyweight.bank
│
├── CurrencyFlyweight.java
├── Currency.java
├── CurrencyFactory.java
│
├── TransactionTypeFlyweight.java
├── TransactionType.java
├── TransactionTypeFactory.java
│
├── BankBranchFlyweight.java
├── BankBranch.java
├── BankBranchFactory.java
│
├── Transaction.java
└── FlyweightBankDemo.java
```

---

## ✔ Summary

This example demonstrates how the **Flyweight Pattern** can dramatically reduce memory usage in a banking system by sharing:

- Currency metadata
- Transaction type metadata
- Bank branch metadata

Each `Transaction` stores only what is unique, while referencing shared flyweights for everything else.

This is a **true, production‑grade Flyweight implementation** aligned with real banking architectures.

---
