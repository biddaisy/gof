package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import static com.github.biddaisy.gof.Logger.*;

/**
 * Demonstration class for the Composite Pattern implementation.
 * This class showcases the use of the Composite pattern for computer equipment
 * with BigDecimal for precise financial calculations and a custom logger
 */
public class Test {

    /**
     * Main method - entry point for the demonstration.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        log("=== Computer Assembly using Composite Pattern ===");
        log("Using BigDecimal for precise financial calculations");

        // Create computer components
        Cabinet cabinet = new Cabinet("PC Cabinet");
        Chassis chassis = new Chassis("PC Chassis");

        cabinet.add(chassis);

        Bus bus = new Bus("MCA Bus");
        bus.add(new Card("16Mbs Token Ring Card"));
        bus.add(new Card("10/100 Ethernet Card"));

        chassis.add(bus);
        chassis.add(new FloppyDisk("3.5in Floppy Disk"));
        chassis.add(new FloppyDisk("5.25in Floppy Disk"));

        // Add additional components for demonstration
        bus.add(new Card("Sound Card"));
        cabinet.add(new Card("USB Controller Card"));

        // Display component information
        log("\nComputer Configuration:");
        printEquipment(cabinet, 0);

        log("\n=== Price and Power Calculations ===");
        BigDecimal netPrice = cabinet.netPrice();
        BigDecimal discountPrice = cabinet.discountPrice();
        BigDecimal savings = netPrice.subtract(discountPrice);

        log("Total Net Price: {0}", MoneyUtils.formatCurrency(netPrice));
        log("Discounted Price: {0}", MoneyUtils.formatCurrency(discountPrice));
        log("Total Savings: {0}", MoneyUtils.formatCurrency(savings));
        log("Total Power Consumption: {0} Watts", cabinet.getPower().toPlainString());

        log("\n=== Detailed Component Information ===");
        log("Cabinet ({0}):", cabinet.getName());
        log("  - Price: {0} (discounted: {1})",
                MoneyUtils.formatCurrency(cabinet.netPrice()),
                MoneyUtils.formatCurrency(cabinet.discountPrice()));
        log("  - Power: {0} Watts", cabinet.getPower().toPlainString());

        log("\nChassis ({0}):", chassis.getName());
        log("  - Price: {0} (discounted: {1})",
                MoneyUtils.formatCurrency(chassis.netPrice()),
                MoneyUtils.formatCurrency(chassis.discountPrice()));
        log("  - Power: {0} Watts", chassis.getPower().toPlainString());

        log("\nBus ({0}):", bus.getName());
        log("  - Price: {0} (discounted: {1})",
                MoneyUtils.formatCurrency(bus.netPrice()),
                MoneyUtils.formatCurrency(bus.discountPrice()));
        log("  - Power: {0} Watts", bus.getPower().toPlainString());

        // Demonstrate error handling
        log("\n=== Error Handling Demonstration ===");
        testErrorHandling();

        // Demonstrate iterator functionality
        log("\n=== Structure Traversal using Iterator ===");
        Iterator<Equipment> iterator = cabinet.createIterator();
        int itemCount = 0;
        while (iterator.hasNext()) {
            Equipment eq = iterator.next();
            log("{0}. {1} (price: {2})",
                    ++itemCount, eq.getName(),
                    MoneyUtils.formatCurrency(eq.netPrice()));
        }

        // Additional example: complex calculations
        log("\n=== Additional Calculations ===");
        performComplexCalculations(cabinet);

        demonstrateFactoryMethods();

        demonstrateSerialization();

        log("\n=== Assembly completed successfully! ===");
    }

    /**
     * Recursively prints the equipment hierarchy structure.
     *
     * @param equipment the equipment to print (may be composite or leaf)
     * @param level the current nesting level for indentation
     */
    private static void printEquipment(Equipment equipment, int level) {
        String indent = "  ".repeat(level);
        log("{0}{1}", indent, equipment);

        // If this is composite equipment, recursively print its children
        if (equipment instanceof CompositeEquipment) {
            Iterator<Equipment> iterator = equipment.createIterator();
            while (iterator.hasNext()) {
                printEquipment(iterator.next(), level + 1);
            }
        }
    }

