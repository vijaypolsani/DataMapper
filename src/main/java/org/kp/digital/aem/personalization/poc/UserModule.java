package org.kp.digital.aem.personalization.poc;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by prokarma on 11/2/15.
 */
@Module
public class UserModule {
    @Provides
    @Singleton
    User providesUser() {
        return new User("Lars", "Vogel");
    }
}
