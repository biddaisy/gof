# Factory Method — Variant 2 (Concrete Creator with Default Implementation)
**Package:** `com.mr.gof.creational.factorymethod.concretecreator`

## 📘 Overview
This module demonstrates the **second major variety** of the GoF **Factory Method** pattern:

> **The Creator is a concrete class and provides a default implementation of the factory method.  
> Subclasses may override the factory method to change the product type.**

This variation is used when the base class has a **reasonable default product**, but designers want to allow subclasses to **customize object creation** without modifying the Creator’s business logic.

This example uses a banking‑related domain: **system alerts**.

---

## 🧩 Pattern Structure

### **1. Product Interface — `Alert`**
Defines the behavior common to all alert types.

### **2. Concrete Products**
- `PushAlert` (default)
- `SmsAlert` (override option)

Each implements the `Alert` interface.

### **3. Concrete Creator — `AlertManager`**
- Implements the **factory method** with a **default product**:
  ```java
  protected Alert createAlert() {
      return new PushAlert();
  }
  ```
- Contains business logic (`processAlert`) that uses the product created by the factory method.
- Subclasses may override the factory method to change the product type.

### **4. Subclass — `SmsAlertManager`**
Overrides the factory method to return `SmsAlert` instead of the default.

---

## 🏗 Example Flow

```java
AlertManager manager = new AlertManager();
manager.processAlert("System maintenance at 2 AM.");
```

Uses the default `PushAlert`.

```java
AlertManager smsManager = new SmsAlertManager();
smsManager.processAlert("Fraud detected on your account.");
```

Uses the overridden `SmsAlert`.

---

## 🧪 Demo Output

```
PUSH ALERT: System maintenance at 2 AM.
SMS ALERT: Fraud detected on your account.
```

---

## 🎯 Why This Variant Matters

### ✔ Creator provides a default implementation
Subclasses are not forced to override the factory method.

### ✔ Subclasses can change product creation when needed
Without modifying the Creator’s business logic.

### ✔ Encourages flexible and extensible design
New alert types can be introduced easily:

```
EmailAlertManager
WebhookAlertManager
InAppAlertManager
```

### ✔ Matches GoF’s second Factory Method variety
The Creator is concrete and the factory method is optional to override.

---

## 📦 Package Structure

```
com.mr.gof.creational.factorymethod.concretecreator
│
├── Alert.java
├── PushAlert.java
├── SmsAlert.java
│
├── AlertManager.java
├── SmsAlertManager.java
│
└── Demo2.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful implementation** of the Factory Method pattern where:

- The Creator is **concrete**
- The factory method has a **default implementation**
- Subclasses **may** override the factory method to change the product type

A clean example of the Factory Method’s second major variety, ideal for flexible and extensible object creation.

---
