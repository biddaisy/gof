# Chain of Responsibility Pattern
**Package:** `com.github.biddaisy.gof.behavioral.chain`

## 📘 Overview
The **Chain of Responsibility** pattern decouples a request from the object that handles it by passing the request along a chain of potential handlers.  
Each handler decides either to process the request or to forward it to the next handler in the chain.

This pattern is ideal when:

- Multiple objects may handle a request
- The handler should be determined at runtime
- You want to avoid large conditional blocks (`if/else`, `switch`)
- You want flexible, dynamic processing pipelines

In this module, the pattern is demonstrated using an **ATM cash dispenser**.  
Each handler represents a **currency note dispenser** (e.g., 100, 50, 20).  
The ATM delegates the withdrawal request to the first handler, which processes what it can and forwards the remainder down the chain.

---

## 🧩 Pattern Structure

### **1. Handler — `Dispenser`**
Defines the interface for handling requests:

- `setNext(Dispenser next)` — links handlers into a chain
- `dispense(CurrencyAmount amount)` — processes or forwards the request

Each concrete dispenser handles one denomination.

### **2. Concrete Handlers — `CurrencyNote` + `Dispenser`**
`CurrencyNote` is an enum representing denominations (e.g., 100, 50, 20).  
Each `Dispenser` instance is configured with a specific note value.

A dispenser:

- Calculates how many notes it can dispense
- Reduces the remaining amount
- Passes the remainder to the next handler
- Throws `DispensingException` if the chain cannot fully process the request

### **3. Request Object — `CurrencyAmount`**
Encapsulates the withdrawal amount.  
This avoids passing raw integers and allows future extensions (currency type, metadata, etc.).

### **4. Client — `Atm`**
Builds the chain of dispensers and initiates the request.

### **5. Test — `Test`**
Demonstrates the pattern in action.

---

## 🏗 Example Flow

### ATM chain setup
```
100 → 50 → 20 → (end)
```

### User requests:
```
withdraw 230
```

### Processing:
- 100-dispenser: gives 2 × 100 → remainder 30
- 50-dispenser: gives 0 × 50 → remainder 30
- 20-dispenser: gives 1 × 20 → remainder 10
- No handler for 10 → exception thrown

---

## 🧪 Sample Output

```
Dispensing 2 x 100
Dispensing 1 x 20
Cannot dispense remaining amount: 10
```

---

## 🎯 Why This Implementation Works Well

### ✔ Clean separation of responsibilities
Each dispenser handles only one denomination.

### ✔ No giant conditional blocks
The chain replaces nested `if/else` logic.

### ✔ Easy to extend
Add a new denomination by inserting a new handler into the chain.

### ✔ Runtime flexibility
Chains can be reordered or replaced dynamically.

### ✔ Fail‑fast error handling
If no handler can process the remainder, an exception is thrown.

---

## 📦 Package Structure

```
behavioral/chain
│
├── Atm.java
├── CurrencyAmount.java
├── CurrencyNote.java
├── Dispenser.java
├── DispensingException.java
└── Test.java
```

---

## ✔ Summary
This module provides a clean, extensible implementation of the **Chain of Responsibility** pattern using an ATM cash‑dispensing scenario.

It demonstrates:

- Request delegation
- Handler chaining
- Partial processing
- Fail‑fast error handling
- Runtime configurability

A strong, practical example of the pattern in real‑world systems such as financial transaction processing, middleware pipelines, and validation chains.

---
