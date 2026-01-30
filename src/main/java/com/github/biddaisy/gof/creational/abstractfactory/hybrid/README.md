# MazeBuilder + AbstractFactory Hybrid — GoF
**Package:** `com.github.biddaisy.gof.creational.abstractfactory.hybrid`

## 📘 Overview
This module implements the **hybrid design** combining two GoF creational patterns:

- **Abstract Factory** — decides *what kinds* of maze components to create
- **Builder** — decides *how* to assemble the maze

This hybrid is explicitly mentioned in the GoF book as a natural pairing, but the book never provides a full implementation.  
This module delivers a **clean, extensible, production‑ready Java version** that integrates both patterns seamlessly.

The result is a flexible architecture where:

- The **factory** determines the *family of products* (Standard, Enchanted, Bombed, etc.)
- The **builder** determines the *construction algorithm* (layout, number of rooms, door placement)
- `MazeGame` stays completely unchanged

---

## 🧩 Pattern Structure

### **1. MapSite (Base Class)**
Common superclass for all maze components:
- `Room`
- `Wall`
- `Door`

---

### **2. MazeFactory (Abstract Factory)**

A concrete class containing factory methods:

```java
public Maze makeMaze()
public Wall makeWall()
public Room makeRoom(int n)
public Door makeDoor(Room r1, Room r2)
```

Subclasses override only the methods they need to change:

- `EnchantedMazeFactory`
- `BombedMazeFactory`

---

### **3. MazeBuilder (Builder Interface)**

Defines *how* the maze is assembled:

```java
void buildMaze();
void buildRoom(int roomNumber);
void buildDoor(int room1, int room2);
Maze getMaze();
```

---

### **4. StandardMazeBuilder (Hybrid Implementation)**

Uses the factory to create components:

- Creates rooms
- Adds default walls
- Connects rooms with doors
- Builds the maze step‑by‑step

This is the **hybrid**:  
The builder delegates object creation to the Abstract Factory.

---

### **5. MazeGame (Director)**

`MazeGame` orchestrates the building process:

```java
builder.buildMaze();
builder.buildRoom(1);
builder.buildRoom(2);
builder.buildDoor(1, 2);
return builder.getMaze();
```

It never changes, regardless of maze type.

---

## 🏗 Example: Standard Factory + Builder

```java
MazeFactory factory = new MazeFactory();
MazeBuilder builder = new StandardMazeBuilder(factory);

Maze maze = new MazeGame().createMaze(builder);
```

## 🪄 Example: Enchanted Factory + Builder

```java
MazeFactory factory = new EnchantedMazeFactory();
MazeBuilder builder = new StandardMazeBuilder(factory);

Maze maze = new MazeGame().createMaze(builder);
```

## 💣 Example: Bombed Factory + Builder

```java
MazeFactory factory = new BombedMazeFactory();
MazeBuilder builder = new StandardMazeBuilder(factory);

Maze maze = new MazeGame().createMaze(builder);
```

---

## 🧪 Demo

The included `HybridDemo` builds:

### ✔ Standard Maze
Uses:
- `Room`
- `Wall`
- `Door`

### ✔ Enchanted Maze
Uses:
- `EnchantedRoom`
- `DoorNeedingSpell`

### ✔ Bombed Maze
Uses:
- `RoomWithABomb`
- `BombedWall`

All three use the **same builder** and **same MazeGame**.

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
This is the exact hybrid the GoF book hints at.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.abstractfactory.hybrid
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
├── MazeBuilder.java
├── StandardMazeBuilder.java
│
├── MazeGame.java
├── DemoUtils.java
└── HybridDemo.java
```

---

## ✔ Summary

This module provides a **complete, extensible, and GoF‑faithful** implementation of the **MazeBuilder + AbstractFactory hybrid**.  
It demonstrates:

- Runtime product family selection
- Flexible construction algorithms
- Clean separation of concerns
- Maximum extensibility with minimal coupling

A powerful architectural pattern for any system requiring both **product variation** and **complex construction logic**.

---
