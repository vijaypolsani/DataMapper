package org.kp.digital.aem.personalization.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vijay on 11/5/15.
 */
@Slf4j
public class EppDao implements BaseDao {
    private static Dao<EppPerson, String> eppPersonDao = null;
    private static Dao<EppCommunicationPreferences, String> eppCommunicationPreferencesDao = null;
    private static Dao<EppContactMethods, String> eppContactMethodsDao = null;
    private static Dao<EppDocumentPreferences, String> eppDocumentPreferencesDao = null;
    private static Dao<AdobeRecord, String> activeRecordDao = null;

    public EppDao() {
        super();
        try {
            TableUtils.createTableIfNotExists(DbConnector.getConnection().get(), EppCommunicationPreferences.class);
            log.info("Created EppCommunicationPreferences Table if not exist.");
            TableUtils.createTableIfNotExists(DbConnector.getConnection().get(), EppContactMethods.class);
            log.info("Created EppContactMethods Table if not exist.");
            TableUtils.createTableIfNotExists(DbConnector.getConnection().get(), EppDocumentPreferences.class);
            log.info("Created EppDocumentPreferences Table if not exist.");
            TableUtils.createTableIfNotExists(DbConnector.getConnection().get(), EppPerson.class);
            log.info("Created Person Table if not exist.");
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }


    private static Dao<AdobeRecord, String> getAdobeRecord() {
        try {
            if (DbConnector.getConnection().isPresent() && activeRecordDao == null) {
                activeRecordDao = DaoManager.createDao(DbConnector.getConnection().get(), AdobeRecord.class);
                log.info("Created eppDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return activeRecordDao;
    }


    private static Dao<EppCommunicationPreferences, String> getEppCommunicationPreferencesDao() {
        try {
            if (DbConnector.getConnection().isPresent() && eppCommunicationPreferencesDao == null) {
                eppCommunicationPreferencesDao = DaoManager.createDao(DbConnector.getConnection().get(),
                        EppCommunicationPreferences.class);
                log.info("Created eppCommunicationPreferencesDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppCommunicationPreferencesDao;
    }

    private static Dao<EppContactMethods, String> getEppContactMethodsDao() {
        try {
            if (DbConnector.getConnection().isPresent() && eppContactMethodsDao == null) {
                eppContactMethodsDao = DaoManager.createDao(DbConnector.getConnection().get(), EppContactMethods.class);
                log.info("Created eppContactMethodsDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppContactMethodsDao;
    }

    private static Dao<EppDocumentPreferences, String> getEppDocumentPreferencesDao() {
        try {
            if (DbConnector.getConnection().isPresent() && eppDocumentPreferencesDao == null) {
                eppDocumentPreferencesDao = DaoManager.createDao(DbConnector.getConnection().get(),
                        EppDocumentPreferences.class);
                log.info("Created eppDocumentPreferencesDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppDocumentPreferencesDao;
    }

    private static Dao<EppPerson, String> getEppPersonDao() {
        try {
            if (DbConnector.getConnection().isPresent() && eppPersonDao == null) {
                eppPersonDao = DaoManager.createDao(DbConnector.getConnection().get(), EppPerson.class);
                log.info("Created eppPersonDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppPersonDao;
    }

    @Override
    public boolean storeRecord(EppCommunicationPreferences eppCommunicationPreferences) {
        try {
            getEppCommunicationPreferencesDao().create(eppCommunicationPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppContactMethods eppContactMethods) {
        try {
            getEppContactMethodsDao().create(eppContactMethods);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppDocumentPreferences eppDocumentPreferences) {
        try {
            getEppDocumentPreferencesDao().create(eppDocumentPreferences);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(EppPerson eppPerson) {
        try {
            getEppPersonDao().create(eppPerson);
            return true;
        } catch (SQLException sqle) {
            //sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean storeRecord(AdobeRecord adobeRecord) {
        try {
            getAdobeRecord().create(adobeRecord);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    @Override
    public AdobeRecord getRecord(String eppPersonRole) {
        //TODO check args for Non-Null
        try {
            return getAdobeRecord().queryForId(eppPersonRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdobeRecord> getAllRecords() {
        List<AdobeRecord> adobeRecordList = null;
        try {
            adobeRecordList = getAdobeRecord().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adobeRecordList;
    }


    public void clearEpp() {
        try {
            TableUtils.clearTable(DbConnector.getConnection().get(), EppPerson.class);
            log.info("Dropped Person Table if not exist.");
            TableUtils.clearTable(DbConnector.getConnection().get(), EppCommunicationPreferences.class);
            log.info("Dropped EppCommunicationPreferences Table if not exist.");
            TableUtils.clearTable(DbConnector.getConnection().get(), EppContactMethods.class);
            log.info("Dropped EppContactMethods Table if not exist.");
            TableUtils.clearTable(DbConnector.getConnection().get(), EppDocumentPreferences.class);
            log.info("Dropped EppDocumentPreferences Table if not exist.");
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
}
