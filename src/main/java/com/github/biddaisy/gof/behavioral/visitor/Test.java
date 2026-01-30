package com.github.biddaisy.gof.behavioral.visitor;

import com.github.biddaisy.gof.Logger;

public class Test {

  public static void main(String[] args) {

    Company company = new Company();
    company.initialize();

    IncomeVisitor incomeVisitor = new IncomeVisitor();
    company.getSuperBoss().accept(incomeVisitor);
    Logger.log("super boss income = " + incomeVisitor.getSuperBossIncome());
    Logger.log("bosses income = " + incomeVisitor.getBossIncome());
    Logger.log("employees income = " + incomeVisitor.getEmployeeIncome());
    Logger.log("total income = " + incomeVisitor.getTotalIncome());

    PersonnelVisitor personnelVisitor = new PersonnelVisitor();
    company.getSuperBoss().accept(personnelVisitor);
    Logger.log("super boss amount : " + personnelVisitor.getSuperBossAmount());
    Logger.log("bosses amount : " + personnelVisitor.getBossAmount());
    Logger.log("employees amount : " + personnelVisitor.getEmployeeAmount());
    Logger.log("total personnel amount : " + personnelVisitor.getPersonnelAmount());
    Logger.log("personnel " + personnelVisitor.getPersonnel());
  }

}
