# Facade Pattern — Banking Example
**Package:** `com.github.biddaisy.gof.structural.facade.bank`

## 📘 Overview
The **Facade Pattern** is a structural design pattern from the *Gang of Four (GoF)*.  
Its purpose is to provide a **simple, unified interface** to a complex subsystem.

In real banking systems, operations such as onboarding, money transfers, and loan applications involve multiple internal services:

- KYC (Know Your Customer)
- AML (Anti‑Money Laundering)
- Identity verification
- Credit scoring
- Account operations
- Notifications

Exposing all these services directly to clients would create unnecessary complexity.  
The **BankFacade** class hides this complexity and exposes a clean, high‑level API.

---

## 🧩 Pattern Structure

### **Subsystems**
These classes represent internal banking services:

- `KYCService` — verifies customer identity documents
- `AMLService` — screens customers and transactions for suspicious activity
- `CreditScoreService` — retrieves credit score for loan decisions
- `SecurityService` — verifies customer identity
- `AccountService` — handles balance checks, debits, and credits
- `NotificationService` — sends messages to customers

### **Facade**
- `BankFacade` — orchestrates all subsystems and exposes simple operations:
    - `onboardCustomer(...)`
    - `transferMoney(...)`
    - `applyForLoan(...)`

### **Client**
- `FacadeBankDemo` — demonstrates how easy it is to use the facade.

---

## 🏦 Banking Example Workflows

### **1. Customer Onboarding**
Performed by:

- KYC check
- AML screening
- Welcome notification

Facade call:

```java
bank.onboardCustomer("CUST-1001");
```

---

### **2. Money Transfer**
Performed by:

- Identity verification
- AML transaction rules
- Balance check
- Debit + credit
- Notifications

Facade call:

```java
bank.transferMoney("CUST-1001", "ACC-1", "ACC-2", 500);
```

---

### **3. Loan Application**
Performed by:

- Identity verification
- AML screening
- Credit score evaluation
- Approval notification

Facade call:

```java
bank.applyForLoan("CUST-1001", 20_000);
```

---

## 📂 Class Diagram (Conceptual)

```
                   ┌──────────────────────┐
                   │      BankFacade      │
                   └──────────────────────┘
                     ▲        ▲        ▲
                     │        │        │
   ┌─────────────────┼────────┼────────┼──────────────────┐
   │                 │        │        │                  │
┌───────────┐  ┌───────────┐ ┌──────────────┐ ┌──────────────────┐
│KYCService │  │AMLService │ │SecurityService│ │CreditScoreService│
└───────────┘  └───────────┘ └──────────────┘ └──────────────────┘
       ▲               ▲               ▲               ▲
       │               │               │               │
   ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
   │AccountService│ │NotificationSvc│ │   (others)   │ │    (etc.)    │
   └──────────────┘ └──────────────┘ └──────────────┘ └──────────────┘
```

---

## 🎯 Why Use the Facade Pattern Here?

- **Simplifies complex workflows**  
  Clients call one method instead of coordinating multiple services.

- **Encapsulates subsystem logic**  
  Internal services can change without affecting client code.

- **Improves maintainability**  
  Business rules live in one place: the facade.

- **Promotes clean architecture**  
  Clients depend on a stable API, not internal details.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.facade.bank
│
├── AccountService.java
├── AMLService.java
├── CreditScoreService.java
├── KYCService.java
├── NotificationService.java
├── SecurityService.java
├── BankFacade.java
└── FacadeBankDemo.java
```

---

## ✔ Summary

This example demonstrates how the **Facade Pattern** can simplify real‑world banking operations by hiding the complexity of multiple subsystems behind a clean, unified interface.

The result is:

- Cleaner client code
- Better separation of concerns
- Easier maintenance
- A realistic demonstration of GoF principles in a financial domain

---
