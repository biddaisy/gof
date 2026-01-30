package com.github.biddaisy.gof.behavioral.mediator.model;

import java.util.ArrayList;
import java.util.List;

import com.github.biddaisy.gof.behavioral.mediator.ServiceLevel;

public class ServiceLevelModel extends BaseModel {
  private ServiceLevel selectedServiceLevel;

  private List<ServiceLevel> serviceLevels = new ArrayList<ServiceLevel>();

  public ServiceLevel getSelectedServiceLevel() {
    return selectedServiceLevel;
  }

  public void setSelectedServiceLevel(ServiceLevel selectedServiceLevel) {
    this.selectedServiceLevel = selectedServiceLevel;
    changed();
  }

  public List<ServiceLevel> getServiceLevels() {
    return new ArrayList<>(serviceLevels);
  }

  public void setServiceLevels(List<ServiceLevel> serviceLevels) {
    this.serviceLevels = serviceLevels;
  }
}
