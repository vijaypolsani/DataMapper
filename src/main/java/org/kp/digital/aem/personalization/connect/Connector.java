package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.util.PropertiesFileLoader;

import java.util.Properties;

/**
 * Created by vijay on 11/6/15.
 */
public interface Connector {
    //TODO: Use ENUM, default interface
    String SERVER_ADDRESS = "server_address";
    String LOCAL_DIRECTORY = "local_directory";
    String REMOTE_DIRECTORY = "remote_directory";
    String MAPPED_DIRECTORY = "mapped_directory";
    String MERGED_DIRECTORY = "merged_directory";
    String BKP_DIRECTORY = "backup_directory";
    String USERID = "userid";
    String PASSWORD = "password";
    String PORT = "port";

    String DEFAULT_PROPERTIES = null;
    Properties properties = PropertiesFileLoader.loadProperties(DEFAULT_PROPERTIES);
    String BKP = ".bkp";

}
