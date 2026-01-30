# Prototype Pattern — Banking Domain
**Package:** `com.github.biddaisy.gof.creational.prototype.banking`

## 📘 Overview
This module demonstrates the **Prototype** design pattern in a banking context.  
Instead of subclassing tools for each banking product (Account, Loan, Card), the system uses **prototypes** that can be cloned to create new instances.

This mirrors the GoF music‑editor example, where tools clone graphical objects.  
Here, tools clone banking products.

---

## 🧩 Pattern Structure

### **1. Prototype — `BankingProduct`**
Abstract base class for all banking objects.  
Defines:

- `display()` — shows product info
- `cloneProduct()` — cloning operation

### **2. Concrete Prototypes**
- `BankAccount`
- `Loan`
- `Card`

Instead of separate subclasses for each account or loan type, these classes are **configured via fields** (e.g., interest rate, loan type, credit limit).

### **3. Tool Hierarchy**
- `Tool` — abstract base
- `BankingTool` — clones a prototype and inserts it into the document

Each tool is parameterized by a prototype instance.

### **4. BankingDocument**
Stores cloned banking products.  
Provides safe, read‑only access to the portfolio.

---

## 🏗 Example Flow

### Configure prototypes
```java
BankingProduct savings = new BankAccount("Savings", 1.5);
BankingProduct mortgage = new Loan("Mortgage", 3.2);
BankingProduct creditCard = new Card("Credit", 5000);
```

### Configure tools
```java
Tool savingsTool = new BankingTool(savings);
Tool mortgageTool = new BankingTool(mortgage);
Tool creditCardTool = new BankingTool(creditCard);
```

### User actions
```java
savingsTool.onAction(portfolio);
mortgageTool.onAction(portfolio);
creditCardTool.onAction(portfolio);
```

Each action clones the prototype and adds it to the portfolio.

---

## 🧪 Sample Output

```
Added product:
BankAccount [Savings], interest=1.5
Added product:
Loan [Mortgage], rate=3.2
Added product:
Card [Credit], limit=5000
```

---

## 🎯 Why This Variant Matters

### ✔ Eliminates subclass explosion
No need for `SavingsAccountTool`, `MortgageTool`, etc.

### ✔ Framework stays decoupled
`BankingTool` never needs to know concrete classes.

### ✔ Easy to add new banking products
Just create a new prototype and a new tool.

### ✔ Reduces number of classes
Different account/loan/card types become **instances**, not subclasses.

### ✔ Perfect match to the GoF Prototype description
This is the banking analogue of the music‑editor example.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.prototype.banking
│
├── BankingProduct.java
├── BankAccount.java
├── Loan.java
├── Card.java
│
├── Tool.java
├── BankingTool.java
│
├── BankingDocument.java
└── Demo.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful implementation** of the Prototype pattern in a banking domain:

- Tools clone prototypes to create new banking products
- The system avoids subclassing
- Adding new product types is trivial
- The design is clean, flexible, and extensible

A strong addition to your GoF pattern library.

---
