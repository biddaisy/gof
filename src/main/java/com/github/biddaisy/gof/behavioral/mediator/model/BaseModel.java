package com.github.biddaisy.gof.behavioral.mediator.model;

import com.github.biddaisy.gof.behavioral.mediator.InstrumentResolver;

public class BaseModel {

  private InstrumentResolver instrumentResolver;
  private boolean disabled = true;

  public void changed() {
    if (disabled){
      throw new IllegalStateException("model disabled");
    }
    instrumentResolver.modelChanged(this);
  }

  public void setInstrumentResolver(InstrumentResolver instrumentResolver) {
    this.instrumentResolver = instrumentResolver;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
}
