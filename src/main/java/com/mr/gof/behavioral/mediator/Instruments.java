package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Bank.*;
import static com.mr.gof.behavioral.mediator.Country.*;
import static com.mr.gof.behavioral.mediator.Currency.*;
import static com.mr.gof.behavioral.mediator.ServiceLevel.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Instruments {

  private List<Instrument> instrumentList;

  {
    instrumentList = new ArrayList<>();

    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList.add(new Instrument(NON_STANDARD_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(NON_STANDARD_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(NON_STANDARD_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList.add(new Instrument(CROCODILE_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(CROCODILE_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(CROCODILE_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList = Collections.unmodifiableList(instrumentList);
  }

  public List<Instrument> getInstrumentList() {
    return instrumentList;
  }

  public List<Currency> getTransferCurrencies(Bank bank) {
    return instrumentList.stream().filter(i -> i.getBank() == bank).map(Instrument::getTransferCurrencies)
        .reduce((tc1, tc2) -> Stream.of(tc1, tc2).flatMap(Collection::stream).collect(Collectors.toList())).orElse(Collections.emptyList());
  }

  public List<Country> getBeneficiaryCountries(Bank bank, Currency currency) {
    return instrumentList.stream().filter(i -> i.getBank() == bank && i.getTransferCurrencies().contains(currency)).map(Instrument::getBeneficiaryCountry)
        .collect(Collectors.toList());
  }

  public List<ServiceLevel> getServiceLevels(Bank bank, Currency transferCurrency, Country beneficiaryCountry) {
    return instrumentList.stream()
        .filter(i -> i.getBank() == bank && i.getTransferCurrencies().contains(transferCurrency) && i.getBeneficiaryCountry() == beneficiaryCountry)
        .map(Instrument::getServiceLevel).collect(Collectors.toList());
  }

}
