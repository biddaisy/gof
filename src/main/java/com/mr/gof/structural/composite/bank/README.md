# Composite Pattern — Banking Accounts Example
**Package:** `com.mr.gof.structural.composite.bank`

## 📘 Overview
The **Composite Pattern** allows clients to treat individual objects and compositions of objects uniformly.  
In this banking example, both **individual accounts** and **groups of accounts** (portfolios, joint accounts) implement the same interface:

- `BankAccount`

This enables:

- Recursive balance aggregation
- Hierarchical display of accounts
- Uniform operations across simple and complex account structures
- Extensibility for new account types

The Composite Pattern is a natural fit for financial domains where accounts can be grouped, nested, and aggregated.

---

## 🧩 Pattern Structure

### **Component (Interface)**
`BankAccount`  
Defines the common operations:

- `getName()`
- `getBalance()`
- `display(indent)`

### **Leaf Components**
Concrete accounts with no children:

- `IndividualAccount`
    - Holds a single customer’s balance
    - Supports transactions
    - Calculates interest
    - Displays itself with an icon 👤

### **Composite Components**
Objects that contain other `BankAccount` instances:

- `CustomerPortfolio`
    - Represents a customer’s entire set of accounts
    - Aggregates balances
    - Provides portfolio analytics
    - Contains nested accounts of any type

- `JointAccount`
    - Represents a shared account structure
    - Contains multiple `BankAccount` children
    - Supports recursive holder counting
    - Displays itself with an icon 👥

### **Client**
`CompositeBankDemo`  
Builds a realistic account hierarchy and demonstrates:

- Composite assembly
- Recursive display
- Balance aggregation
- Portfolio analytics
- Nested joint accounts

---

## 🏦 Banking Scenario

A customer may have:

- Individual checking and savings accounts
- A joint family account
- A portfolio grouping all accounts
- Nested joint accounts (e.g., family → children → sub‑accounts)

The Composite Pattern allows all of these to be treated uniformly.

---

## 📂 Example Structure

```
CustomerPortfolio "John Doe's Portfolio"
 ├── 👤 John Doe: $15000.50
 ├── 👤 John Doe: $3200.75
 ├── 👤 Sarah Smith: $8500.25
 └── 👥 Family Savings [Total: $10000.00]
       ├── 👤 John Doe: $5000.00
       └── 👤 Jane Doe: $5000.00
```

---

## 💰 Balance & Interest Calculations

### **IndividualAccount**
- Stores a single balance
- Supports transactions with validation
- Calculates interest:  
  `balance * (annualRate / 100)`

### **CustomerPortfolio**
- Aggregates balances of all child accounts
- Computes total annual interest
- Provides a `PortfolioSummary`:
    - Count of individual accounts
    - Count of joint accounts
    - Largest account
    - Total accounts

### **JointAccount**
- Aggregates balances of all child accounts
- Supports bonus distribution
- Recursively counts account holders

---

## 🧪 Example Usage

```java
CustomerPortfolio portfolio = new CustomerPortfolio("John Doe");

portfolio.addAccount(new IndividualAccount("John Doe", new BigDecimal("15000.50")));
portfolio.addAccount(new IndividualAccount("John Doe", new BigDecimal("3200.75")));

JointAccount family = new JointAccount("Family Savings");
family.addAccount(new IndividualAccount("John Doe", new BigDecimal("5000.00")));
family.addAccount(new IndividualAccount("Jane Doe", new BigDecimal("5000.00")));

portfolio.addAccount(family);

portfolio.display("");
Logger.log("Total Balance: ${0}", portfolio.getBalance());
```

---

## 📊 Portfolio Summary Example

```
Portfolio Summary for John Doe:
  Individual Accounts: 2
  Joint Accounts: 1
  Total Accounts: 3
  Largest Account: John Doe's Account ($15000.50)
```

---

## 🎯 Why This Is a True GoF Composite

### ✔ Uniform treatment
Clients interact with `BankAccount` without caring if it’s a leaf or composite.

### ✔ Recursive structure
Composite accounts contain other accounts of the same type.

### ✔ Aggregated behavior
Balances, interest, and analytics are computed recursively.

### ✔ Extensibility
New account types can be added without modifying existing logic.

### ✔ Realistic banking domain
Portfolios, joint accounts, and nested account structures are common in financial systems.

---

## 📦 Package Structure

```
com.mr.gof.structural.composite.bank
│
├── BankAccount.java
├── IndividualAccount.java
├── JointAccount.java
├── CustomerPortfolio.java
└── CompositeBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **robust, domain‑realistic Composite Pattern** applied to banking accounts.  
It includes:

- Recursive aggregation
- Portfolio analytics
- Nested joint accounts
- Transaction logic
- Interest calculations
- Defensive copying
- Logging and error handling

A powerful demonstration of how the Composite Pattern elegantly models hierarchical financial structures.

---