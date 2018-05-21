package com.training.train;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

final class Train
{
  private static final Compartment HEADER = new Compartment()
  {
    @Override
    String print()
    {
      return "<HHHH";
    }
  };
  
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
  
  private static final Map<Character, Supplier<Compartment>> COMPARTMENTS_MAPPING = new HashMap<Character, Supplier<Compartment>>()
  {
    private static final long serialVersionUID = -3747475221358822772L;
    
    {
      put('H', () -> HEADER);
      
      put('P', () -> PASSENGER);
      
      put('R', () -> RESTAURANT);
      
      put('C', CargoCompartment::new);
    }
  };

  private final List<Compartment> compartments;
  private int currentIndex;
  
  Train(final String compartments)
  {
    this.compartments = compartments.chars()
        .mapToObj(value -> (char)value)
        .map(COMPARTMENTS_MAPPING::get)
        .map(Supplier::get)
        .collect(Collectors.toList());
    
    currentIndex = 0;
  }
  
  String print()
  {
    return compartments.stream()
        .map(Compartment::print)
        .collect(Collectors.joining("::"));
  }
  
  boolean fill()
  {
    final int previousCurrentIndex = currentIndex;
    
    compartments.subList(currentIndex, compartments.size()).stream()
        .filter(CargoCompartment.class::isInstance)
        .findFirst()
        .ifPresent(cargo ->
        {
          currentIndex = compartments.indexOf(cargo);
          ((CargoCompartment) compartments.get(currentIndex++)).fill();
        });
    
    return previousCurrentIndex != currentIndex;
  }
}
