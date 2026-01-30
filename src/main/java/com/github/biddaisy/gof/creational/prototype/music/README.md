# Prototype Pattern — Music Editor Example
**Package:** `com.github.biddaisy.gof.creational.prototype.music`

## 📘 Overview
This module demonstrates the **Prototype** design pattern using the classic GoF scenario of a **music score editor**.

In this editor, users add musical elements such as notes, rests, and staves to a score. The framework provides:

- A palette of tools
- A base `Graphic` class for drawable objects
- A `Tool` abstraction for user actions
- A `GraphicTool` for creating new graphics

The challenge:  
The framework cannot know the concrete classes of music objects (whole notes, quarter notes, rests, staves). Subclassing `GraphicTool` for each type would lead to a large number of nearly identical subclasses.

The **Prototype pattern** solves this by letting `GraphicTool` clone a **prototype instance** of the desired `Graphic`. Each tool is parameterized by a prototype, not by a subclass.

---

## 🧩 Pattern Structure

### **1. Prototype — `Graphic`**
The abstract base class for all drawable music elements.  
It defines:

- `draw()` — rendering behavior
- `cloneGraphic()` — the Prototype cloning operation

All concrete music objects inherit cloning behavior.

### **2. Concrete Prototypes**
- `MusicalNote` — configurable by bitmap and duration
- `Rest` — represents silence
- `Staff` — five-line staff

Instead of separate classes for whole, half, and quarter notes, `MusicalNote` instances are configured differently. This dramatically reduces class count.

### **3. Tool Hierarchy**
- `Tool` — abstract base for all editor tools
- `GraphicTool` — framework tool that clones a prototype and inserts it into the document

Each tool in the palette is simply:

```java
new GraphicTool(somePrototype);
```

No subclassing required.

### **4. ScoreDocument**
Stores all graphics added to the score.  
Provides safe, read‑only query operations:

- `getGraphics()`
- `getGraphicsByType()`
- `getLastGraphic()`
- `getGraphicCount()`
- `findGraphics(Predicate)`

This allows the editor to inspect and manipulate the score without exposing internal state.

---

## 🏗 Example Flow

### Configure prototypes
```java
Graphic wholeNote   = new MusicalNote("whole-note-bitmap", "whole");
Graphic quarterNote = new MusicalNote("quarter-note-bitmap", "quarter");
Graphic rest        = new Rest("quarter-rest");
Graphic staff       = new Staff();
```

### Configure tools
```java
Tool wholeNoteTool   = new GraphicTool(wholeNote);
Tool quarterNoteTool = new GraphicTool(quarterNote);
Tool restTool        = new GraphicTool(rest);
Tool staffTool       = new GraphicTool(staff);
```

### User clicks tools
```java
wholeNoteTool.onMouseClick(score);
quarterNoteTool.onMouseClick(score);
restTool.onMouseClick(score);
staffTool.onMouseClick(score);
```

Each click clones the prototype and inserts the clone into the score.

---

## 🧪 Sample Output

```
Added graphic to score:
Drawing MusicalNote: whole (whole-note-bitmap)

Added graphic to score:
Drawing MusicalNote: quarter (quarter-note-bitmap)

Added graphic to score:
Drawing Rest: quarter-rest

Added graphic to score:
Drawing Staff (5 lines)
```

---

## 🎯 Why This Variant Matters

### ✔ Eliminates subclass explosion
No need for `WholeNoteTool`, `QuarterNoteTool`, `RestTool`, etc.

### ✔ Framework stays decoupled
`GraphicTool` never needs to know concrete classes.

### ✔ Easy to add new music objects
Just create a new prototype and a new `GraphicTool`.

### ✔ Reduces number of classes
Whole, half, quarter notes become **instances**, not subclasses.

### ✔ Perfect match to the GoF description
This module faithfully implements the music‑editor example from the book.

---

## 📦 Package Structure

```
com.github.biddaisy.gof.creational.prototype.music
│
├── Graphic.java
├── MusicalNote.java
├── Rest.java
├── Staff.java
│
├── Tool.java
├── GraphicTool.java
│
├── ScoreDocument.java
└── Demo.java
```

---

## ✔ Summary
This module provides a **GoF‑accurate implementation** of the Prototype pattern:

- Prototypes represent music objects
- Tools clone prototypes to create new graphics
- The framework remains flexible and decoupled
- The number of classes is minimized
- Adding new note types becomes trivial

A strong, extensible example of Prototype in a real editor framework.

---
