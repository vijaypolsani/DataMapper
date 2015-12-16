package org.kp.digital.aem.personalization.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vijay on 11/5/15.
 */
@Slf4j
public class EppDao {
    public static final String databaseUrl = "jdbc:sqlite:epp.db";
    private static Dao<EppBenefits, String> eppBenefitsesDao = null;
    private static Dao<EppCommunicationPreferences, String> eppCommunicationPreferencesDao = null;
    private static Dao<EppContactMethods, String> eppContactMethodsDao = null;
    private static Dao<EppDocumentPreferences, String> eppDocumentPreferencesDao = null;
    private static Dao<EppPerson, String> eppPersonDao = null;
    private static Dao<EppPersonIdentifiers, String> eppPersonIdentifiersDao = null;
    private static JdbcConnectionSource connectionSource = null;
    private static Dao<EppRecord, String> eppDao = getEppDao();

    //TODO Dagger singleton
    private static Optional<ConnectionSource> getConnection() {
        try {
            if (connectionSource == null) {
                connectionSource = new JdbcConnectionSource(databaseUrl);
                log.info("Created DB connection.");
            }
            return Optional.of(connectionSource);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }

    private static Dao<EppRecord, String> getEppDao() {
        try {
            if (getConnection().isPresent() && eppDao == null) {
                eppDao = DaoManager.createDao(getConnection().get(), EppRecord.class);
                log.info("Created eppDao DAO from connection.");
                TableUtils.createTableIfNotExists(getConnection().get(), EppRecord.class);
                log.info("Created Epp Table if no exist.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppDao;
    }

    private static Dao<EppBenefits, String> getEppBenefitsDao() {
        try {
            if (getConnection().isPresent() && eppBenefitsesDao == null) {
                eppBenefitsesDao = DaoManager.createDao(getConnection().get(), EppBenefits.class);
                log.info("Created eppBenefitsesDao from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppBenefitsesDao;
    }

    private static Dao<EppCommunicationPreferences, String> getEppCommunicationPreferencesDao() {
        try {
            if (getConnection().isPresent() && eppCommunicationPreferencesDao == null) {
                eppCommunicationPreferencesDao = DaoManager.createDao(getConnection().get(),
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
            if (getConnection().isPresent() && eppContactMethodsDao == null) {
                eppContactMethodsDao = DaoManager.createDao(getConnection().get(), EppContactMethods.class);
                log.info("Created eppContactMethodsDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppContactMethodsDao;
    }

    private static Dao<EppDocumentPreferences, String> getEppDocumentPreferencesDao() {
        try {
            if (getConnection().isPresent() && eppDocumentPreferencesDao == null) {
                eppDocumentPreferencesDao = DaoManager.createDao(getConnection().get(), EppDocumentPreferences.class);
                log.info("Created eppDocumentPreferencesDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppDocumentPreferencesDao;
    }

    private static Dao<EppPerson, String> getEppPersonDao() {
        try {
            if (getConnection().isPresent() && eppPersonDao == null) {
                eppPersonDao = DaoManager.createDao(getConnection().get(), EppPerson.class);
                log.info("Created eppPersonDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppPersonDao;
    }

    private static Dao<EppPersonIdentifiers, String> getEppPersonIdentifiersDao() {
        try {
            if (getConnection().isPresent() && eppPersonIdentifiersDao == null) {
                eppPersonIdentifiersDao = DaoManager.createDao(getConnection().get(), EppPersonIdentifiers.class);
                log.info("Created eppPersonIdentifiersDao DAO from connection.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppPersonIdentifiersDao;
    }


    public static void addEppData(EppRecord eppRecord) throws SQLException {
        getEppDao().createOrUpdate(eppRecord);
    }

    public static void addEppBenefitsData(EppBenefits eppBenefits) throws SQLException {
        getEppBenefitsDao().createOrUpdate(eppBenefits);
    }

    public static void addEppCommunicationPreferences(EppCommunicationPreferences eppCommunicationPreferences) throws
            SQLException {
        getEppCommunicationPreferencesDao().createOrUpdate(eppCommunicationPreferences);
    }

    public static void addEppContactMethods(EppContactMethods eppContactMethods) throws SQLException {
        getEppContactMethodsDao().createOrUpdate(eppContactMethods);
    }

    public static void addEppDocumentPreferences(EppDocumentPreferences eppDocumentPreferences) throws SQLException {
        getEppDocumentPreferencesDao().createOrUpdate(eppDocumentPreferences);
    }

    public static void addEppPerson(EppPerson eppPerson) throws SQLException {
        getEppPersonDao().createOrUpdate(eppPerson);
    }

    public static void addEppPersonIdentifiers(EppPersonIdentifiers eppPersonIdentifiers) throws SQLException {
        getEppPersonIdentifiersDao().createOrUpdate(eppPersonIdentifiers);
    }

    public static EppRecord getEppData(String eppPersonalData) throws SQLException {
        return getEppDao().queryForId(eppPersonalData);
    }

    public static List<EppRecord> getAllEppData() throws SQLException {
        return getEppDao().queryForAll();
    }

}
