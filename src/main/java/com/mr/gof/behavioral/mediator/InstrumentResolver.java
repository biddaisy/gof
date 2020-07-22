package com.mr.gof.behavioral.mediator;

import com.mr.gof.behavioral.mediator.model.BaseModel;
import com.mr.gof.behavioral.mediator.model.ModelComposer;

public class InstrumentResolver {

  private final ModelComposer modelComposer = new ModelComposer();

  private final Instruments instruments = new Instruments();

  public InstrumentResolver() {
    modelComposer.init(this);
  }

  public ModelComposer getModelComposer() {
    return modelComposer;
  }

  public void modelChanged(BaseModel baseModel){

  }
}
