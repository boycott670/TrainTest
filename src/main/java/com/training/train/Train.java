package com.training.train;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Train
{
  private static final Compartment RESTAURANT = new Compartment()
  {
    @Override
    String print()
    {
      return "|hThT|";
    }
  };
  
  private static final Compartment PASSENGER = new Compartment()
  {
    @Override
    String print()
    {
      return "|OOOO|";
    }
  };
  
  private static final Map<Character, Supplier<? extends Compartment>> COMPARTMENTS_MAPPING = new HashMap<Character, Supplier<? extends Compartment>>()
  {
    private static final long serialVersionUID = -3747475221358822772L;
    
    {
      put('H', HeadCompartment::new);
      
      put('P', () -> PASSENGER);
      
      put('R', () -> RESTAURANT);
      
      put('C', CargoCompartment::new);
    }
  };

  private final Deque<Compartment> compartments;
  
  public Train(final CharSequence compartments)
  {
    this.compartments = IntStream.range(0, compartments.length())
        .mapToObj(compartments::charAt)
        .map(COMPARTMENTS_MAPPING::get)
        .map(Supplier::get)
        .collect(Collectors.toCollection(ArrayDeque::new));
    
    this.compartments.peekLast().setAsTail();
  }
  
  public String print()
  {
    return compartments.stream()
        .map(Compartment::print)
        .collect(Collectors.joining("::"));
  }
  
  public boolean fill()
  {
    return compartments.stream()
        .filter(CargoCompartment.class::isInstance)
        .map(CargoCompartment.class::cast)
        .filter(CargoCompartment::fill)
        .findFirst()
        .isPresent();
  }
  
  public void detachHead()
  {
    compartments.removeFirst();
  }
  
  public void detachEnd()
  {
    compartments.removeLast();
  }
}
