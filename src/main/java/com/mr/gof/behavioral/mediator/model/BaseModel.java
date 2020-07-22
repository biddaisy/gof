package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.InstrumentResolver;

public class BaseModel {

  private InstrumentResolver instrumentResolver;

  public void changed() {
    instrumentResolver.modelChanged(this);
  }

  public void setInstrumentResolver(InstrumentResolver instrumentResolver) {
    this.instrumentResolver = instrumentResolver;
  }
}
