package org.kp.digital.aem.personalization.poc;

import javax.inject.Inject;

/**
 * Created by prokarma on 11/2/15.
 */
public class ThermosepianPump implements Pump {
    private final Heater heater;

    @Inject
    public ThermosepianPump(Heater heater){
        this.heater = heater;
    }
    @Override
    public void pump() {
        if (heater.isHot()){
            System.out.println("=> => pumping => =>");
        }
    }
}
