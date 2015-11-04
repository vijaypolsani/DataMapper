package org.kp.digital.aem.personalization.poc;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by prokarma on 11/2/15.
 */
@Module(includes = PumpModule.class)
public class DripCofeeModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
