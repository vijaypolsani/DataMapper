package org.kp.digital.aem.personalization.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.kp.digital.aem.personalization.model.EppRecord;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vijay on 11/5/15.
 */
public class EppDao {
    public static final String databaseUrl = "jdbc:sqlite:epp.db";
    private static Dao<EppRecord, String> eppDao = null;
    private static JdbcConnectionSource connectionSource = null;

    //TODO Dagger singleton
    private static Optional<ConnectionSource> getConnection() {
        try {
            if (connectionSource != null)
                connectionSource = new JdbcConnectionSource(databaseUrl);
            return Optional.of(connectionSource);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }

    private static Dao<EppRecord, String> getDao() {
        try {
            if (getConnection().isPresent() && eppDao == null) {
                Dao<EppRecord, String> eppDao = DaoManager.createDao(getConnection().get(), EppRecord.class);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return eppDao;
    }

    public static void createNewEppData(EppRecord eppRecord) throws SQLException {
        TableUtils.createTableIfNotExists(getConnection().get(), EppRecord.class);
        getDao().createOrUpdate(eppRecord);
    }
    public static EppRecord getEppData(String eppPersonalData) throws SQLException {
        return getDao().queryForId(eppPersonalData);
    }
    public static List<EppRecord> getAllEppData() throws SQLException {
        return getDao().queryForAll();
    }

}
