package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Country.*;

import java.util.Collections;
import java.util.List;

public class Beneficiaries {

  private List<Beneficiary> beneficiaryList;

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

  public List<Beneficiary> getBeneficiaryList() {
    return beneficiaryList;
  }
}
