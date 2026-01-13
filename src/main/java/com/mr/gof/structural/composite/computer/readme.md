# Composite Pattern Implementation in Java

## 📋 Overview
This project demonstrates the **Composite Design Pattern** from the Gang of Four (GoF) patterns, implemented in Java with modern features including `BigDecimal` for precise financial calculations and a custom logging utility.

## 🎯 Purpose
The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. This implementation models computer equipment hierarchies where individual components (leaf nodes) and composite components (containers) can be treated uniformly through a common interface.

## 🏗️ Project Structure
CompositePattern/
├── Equipment.java # Abstract base class (Component)
├── FloppyDisk.java # Leaf class
├── Card.java # Leaf class
├── CompositeEquipment.java # Abstract composite class
├── Chassis.java # Concrete composite class
├── Bus.java # Concrete composite class
├── Cabinet.java # Concrete composite class
├── NullIterator.java # Null Object pattern implementation
├── MoneyUtils.java # Utility class for financial operations
├── Logger.java # Custom logging utility
├── CompositePatternDemo.java # Main demonstration class
└── README.md # This file

text

## 🎭 Design Patterns Used
### 1. **Composite Pattern** (Primary Pattern)
- **Component**: `Equipment` (abstract) - Defines the common interface
- **Leaf**: `FloppyDisk`, `Card` - Implement terminal equipment
- **Composite**: `CompositeEquipment`, `Chassis`, `Bus`, `Cabinet` - Implement equipment containers

### 2. **Null Object Pattern**
- `NullIterator` - Provides safe default iterator behavior for leaf components

### 3. **Utility Pattern**
- `MoneyUtils` - Helper methods for financial calculations
- `Logger` - Simplified logging interface

### 4. **Factory Method Pattern**
- Implicitly used in equipment constructors for object creation

### 5. **Iterator Pattern**
- `createIterator()` method for traversing composite structures
- `NullIterator` implementation for leaf components

## 🚀 Features
- **Hierarchical Modeling**: Represent complex computer equipment structures
- **Precise Calculations**: Use `BigDecimal` for accurate financial operations
- **Uniform Interface**: Treat individual and composite objects identically
- **Type Safety**: Compile-time checking with proper inheritance hierarchy
- **Error Handling**: Graceful handling of invalid operations
- **Logging**: Comprehensive logging with different severity levels
- **Serialization**: JSON and CSV output for equipment data

## 📊 Class Hierarchy
Equipment (abstract)
├── FloppyDisk (leaf)
├── Card (leaf)
└── CompositeEquipment (abstract)
├── Chassis
├── Bus
└── Cabinet

text

## 💻 Key Components
### Equipment (Abstract Base Class)
```java
// Common interface for all equipment
abstract class Equipment {
    public abstract BigDecimal getPower();
    public abstract BigDecimal netPrice();
    public abstract BigDecimal discountPrice();
    public void add(Equipment e);          // Throws exception for leaf
    public void remove(Equipment e);       // Throws exception for leaf
    public Iterator<Equipment> createIterator();
}
Leaf Classes
FloppyDisk: Represents a floppy disk drive with fixed pricing

Card: Represents expansion cards (network, sound, etc.)

Composite Classes
CompositeEquipment: Base class for equipment that can contain other equipment

Chassis: Computer chassis containing buses and drives

Bus: Expansion bus containing cards

Cabinet: Outer cabinet containing chassis and other components

🔧 How to Run
Prerequisites
Java 11 or higher

Command line tools

Compilation
bash
# Compile all Java files
javac *.java
Execution
bash
# Run the main demonstration
java CompositePatternDemo
📝 Example Usage
java
// Building a computer system
Cabinet cabinet = new Cabinet("PC Cabinet");
Chassis chassis = new Chassis("PC Chassis");
cabinet.add(chassis);

Bus bus = new Bus("MCA Bus");
bus.add(new Card("16Mbs Token Ring Card"));
bus.add(new Card("Sound Card"));

chassis.add(bus);
chassis.add(new FloppyDisk("3.5in Floppy"));

// Calculate total price
BigDecimal totalPrice = cabinet.netPrice();
Logger.log("Total price: {0}", MoneyUtils.formatCurrency(totalPrice));
📈 Example Output
text
=== Computer Assembly using Composite Pattern ===

Computer Configuration:
PC Cabinet
  PC Chassis
    MCA Bus
      16Mbs Token Ring Card
      Sound Card
    3.5in Floppy Disk

=== Price and Power Calculations ===
Total Net Price: $670.00
Discounted Price: $595.50
Total Savings: $74.50
Total Power Consumption: 90.00 Watts
🎯 Key Benefits
Uniform Treatment: Client code can treat individual objects and compositions identically

Simplified Client Code: No need for type checking or conditional logic

Easy to Add New Types: New equipment types can be added without modifying existing code

Recursive Composition: Natural representation of hierarchical structures

Type Safety: Compile-time checking prevents invalid operations

🔍 Design Considerations
When to Use Composite Pattern
You need to represent part-whole hierarchies

You want clients to ignore differences between individual and composite objects

The structure can have any level of complexity

You need to apply operations recursively over the hierarchy

Trade-offs
Pros: Simplifies client code, makes adding new components easy, provides flexibility

Cons: Can make design overly general, might violate interface segregation principle

🧪 Testing Features
The implementation includes:

Error handling demonstrations

Iterator pattern usage

Complex financial calculations

JSON and CSV serialization

Factory method demonstrations

📚 Related Patterns
Decorator: Both use recursive composition but for different purposes

Iterator: Used to traverse composite structures

Visitor: Can be used to apply operations to composite structures

Flyweight: Can be combined to share leaf nodes

🛠️ Technical Details
Financial Precision: Uses BigDecimal with RoundingMode.HALF_UP

Thread Safety: Not thread-safe in current implementation

Memory Management: No special considerations needed

Performance: O(n) for operations that traverse the hierarchy

🤝 Contributing
Feel free to:

Fork the repository

Create a feature branch

Make your improvements

Submit a pull request

📄 License
This project is for educational purposes and can be used freely for learning about design patterns.

🙏 Acknowledgments
Gang of Four for the original Composite pattern

Java platform for robust type system and collections

The software design community for continuous improvement

Happy coding! May your designs be elegant and your hierarchies well-structured! 🚀

text

**Вот и весь файл.** Просто скопируйте от `# Composite Pattern Implementation in Java` до конца. Больше ничего не нужно.