# Remote Proxy Pattern — gRPC‑Style Banking Example
**Package:** `com.github.biddaisy.gof.structural.proxy.bank.grpc`

## 📘 Overview
The **Remote Proxy** is a GoF Proxy variant used when the real object exists on a **remote server**.  
Modern distributed banking systems frequently use **gRPC** for high‑performance, strongly‑typed RPC communication.

This example demonstrates a **gRPC‑style Remote Proxy** where:

- The **server** hosts a `BankAccountGrpcService`
- The **client** communicates through a **generated stub**
- A **Remote Proxy** wraps the stub to add:
    - Logging
    - Retry logic
    - Network failure simulation
    - Latency simulation

This mirrors real‑world microservice communication in financial systems.

---

## 🧩 Pattern Structure

### **1. Service Definition (`.proto`)**
Defines the RPC contract:

- `GetBalance`
- `Deposit`
- `Withdraw`

Messages:

- `BalanceRequest`, `BalanceResponse`
- `TransactionRequest`, `TransactionResponse`

### **2. Server‑Side Implementation**
`BankAccountGrpcService` simulates a real gRPC server:

- Stores balances
- Processes RPC calls
- Simulates latency

### **3. Client Stub**
`BankAccountGrpcStub` simulates the auto‑generated gRPC client stub.

### **4. Remote Proxy**
`BankAccountGrpcProxy` wraps the stub and adds:

- Logging
- Retry logic
- Network failure simulation
- Error handling

### **5. Client**
`GrpcProxyBankDemo` interacts only with the proxy.

---

## 🏦 Banking Scenario

### Without Remote Proxy
The client would need to handle:

- Network failures
- Retries
- Latency
- Logging
- Error handling

This would clutter business logic.

### With Remote Proxy
The client simply calls:

```java
proxy.deposit("ACC-1001", new BigDecimal("500"));
proxy.getBalance("ACC-1001");
```

The proxy handles all network concerns.

---

## 📂 Class Diagram (Conceptual)

```
                     ┌──────────────────────────────┐
                     │   BankAccountService.proto   │
                     └───────────────┬──────────────┘
                                     │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
┌──────────────────────┐   ┌──────────────────────────┐   ┌────────────────────┐
│ BankAccountGrpcService│   │   BankAccountGrpcProxy   │   │      Client        │
│   (remote server)     │◄──┤ (client-side remote proxy)│  │ GrpcProxyBankDemo  │
└──────────────────────┘   └──────────────────────────┘   └────────────────────┘
                                     ▲
                                     │
                         ┌──────────────────────────┐
                         │   BankAccountGrpcStub    │
                         │ (simulated gRPC stub)    │
                         └──────────────────────────┘
```

---

## 🧪 Example Usage

### **Client Code**

```java
BankAccountGrpcService server = new BankAccountGrpcService();
BankAccountGrpcStub stub = new BankAccountGrpcStub(server);

BankAccountGrpcProxy proxy = new BankAccountGrpcProxy(stub);

proxy.deposit("ACC-1001", new BigDecimal("500"));
proxy.withdraw("ACC-1001", new BigDecimal("200"));

BigDecimal balance = proxy.getBalance("ACC-1001");
Logger.log("Final balance: {0}", balance);
```

The proxy:

- Simulates network failures (20% chance)
- Retries up to 3 times
- Logs all calls
- Delegates to the stub

---

## 🎯 Why Use a gRPC‑Style Remote Proxy in Banking?

### ✔ Encapsulation of Network Logic
Clients remain clean and business‑focused.

### ✔ Fault Tolerance
Retries and fallback behavior are centralized.

### ✔ Observability
All remote calls are logged for auditing.

### ✔ Realistic Microservice Simulation
Matches how modern banking systems use gRPC stubs.

### ✔ Strong Typing
Request/response messages enforce strict structure.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.structural.proxy.bank.grpc
│
├── BalanceRequest.java
├── BalanceResponse.java
├── TransactionRequest.java
├── TransactionResponse.java
│
├── BankAccountGrpcService.java
├── BankAccountGrpcStub.java
├── BankAccountGrpcProxy.java
│
└── GrpcProxyBankDemo.java
```

---

## ✔ Summary

This example demonstrates a **modern Remote Proxy** using a **gRPC‑style architecture**, where:

- The real service runs remotely
- The stub acts as a client‑side RPC interface
- The proxy adds reliability, logging, and network simulation
- The client interacts only with the proxy

This is a **true GoF Remote Proxy**, implemented in a way that mirrors real banking microservices.

---