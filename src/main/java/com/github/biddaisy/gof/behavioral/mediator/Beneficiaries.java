package com.github.biddaisy.gof.behavioral.mediator;

import static com.github.biddaisy.gof.behavioral.mediator.Country.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Beneficiaries {

  public static final Beneficiaries INSTANCE = new Beneficiaries();

  private Beneficiaries() {
  }

  private List<Beneficiary> beneficiaryList = new ArrayList<>();

  {
    beneficiaryList.add(new Beneficiary("bene 1", USA));
    beneficiaryList.add(new Beneficiary("bene 2", USA));
    beneficiaryList.add(new Beneficiary("bene 3", USA));

    beneficiaryList.add(new Beneficiary("bene 4", BELARUS));
    beneficiaryList.add(new Beneficiary("bene 5", BELARUS));
    beneficiaryList.add(new Beneficiary("bene 6", BELARUS));

    beneficiaryList.add(new Beneficiary("bene 7", SOUTH_AFRICA));
    beneficiaryList.add(new Beneficiary("bene 8", SOUTH_AFRICA));
    beneficiaryList.add(new Beneficiary("bene 9", SOUTH_AFRICA));

    beneficiaryList = Collections.unmodifiableList(beneficiaryList);
  }

  public List<Beneficiary> getBeneficiaryListByCountries(List<Country> countries) {
    return beneficiaryList.stream().filter(b -> countries.contains(b.getCountry())).collect(Collectors.toList());
  }

  public List<Beneficiary> getBeneficiaryListByCountry(Country country) {
    return beneficiaryList.stream().filter(b -> country == b.getCountry()).collect(Collectors.toList());
  }
}
