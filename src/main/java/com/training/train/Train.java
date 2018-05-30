package com.training.train;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
   
   private final Deque<Compartment> compartments;
   
   public Train (final String compartments)
   {
     this.compartments = new ArrayDeque<>(Arrays.asList(parser.parse(factory, compartments)));
   }
   
   public String print ()
   {
     return compartments.stream()
       .map(Compartment::print)
       .collect(Collectors.joining("::"));
   }
   
   public boolean fill ()
   {
    return compartments.stream()
        .filter(Compartment::fill)
        .findFirst()
        .isPresent();
   }
   
   public void detachEnd()
   {
     compartments.removeLast();
   }
   
   public void detachHead()
   {
     compartments.removeFirst();
   }
}
