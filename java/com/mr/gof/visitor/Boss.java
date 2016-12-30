package com.mr.gof.visitor;

import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Boss extends ParentNode {

    private int salary;
    private int annualBonus;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(int annualBonus) {
        this.annualBonus = annualBonus;
    }

    public void accept (Visitor visitor){
        visitor.visit(this);
        List<Node> children = getChildren();
        for (Node child : children){
            child.accept(visitor);
        }
    }
}
