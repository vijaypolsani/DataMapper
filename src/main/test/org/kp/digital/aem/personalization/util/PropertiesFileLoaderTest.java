package org.kp.digital.aem.personalization.util;

import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class PropertiesFileLoaderTest {
    @Test
    public void LoadFileTest(){
        Properties properties = PropertiesFileLoader.loadProperties(null);
        log.info("Properties: "+properties);
    }
}
