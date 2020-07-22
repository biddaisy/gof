package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Country.*;

import java.util.Collections;
import java.util.List;

public class Beneficiaries {

  private List<Beneficiary> beneficiaries;

  {
    beneficiaries.add(new Beneficiary("bene 1", USA));
    beneficiaries.add(new Beneficiary("bene 2", USA));
    beneficiaries.add(new Beneficiary("bene 3", USA));

    beneficiaries.add(new Beneficiary("bene 4", BELARUS));
    beneficiaries.add(new Beneficiary("bene 5", BELARUS));
    beneficiaries.add(new Beneficiary("bene 6", BELARUS));

    beneficiaries.add(new Beneficiary("bene 7", SOUTH_AFRICA));
    beneficiaries.add(new Beneficiary("bene 8", SOUTH_AFRICA));
    beneficiaries.add(new Beneficiary("bene 9", SOUTH_AFRICA));

    beneficiaries = Collections.unmodifiableList(beneficiaries);
  }

  public List<Beneficiary> getBeneficiaries() {
    return beneficiaries;
  }
}
