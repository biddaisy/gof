package com.mr.gof.behavioral.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class IncomeVisitor implements Visitor {

  private int superBossIncome;

  private int bossIncome;

  private int employeeIncome;

  @Override
  public void visit(Employee employee) {
    employeeIncome += employee.getSalary() + employee.getIncentiveBonus();
    System.out.println("IncomeVisitor.visit Employee " + employee.getName());
  }

  @Override
  public void visit(Boss boss) {
    bossIncome += boss.getSalary() + boss.getAnnualBonus();
    System.out.println("IncomeVisitor.visit Boss " + boss.getName());
  }

  @Override
  public void visit(SuperBoss superBoss) {
    superBossIncome += superBoss.getSalary() + superBoss.getAnnualBonus() + superBoss.getOptionBonus();
    System.out.println("IncomeVisitor.visit SuperBoss " + superBoss.getName());
  }

  public int getTotalIncome() {
    return superBossIncome + bossIncome + employeeIncome;
  }

  public int getSuperBossIncome() {
    return superBossIncome;
  }

  public int getBossIncome() {
    return bossIncome;
  }

  public int getEmployeeIncome() {
    return employeeIncome;
  }

}
