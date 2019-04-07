package com.mr.gof.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryModel {
    private Beneficiary selectedBeneficiary;
    private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

    public Beneficiary getSelectedBeneficiary() {
        return selectedBeneficiary;
    }

    public void setSelectedBeneficiary(Beneficiary selectedBeneficiary) {
        this.selectedBeneficiary = selectedBeneficiary;
    }

    public List<Beneficiary> getBeneficiaries() {
        return new ArrayList<Beneficiary>(beneficiaries);
    }
}
