package org.kp.digital.aem.personalization.poc;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by prokarma on 11/2/15.
 */
public class CoffeeApp {
    @Singleton
    @Component(modules = {DripCofeeModule.class})
    public interface Coffee {
        CoffeeMaker maker();
    }

    public static void main(String args[]) {
        Coffee coffee = org.kp.digital.aem.personalization.poc.DaggerCoffeeApp_Coffee.builder().build();
    }
}
