package org.kp.digital.aem.personalization.poc;

import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.kp.digital.aem.personalization.poc.CoffeeApp.Coffee;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerCoffeeApp_Coffee implements Coffee {
  private Provider<Heater> provideHeaterProvider;
  private Provider<ThermosepianPump> thermosepianPumpProvider;
  private Provider<Pump> providePumpProvider;
  private Provider<CoffeeMaker> coffeeMakerProvider;

  private DaggerCoffeeApp_Coffee(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static Coffee create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.provideHeaterProvider = ScopedProvider.create(DripCofeeModule_ProvideHeaterFactory.create(builder.dripCofeeModule));
    this.thermosepianPumpProvider = ThermosepianPump_Factory.create(provideHeaterProvider);
    this.providePumpProvider = PumpModule_ProvidePumpFactory.create(builder.pumpModule, thermosepianPumpProvider);
    this.coffeeMakerProvider = CoffeeMaker_Factory.create(provideHeaterProvider, providePumpProvider);
  }

  @Override
  public CoffeeMaker maker() {  
    return coffeeMakerProvider.get();
  }

  public static final class Builder {
    private DripCofeeModule dripCofeeModule;
    private PumpModule pumpModule;
  
    private Builder() {  
    }
  
    public Coffee build() {  
      if (dripCofeeModule == null) {
        this.dripCofeeModule = new DripCofeeModule();
      }
      if (pumpModule == null) {
        this.pumpModule = new PumpModule();
      }
      return new DaggerCoffeeApp_Coffee(this);
    }
  
    public Builder dripCofeeModule(DripCofeeModule dripCofeeModule) {  
      if (dripCofeeModule == null) {
        throw new NullPointerException("dripCofeeModule");
      }
      this.dripCofeeModule = dripCofeeModule;
      return this;
    }
  
    public Builder pumpModule(PumpModule pumpModule) {  
      if (pumpModule == null) {
        throw new NullPointerException("pumpModule");
      }
      this.pumpModule = pumpModule;
      return this;
    }
  }
}

