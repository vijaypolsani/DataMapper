package org.kp.digital.aem.personalization.dao;

import org.kp.digital.aem.personalization.model.*;

/**
 * Created by vijay on 11/6/15.
 */
public interface BaseDao {

    boolean storeRecord(AdobeRecord eppRecord);

    boolean storeRecord(EppCommunicationPreferences eppCommunicationPreferences);

    boolean storeRecord(EppContactMethods eppContactMethods);

    boolean storeRecord(EppDocumentPreferences eppDocumentPreferences);

    boolean storeRecord(EppPerson eppPerson);

    AdobeRecord getRecord(String eppPersonRole);

    java.util.List<AdobeRecord> getAllRecords();


}
