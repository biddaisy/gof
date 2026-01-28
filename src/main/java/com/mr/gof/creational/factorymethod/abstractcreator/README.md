# Factory Method — Variant 1 (Abstract Creator, No Default Implementation)
**Package:** `com.mr.gof.creational.factorymethod.abstractcreator`

## 📘 Overview
This module demonstrates the **first major variety** of the GoF **Factory Method** pattern:

> **The Creator is an abstract class and does NOT provide a default implementation of the factory method.  
> Subclasses MUST implement the factory method.**

This variation is used when the base class cannot reasonably know which concrete product to instantiate.  
It solves the problem of instantiating **unforeseeable product types** while keeping the Creator’s business logic independent of concrete classes.

This example uses a banking‑related domain: **customer notifications**.

---

## 🧩 Pattern Structure

### **1. Product Interface — `Notification`**
Defines the behavior common to all notification types.

### **2. Concrete Products**
- `EmailNotification`
- `SmsNotification`

Each implements the `Notification` interface.

### **3. Abstract Creator — `NotificationCreator`**
- Declares the **factory method**:
  ```java
  protected abstract Notification createNotification();
  ```
- Contains business logic (`notifyCustomer`) that relies on the product created by the factory method.
- Does **not** provide a default implementation — subclasses must override.

### **4. Concrete Creators**
- `EmailNotificationCreator`
- `SmsNotificationCreator`

Each implements the factory method to instantiate the appropriate product.

---

## 🏗 Example Flow

```java
NotificationCreator creator = new EmailNotificationCreator();
creator.notifyCustomer("Your account balance is low.");
```

The Creator calls:

1. `createNotification()` → returns `EmailNotification`
2. `notifyCustomer()` → uses the product without knowing its concrete type

---

## 🧪 Demo Output

```
Sending EMAIL: Your account balance is low.
Sending SMS: Your OTP code is 123456.
```

---

## 🎯 Why This Variant Matters

### ✔ Subclasses MUST implement the factory method
The Creator cannot provide a reasonable default.

### ✔ Decouples business logic from concrete classes
`notifyCustomer()` works with any notification type.

### ✔ Enables future extensibility
Add new notification types without modifying existing code:

```
PushNotificationCreator
InAppNotificationCreator
WebhookNotificationCreator
```

### ✔ Pure GoF implementation
Matches the first variant described in the Design Patterns book.

---

## 📦 Package Structure

```
com.mr.gof.creational.factorymethod.abstractcreator
│
├── Notification.java
├── EmailNotification.java
├── SmsNotification.java
│
├── NotificationCreator.java
├── EmailNotificationCreator.java
├── SmsNotificationCreator.java
│
└── Demo1.java
```

---

## ✔ Summary
This module provides a **GoF‑faithful implementation** of the Factory Method pattern where:

- The Creator is **abstract**
- The factory method is **abstract**
- Subclasses **must** define the product creation logic

A foundational example of the Factory Method pattern’s first major variety.

---
