# Virtual Proxy Pattern — Banking Example
**Package:** `com.mr.gof.structural.proxy.bank.virtual`

## 📘 Overview
The **Virtual Proxy** is a structural design pattern from the *Gang of Four (GoF)*.  
It is used when creating an object is **expensive**, and you want to **delay its creation** until it is actually needed.

In banking systems, this is extremely common.  
Customer‑related data — especially **KYC**, **AML**, **risk scoring**, and **historical documents** — is often stored in remote systems and is expensive to load.

This example demonstrates a **Virtual Proxy** that delays loading a heavy `RealCustomerProfile` object until the moment the client actually needs it.

---

## 🧩 Pattern Structure

### **Subject Interface**
Defines the operations available to clients:

- `CustomerProfile`

### **Real Subject (Heavy Object)**
Represents a large, expensive object:

- `RealCustomerProfile`
    - Simulates a 2‑second load
    - Contains KYC document
    - Contains risk rating
    - Contains full customer details

### **Virtual Proxy**
Creates the real object **only when needed**:

- `CustomerProfileProxy`
    - Stores only the customer ID initially
    - Loads the real profile lazily
    - Hides the loading process from the client

### **Client**
Uses the proxy exactly as if it were the real object:

- `VirtualProxyBankDemo`

---

## 🏦 Banking Scenario

### Without Virtual Proxy
If the system loads the full customer profile every time:

- UI becomes slow
- Backend services waste resources
- Unnecessary remote calls occur
- Expensive KYC documents load even when not needed

### With Virtual Proxy
The system loads only what is needed:

- Customer ID is available immediately
- Heavy data loads **only when accessed**
- Performance improves dramatically
- Remote calls are minimized

---

## 📂 Class Diagram (Conceptual)

```
                     ┌──────────────────────────────┐
                     │       CustomerProfile        │
                     └───────────────┬──────────────┘
                                     │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
┌──────────────────────┐   ┌──────────────────────────┐   ┌────────────────────┐
│ RealCustomerProfile   │   │   CustomerProfileProxy   │   │      Client        │
│ (heavy, expensive)    │◄──┤ (lazy loads real object) │   │ VirtualProxyDemo   │
└──────────────────────┘   └──────────────────────────┘   └────────────────────┘
```

---

## 🧪 Example Usage

```java
CustomerProfile profile = new CustomerProfileProxy("CUST-1001");

Logger.log("Customer ID: {0}", profile.getCustomerId()); // immediate

Logger.log("Full name: {0}", profile.getFullName()); // triggers lazy load
Logger.log("Risk rating: {0}", profile.getRiskRating());
Logger.log("KYC document: {0}", profile.getKycDocument());
```

Expected output:

```
=== Creating proxy ===
Customer ID available immediately: CUST-1001
=== Accessing heavy data ===
[PROXY] Lazy-loading RealCustomerProfile...
[REAL] Loading customer profile from remote system...
Full name: John Doe
Risk rating: LOW
KYC document: KYC-PDF-DATA
```

---

## 🎯 Why Use a Virtual Proxy in Banking?

### ✔ Performance Optimization
Load heavy data only when needed.

### ✔ Reduced Remote Calls
Avoid unnecessary KYC/AML fetches.

### ✔ Transparent to Client
Client code doesn’t change.

### ✔ Memory Efficiency
Large objects are created only when required.

### ✔ Realistic Banking Use Case
Customer profiles, risk data, and compliance documents are perfect candidates.

---

## 📦 Package Structure

```
com.mr.gof.structural.proxy.bank.virtual
│
├── CustomerProfile.java
├── RealCustomerProfile.java
├── CustomerProfileProxy.java
└── VirtualProxyBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **Virtual Proxy** that:

- Represents a heavy customer profile
- Loads it lazily
- Hides the loading process
- Improves performance
- Matches real banking architecture patterns

A Virtual Proxy is ideal whenever object creation is expensive and not always necessary.

---

If you want, Mike, I can also create:

- A **Smart Virtual Proxy** (caching, prefetching, eviction)
- A **Virtual Proxy + Factory Method** combo
- A **Virtual Proxy + Flyweight** hybrid
- A UML diagram

Just point the direction.