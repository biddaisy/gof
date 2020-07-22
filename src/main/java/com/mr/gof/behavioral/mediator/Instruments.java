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

  private List<Instrument> instruments;

  {
    instruments = new ArrayList<>();

    instruments.add(new Instrument(FIRST_NATIONAL_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instruments.add(new Instrument(FIRST_NATIONAL_BANK, Arrays.asList(BYN), BELARUS, URGENT));
    instruments.add(new Instrument(FIRST_NATIONAL_BANK, Arrays.asList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instruments.add(new Instrument(NON_STANDARD_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instruments.add(new Instrument(NON_STANDARD_BANK, Arrays.asList(BYN), BELARUS, URGENT));
    instruments.add(new Instrument(NON_STANDARD_BANK, Arrays.asList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instruments.add(new Instrument(CROCODILE_BANK, Arrays.asList(USD, EUR, ZAR, BYN), USA, NORMAL));
    instruments.add(new Instrument(CROCODILE_BANK, Arrays.asList(BYN), BELARUS, URGENT));
    instruments.add(new Instrument(CROCODILE_BANK, Arrays.asList(ZAR), SOUTH_AFRICA, ULTIMATE));

    instruments = Collections.unmodifiableList(instruments);
  }

  public List<Instrument> getInstruments() {
    return instruments;
  }
}
