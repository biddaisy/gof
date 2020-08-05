package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Currency.ZAR;

import java.util.List;

public class Test {

  public static void main(String[] args) {
    InstrumentResolver instrumentResolver = new InstrumentResolver();
    Account account = Accounts.INSTANCE.getAccountList().get(1);
    instrumentResolver.getModelComposer().getOrderingAccountModel().setSelectedAccount(account);
    Account selectedAccount = instrumentResolver.getModelComposer().getOrderingAccountModel().getSelectedAccount();
    System.out.println("selected account : " + selectedAccount);

    List<Currency> transferCurrencies = instrumentResolver.getModelComposer().getTransferCurrencyModel().getCurrencies();
    transferCurrencies.forEach(tc -> System.out.println("transfer currency: " + tc));
    instrumentResolver.getModelComposer().getTransferCurrencyModel().setSelectedCurrency(ZAR);
    Currency selectedTransferCurrency = instrumentResolver.getModelComposer().getTransferCurrencyModel().getSelectedCurrency();
    System.out.println("selected currency : " + selectedTransferCurrency);

    List<Beneficiary> beneficiaries = instrumentResolver.getModelComposer().getBeneficiaryModel().getBeneficiaries();
    beneficiaries.forEach(b -> System.out.println("beneficiary: " + b));
    Beneficiary beneficiary = Beneficiaries.INSTANCE.getBeneficiaryListByCountry(beneficiaries.get(0).getCountry()).get(0);
    instrumentResolver.getModelComposer().getBeneficiaryModel().setSelectedBeneficiary(beneficiary);
    Beneficiary selectedBeneficiary = instrumentResolver.getModelComposer().getBeneficiaryModel().getSelectedBeneficiary();
    System.out.println("selected beneficiary : " + selectedBeneficiary);

    List<ServiceLevel> serviceLevels = instrumentResolver.getModelComposer().getServiceLevelModel().getServiceLevels();
    serviceLevels.forEach(sl -> System.out.println("service level: " + sl));

    instrumentResolver.getModelComposer().getServiceLevelModel().setSelectedServiceLevel(serviceLevels.get(0));

    ServiceLevel selectedServiceLevel = instrumentResolver.getModelComposer().getServiceLevelModel().getSelectedServiceLevel();

    System.out.println("selected service level: " + selectedServiceLevel);

    instrumentResolver.getSelectedInstruments().forEach(i->System.out.println("selected instrument: " + i));
  }
}
