# Serialization‑Safe Singleton (using `readResolve()`)
**Package:** `com.github.biddaisy.gof.creational.singleton.serialization`

## 📘 Overview
Java serialization can silently break the Singleton pattern.  
When a Singleton is serialized and then deserialized, the JVM creates a **new instance**, violating the Singleton contract.

The solution is to implement the `readResolve()` method.  
This method is invoked by the JVM after deserialization and allows the class to **replace the deserialized object** with the original Singleton instance.

This module demonstrates a **thread‑safe, serialization‑safe Singleton** using the classic GoF class‑based approach.

---

## 🧩 Key Concepts

### **1. The Problem**
Without protection, this code:

```java
ObjectInputStream in = ...
Singleton s2 = (Singleton) in.readObject();
```

creates a **new instance**, even if the constructor is private.

### **2. The Solution — `readResolve()`**
Implementing:

```java
private Object readResolve() {
    return INSTANCE;
}
```

forces the JVM to return the existing Singleton instance instead of the newly deserialized one.

### **3. Serializable Singleton Requirements**
- Must implement `Serializable`
- Must define a `serialVersionUID`
- Must implement `readResolve()`

---

## 🏗 Class Structure

### **SerializationSafeSingleton**
- Eagerly initialized Singleton instance
- Implements `Serializable`
- Overrides `readResolve()` to preserve Singleton identity

### **Demo**
- Serializes the Singleton to a file
- Deserializes it back
- Verifies that both references point to the **same instance**

---

## 🧪 Example Output

```
s1 == s2: true
```

This confirms that serialization did **not** create a second instance.

---

## 📦 Package Structure

```
serialization
│
├── SerializationSafeSingleton.java
└── Demo.java
```

---

## 🎯 Why Use This Variant?

### ✔ When you need:
- A **class‑based** Singleton (not enum)
- **Serialization safety**
- **Thread safety** (via eager initialization)
- Compatibility with frameworks that require Serializable objects

### ✔ When NOT to use:
If you need:
- Reflection‑proof Singleton
- Simplest and strongest Singleton

➡️ Use **Enum Singleton** instead.

---

## ✔ Summary
This module provides a robust, serialization‑safe Singleton implementation using the `readResolve()` technique. It ensures:

- Only one instance exists across serialization boundaries
- Thread‑safe initialization
- Full compatibility with Java’s serialization mechanism

A solid, GoF‑faithful Singleton suitable for enterprise systems.

---
