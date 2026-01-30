package com.github.biddaisy.gof.behavioral.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Company {

  private SuperBoss superBoss;

  public void initialize() {
    superBoss = createSuperBoss();
    Boss boss1 = createBoss("Boss1", 700, 1400);
    Boss boss2 = createBoss("Boss2", 500, 1000);
    Employee employee1 = createEmployee("Employee1", 300, 100);
    Employee employee2 = createEmployee("Employee2", 200, 50);
    Employee employee3 = createEmployee("Employee3", 100, 25);
    Employee employee4 = createEmployee("Employee4", 50, 10);
    superBoss.addEmployee(boss1);
    superBoss.addEmployee(boss2);
    boss1.addEmployee(employee1);
    boss1.addEmployee(employee2);
    boss2.addEmployee(employee3);
    boss2.addEmployee(employee4);
  }

  public SuperBoss getSuperBoss() {
    return superBoss;
  }

  private SuperBoss createSuperBoss() {
    SuperBoss boss = new SuperBoss();
    boss.setName("SuperBoss");
    boss.setSalary(1000);
    boss.setAnnualBonus(2000);
    boss.setOptionBonus(10000);
    return boss;
  }

  private Boss createBoss(String name, int salary, int annualBonus) {
    Boss boss = new Boss();
    boss.setName(name);
    boss.setSalary(salary);
    boss.setAnnualBonus(annualBonus);
    return boss;
  }

  private Employee createEmployee(String name, int salary, int incentiveBonus) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setSalary(salary);
    employee.setIncentiveBonus(incentiveBonus);
    return employee;
  }

}
