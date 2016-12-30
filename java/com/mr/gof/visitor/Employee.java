package com.mr.gof.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Employee extends Node {

    private int salary;
    private int incentiveBonus;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIncentiveBonus() {
        return incentiveBonus;
    }

    public void setIncentiveBonus(int incentiveBonus) {
        this.incentiveBonus = incentiveBonus;
    }

    public void accept (Visitor visitor){
        visitor.visit(this);
    }
}
