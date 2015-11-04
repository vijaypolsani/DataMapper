package org.kp.digital.aem.personalization.poc;

import dagger.internal.DoubleCheckLazy;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class CoffeeMaker_Factory implements Factory<CoffeeMaker> {
  private final Provider<Heater> heaterProvider;
  private final Provider<Pump> pumpProvider;

  public CoffeeMaker_Factory(Provider<Heater> heaterProvider, Provider<Pump> pumpProvider) {  
    assert heaterProvider != null;
    this.heaterProvider = heaterProvider;
    assert pumpProvider != null;
    this.pumpProvider = pumpProvider;
  }

  @Override
  public CoffeeMaker get() {  
    return new CoffeeMaker(DoubleCheckLazy.create(heaterProvider), pumpProvider.get());
  }

  public static Factory<CoffeeMaker> create(Provider<Heater> heaterProvider, Provider<Pump> pumpProvider) {  
    return new CoffeeMaker_Factory(heaterProvider, pumpProvider);
  }
}

