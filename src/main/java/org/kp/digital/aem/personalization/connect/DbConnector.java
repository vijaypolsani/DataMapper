package org.kp.digital.aem.personalization.connect;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by vijay on 11/6/15.
 */
public interface DbConnector {

    String databaseUrl = "jdbc:sqlite:epp.db";
    long CONNECT_OPEN_TIME = 5 * 60 * 1000; // 5 minutes
    long CONNECT_RETRY_TIME = 60 * 1000; // 60 sec

    static Optional<ConnectionSource> getConnection() {
        JdbcPooledConnectionSource connectionSource = null;
        try {
            if (connectionSource == null) {
                connectionSource = new JdbcPooledConnectionSource(databaseUrl);
                connectionSource.setMaxConnectionAgeMillis(CONNECT_OPEN_TIME);
                connectionSource.setCheckConnectionsEveryMillis(CONNECT_RETRY_TIME);
                //connectionSource.setTestBeforeGet(true);
            }
            return Optional.of(connectionSource);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }
}
