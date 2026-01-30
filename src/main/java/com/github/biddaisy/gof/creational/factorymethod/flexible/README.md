# Flexible Factory Method — Banking Domain
**Package:** `com.github.biddaisy.gof.creational.factorymethod.flexible`

## 📘 Overview
This module demonstrates a **language‑specific variant** of the GoF Factory Method pattern inspired by **Smalltalk’s metaclass approach**.

Instead of subclassing the Creator to vary the product type, the Creator **stores the class to instantiate** in a field.  
This allows the system to:

- Change the product type **at runtime**
- Avoid subclassing entirely
- Bind the product type **as late as possible**
- Support dynamic configuration, plugins, and metadata‑driven creation

This version is also **thread‑safe**, ensuring correct behavior in concurrent banking systems.

---

## 🧩 Pattern Structure

### **1. Product Interface — `BankingProduct`**
Defines the common behavior for all banking domain objects.  
Each product implements a `load()` method simulating reconstruction from storage.

### **2. Concrete Products**
- `BankAccount`
- `Loan`
- `Card`

These represent typical banking entities.

### **3. Flexible Creator — `ConfigurableBankingSystem`**
Stores the class to instantiate:

```java
private volatile Class<? extends BankingProduct> productClass;
```

The factory method becomes:

```java
public BankingProduct createProduct()
```

Instead of deciding which product to create, it simply instantiates the class stored in the field.

### **4. Thread Safety**
The module uses:

- `volatile` for safe publication of the configured class
- `synchronized` for atomic reconfiguration
- Local copies of volatile references for safe instantiation

This ensures correct behavior even when multiple threads:

- Read the configured product class
- Change the configured product class
- Create products concurrently

---

## 🏗 Example Flow

### Configure the system
```java
ConfigurableBankingSystem system =
        new ConfigurableBankingSystem(BankAccount.class);
```

### Create a product
```java
BankingProduct p = system.createProduct();
p.load();
```

### Switch product type at runtime
```java
system.setProductClass(Loan.class);
```

### Create the new product
```java
system.createProduct().load();
```

---

## 🧪 Demo Output

```
Loading BankAccount data...
Switched to Loan
Loading Loan data...
```

---

## 🎯 Why This Variant Matters

### ✔ No subclassing required
The product type is stored in a field, not hardcoded in a subclass.

### ✔ Extremely late binding
The class to instantiate can be changed at runtime.

### ✔ Thread‑safe
Correct under concurrent access.

### ✔ Mirrors Smalltalk’s `documentClass` technique
But adapted to Java’s reflection and memory model.

### ✔ Ideal for banking systems
Where product types often come from:

- configuration files
- metadata
- user selection
- dynamic plugin loading
- external services

### ✔ Clean, extensible, enterprise‑grade

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.factorymethod.flexible
│
├── Logger.java
│
├── BankingProduct.java
├── BankAccount.java
├── Loan.java
├── Card.java
│
├── ConfigurableBankingSystem.java
│
└── Demo.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful, Smalltalk‑inspired Factory Method variant** adapted for Java and applied to a realistic banking domain.

It demonstrates:

- Storing the class to instantiate
- Runtime configurability
- Thread‑safe dynamic product creation
- Clean separation of concerns
- No need for subclassing

A powerful and flexible addition to your Factory Method collection.

---
