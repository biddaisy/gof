package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.ServiceLevel;

import java.util.ArrayList;
import java.util.List;

public class ServiceLevelModel extends BaseModel{
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
}
