# Cache Proxy Pattern — Banking Example
**Package:** `com.github.biddaisy.gof.structural.proxy.bank.cache`

## 📘 Overview
A **Cache Proxy** is a structural design pattern where a proxy stores the results of expensive operations and returns cached values on subsequent calls.  
This dramatically reduces latency and load on downstream systems — a critical requirement in banking environments where remote calls to core systems, risk engines, or customer services are costly.

This example demonstrates a **Cache Proxy** that wraps an expensive `AccountBalanceService` and caches account balances to avoid repeated remote calls.

---

## 🧩 Pattern Structure

### **Subject Interface**
Defines the operation available to clients:

- `AccountBalanceService`

### **Real Subject (Expensive Remote Service)**
Simulates a slow, remote call:

- `RealAccountBalanceService`
    - 1.5‑second delay
    - Represents a core banking or remote microservice call

### **Cache Proxy**
Stores results and returns cached values:

- `AccountBalanceCacheProxy`
    - Thread‑safe `ConcurrentHashMap`
    - Transparent to the client
    - Avoids repeated remote calls

### **Client**
Uses the proxy exactly as if it were the real service:

- `CacheProxyBankDemo`

---

## 🏦 Banking Scenario

### Without Cache Proxy
Every balance lookup triggers:

- A remote call
- Network latency
- Load on core banking systems
- Increased cost and slower response times

### With Cache Proxy
The system:

- Calls the real service **once per account**
- Returns cached values instantly afterward
- Reduces load on remote systems
- Improves performance and scalability

---

## 📂 Class Diagram (Conceptual)

```
                     ┌──────────────────────────────┐
                     │     AccountBalanceService    │
                     └───────────────┬──────────────┘
                                     │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
┌────────────────────────┐   ┌────────────────────────────┐   ┌────────────────────┐
│ RealAccountBalanceService│  │ AccountBalanceCacheProxy   │   │      Client        │
│ (slow remote service)    │◄─┤ (caches results)           │   │ CacheProxyDemo     │
└────────────────────────┘   └────────────────────────────┘   └────────────────────┘
```

---

## 🧪 Example Usage

```java
AccountBalanceService real = new RealAccountBalanceService();
AccountBalanceService proxy = new AccountBalanceCacheProxy(real);

proxy.getBalance("ACC-1001"); // slow, remote call
proxy.getBalance("ACC-1001"); // fast, cached
proxy.getBalance("ACC-1001"); // fast, cached

proxy.getBalance("ACC-2002"); // slow, remote call
proxy.getBalance("ACC-2002"); // fast, cached
```

Expected output:

```
[CACHE] Cache miss for ACC-1001. Calling real service...
[REAL] Fetching balance from remote system...
[CACHE] Returning cached balance for ACC-1001
[CACHE] Returning cached balance for ACC-1001
```

---

## 🎯 Why Use a Cache Proxy in Banking?

### ✔ Massive Performance Gains
Avoid repeated remote calls to core systems.

### ✔ Reduced Load
Protects downstream services from unnecessary traffic.

### ✔ Transparent to Client
Client code does not change.

### ✔ Thread‑Safe
Uses `ConcurrentHashMap` for safe concurrent access.

### ✔ Realistic Banking Use Case
Balances, FX rates, risk scores, AML flags — all benefit from caching.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.proxy.bank.cache
│
├── AccountBalanceService.java
├── RealAccountBalanceService.java
├── AccountBalanceCacheProxy.java
└── CacheProxyBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **Cache Proxy** that:

- Wraps an expensive remote service
- Caches results for fast subsequent access
- Reduces latency and system load
- Preserves the same interface
- Fits naturally into real banking architectures

A Cache Proxy is one of the most practical and widely used proxy variants in modern distributed systems.

---