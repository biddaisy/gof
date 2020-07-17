package com.mr.gof.behavioral.visitor;

public class Test {

  public static void main(String[] args) {

    Company company = new Company();
    company.initialize();

    IncomeVisitor incomeVisitor = new IncomeVisitor();
    company.getSuperBoss().accept(incomeVisitor);
    System.out.println("super boss income = " + incomeVisitor.getSuperBossIncome());
    System.out.println("bosses income = " + incomeVisitor.getBossIncome());
    System.out.println("employees income = " + incomeVisitor.getEmployeeIncome());
    System.out.println("total income = " + incomeVisitor.getTotalIncome());

    PersonnelVisitor personnelVisitor = new PersonnelVisitor();
    company.getSuperBoss().accept(personnelVisitor);
    System.out.println("super boss amount : " + personnelVisitor.getSuperBossAmount());
    System.out.println("bosses amount : " + personnelVisitor.getBossAmount());
    System.out.println("employees amount : " + personnelVisitor.getEmployeeAmount());
    System.out.println("total personnel amount : " + personnelVisitor.getPersonnelAmount());
    System.out.println("personnel " + personnelVisitor.getPersonnel());
  }

}
