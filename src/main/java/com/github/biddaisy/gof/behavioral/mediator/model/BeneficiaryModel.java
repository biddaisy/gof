package com.github.biddaisy.gof.behavioral.mediator.model;

import java.util.ArrayList;
import java.util.List;

import com.github.biddaisy.gof.behavioral.mediator.Beneficiary;

public class BeneficiaryModel extends BaseModel {
  private Beneficiary selectedBeneficiary;

  private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

  public Beneficiary getSelectedBeneficiary() {
    return selectedBeneficiary;
  }

  public void setSelectedBeneficiary(Beneficiary selectedBeneficiary) {
    this.selectedBeneficiary = selectedBeneficiary;
    changed();
  }

  public List<Beneficiary> getBeneficiaries() {
    return new ArrayList<>(beneficiaries);
  }

  public void setBeneficiaries(List<Beneficiary> beneficiaries) {
    this.beneficiaries = beneficiaries;
  }
}
