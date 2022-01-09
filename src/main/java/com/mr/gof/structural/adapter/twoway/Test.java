package com.mr.gof.structural.adapter.twoway;

public class Test {

    public static void main(String... args){
        IntSet intSet = new IntSetImpl();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.remove(3);
        System.out.println("intSet (1,2,4,5): %s");
        intSet.iterator().forEachRemaining(Test::printI);
        System.out.println();
        System.out.printf("intSet has 3: %s%n", intSet.member(3));
        System.out.printf("intSet has 4: %s%n", intSet.member(4));

        IntRange intRange = new IntRangeImpl(intSet);
        System.out.println("intRange (1,2,4,5):");
        intRange.asList().forEach(Test::printI);
        IntRange intRange2 = new IntRangeImpl(1,2);
        intRange.differenceFrom(intRange2);
        System.out.println("intRange (4,5):");
        intRange.asList().forEach(Test::printI);
        IntRange intRange3 = new IntRangeImpl(-1,-2);
        intRange.unionWith(intRange3);
        System.out.println("intRange (-1,-2,4,5):");
        intRange.asList().forEach(Test::printI);
        System.out.println();
        System.out.printf("%s contains %s : %s%n", intRange, intRange3, intRange.isSupersetOf(intRange3));
        System.out.printf("%s contains %s : %s%n", intRange, intRange2, intRange.isSupersetOf(intRange2));

        IntSetRangeImpl intSetRangeImpl = new IntSetRangeImpl(intRange);
        System.out.printf("intSetRangeImpl:%s%n", intSetRangeImpl);
        System.out.printf("intRange:%s%n", intSetRangeImpl);
        intSetRangeImpl.add(0);
        System.out.printf("intSetRangeImpl + 0:%s%n", intSetRangeImpl);
        intSetRangeImpl.remove(5);
        System.out.printf("intSetRangeImpl + 0 -5:%s%n", intSetRangeImpl);
        intSetRangeImpl.unionWith(intRange2);
        System.out.printf("intSetRangeImpl + 1 +2:%s%n", intSetRangeImpl);
    }

    private static void printI(int i) {
        System.out.printf("i=%d ", i);
    }
}
