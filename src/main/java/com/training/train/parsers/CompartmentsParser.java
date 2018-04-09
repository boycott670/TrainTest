package com.training.train.parsers;

import java.util.List;

import com.training.train.entities.Compartment;
import com.training.train.factories.CompartmentsFactory;

public interface CompartmentsParser
{
  List<Compartment> parse (final CompartmentsFactory factory, final String compartments);
}
