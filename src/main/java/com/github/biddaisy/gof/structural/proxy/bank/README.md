# Proxy Pattern — Banking Example
**Package:** `com.github.biddaisy.gof.structural.proxy.bank`

## 📘 Overview
The **Proxy Pattern** is a structural design pattern from the *Gang of Four (GoF)*.  
It provides a **surrogate or placeholder** for another object to control access to it.

In banking systems, direct access to sensitive services (like account operations) must be restricted.  
A **Protection Proxy** is ideal for:

- Authentication
- Authorization
- Account blocking
- Logging
- Auditing
- Fraud prevention

This example demonstrates a realistic **security proxy** for a bank account service.

---

## 🧩 Pattern Structure

### **Subject Interface**
Defines the operations available to clients:

- `BankAccountService`

### **Real Subject**
Performs the actual business logic:

- `RealBankAccountService`
    - Stores balances
    - Performs deposits and withdrawals
    - Returns account balances

### **Proxy**
Controls access to the real subject:

- `BankAccountProxy`
    - Validates identity
    - Checks blocked accounts
    - Logs access attempts
    - Delegates to the real service only when allowed

### **Client**
Uses the proxy instead of the real service:

- `ProxyBankDemo`

---

## 🏦 Banking Scenario

### Without Proxy
Clients would directly call:

```java
RealBankAccountService service = new RealBankAccountService();
service.withdraw("ACC-1001", new BigDecimal("500"));
```

This is unsafe because:

- Anyone could call the service
- No authentication
- No logging
- No blocked-account checks

### With Proxy
Clients interact with:

```java
BankAccountService service =
    new BankAccountProxy(realService, "CUST-1001", Set.of("CUST-9999"));
```

The proxy ensures:

- Only the authenticated customer can access their account
- Blocked accounts are denied
- All access attempts are logged
- Real service is protected

---

## 📂 Class Diagram (Conceptual)

```
                   ┌──────────────────────────┐
                   │   BankAccountService     │
                   └───────────────┬──────────┘
                                   │
        ┌──────────────────────────┼──────────────────────────┐
        │                          │                          │
┌───────────────┐        ┌──────────────────┐       ┌────────────────────┐
│ RealBankAccount│        │ BankAccountProxy │       │     Client         │
│    Service     │◄───────┤ (access control)│       │ ProxyBankDemo      │
└───────────────┘        └──────────────────┘       └────────────────────┘
```

---

## 🧪 Example Usage

```java
BankAccountService real = new RealBankAccountService();

BankAccountService proxy =
        new BankAccountProxy(real, "CUST-1001", Set.of("CUST-9999"));

proxy.deposit("CUST-1001", new BigDecimal("500"));
proxy.withdraw("CUST-1001", new BigDecimal("200"));
proxy.getBalance("CUST-1001");

proxy.getBalance("CUST-2002"); // unauthorized
proxy.deposit("CUST-9999", new BigDecimal("100")); // blocked
```

---

## 🎯 Why Use the Proxy Pattern in Banking?

### ✔ Security
Only authenticated users can access their accounts.

### ✔ Access Control
Blocked or flagged accounts are denied.

### ✔ Logging & Auditing
Every access attempt is recorded.

### ✔ Encapsulation
The real service remains untouched and protected.

### ✔ Same Interface
Clients don’t need to know whether they’re talking to a proxy or the real service.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.proxy.bank
│
├── BankAccountService.java
├── RealBankAccountService.java
├── BankAccountProxy.java
└── ProxyBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **Protection Proxy**, one of the most common and practical uses of the Proxy pattern in financial systems.

The proxy:

- Controls access
- Adds security
- Adds logging
- Protects the real service
- Maintains the same interface

This is a **true GoF Proxy implementation**, aligned with real-world banking architecture.

---