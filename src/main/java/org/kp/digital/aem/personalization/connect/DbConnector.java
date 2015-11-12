package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.model.*;

/**
 * Created by vijay on 11/6/15.
 */
public interface DbConnector {

    boolean storeRecord(EppRecord eppRecord);

    boolean storeRecord(EppBenefits eppBenefits);

    boolean storeRecord(EppCommunicationPreferences eppCommunicationPreferences);

    boolean storeRecord(EppContactMethods eppContactMethods);

    boolean storeRecord(EppDocumentPreferences eppDocumentPreferences);

    boolean storeRecord(EppPerson eppPerson);

    boolean storeRecord(EppPersonIdentifiers eppPersonIdentifiers);

    EppRecord getRecord(String eppPersonRole);

    java.util.List<EppRecord> getAllRecords();

}
