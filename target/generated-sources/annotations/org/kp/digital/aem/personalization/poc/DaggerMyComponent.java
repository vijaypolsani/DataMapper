package org.kp.digital.aem.personalization.poc;

import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerMyComponent implements MyComponent {
  private DaggerMyComponent(Builder builder) {  
    assert builder != null;
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static MyComponent create() {  
    return builder().build();
  }

  public static final class Builder {
    private UserModule userModule;
    private BackEndServiceModule backEndServiceModule;
  
    private Builder() {  
    }
  
    public MyComponent build() {  
      if (userModule == null) {
        this.userModule = new UserModule();
      }
      if (backEndServiceModule == null) {
        this.backEndServiceModule = new BackEndServiceModule();
      }
      return new DaggerMyComponent(this);
    }
  
    public Builder userModule(UserModule userModule) {  
      if (userModule == null) {
        throw new NullPointerException("userModule");
      }
      this.userModule = userModule;
      return this;
    }
  
    public Builder backEndServiceModule(BackEndServiceModule backEndServiceModule) {  
      if (backEndServiceModule == null) {
        throw new NullPointerException("backEndServiceModule");
      }
      this.backEndServiceModule = backEndServiceModule;
      return this;
    }
  }
}

