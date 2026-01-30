package com.mr.gof.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 1/6/2017.
 */
public class PersonnelVisitor implements Visitor {

  private int employeeAmount;

  private int bossAmount;

  private int superBossAmount;

  private List<String> personnel = new ArrayList<>();

  @Override
  public void visit(Employee employee) {
    employeeAmount++;
    personnel.add("Employee: " + employee.getName());
  }

  @Override
  public void visit(Boss boss) {
    bossAmount++;
    personnel.add("Boss: " + boss.getName());
  }

  @Override
  public void visit(SuperBoss superBoss) {
    superBossAmount++;
    personnel.add("Super Boss: " + superBoss.getName());
  }

  public int getEmployeeAmount() {
    return employeeAmount;
  }

  public int getBossAmount() {
    return bossAmount;
  }

  public int getSuperBossAmount() {
    return superBossAmount;
  }

  public int getPersonnelAmount() {
    return employeeAmount + bossAmount + superBossAmount;
  }

  public String getPersonnel() {
    return personnel.toString();
  }
}
