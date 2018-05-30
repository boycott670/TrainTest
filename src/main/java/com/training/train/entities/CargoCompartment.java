package com.training.train.entities;

public final class CargoCompartment extends Compartment
{
  private boolean filled = false;
  
  public CargoCompartment(boolean tail)
  {
    super(tail);
    // TODO Auto-generated constructor stub
  }

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
