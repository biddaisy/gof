package com.mr.gof.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Company extends NodeTree{

    public void initialize(){
        SuperBoss superBoss = createSuperBoss();
        Boss boss1 = createBoss("Boss1", 700, 1400);
        Boss boss2 = createBoss("Boss2", 500, 1000);
        Employee employee1 = createEmployee("Employee1", 300, 100);
        Employee employee2 = createEmployee("Employee2", 200, 50);
        Employee employee3 = createEmployee("Employee3", 100, 25);
        Employee employee4 = createEmployee("Employee4", 50, 10);
        setRootNode(superBoss);
        superBoss.addChild(boss1);
        superBoss.addChild(boss2);
        boss1.addChild(employee1);
        boss1.addChild(employee2);
        boss2.addChild(employee3);
        boss2.addChild(employee4);
    }

    private SuperBoss createSuperBoss() {
        SuperBoss superBoss = new SuperBoss();
        superBoss.setName("SuperBoss");
        superBoss.setSalary(1000);
        superBoss.setAnnualBonus(2000);
        superBoss.setOptionBonus(10000);
        return superBoss;
    }

    private Boss createBoss(String name, int salary, int annualBonus){
        Boss superBoss = new Boss();
        superBoss.setName(name);
        superBoss.setSalary(salary);
        superBoss.setAnnualBonus(annualBonus);
        return superBoss;
    }

    private Employee createEmployee(String name, int salary, int incentiveBonus){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setIncentiveBonus(incentiveBonus);
        return employee;
    }

    public static void main(String[] args){
        Company company = new Company();
        IncomeVisitor incomeVisitor = new IncomeVisitor();
        company.initialize();
        company.traverse(incomeVisitor);
        System.out.println("super boss income = " + incomeVisitor.getSuperBossIncome());
        System.out.println("bosses income = " + incomeVisitor.getBossIncome());
        System.out.println("employees income = " + incomeVisitor.getEmployeeIncome());
        System.out.println("total income = " + incomeVisitor.getTotalIncome());
    }

}
