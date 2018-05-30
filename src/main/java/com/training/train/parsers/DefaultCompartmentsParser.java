package com.training.train.parsers;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.stream.IntStream;

import com.training.train.entities.Compartment;
import com.training.train.factories.CompartmentsFactory;

public final class DefaultCompartmentsParser implements CompartmentsParser
{

  @Override
  public Compartment[] parse(CompartmentsFactory factory, CharSequence compartments)
  {
    return IntStream.range(0, compartments.length())
        .mapToObj(index -> new SimpleImmutableEntry<>(compartments.charAt(index), index == compartments.length() - 1))
        .map(pair -> factory.getCompartment(pair.getKey(), pair.getValue()))
        .toArray(Compartment[]::new);
  }

}
