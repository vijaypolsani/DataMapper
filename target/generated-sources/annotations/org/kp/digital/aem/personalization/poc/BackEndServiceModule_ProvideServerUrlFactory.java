package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BackEndServiceModule_ProvideServerUrlFactory implements Factory<String> {
  private final BackEndServiceModule module;

  public BackEndServiceModule_ProvideServerUrlFactory(BackEndServiceModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public String get() {  
    String provided = module.provideServerUrl();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<String> create(BackEndServiceModule module) {  
    return new BackEndServiceModule_ProvideServerUrlFactory(module);
  }
}

