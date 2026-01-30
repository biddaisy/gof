# Dynamic Abstract Factory + MazeBuilder Hybrid — Smalltalk‑Style (GoF)
**Package:** `com.github.biddaisy.gof.creational.abstractfactory.dynamic`

## 📘 Overview
This module implements a **hybrid design** combining two GoF creational patterns:

- **Dynamic Abstract Factory (Smalltalk‑style)**  
  The factory stores **classes** in a runtime catalog and creates objects using a single `make(String)` method.

- **MazeBuilder (Builder Pattern)**  
  The builder controls *how* the maze is assembled (layout, rooms, doors).

Together, they form one of the most flexible and extensible architectures in the GoF catalog:

- The **factory** decides *what kinds* of components to create (Standard, Enchanted, Bombed, etc.)
- The **builder** decides *how* to assemble the maze
- `MazeGame` stays completely unchanged

This hybrid is explicitly mentioned in the GoF book as a natural pairing, but the book never provides a full implementation.  
This module delivers a **clean, production‑ready Java version**.

---

## 🧩 Pattern Structure

### **1. MapSite (Base Class)**
Common superclass for all maze components:
- `Room`
- `Wall`
- `Door`

---

### **2. Dynamic MazeFactory (Smalltalk‑style Abstract Factory)**

The factory stores a mapping:

```
String partName → Class<? extends MapSite>
```

Example:

```java
factory.addPart(Room.class, "room");
factory.addPart(Wall.class, "wall");
factory.addPart(Door.class, "door");
```

Object creation:

```java
MapSite site = factory.make("room");
```

This is the Java equivalent of the Smalltalk:

```
make: partName
    ^ (partCatalog at: partName) new
```

Factories are created by registering different classes:

- `StandardMazeFactoryCreator`
- `EnchantedMazeFactoryCreator`
- (extendable: Bombed, Counting, Logging, etc.)

---

### **3. MazeBuilder (Builder Pattern)**

The builder defines *how* the maze is assembled:

```java
void buildMaze();
void buildRoom(int roomNumber);
void buildDoor(int room1, int room2);
Maze getMaze();
```

The included `StandardMazeBuilder`:

- Creates rooms using the factory
- Adds default walls
- Connects rooms with doors
- Builds the maze step‑by‑step

This is the **hybrid**:  
The builder delegates object creation to the Abstract Factory.

---

### **4. MazeGame (Director)**

`MazeGame` orchestrates the building process:

```java
builder.buildMaze();
builder.buildRoom(1);
builder.buildRoom(2);
builder.buildDoor(1, 2);
return builder.getMaze();
```

It never changes, regardless of:

- Maze type
- Factory type
- Builder type

---

## 🏗 Example: Standard Factory

```java
return new MazeFactory()
        .addPart(Wall.class, "wall")
        .addPart(Room.class, "room")
        .addPart(Door.class, "door");
```

## 🪄 Example: Enchanted Factory

```java
return new MazeFactory()
        .addPart(Wall.class, "wall")
        .addPart(EnchantedRoom.class, "room")
        .addPart(DoorNeedingSpell.class, "door");
```

---

## 🧪 Demo (HybridDemo)

The included `HybridDemo` builds:

### ✔ Standard Maze (Builder + Factory)
Uses:
- `Room`
- `Wall`
- `Door`

### ✔ Enchanted Maze (Builder + Factory)
Uses:
- `EnchantedRoom`
- `DoorNeedingSpell`

Both use the **same builder** and **same MazeGame**.

Example output:

```
=== Standard Maze (Builder + Factory) ===
Room 1
  NORTH  -> Wall
  EAST   -> Door
  SOUTH  -> Wall
  WEST   -> Wall

=== Enchanted Maze (Builder + Factory) ===
Room 1
  NORTH  -> Wall
  EAST   -> DoorNeedingSpell
  SOUTH  -> Wall
  WEST   -> DoorNeedingSpell
```

---

## 🎯 Why This Hybrid Matters

### ✔ Abstract Factory decides *what* to build
Different families of products:

- Standard
- Enchanted
- Bombed
- Counting
- Logging
- Plugin‑based factories

### ✔ Builder decides *how* to build
Different construction algorithms:

- Linear maze
- Grid maze
- Procedural/random maze
- Multi‑level maze
- JSON/XML‑driven maze

### ✔ MazeGame stays unchanged
The same algorithm works with any factory + any builder.

### ✔ Fully GoF‑compliant
This is the exact combination the GoF book hints at.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.abstractfactory.dynamic
│
├── MapSite.java
├── Room.java
├── Wall.java
├── Door.java
├── Maze.java
├── Direction.java
│
├── MazeFactory.java
├── StandardMazeFactoryCreator.java
├── EnchantedMazeFactoryCreator.java
│
├── EnchantedRoom.java
├── DoorNeedingSpell.java
│
├── MazeBuilder.java
├── StandardMazeBuilder.java
│
├── MazeGame.java
├── HybridDemo.java
└── DemoUtils.java
```

---

## ✔ Summary

This module provides a **complete, extensible, and GoF‑faithful** implementation of the **Dynamic Abstract Factory + MazeBuilder hybrid**.  
It demonstrates:

- Runtime product family selection
- Flexible construction algorithms
- Clean separation of concerns
- Maximum extensibility with minimal coupling

A powerful architectural pattern for any system requiring both **product variation** and **complex construction logic**.

---
