# Remote Proxy Pattern — Java RMI Style (Banking Example)
**Package:** `com.mr.gof.structural.proxy.bank.rmi`

## 📘 Overview
The **Remote Proxy** is a GoF Proxy variant used when the real object exists on a **different machine**, **different JVM**, or **remote server**.  
Java RMI (Remote Method Invocation) is the classic example of this pattern.

In this banking scenario:

- The **real bank account service** runs on a remote server.
- Clients interact with a **local proxy (stub)** that forwards calls to the remote object.
- The proxy hides:
    - Network communication
    - Serialization
    - Remote exceptions
    - Server lookup
    - Transport details

This is a textbook demonstration of the **Remote Proxy** pattern.

---

## 🧩 Pattern Structure

### **Subject Interface**
Defines the remote operations:

- `BankAccountRemote`

### **Real Remote Object (Server‑Side)**
Implements the remote interface and runs inside an RMI server:

- `BankAccountRemoteImpl`

### **Remote Proxy (Client‑Side Stub)**
Wraps the remote object and simulates client‑side proxy behavior:

- `BankAccountRemoteProxy`

### **RMI Server**
Creates and binds the remote object:

- `BankAccountRMIServer`

### **RMI Client**
Looks up the remote object and interacts with it through the proxy:

- `BankAccountRMIClient`

---

## 🏦 Banking Scenario

### Without Remote Proxy
Clients would need to manually handle:

- Socket connections
- Serialization
- Timeouts
- Retries
- Exceptions
- Network failures

This would pollute business logic.

### With Remote Proxy
Clients simply call:

```java
BankAccountRemote service = new BankAccountRemoteProxy(remote);
service.getBalance("ACC-1001");
```

The proxy handles everything else.

---

## 📂 Class Diagram (Conceptual)

```
                     ┌──────────────────────────────┐
                     │      BankAccountRemote       │
                     └───────────────┬──────────────┘
                                     │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
┌──────────────────────┐   ┌──────────────────────────┐   ┌────────────────────┐
│ BankAccountRemoteImpl │   │   BankAccountRemoteProxy │   │      Client        │
│   (remote server)     │◄──┤ (client-side stub/proxy) │   │ BankAccountRMIClient│
└──────────────────────┘   └──────────────────────────┘   └────────────────────┘
```

---

## 🧪 Example Usage

### **Start the RMI Server**

```java
BankAccountRemote service = new BankAccountRemoteImpl();
Registry registry = LocateRegistry.createRegistry(1099);
registry.rebind("BankAccountService", service);
```

### **Client Lookup + Proxy**

```java
Registry registry = LocateRegistry.getRegistry("localhost", 1099);
BankAccountRemote remote = (BankAccountRemote) registry.lookup("BankAccountService");

BankAccountRemote proxy = new BankAccountRemoteProxy(remote);

proxy.deposit("ACC-1001", new BigDecimal("500"));
proxy.withdraw("ACC-1001", new BigDecimal("200"));
proxy.getBalance("ACC-1001");
```

---

## 🎯 Why Use a Remote Proxy in Banking?

### ✔ Encapsulation of Network Logic
Clients don’t deal with RMI internals.

### ✔ Fault Isolation
Remote exceptions are handled in one place.

### ✔ Clean Architecture
Business logic stays local and simple.

### ✔ Transparent Remote Calls
Clients call methods as if the object were local.

### ✔ Realistic Distributed System Modeling
Matches how legacy banking systems used RMI and how modern systems use gRPC/REST stubs.

---

## 📦 Package Structure

```
com.mr.gof.structural.proxy.bank.rmi
│
├── BankAccountRemote.java
├── BankAccountRemoteImpl.java
├── BankAccountRemoteProxy.java
│
├── BankAccountRMIServer.java
└── BankAccountRMIClient.java
```

---

## ✔ Summary

This example demonstrates a **Remote Proxy** implemented in the classic **Java RMI style**, where:

- The real object lives on a remote server
- The proxy acts as a local representative
- Clients interact with the proxy, not the remote object
- Network communication is fully hidden

This is a **true GoF Remote Proxy**, aligned with distributed banking architectures.

---