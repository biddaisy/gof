# Parameterized Factory Method — Banking Domain
**Package:** `com.github.biddaisy.gof.creational.factorymethod.parameterized.banking`

## 📘 Overview
This module demonstrates the **Parameterized Factory Method** variation of the GoF Factory Method pattern in a realistic **banking domain**.

Unlike the classic Factory Method, which typically creates **one product family**, the parameterized version allows the Creator to instantiate **multiple product types** based on an identifier.

This variation is ideal for systems that must reconstruct objects from storage, parse external data, or dynamically create domain objects based on metadata — exactly like the Unidraw framework described in the GoF book.

---

## 🧩 Pattern Structure

### **1. Product Interface — `BankingProduct`**
Defines the common behavior for all banking domain objects.  
Each product implements a `load()` method simulating reconstruction from disk.

### **2. Concrete Products**
- `BankAccount`
- `Loan`
- `Card`
- `InvestmentAccount` *(introduced by subclass)*

These represent typical banking entities.

### **3. Product Identifier — `ProductType`**
Enum used by the parameterized factory method to determine which product to create.

### **4. Creator — `BankingProductCreator`**
Defines the **parameterized factory method**:

```java
public BankingProduct create(ProductType type)
```

This method maps identifiers to concrete products:

- `ACCOUNT` → `BankAccount`
- `LOAN` → `Loan`
- `CARD` → `Card`

### **5. Subclass Creator — `AdvancedBankingProductCreator`**
Overrides the factory method to:

- **Swap mappings**
    - `ACCOUNT` → `Loan`
    - `LOAN` → `BankAccount`

- **Add new product types**
    - Supports `"INVESTMENT"` → `InvestmentAccount`

- **Delegate to parent** for all other types  
  (e.g., `CARD`)

This mirrors the GoF example where a subclass selectively overrides behavior while deferring the rest.

---

## 🏗 Example Flow

### Base Creator
```java
BankingProductCreator creator = new BankingProductCreator();
creator.create(ProductType.ACCOUNT).load();
```

### Subclass Creator
```java
BankingProductCreator creator = new AdvancedBankingProductCreator();
creator.create(ProductType.LOAN).load(); // swapped
creator.create(ProductType.valueOf("INVESTMENT")).load(); // new product
```

---

## 🧪 Demo Output

```
--- Base Creator ---
Loading BankAccount data...
Loading Loan data...
Loading Card data...

--- Advanced Creator (Overridden) ---
Loading Loan data...
Loading BankAccount data...
Loading Card data...

--- Advanced Creator (New Product) ---
Loading InvestmentAccount data...
```

---

## 🎯 Why This Variant Matters

### ✔ Supports multiple product families
A single factory method can create accounts, loans, cards, investments, etc.

### ✔ Subclasses can selectively override behavior
Swap mappings, add new types, or extend functionality.

### ✔ Perfect for object reconstruction
Matches the Unidraw pattern:
- Read identifier
- Call factory method
- Call `load()` to restore state

### ✔ Clean extensibility
Adding new banking products requires **no changes** to existing classes.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.factorymethod.parameterized
│
├── Logger.java
│
├── BankingProduct.java
├── BankAccount.java
├── Loan.java
├── Card.java
├── InvestmentAccount.java
│
├── ProductType.java
│
├── BankingProductCreator.java
├── AdvancedBankingProductCreator.java
│
└── Demo.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful implementation** of the Parameterized Factory Method pattern in a banking context.  
It demonstrates:

- A Creator capable of producing multiple product types
- A subclass that overrides mappings and adds new products
- Delegation to the parent for unknown identifiers
- Realistic banking domain modeling

A strong reference implementation for advanced Factory Method usage.

---
