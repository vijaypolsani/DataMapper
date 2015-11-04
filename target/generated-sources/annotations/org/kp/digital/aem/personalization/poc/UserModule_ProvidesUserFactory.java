package org.kp.digital.aem.personalization.poc;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class UserModule_ProvidesUserFactory implements Factory<User> {
  private final UserModule module;

  public UserModule_ProvidesUserFactory(UserModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public User get() {  
    User provided = module.providesUser();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<User> create(UserModule module) {  
    return new UserModule_ProvidesUserFactory(module);
  }
}

