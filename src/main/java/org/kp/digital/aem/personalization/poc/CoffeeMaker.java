package org.kp.digital.aem.personalization.poc;

import dagger.Lazy;

import javax.inject.Inject;

/**
 * Created by prokarma on 11/2/15.
 */
public class CoffeeMaker {
    private final Lazy<Heater> heater;
    private final Pump pump;

    @Inject
    public CoffeeMaker(Lazy<Heater> heater, Pump pump){
        this.heater = heater;
        this.pump = pump;

    }

    public void brew(){
        heater.get().on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.get().off();
    }
}

