package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Bank.*;
import static com.mr.gof.behavioral.mediator.Country.*;
import static com.mr.gof.behavioral.mediator.Currency.*;
import static com.mr.gof.behavioral.mediator.ServiceLevel.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Instruments {

  private List<Instrument> instrumentList;

  {
    instrumentList = new ArrayList<>();

    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(FIRST_NATIONAL_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList.add(new Instrument(NON_STANDARD_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(NON_STANDARD_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(NON_STANDARD_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList.add(new Instrument(CROCODILE_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instrumentList.add(new Instrument(CROCODILE_BANK, Collections.singletonList(BYN), BELARUS, URGENT));
    instrumentList.add(new Instrument(CROCODILE_BANK, Collections.singletonList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instrumentList = Collections.unmodifiableList(instrumentList);
  }

  public List<Instrument> getInstrumentList() {
    return instrumentList;
  }
}
