package org.kp.digital.aem.personalization.poc;

import dagger.Component;

/**
 * Created by prokarma on 11/2/15.
 */
@Component(modules = {UserModule.class, BackEndServiceModule.class})
public interface MyComponent {
    //BackendService createBackendService();
}
