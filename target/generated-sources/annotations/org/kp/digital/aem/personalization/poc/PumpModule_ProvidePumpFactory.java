package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PumpModule_ProvidePumpFactory implements Factory<Pump> {
  private final PumpModule module;
  private final Provider<ThermosepianPump> pumpProvider;

  public PumpModule_ProvidePumpFactory(PumpModule module, Provider<ThermosepianPump> pumpProvider) {  
    assert module != null;
    this.module = module;
    assert pumpProvider != null;
    this.pumpProvider = pumpProvider;
  }

  @Override
  public Pump get() {  
    Pump provided = module.providePump(pumpProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Pump> create(PumpModule module, Provider<ThermosepianPump> pumpProvider) {  
    return new PumpModule_ProvidePumpFactory(module, pumpProvider);
  }
}

