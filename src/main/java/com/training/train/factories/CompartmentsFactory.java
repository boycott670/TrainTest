package com.training.train.factories;

import com.training.train.entities.Compartment;

public interface CompartmentsFactory
{
  Compartment getCompartment (final char compartment);
}
