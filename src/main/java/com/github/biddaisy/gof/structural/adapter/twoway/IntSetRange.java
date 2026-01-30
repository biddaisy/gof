package com.github.biddaisy.gof.structural.adapter.twoway;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//class adapter
public class IntSetRange extends IntSetImpl implements IntRange {

  @Override
  public void unionWith(IntRange other) {
    other.asList().forEach(this::add);
  }

  @Override
  public void differenceFrom(IntRange other) {
    other.asList().forEach(this::remove);
  }

  @Override
  public boolean isSupersetOf(IntRange other) {
    for (int z : other.asList()) {
      if (!member(z))
        return false;
    }
    return true;
  }

  @Override
  public List<Integer> asList() {
      return StreamSupport.stream(spliterator(), false).collect(Collectors.toList());
  }
}
