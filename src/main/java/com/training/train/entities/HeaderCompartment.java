package com.training.train.entities;

public final class HeaderCompartment extends Compartment
{
  
  

  public HeaderCompartment(boolean tail)
  {
    super(tail);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String print()
  {
    // TODO Auto-generated method stub
    return tail ? "HHHH>" : "<HHHH";
  }

  @Override
  public boolean fill()
  {
    // TODO Auto-generated method stub
    return false;
  }
  
  

}
