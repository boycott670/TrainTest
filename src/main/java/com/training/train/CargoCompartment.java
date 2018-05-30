package com.training.train;

final class CargoCompartment extends Compartment
{

  private boolean isFilled = false;

  @Override
  String print()
  {
    return String.format("|%s|", isFilled ? "^^^^" : "____");
  }

  boolean fill()
  {
    return !isFilled ? isFilled = true : false;
  }

}
