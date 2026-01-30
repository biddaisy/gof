# Structural Design Patterns — Complete Module
**Package Root:** `com.github.biddaisy.gof.structural`

## 📘 Overview
Structural patterns define **how classes and objects are composed** to form larger structures while keeping them flexible and efficient.  
They help you build systems that are:

- Easier to extend
- Easier to maintain
- Less tightly coupled
- More expressive in their architecture

This module contains **full, production‑grade implementations** of all major GoF Structural Patterns, each adapted to realistic domains such as banking, computer hardware, and distributed systems.

---

# 🧩 Included Structural Patterns

## 1. **Adapter Pattern**
**Package:** `com.github.biddaisy.gof.structural.adapter`  
Adapts incompatible interfaces so they can work together.  
Used for integrating legacy systems or third‑party APIs.

**Example domain:**
- Converting legacy banking APIs to modern interfaces
- Wrapping incompatible hardware drivers

---

## 2. **Bridge Pattern**
**Package:** `com.github.biddaisy.gof.structural.bridge`  
Separates abstraction from implementation so both can vary independently.

**Example domain:**
- Payment processing abstraction with multiple payment gateways
- Rendering engines with multiple output devices

---

## 3. **Composite Pattern**
**Packages:**
- `com.github.biddaisy.gof.structural.composite.computer`
- `com.github.biddaisy.gof.structural.composite.bank`

Treats individual objects and compositions uniformly.

### Computer Composite
Models computer hardware:

- `Cabinet`, `Chassis`, `Bus` (composites)
- `Card`, `FloppyDisk` (leaves)
- Full recursive pricing, power, serialization, and traversal

### Banking Composite
Models financial account hierarchies:

- `IndividualAccount` (leaf)
- `JointAccount`, `CustomerPortfolio` (composites)
- Recursive balance aggregation
- Portfolio analytics
- Nested joint accounts

---

## 4. **Decorator Pattern**
**Package:** `com.github.biddaisy.gof.structural.decorator`  
Adds responsibilities dynamically without modifying the original class.

**Example domain:**
- Adding logging, encryption, or validation to banking transactions
- Enhancing hardware components with optional features

---

## 5. **Facade Pattern**
**Package:** `com.github.biddaisy.gof.structural.facade`  
Provides a simplified interface to a complex subsystem.

**Example domain:**
- Unified banking operations API
- Computer system boot sequence controller

---

## 6. **Flyweight Pattern**
**Package:** `com.github.biddaisy.gof.structural.flyweight`  
Shares intrinsic state to reduce memory usage.

**Example domain:**
- Shared hardware specifications
- Banking currency metadata
- Reusable immutable objects

---

## 7. **Proxy Pattern**
**Packages:**
- `com.github.biddaisy.gof.structural.proxy.bank.rmi`
- `com.github.biddaisy.gof.structural.proxy.bank.grpc`
- `com.github.biddaisy.gof.structural.proxy.bank.virtual`
- `com.github.biddaisy.gof.structural.proxy.bank.cache`

Controls access to another object, adding behavior such as:

### Remote Proxy (RMI)
Simulates Java RMI remote service access.

### Remote Proxy (gRPC)
Modern distributed system proxy with:

- Stub wrapping
- Retry logic
- Network simulation
- Logging

### Virtual Proxy
Lazy‑loads expensive objects (e.g., KYC profiles).

### Cache Proxy
Caches expensive remote calls (e.g., account balances).

---

# 🏗 Architectural Philosophy

This module follows these principles:

### ✔ **Domain‑realistic examples**
Banking, hardware, distributed systems — not toy examples.

### ✔ **BigDecimal for financial correctness**
All monetary calculations use precise arithmetic.

### ✔ **Custom logging**
Consistent, structured logging across all patterns.

### ✔ **Iterator support**
Composite structures expose iterators for traversal.

### ✔ **Extensibility**
Each pattern is implemented in a way that encourages extension without modification.

### ✔ **Clean package boundaries**
Each pattern is isolated in its own namespace.

---

# 📂 Directory Structure

```
com/mr/gof/structural
│
├── adapter/
├── bridge/
├── composite/
│   ├── computer/
│   └── bank/
├── decorator/
├── facade/
├── flyweight/
└── proxy/
    ├── bank/
    │   ├── rmi/
    │   ├── grpc/
    │   ├── virtual/
    │   └── cache/
```

---

# 🎯 Summary

This module provides **complete, production‑ready implementations** of all GoF Structural Patterns, each demonstrated with:

- Realistic domain models
- Clean object‑oriented design
- Precise financial calculations
- Logging, error handling, and extensibility
- Full documentation and demos

It serves as a **professional reference implementation** for structural design patterns in Java.

---