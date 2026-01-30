# Generic Factory Method (Template‑Style)
**Package:** `com.github.biddaisy.gof.creational.factorymethod.generic`

## 📘 Overview
This module demonstrates the **template‑style Factory Method** variant described in the GoF book, originally implemented in C++ using **templates** to avoid subclassing.

In the C++ version:

```cpp
template <class TheProduct>
class StandardCreator : public Creator {
public:
    virtual Product* CreateProduct() { return new TheProduct; }
};
```

The client simply supplies the product class:

```cpp
StandardCreator<MyProduct> myCreator;
```

Java does not have C++ templates, but we can achieve the same effect using:

- **Generics**
- **Reflection**
- **A parameterized Creator implementation**

This allows the client to specify the product class **without subclassing** the Creator.

---

## 🧩 Pattern Structure

### **1. Product Interface — `Product`**
Defines the common behavior for all products created by the factory.

### **2. Concrete Product — `MyProduct`**
Implements the `Product` interface.

### **3. Creator Interface — `Creator`**
Declares the factory method:

```java
Product createProduct();
```

### **4. Generic Creator — `StandardCreator<T>`**
This is the Java equivalent of the C++ template subclass.

- Parameterized by the product type (`T extends Product`)
- Stores the product class (`Class<T>`)
- Instantiates the product using reflection

This avoids the need to subclass `Creator` for each product type.

---

## 🏗 Example Flow

### Create a generic creator
```java
Creator creator = new StandardCreator<>(MyProduct.class);
```

### Create a product
```java
Product product = creator.createProduct();
product.execute();
```

### No subclassing required
You can create any product type simply by passing its class:

```java
new StandardCreator<>(LoanProduct.class);
new StandardCreator<>(CardProduct.class);
new StandardCreator<>(InvestmentProduct.class);
```

---

## 🧪 Demo Output

```
MyProduct constructor invoked
Created product: MyProduct
Executing MyProduct...
```

---

## 🎯 Why This Variant Matters

### ✔ Avoids subclassing
The client supplies the product class directly.

### ✔ Matches the GoF C++ template strategy
This is the closest Java analogue to template‑based Factory Methods.

### ✔ Extremely flexible
Any product type can be created without modifying or extending the Creator.

### ✔ Clean, type‑safe, and enterprise‑grade
Uses generics and reflection in a controlled, safe manner.

### ✔ Ideal for plugin systems and dynamic product creation
Perfect when product types are not known at compile time.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.factorymethod.generic
│
├── Logger.java
│
├── Product.java
├── MyProduct.java
│
├── Creator.java
├── StandardCreator.java
│
└── Demo.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful Java adaptation** of the C++ template‑based Factory Method:

- The Creator is **generic**, not subclassed
- The product type is supplied by the client
- Reflection instantiates the product
- The design is clean, flexible, and extensible

A powerful addition to your Factory Method collection, especially for systems requiring dynamic product creation.

---
