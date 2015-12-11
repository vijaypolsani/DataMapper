package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vijay on 11/9/15.
 */
public class EppDb implements DbConnector {

    //TODO inject EppDb ? All static no need!

    @Override
    public boolean storeRecord(EppRecord eppRecord) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppData(eppRecord);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppBenefits eppBenefits) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppBenefitsData(eppBenefits);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppCommunicationPreferences eppCommunicationPreferences) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppCommunicationPreferences(eppCommunicationPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppContactMethods eppContactMethods) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppContactMethods(eppContactMethods);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppDocumentPreferences eppDocumentPreferences) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppDocumentPreferences(eppDocumentPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppPerson eppPerson) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppPerson(eppPerson);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppPersonIdentifiers eppPersonIdentifiers) {
        try {
            org.kp.digital.aem.personalization.dao.EppDao.addEppPersonIdentifiers(eppPersonIdentifiers);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public EppRecord getRecord(String eppPersonRole) {
        //TODO check args for Non-Null
        try {
            return org.kp.digital.aem.personalization.dao.EppDao.getEppData(eppPersonRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EppRecord> getAllRecords() {
        try {
            return org.kp.digital.aem.personalization.dao.EppDao.getAllEppData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
