package org.kp.digital.aem.personalization.connect;

import org.kp.digital.aem.personalization.util.PropertiesFileLoader;

import java.util.Properties;

/**
 * Created by vijay on 11/6/15.
 */
public interface Connector {
    //TODO: Use ENUM, default interface
    public static final String  SERVER_ADDRESS = "server_address";
    public static final String  LOCAL_DIRECTORY = "local_directory";
    public static final String  REMOTE_DIRECTORY = "remote_directory";
    public static final String  MAPPED_DIRECTORY = "mapped_directory";
    public static final String  BKP_DIRECTORY = "backup_directory";
    public static final String  USERID = "userid";
    public static final String  PASSWORD = "password";
    public static final String  PORT = "port";

    public static final String DEFAULT_PROPERTIES = null;
    public static final Properties properties = PropertiesFileLoader.loadProperties(DEFAULT_PROPERTIES);
    public static final String BKP = ".bkp";

    public Connector create();
    public void destroy();

}
