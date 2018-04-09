package com.training.train.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.training.train.entities.CargoCompartment;
import com.training.train.entities.Compartment;
import com.training.train.entities.HeaderCompartment;
import com.training.train.entities.PassengerCompartment;
import com.training.train.entities.RestaurantCompartment;

public final class DefaultCompartmentsFactory implements CompartmentsFactory
{

  @Override
  public Compartment getCompartment(char compartment)
  {
    final Map<? super Character, Supplier<? extends Compartment>> compartmentsSuppliers = new HashMap<>();
    
    compartmentsSuppliers.put('H', HeaderCompartment::new);
    compartmentsSuppliers.put('P', PassengerCompartment::new);
    compartmentsSuppliers.put('R', RestaurantCompartment::new);
    compartmentsSuppliers.put('C', CargoCompartment::new);
    
    return Optional.ofNullable(compartmentsSuppliers.get(compartment))
        .orElseThrow(IllegalArgumentException::new)
        .get();
  }

}
