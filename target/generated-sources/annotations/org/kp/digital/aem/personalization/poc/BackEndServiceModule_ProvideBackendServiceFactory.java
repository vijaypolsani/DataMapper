package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BackEndServiceModule_ProvideBackendServiceFactory implements Factory<BackendService> {
  private final BackEndServiceModule module;
  private final Provider<User> userProvider;
  private final Provider<String> serverUrlProvider;

  public BackEndServiceModule_ProvideBackendServiceFactory(BackEndServiceModule module, Provider<User> userProvider, Provider<String> serverUrlProvider) {  
    assert module != null;
    this.module = module;
    assert userProvider != null;
    this.userProvider = userProvider;
    assert serverUrlProvider != null;
    this.serverUrlProvider = serverUrlProvider;
  }

  @Override
  public BackendService get() {  
    BackendService provided = module.provideBackendService(userProvider.get(), serverUrlProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<BackendService> create(BackEndServiceModule module, Provider<User> userProvider, Provider<String> serverUrlProvider) {  
    return new BackEndServiceModule_ProvideBackendServiceFactory(module, userProvider, serverUrlProvider);
  }
}

