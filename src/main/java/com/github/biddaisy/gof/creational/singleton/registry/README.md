# Singleton Registry (Index‑Based)

A tiny, explicit registry for managing multiple singleton implementations.  
No scanning, no ServiceLoader, no static blocks.

---

## Architecture Diagram

┌──────────────┐
│ Application  │
└──────┬───────┘
│ get("Foo")
▼
┌──────────────┐
│  Registry    │
└──────┬───────┘
│ loads Index.ALL[]
▼
┌──────────────┐
│  Index       │
└──────┬───────┘
│ providers[]
▼
┌──────────────┐
│ Providers    │
└──────┬───────┘
│ instance()
▼
┌──────────────┐
│ Singletons   │
└──────────────┘

---

## Dependency Direction

Singletons → Providers → SingletonIndex → SingletonRegistry → Application

---

## Startup Flow

Application starts  
↓  
Registry static init  
↓  
Registry loads Index.ALL[]  
↓  
Each Provider supplies instance  
↓  
Registry stores instance  
↓  
Application calls get("Foo")  
↓  
Registry returns instance

---

## Core Concepts (Conceptual)

SingletonProvider
- name() → String
- instance() → Singleton

SingletonIndex
- ALL = [ Foo.Provider, Bar.Provider, LazyFoo.Provider ]

SingletonRegistry
- loadAll() → register all providers
- get(name) → return instance

---

## Example Singletons (Conceptual)

FooSingleton (eager)
- INSTANCE = new FooSingleton()
- Provider: name="Foo", instance=INSTANCE

BarSingleton (eager)
- INSTANCE = new BarSingleton()
- Provider: name="Bar", instance=INSTANCE

LazyFooSingleton (lazy)
- INSTANCE created on first getInstance()
- Provider: name="LazyFoo", instance=getInstance()

---

## Usage

SingletonRegistry.get("Foo").doWork()  
SingletonRegistry.get("Bar").doWork()  
SingletonRegistry.get("LazyFoo").doWork()

---

## Adding a New Singleton

1. Implement the singleton
2. Add a nested Provider
3. Add provider to SingletonIndex.ALL

---

## Why This Design

- No scanning
- No static blocks
- No reflection hacks
- Explicit wiring
- Deterministic startup
- Works with eager, lazy, holder, enum  
