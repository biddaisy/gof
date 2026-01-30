# Prototype Pattern — Registry Variant
**Package:** `com.mr.gof.creational.prototype.registry`

## 📘 Overview
This module demonstrates the **Prototype Registry**, the most powerful form of the Prototype pattern.

Instead of tools holding individual prototypes, a **central registry** stores all prototypes under string keys.  
Tools request clones by key, enabling:

- dynamic prototype lookup
- dynamic addition of new product types
- dynamic switching of prototypes
- centralized configuration
- plugin‑style extensibility

This is ideal for large systems where product types are not known at compile time.

---

## 🧩 Pattern Structure

### **1. Prototype — `BankingProduct`**
Abstract base class for all banking objects.  
Defines:

- `display()`
- `cloneProduct()`

### **2. Concrete Prototypes**
- `BankAccount`
- `Loan`
- `Card`

These are configured via fields instead of subclasses.

### **3. Prototype Registry — `PrototypeRegistry`**
Stores prototypes under string keys:

```java
registry.registerPrototype("savings", new BankAccount(...));
```

Creates new objects by cloning:

```java
registry.create("savings");
```

### **4. RegistryTool**
A tool that requests clones from the registry using a key.

### **5. BankingDocument**
Stores cloned products.

---

## 🏗 Example Flow

### Register prototypes
```java
registry.registerPrototype("savings", new BankAccount("Savings", 1.5));
registry.registerPrototype("mortgage", new Loan("Mortgage", 3.2));
registry.registerPrototype("credit", new Card("Credit", 5000));
```

### Tools use registry keys
```java
Tool savingsTool = new RegistryTool(registry, "savings");
```

### User actions
```java
savingsTool.onAction(portfolio);
mortgageTool.onAction(portfolio);
creditTool.onAction(portfolio);
```

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

### ✔ Most powerful form of Prototype
Centralized registry enables dynamic behavior.

### ✔ No subclassing
Tools never depend on concrete classes.

### ✔ Dynamic extensibility
New product types can be added at runtime.

### ✔ Perfect for plugin architectures
Load prototypes from config files, databases, or remote services.

### ✔ Clean, decoupled, enterprise‑grade

---

## 📦 Package Structure

```
com.mr.gof.creational.prototype.registry
│
├── BankingProduct.java
├── BankAccount.java
├── Loan.java
├── Card.java
│
├── PrototypeRegistry.java
├── Tool.java
├── RegistryTool.java
│
├── BankingDocument.java
└── Demo.java
```

---

## ✔ Summary
The Prototype Registry is a **super‑powerful, highly flexible** variant of the Prototype pattern:

- Centralized prototype management
- Dynamic creation by key
- No subclassing
- Ideal for large, configurable systems

A perfect addition to your GoF pattern library.

---