    /**
     * Demonstrates various error handling scenarios.
     */
    private static void testErrorHandling() {
        // Test 1: Attempt to add to a leaf component
        try {
            Equipment floppy = new FloppyDisk("Test Floppy");
            floppy.add(new Card("Should Fail"));
            log("Error: Operation should have thrown an exception");
        } catch (UnsupportedOperationException e) {
            log("✅ Correctly handled exception: {0}", e.getMessage());
        }

        // Test 4: Empty composite operations
        try {
            CompositeEquipment emptyComposite = new Chassis("Empty Chassis");
            log("Empty composite price: {0}",
                    MoneyUtils.formatCurrency(emptyComposite.netPrice()));
        } catch (Exception e) {
            error("Unexpected error with empty composite: {0}", e.getMessage());
        }
    }

    /**
     * Performs complex calculations on the equipment hierarchy.
     *
     * @param equipment the root equipment for calculations
     */
    private static void performComplexCalculations(Equipment equipment) {
        log("Performing complex calculations...");

        // Calculate average component price
        BigDecimal totalPrice = equipment.netPrice();
        int componentCount = countComponents(equipment);

        if (componentCount > 0) {
            BigDecimal averagePrice = totalPrice.divide(
                    new BigDecimal(componentCount), 2, RoundingMode.HALF_UP);
            log("Average component price: {0}",
                    MoneyUtils.formatCurrency(averagePrice));
        } else {
            warn("No components found for average calculation");
        }

        // Calculate efficiency (price per watt)
        BigDecimal power = equipment.getPower();
        if (power.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal efficiency = totalPrice.divide(power, 2, RoundingMode.HALF_UP);
            log("Efficiency (price per watt): {0} $/Watt", efficiency);
        } else {
            warn("Zero power consumption, cannot calculate efficiency");
        }

        // Calculate percentage savings
        BigDecimal discountPrice = equipment.discountPrice();
        if (totalPrice.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal savingsPercent = BigDecimal.ONE.subtract(
                            discountPrice.divide(totalPrice, 4, RoundingMode.HALF_UP))
                    .multiply(new BigDecimal("100"));
            log("Total discount: {0}%", savingsPercent.setScale(2, RoundingMode.HALF_UP));
        }

        // Log calculation completion with timestamp
        debug("Calculations completed. Time: {0}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    /**
     * Counts all components in the equipment hierarchy.
     *
     * @param equipment the root equipment to count from
     * @return total number of components (including composite and leaf)
     */
    private static int countComponents(Equipment equipment) {
        // Base case: leaf component
        if (!(equipment instanceof CompositeEquipment)) {
            return 1;
        }

        // Recursive case: composite component
        int count = 0;
        Iterator<Equipment> iterator = equipment.createIterator();
        while (iterator.hasNext()) {
            count += countComponents(iterator.next());
        }
        return count;
    }

    /**
     * Demonstrates the factory method pattern with equipment creation.
     */
    private static void demonstrateFactoryMethods() {
        log("\n=== Equipment Factory Demonstration ===");

        // Create equipment using different factory approaches
        Equipment[] equipmentList = {
                createStandardFloppy(),
                createPremiumCard(),
                createCustomChassis()
        };

        // Display created equipment
        for (int i = 0; i < equipmentList.length; i++) {
            Equipment eq = equipmentList[i];
            log("{0}. {1} - Price: {2}, Power: {3}W",
                    i + 1, eq.getName(),
                    MoneyUtils.formatCurrency(eq.netPrice()),
                    eq.getPower());
        }
    }

    /**
     * Creates a standard floppy disk equipment.
     *
     * @return a FloppyDisk instance
     */
    private static Equipment createStandardFloppy() {
        return new FloppyDisk("Standard 3.5\" Floppy Drive");
    }

    /**
     * Creates a premium graphics card equipment.
     *
     * @return a Card instance with premium pricing
     */
    private static Equipment createPremiumCard() {
        return new Card("Premium Graphics Card") {
            @Override
            public BigDecimal netPrice() {
                return new BigDecimal("499.99");
            }

            @Override
            public BigDecimal discountPrice() {
                return MoneyUtils.calculateDiscount(netPrice(), new BigDecimal("0.10"));
            }

            @Override
            public BigDecimal getPower() {
                return new BigDecimal("75.00");
            }
        };
    }

    /**
     * Creates a custom chassis with predefined components.
     *
     * @return a Chassis instance with pre-populated components
     */
    private static Equipment createCustomChassis() {
        Chassis chassis = new Chassis("Custom Gaming Chassis");

        // Add standard components
        chassis.add(new Card("NVIDIA Graphics Card"));
        chassis.add(new Card("Sound Card"));
        chassis.add(new FloppyDisk("Disk Drive"));

        // Add a custom component
        chassis.add(new Equipment("Custom Cooling System") {
            @Override
            public BigDecimal getPower() {
                return new BigDecimal("20.00");
            }

            @Override
            public BigDecimal netPrice() {
                return new BigDecimal("89.99");
            }

            @Override
            public BigDecimal discountPrice() {
                return new BigDecimal("79.99");
            }
        });

        return chassis;
    }

    /**
     * Demonstrates serialization of equipment data.
     */
    private static void demonstrateSerialization() {
        log("\n=== Equipment Data Serialization ===");

        // Create a simple equipment structure
        Chassis testChassis = new Chassis("Serialization Test");
        testChassis.add(new Card("Test Card"));
        testChassis.add(new FloppyDisk("Test Drive"));

        // Generate JSON-like representation
        String jsonRepresentation = generateEquipmentJSON(testChassis);
        log("JSON representation:");
        log(jsonRepresentation);

        // Generate CSV representation
        String csvRepresentation = generateEquipmentCSV(testChassis);
        log("\nCSV representation:");
        log(csvRepresentation);
    }

    /**
     * Generates a JSON-like string representation of equipment.
     *
     * @param equipment the equipment to serialize
     * @return JSON string representation
     */
    private static String generateEquipmentJSON(Equipment equipment) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"name\": \"").append(equipment.getName()).append("\",\n");
        json.append("  \"netPrice\": ").append(equipment.netPrice()).append(",\n");
        json.append("  \"discountPrice\": ").append(equipment.discountPrice()).append(",\n");
        json.append("  \"power\": ").append(equipment.getPower()).append(",\n");

        if (equipment instanceof CompositeEquipment) {
            json.append("  \"type\": \"composite\",\n");
            json.append("  \"children\": [\n");

            Iterator<Equipment> iterator = equipment.createIterator();
            boolean first = true;
            while (iterator.hasNext()) {
                if (!first) {
                    json.append(",\n");
                }
                json.append("    ").append(generateEquipmentJSON(iterator.next()).replace("\n", "\n    "));
                first = false;
            }
            json.append("\n  ]\n");
        } else {
            json.append("  \"type\": \"leaf\"\n");
        }

        json.append("}");
        return json.toString();
    }

    /**
     * Generates a CSV string representation of equipment.
     *
     * @param equipment the equipment to serialize
     * @return CSV string representation
     */
    private static String generateEquipmentCSV(Equipment equipment) {
        StringBuilder csv = new StringBuilder();
        csv.append("Name,Type,Net Price,Discount Price,Power\n");
        addEquipmentToCSV(equipment, csv, "");
        return csv.toString();
    }

    /**
     * Helper method to recursively add equipment to CSV.
     *
     * @param equipment the equipment to add
     * @param csv the CSV string builder
     * @param prefix prefix for nested components
     */
    private static void addEquipmentToCSV(Equipment equipment, StringBuilder csv, String prefix) {
        String type = (equipment instanceof CompositeEquipment) ? "Composite" : "Leaf";
        csv.append(prefix)
                .append(equipment.getName()).append(",")
                .append(type).append(",")
                .append(equipment.netPrice()).append(",")
                .append(equipment.discountPrice()).append(",")
                .append(equipment.getPower()).append("\n");

        if (equipment instanceof CompositeEquipment) {
            Iterator<Equipment> iterator = equipment.createIterator();
            while (iterator.hasNext()) {
                addEquipmentToCSV(iterator.next(), csv, prefix + "  ");
            }
        }
    }
}