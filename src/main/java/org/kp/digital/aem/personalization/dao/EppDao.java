package org.kp.digital.aem.personalization.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.model.EppRecord;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vijay on 11/5/15.
 */
@Slf4j
public class EppDao {
    public static final String databaseUrl = "jdbc:sqlite:epp.db";
    private static Dao<EppRecord, String> eppDao = null;
    private static JdbcConnectionSource connectionSource = null;

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
                log.info("Created DAO from connection.");
                TableUtils.createTableIfNotExists(getConnection().get(), EppRecord.class);
                log.info("Created Epp Table if no exist.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppDao;
    }

    public static void createNewEppData(EppRecord eppRecord) throws SQLException {
        getEppDao().createOrUpdate(eppRecord);
    }

    public static EppRecord getEppData(String eppPersonalData) throws SQLException {
        return getEppDao().queryForId(eppPersonalData);
    }

    public static List<EppRecord> getAllEppData() throws SQLException {
        return getEppDao().queryForAll();
    }

}
