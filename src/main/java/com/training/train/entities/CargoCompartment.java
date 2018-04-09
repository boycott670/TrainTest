package com.training.train.entities;

public final class CargoCompartment extends Compartment
{
  private boolean filled = false;
  
  @Override
  public String print()
  {
    // TODO Auto-generated method stub
    return filled ? "|^^^^|" : "|____|";
  }

  @Override
  public boolean fill()
  {
    return !filled ? filled = true : false;
  }

}
