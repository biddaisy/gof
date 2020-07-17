package com.mr.gof.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Boss extends Employee {

  private int annualBonus;

  private List<Employee> employees = new ArrayList<Employee>();

  public int getAnnualBonus() {
    return annualBonus;
  }

  public void setAnnualBonus(int annualBonus) {
    this.annualBonus = annualBonus;
  }

  @Override public void accept(Visitor visitor) {
    visitor.visit(this);
    acceptEmployees(visitor);
  }

  public void acceptEmployees(Visitor visitor) {
    for (Employee employee : employees) {
      employee.accept(visitor);
    }
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }
}
