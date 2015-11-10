package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.connect.EppDbConnector;
import org.kp.digital.aem.personalization.model.EppRecord;

import java.util.Arrays;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class EppDbConnectorTest {
    private DbConnector dbConnector = null;
    private EppRecord eppRecord = null;

    @Before
    public void setup() {
        dbConnector = new EppDbConnector();
        eppRecord = new EppRecord();
        eppRecord.setEpp_PersonRole("AAAA1111");
    }

    @Test
    public void testFtpFileRead() {
        log.info("Starting the test for database :" + eppRecord.toString());
        dbConnector.storeRecord(eppRecord);
        log.info("Data stored in the DB.");
        log.info("Data: " + dbConnector.getRecord("AAAA1111").toString());
        log.info("Data of all records: " + Arrays.asList(dbConnector.getAllRecords()));
        eppRecord.setEpp_PersonRole("BBBB2222");
        dbConnector.storeRecord(eppRecord);
        eppRecord.setEpp_PersonRole("CCCC3333");
        dbConnector.storeRecord(eppRecord);
        eppRecord.setEpp_PersonRole("AAAA1111");
        dbConnector.storeRecord(eppRecord);
        log.info("Data of all records: " + Arrays.asList(dbConnector.getAllRecords()));
    }

    @After
    public void tearDown() {
        dbConnector = null;
        eppRecord = null;
    }
}
