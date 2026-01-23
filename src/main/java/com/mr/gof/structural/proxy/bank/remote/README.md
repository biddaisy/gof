# Remote Proxy Pattern — Banking Example
**Package:** `com.mr.gof.structural.proxy.bank.remote`

## 📘 Overview
The **Remote Proxy** is a GoF Proxy variant used when the real object exists on a **different machine**, **different process**, or **remote server**.  
The proxy acts as a **local representative** (client‑side stub) that hides:

- Network communication
- Serialization/deserialization
- Latency
- Connection failures
- Retries
- Logging

This pattern is foundational in distributed banking systems, microservices, and service‑oriented architectures.

In this example, a **RemoteBankAccountService** simulates a remote server that stores account balances.  
Clients never call it directly — they interact with a **RemoteBankAccountProxy**, which simulates real‑world network behavior.

---

## 🧩 Pattern Structure

### **Subject Interface**
Defines the operations available to clients:

- `RemoteBankAccountService`

### **Real Remote Service**
Simulates a server running elsewhere:

- `RealRemoteBankAccountService`
    - Stores balances
    - Simulates network latency
    - Responds to requests

### **Remote Proxy**
Client‑side stub that:

- Simulates network calls
- Injects random failures
- Implements retry logic
- Logs requests/responses
- Delegates to the remote service

- `RemoteBankAccountProxy`

### **Client**
Uses the proxy instead of the remote service:

- `RemoteProxyBankDemo`

---

## 🏦 Banking Scenario

### Without Remote Proxy
Clients would need to handle:

- Network connections
- Timeouts
- Retries
- Failures
- Logging
- Latency

This would pollute business logic and create brittle code.

### With Remote Proxy
Clients simply call:

```java
RemoteBankAccountService service =
    new RemoteBankAccountProxy(realRemoteService);

service.getBalance("ACC-1001");
```

The proxy handles everything else.

---

## 📂 Class Diagram (Conceptual)

```
                     ┌──────────────────────────────┐
                     │ RemoteBankAccountService     │
                     └───────────────┬──────────────┘
                                     │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
┌──────────────────────┐   ┌──────────────────────────┐   ┌────────────────────┐
│ RealRemoteBankAccount │   │   RemoteBankAccountProxy │   │      Client        │
│       Service         │◄──┤ (network simulation)     │   │ RemoteProxyBankDemo│
└──────────────────────┘   └──────────────────────────┘   └────────────────────┘
```

---

## 🧪 Example Usage

```java
RemoteBankAccountService remote = new RealRemoteBankAccountService();

RemoteBankAccountService proxy =
        new RemoteBankAccountProxy(remote);

proxy.getBalance("ACC-1001");
proxy.getBalance("ACC-2002");
proxy.getBalance("ACC-9999");
```

The proxy simulates:

- 150ms network latency
- 20% chance of network failure
- 3 retry attempts
- Logging of all attempts

---

## 🎯 Why Use a Remote Proxy in Banking?

### ✔ Encapsulation of Network Logic
Clients don’t deal with sockets, HTTP, retries, or failures.

### ✔ Fault Tolerance
Retries and fallback behavior are centralized.

### ✔ Logging & Monitoring
Every remote call is logged for auditing.

### ✔ Cleaner Architecture
Business logic stays clean and local.

### ✔ Realistic Distributed System Simulation
Matches how banking microservices communicate in production.

---

## 📦 Package Structure

```
com.mr.gof.structural.proxy.bank.remote
│
├── RemoteBankAccountService.java
├── RealRemoteBankAccountService.java
├── RemoteBankAccountProxy.java
└── RemoteProxyBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **Remote Proxy**, one of the most important GoF Proxy variants for distributed banking systems.

The proxy:

- Represents a remote object
- Simulates network behavior
- Adds retry logic
- Adds logging
- Protects the real remote service
- Maintains the same interface

This is a **true Remote Proxy**, aligned with real-world financial architectures and microservice communication patterns.

---