package com.training.train.parsers;

import java.util.List;
import java.util.stream.Collectors;

import com.training.train.entities.Compartment;
import com.training.train.factories.CompartmentsFactory;

public final class DefaultCompartmentsParser implements CompartmentsParser
{

  @Override
  public List<Compartment> parse(CompartmentsFactory factory, String compartments)
  {
    return compartments.chars()
        .mapToObj(code -> (char)code)
        .map(factory::getCompartment)
        .collect(Collectors.toList());
  }

}
