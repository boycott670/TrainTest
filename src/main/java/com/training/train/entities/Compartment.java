package com.training.train.entities;

public abstract class Compartment
{
  final boolean tail;
  
  Compartment(final boolean tail)
  {
    this.tail = tail;
  }
  
  public abstract String print();
  public abstract boolean fill();
}
