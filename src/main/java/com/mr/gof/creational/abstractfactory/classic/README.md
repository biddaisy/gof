# Classic Abstract Factory — GoF Maze Example
**Package:** `com.mr.gof.creational.abstractfactory.classic`

## 📘 Overview
This module implements the **canonical Abstract Factory pattern** exactly as described in the GoF book.  
The factory creates families of related maze components:

- `Maze`
- `Room`
- `Wall`
- `Door`

The key idea is that **MazeGame never knows which concrete classes it is instantiating**.  
Instead, it delegates all creation to a `MazeFactory`, which can be replaced with subclasses to produce different maze variants.

This is the **classic C++ GoF implementation**, translated faithfully into Java.

---

## 🧩 Pattern Structure

### **1. MapSite (Base Class)**
Common superclass for all maze components:
- `Room`
- `Wall`
- `Door`

Each component implements `enter()`.

---

### **2. MazeFactory (Abstract Factory)**
A concrete class containing factory methods:

```java
public Maze makeMaze()
public Wall makeWall()
public Room makeRoom(int n)
public Door makeDoor(Room r1, Room r2)
```

This is the most common GoF Abstract Factory implementation:
- The base factory is **not abstract**
- Subclasses override only the methods they need to change

---

### **3. MazeGame (Client / Director)**

`MazeGame.createMaze(factory)` builds a maze using only the factory:

```java
Maze maze = factory.makeMaze();
Room r1 = factory.makeRoom(1);
Room r2 = factory.makeRoom(2);
Door door = factory.makeDoor(r1, r2);
```

It never references concrete classes directly.

---

### **4. Concrete Factories**

#### **StandardMazeFactory**
Uses:
- `Room`
- `Wall`
- `Door`

#### **EnchantedMazeFactory**
Overrides:
- `makeRoom()` → returns `EnchantedRoom`
- `makeDoor()` → returns `DoorNeedingSpell`

Adds:
- `Spell castSpell()`

#### **BombedMazeFactory**
Overrides:
- `makeWall()` → returns `BombedWall`
- `makeRoom()` → returns `RoomWithABomb`

---

## 🏗 Example: Standard Factory

```java
MazeFactory factory = new MazeFactory();
Maze maze = game.createMaze(factory);
```

## 🪄 Example: Enchanted Factory

```java
MazeFactory factory = new EnchantedMazeFactory();
Maze maze = game.createMaze(factory);
```

## 💣 Example: Bombed Factory

```java
MazeFactory factory = new BombedMazeFactory();
Maze maze = game.createMaze(factory);
```

---

## 🧪 Demo

The included `Demo` class:

- Builds a **Standard Maze**
- Builds an **Enchanted Maze**
- Builds a **Bombed Maze**
- Prints room numbers
- Prints each side (N/E/S/W)
- Shows the actual class of each component

Example output:

```
=== Standard Maze ===

Room 1
  NORTH  -> Wall
  EAST   -> Door
  SOUTH  -> Wall
  WEST   -> Wall

=== Enchanted Maze ===

Room 1
  NORTH  -> Wall
  EAST   -> DoorNeedingSpell
  SOUTH  -> Wall
  WEST   -> Wall

=== Bombed Maze ===

Room 1
  NORTH  -> BombedWall
  EAST   -> Door
  SOUTH  -> BombedWall
  WEST   -> BombedWall
```

---

## 🎯 Why This Version Matters

### ✔ Faithful GoF implementation
This is the exact structure from the GoF book, translated into Java.

### ✔ Factory methods encapsulate all creation
MazeGame never depends on concrete classes.

### ✔ Easy to extend
New maze types require only a new factory subclass.

### ✔ No reflection, no dynamic catalogs
Pure, classic Abstract Factory.

---

## 📦 Package Structure

```
com.mr.gof.creational.abstractfactory.classic
│
├── MapSite.java
├── Room.java
├── Wall.java
├── Door.java
├── Maze.java
├── Direction.java
│
├── MazeFactory.java
├── EnchantedMazeFactory.java
├── BombedMazeFactory.java
│
├── EnchantedRoom.java
├── DoorNeedingSpell.java
├── BombedWall.java
├── RoomWithABomb.java
│
├── MazeGame.java
├── MazePrinter.java
└── Demo.java
```

---

## ✔ Summary

This module provides a **complete, GoF‑faithful implementation** of the classic Abstract Factory pattern.  
It demonstrates:

- Factory methods for product families
- Subclassed factories for variant mazes
- A MazeGame that is fully decoupled from concrete classes
- Clean extensibility and strong separation of concerns

A foundational example of the Abstract Factory pattern in its purest form.

---
