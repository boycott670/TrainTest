package com.training.train.parsers;

import com.training.train.entities.Compartment;
import com.training.train.factories.CompartmentsFactory;

public interface CompartmentsParser
{
  Compartment[] parse (final CompartmentsFactory factory, final CharSequence compartments);
}
