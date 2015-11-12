package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vijay on 11/9/15.
 */
public class EppDbConnector implements DbConnector {

    //TODO inject EppDao ? All static no need!

    @Override
    public boolean storeRecord(EppRecord eppRecord) {
        try {
            EppDao.addEppData(eppRecord);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppBenefits eppBenefits) {
        try {
            EppDao.addEppBenefitsData(eppBenefits);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppCommunicationPreferences eppCommunicationPreferences) {
        try {
            EppDao.addEppCommunicationPreferences(eppCommunicationPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppContactMethods eppContactMethods) {
        try {
            EppDao.addEppContactMethods(eppContactMethods);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppDocumentPreferences eppDocumentPreferences) {
        try {
            EppDao.addEppDocumentPreferences(eppDocumentPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppPerson eppPerson) {
        try {
            EppDao.addEppPerson(eppPerson);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppPersonIdentifiers eppPersonIdentifiers) {
        try {
            EppDao.addEppPersonIdentifiers(eppPersonIdentifiers);
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
            return EppDao.getEppData(eppPersonRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EppRecord> getAllRecords() {
        try {
            return EppDao.getAllEppData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
