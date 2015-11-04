package org.kp.digital.aem.personalization.poc;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by prokarma on 11/2/15.
 */
@Module
public class BackEndServiceModule {

    @Provides
    @Singleton
    BackendService provideBackendService(User user, @Named("serverUrl") String serverUrl) {
        return new BackendService(user);
    }

    @Provides
    @Named("serverUrl")
    String provideServerUrl() {
        return "http://www.google.com";
    }

    @Provides
    @Named("anotherUrl")
    String provideAnotherUrl() {
        return "http://www.yahoo.com";
    }

}
