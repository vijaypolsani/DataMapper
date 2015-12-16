package org.kp.digital.aem.personalization.util;

/**
 * Created by vijay on 11/11/15.
 */
public enum FileTypes {
    Benefit("Benefit.txt"), CommunicationPreferences("CommunicationPreferences.txt"), ContactMethods("ContactMethods" +
            ".txt"),
    DocumentPreferences("DocumentPreferences.txt"), PersonIdentifiers("PersonIdentifiers.txt"), Person("Person.txt"),
    Merged("Merged.csv");

    private String value;

    FileTypes(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }


}
