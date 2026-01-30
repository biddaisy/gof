package com.github.biddaisy.gof.structural.adapter.twoway;

import com.github.biddaisy.gof.Logger;

public class Test {

    public static void main(String... args){
        IntSet intSet = new IntSetImpl();
        testIntSet(intSet);
        IntRange intRange = new IntRangeImpl(intSet);
        testIntRange(intRange);
        IntSetRangeImpl intSetRangeImpl = new IntSetRangeImpl(intRange);
        testIntSet(intSetRangeImpl);
        testIntRange(intSetRangeImpl);
        IntSetRange intSetRange = new IntSetRange();
        intSetRange.add(10);
        intSetRange.add(11);
        testIntSet(intSetRange);
        testIntRange(intSetRange);
    }

    private static void printI(int i) {
        System.out.printf("i=%d ", i);
    }

    private static void testIntSet(IntSet intSet){
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.remove(3);
        System.out.print("intSet: ");
        intSet.iterator().forEachRemaining(Test::printI);
        Logger.log("");
        System.out.printf("intSet %s has 3: %s%n", intSet, intSet.member(3));
        System.out.printf("intSet %s has 4: %s%n", intSet, intSet.member(4));

    }

    private static void testIntRange(IntRange intRange){
        System.out.print("intRange: ");
        intRange.asList().forEach(Test::printI);
        Logger.log("");
        IntRange intRange2 = new IntRangeImpl(1,2);
        intRange.differenceFrom(intRange2);
        System.out.print("intRange removed 1,2: ");
        intRange.asList().forEach(Test::printI);
        Logger.log("");
        IntRange intRange3 = new IntRangeImpl(-1,-2);
        intRange.unionWith(intRange3);
        System.out.print("intRange added -1,-2: ");
        intRange.asList().forEach(Test::printI);
        Logger.log("");
        System.out.printf("%s contains %s: %s%n", intRange, intRange3, intRange.isSupersetOf(intRange3));
        System.out.printf("%s contains %s: %s%n", intRange, intRange2, intRange.isSupersetOf(intRange2));
        intRange.unionWith(intRange2);
        System.out.printf("intSetRangeImpl added 1, 2: %s%n", intRange);
    }
}
