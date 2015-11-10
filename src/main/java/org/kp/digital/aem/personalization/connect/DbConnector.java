package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.model.EppRecord;

/**
 * Created by vijay on 11/6/15.
 */
public interface DbConnector {

    boolean storeRecord(EppRecord eppRecord);

    EppRecord getRecord(String eppPersonRole);

    java.util.List<EppRecord> getAllRecords();

}
