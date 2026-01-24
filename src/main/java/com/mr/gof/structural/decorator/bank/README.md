# Decorator Pattern — Banking Example
**Package:** `com.mr.gof.structural.decorator.bank`

## 📘 Overview
The **Decorator Pattern** is a structural design pattern from the *Gang of Four (GoF)* that allows behavior to be added to individual objects dynamically, without modifying their underlying class.  
It is especially useful when you want to extend functionality in a flexible, composable way.

In this example, we apply the Decorator pattern to a **banking domain**, where a `BankAccount` can be enhanced with additional behaviors such as:

- Logging
- Fraud detection
- Service fees

Each enhancement is implemented as a decorator that wraps the original account object.

---

## 🧩 Pattern Structure

### **Component**
Defines the interface for objects that can have responsibilities added to them.

- `BankAccount`

### **Concrete Component**
The primary object being decorated.

- `SavingsAccount`

### **Decorator (Base Class)**
Holds a reference to a `BankAccount` and delegates calls to it.

- `AccountDecorator`

### **Concrete Decorators**
Add new behavior before/after delegating to the wrapped object.

- `LoggingDecorator` — logs deposits and withdrawals
- `FraudCheckDecorator` — warns about suspicious withdrawals
- `FeeDecorator` — applies a fixed service fee to withdrawals

---

## 🏦 Banking Example Flow

The demo builds a decorated account like this:

```
SavingsAccount
    → FeeDecorator
        → FraudCheckDecorator
            → LoggingDecorator
```

Each decorator adds its own behavior while still delegating to the underlying account.

---

## 📂 Class Diagram (Conceptual)

```
          ┌──────────────────────┐
          │     BankAccount      │◄───────────────┐
          └──────────────────────┘                │
                    ▲                             │
                    │                             │
          ┌──────────────────────┐                │
          │   SavingsAccount     │                │
          └──────────────────────┘                │
                    ▲                             │
                    │ wraps                       │
          ┌──────────────────────┐                │
          │   AccountDecorator   │────────────────┘
          └──────────────────────┘
                    ▲
     ┌──────────────┼───────────────────────────────┐
     │              │                               │
┌──────────────┐┌──────────────┐┌──────────────────┐
│LoggingDecorator││FraudCheckDecorator││FeeDecorator │
└──────────────┘└──────────────┘└──────────────────┘
```

---

## 🧪 Running the Demo

Run:

```java
public class DecoratorBankDemo {
    public static void main(String[] args) {
        BankAccount account =
                new LoggingDecorator(
                    new FraudCheckDecorator(
                        new FeeDecorator(
                            new SavingsAccount(10_000)
                        )
                    )
                );

        account.deposit(500);
        account.withdraw(6000);

        Logger.log(account.getBalance());
    }
}
```

### Output (conceptual)

```
SavingsAccount created with initial balance: 10000
LOG: Depositing 500
LOG: Withdrawing 6000
FRAUD ALERT: Large withdrawal attempt: 6000
Applying service fee of 1.5
Final balance: 3498.5
```

---

## 🎯 Why Use the Decorator Pattern Here?

- **Open/Closed Principle** — add new behaviors without modifying existing classes
- **Flexible composition** — combine decorators in any order
- **Runtime behavior changes** — wrap or unwrap decorators dynamically
- **Avoids subclass explosion** — no need for dozens of specialized subclasses

---

## 📦 Package Structure

```
com.mr.gof.structural.decorator.bank
│
├── BankAccount.java
├── SavingsAccount.java
├── AccountDecorator.java
├── LoggingDecorator.java
├── FraudCheckDecorator.java
├── FeeDecorator.java
└── DecoratorBankDemo.java
```

---

## ✔ Summary

This example demonstrates how the Decorator pattern can be applied in a real-world financial context to add cross‑cutting concerns (logging, fraud detection, fees) without modifying the core account logic.

It keeps your code:

- Clean
- Extensible
- Maintainable
- Open for extension, closed for modification

---