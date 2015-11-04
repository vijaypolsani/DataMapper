package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DripCofeeModule_ProvideHeaterFactory implements Factory<Heater> {
  private final DripCofeeModule module;

  public DripCofeeModule_ProvideHeaterFactory(DripCofeeModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Heater get() {  
    Heater provided = module.provideHeater();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Heater> create(DripCofeeModule module) {  
    return new DripCofeeModule_ProvideHeaterFactory(module);
  }
}

