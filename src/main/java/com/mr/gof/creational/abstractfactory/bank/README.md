# Banking Abstract Factory — GoF
**Package:** `com.mr.gof.creational.abstractfactory.bank`

## 📘 Overview
This module demonstrates the **Abstract Factory** pattern in a realistic **banking domain**.  
Different regions (US, EU, etc.) require different implementations of banking products due to regulatory, compliance, and operational differences.

The Abstract Factory pattern lets the system create **families of related banking products** without coupling the client to concrete classes.

Each region provides its own implementations of:

- `Account`
- `Loan`
- `Card`

A `BankingProductFactory` produces a consistent set of products for a given region.

---

## 🧩 Pattern Structure

### **1. Product Interfaces**
Each product type has a simple interface:

- `Account.open()`
- `Loan.approve()`
- `Card.issue()`

These represent operations that differ across regions.

---

### **2. Abstract Factory**

```java
public interface BankingProductFactory {
    Account createAccount();
    Loan createLoan();
    Card createCard();
}
```

This interface defines how to create a **family of banking products**.

---

### **3. Concrete Factories**

Each region implements the factory and returns region‑specific products.

#### 🇺🇸 USBankingProductFactory
Produces:
- `USAccount`
- `USLoan`
- `USCard`

#### 🇪🇺 EUBankingProductFactory
Produces:
- `EUAccount`
- `EULoan`
- `EUCard`

Additional regions can be added without modifying existing code.

---

### **4. Concrete Products**

Each region has its own implementations:

#### US Examples
- `USAccount` — FDIC‑insured checking account
- `USLoan` — FICO‑based underwriting
- `USCard` — Visa/Mastercard credit card

#### EU Examples
- `EUAccount` — SEPA‑compliant current account
- `EULoan` — ECB‑regulated loan
- `EUCard` — Maestro debit card

These differences reflect real‑world regulatory and operational variations.

---

### **5. Client Code (BankingApplication)**

The client receives a factory and uses it to create products:

```java
Account account = factory.createAccount();
Loan loan = factory.createLoan();
Card card = factory.createCard();
```

The client never references concrete classes.

---

## 🧪 Demo

The included `Demo` class builds two product families:

### ✔ US Banking Products
```
Opening US Checking Account (FDIC insured)
Approving US Personal Loan (FICO-based underwriting)
Issuing US Credit Card (Visa/MC)
```

### ✔ EU Banking Products
```
Opening EU Current Account (SEPA compliant)
Approving EU Loan (ECB regulations)
Issuing EU Debit Card (Maestro)
```

The same client code works with any factory.

---

## 🎯 Why This Example Matters

### ✔ Realistic banking domain
Reflects real regulatory and operational differences.

### ✔ Clean separation of concerns
Client code depends only on interfaces.

### ✔ Easy to extend
Add new regions by creating new factories:

- `AsiaBankingProductFactory`
- `CryptoBankingProductFactory`
- `PremiumBankingProductFactory`

No changes to existing code.

### ✔ Fully GoF‑compliant
This is the classic Abstract Factory pattern applied to a real enterprise domain.

---

## 📦 Package Structure

```
com.mr.gof.creational.abstractfactory.bank
│
├── Account.java
├── Loan.java
├── Card.java
│
├── BankingProductFactory.java
│
├── USAccount.java
├── USLoan.java
├── USCard.java
├── USBankingProductFactory.java
│
├── EUAccount.java
├── EULoan.java
├── EUCard.java
├── EUBankingProductFactory.java
│
├── BankingApplication.java
└── Demo.java
```

---

## ✔ Summary

This module provides a **realistic, extensible, and GoF‑faithful** implementation of the Abstract Factory pattern in the banking domain.  
It demonstrates:

- Region‑specific product families
- Decoupled client logic
- Clean extensibility
- Strong alignment with enterprise banking architectures

A practical and elegant example of the Abstract Factory pattern in action.

---
