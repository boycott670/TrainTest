package com.training.train;

import java.util.List;
import java.util.stream.Collectors;

import com.training.train.entities.Compartment;
import com.training.train.factories.CompartmentsFactory;
import com.training.train.factories.DefaultCompartmentsFactory;
import com.training.train.parsers.CompartmentsParser;
import com.training.train.parsers.DefaultCompartmentsParser;

public final class Train
{
   private final CompartmentsParser parser = new DefaultCompartmentsParser();
   private final CompartmentsFactory factory = new DefaultCompartmentsFactory();
   
   private final List<Compartment> compartments;
   private int currentCompartment = 0;
   
   public Train (final String compartments)
   {
     this.compartments = parser.parse(factory, compartments);
   }
   
   public String print ()
   {
     return compartments.stream()
       .map(Compartment::print)
       .collect(Collectors.joining("::"));
   }
   
   public boolean fill ()
   {
     if (currentCompartment == compartments.size())
     {
       return false;
     }
     
     while (!compartments.get(currentCompartment++).fill());
     
     return true;
   }
}
