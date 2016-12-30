package com.mr.gof.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class IncomeVisitor implements Visitor {

    private int superBossIncome;
    private int bossIncome;
    private int employeeIncome;

    @Override
    public void visit(Node node) {
        System.out.println("IncomeVisitor.visit Node");
    }

    @Override
    public void visit(Employee employee){
        employeeIncome += employee.getSalary() + employee.getIncentiveBonus();
        System.out.println("IncomeVisitor.visit Employee");
    }

    @Override
    public void visit(Boss boss){
        bossIncome += boss.getSalary() + boss.getAnnualBonus();
        System.out.println("IncomeVisitor.visit Boss");
    }

    @Override
    public void visit(SuperBoss superBoss){
        superBossIncome += superBoss.getSalary() + superBoss.getAnnualBonus() + superBoss.getOptionBonus();
        System.out.println("IncomeVisitor.visit SuperBoss");
    }

    public int getTotalIncome(){
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
