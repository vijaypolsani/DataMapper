package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ThermosepianPump_Factory implements Factory<ThermosepianPump> {
  private final Provider<Heater> heaterProvider;

  public ThermosepianPump_Factory(Provider<Heater> heaterProvider) {  
    assert heaterProvider != null;
    this.heaterProvider = heaterProvider;
  }

  @Override
  public ThermosepianPump get() {  
    return new ThermosepianPump(heaterProvider.get());
  }

  public static Factory<ThermosepianPump> create(Provider<Heater> heaterProvider) {  
    return new ThermosepianPump_Factory(heaterProvider);
  }
}

