package org.kp.digital.aem.personalization.poc;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prokarma on 11/2/15.
 */
@Module
public class PumpModule {
    @Provides
    Pump providePump(ThermosepianPump pump){
        return pump;
    }
}
