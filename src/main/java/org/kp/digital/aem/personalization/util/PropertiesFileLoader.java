package org.kp.digital.aem.personalization.util;

import lombok.Data;

import java.io.*;
import java.util.Properties;

/**
 * Created by vijay on 11/9/15.
 */
@Data
public class PropertiesFileLoader {
    private static final Properties properties = new Properties();
    private static final String PROPS_NAME = "/Users/vijay/research/datamapper/config/properties.config";

    public PropertiesFileLoader() {

    }

    public static Properties loadProperties(String propertiesFileLocation) {
        if (propertiesFileLocation == null)
            propertiesFileLocation = PROPS_NAME;
        if (properties.entrySet().size() > 0)
            return properties;
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(PROPS_NAME))) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
