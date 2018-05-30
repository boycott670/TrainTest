package com.training.train.entities;

public final class PassengerCompartment extends Compartment
{
  
  

  public PassengerCompartment(boolean tail)
  {
    super(tail);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String print()
  {
    // TODO Auto-generated method stub
    return "|OOOO|";
  }

  @Override
  public boolean fill()
  {
    // TODO Auto-generated method stub
    return false;
  }

}
