# 📦 `singleton.test` — Hardened Singleton Test Suite

This package contains a comprehensive attack and stress‑test suite for validating the integrity of the hardened `SerializationSafeSingleton`.  
The goal is to ensure that the Singleton remains unique, unbreakable, and stable under all known JVM‑level attack vectors.

The tests simulate real‑world threats that can break improperly implemented Singletons, including:

- Reflection attacks
- Cloning attacks
- Serialization attacks
- Multithreaded access
- Combined stress scenarios

These tests are intentionally low‑level and aggressive to expose weaknesses early.

---

## 🧪 Included Tests

### 1. **ReflectionAttackTest**
Attempts to instantiate the Singleton using Java reflection by:

- Accessing the private constructor
- Forcing accessibility
- Creating a second instance

**Expected outcome:**  
The constructor’s guard flag detects the attack and throws `IllegalStateException`.

---

### 2. **CloneAttackTest**
Attempts to break the Singleton by cloning it.

Since `clone()` is protected, the test uses reflection to invoke it.

**Expected outcome:**  
`CloneNotSupportedException` is thrown, and no new instance is created.

---

### 3. **SerializationTestHarness**
Validates that serialization does not create a new instance.

Steps:

1. Serialize the Singleton to disk
2. Deserialize it
3. Compare identity (`==`)

**Expected outcome:**  
`readResolve()` returns the canonical instance.

---

### 4. **SerializationAndConcurrencyStressTest**
A combined stress test that validates:

- Thread‑safe access under heavy concurrency
- Serialization safety across multiple cycles
- Identity consistency across all threads and deserialization attempts
- Proper executor shutdown (Java 25 compliant)
- Proper file cleanup using `Files.deleteIfExists(Path)`

**Expected outcome:**  
Only one instance is ever observed.

---

## 🔐 What These Tests Guarantee

Together, these tests ensure that the Singleton is hardened against:

| Attack Vector | Defense Mechanism |
|---------------|-------------------|
| Reflection | Constructor guard flag |
| Serialization | `readResolve()` |
| Cloning | Overridden `clone()` throwing exception |
| Concurrency | JVM class‑loading guarantees + eager initialization |
| Deserialization loops | Identity preserved across cycles |

This suite validates that the Singleton implementation is robust, predictable, and compliant with GoF design principles.

---

## 🧭 Package Purpose

This package exists to:

- Demonstrate correct Singleton hardening techniques
- Provide regression tests for future refactoring
- Serve as reference material for GoF pattern learners
- Ensure that the Singleton cannot be broken accidentally or intentionally

It is intentionally explicit to highlight JVM behavior and edge cases.

---

## 📁 Directory Structure

com.github.biddaisy.gof.creational.singleton.test
├── ReflectionAttackTest.java
├── CloneAttackTest.java
├── SerializationTestHarness.java
└── SerializationAndConcurrencyStressTest.java


---

## ✔ Best Practices Demonstrated

- Proper use of `readResolve()`
- Reflection‑safe constructor design
- Clone‑safe Singleton implementation
- Java 25–compliant executor shutdown
- NIO‑based file cleanup
- Deterministic concurrency testing
- Clear logging via the project’s custom `Logger`  
