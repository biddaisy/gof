package com.github.biddaisy.gof.behavioral.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Employee {

  private String name;

  private int salary;

  private int incentiveBonus;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

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

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
