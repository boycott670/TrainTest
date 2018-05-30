package com.training.train;

import java.util.function.Function;

final class HeadCompartment extends Compartment
{
  private boolean asTail = false;

  @Override
  String print()
  {
    Function<Boolean, String> printer = inFront -> asTail ? (inFront ? "" : ">") : (inFront ? "<" : "");
    
    return String.format("%sHHHH%s", printer.apply(true), printer.apply(false));
  }

  @Override
  void setAsTail()
  {
    asTail = true;
  }
}
