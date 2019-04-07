package com.mr.gof.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ServiceLevelModel {
    private ServiceLevel selectedServiceLevel;
    private List<ServiceLevel> serviceLevels = new ArrayList<ServiceLevel>();

    public ServiceLevel getSelectedServiceLevel() {
        return selectedServiceLevel;
    }

    public void setSelectedServiceLevel(ServiceLevel selectedServiceLevel) {
        this.selectedServiceLevel = selectedServiceLevel;
    }

    public List<ServiceLevel> getServiceLevels() {
        return new ArrayList<ServiceLevel>(serviceLevels);
    }
}
