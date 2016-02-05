package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.AdobeRecord;

import java.util.Arrays;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class EppDaoConnectorTest {
    private EppDao eppDao = null;
    private AdobeRecord adobeRecord = null;

    @Before
    public void setup() {
        eppDao = new EppDao();
        adobeRecord = new AdobeRecord();
        adobeRecord.setEpp_PersonRole("AAAA1111");
    }

    @Test
    public void testFtpFileRead() {
        log.info("Starting the test for database :" + adobeRecord.toString());
        eppDao.storeRecord(adobeRecord);
        log.info("Data stored in the DB.");
        log.info("Data: " + eppDao.getRecord("AAAA1111").toString());
        log.info("Data of all records: " + Arrays.asList(eppDao.getAllRecords()));
        adobeRecord.setEpp_PersonRole("BBBB2222");
        eppDao.storeRecord(adobeRecord);
        adobeRecord.setEpp_PersonRole("CCCC3333");
        eppDao.storeRecord(adobeRecord);
        adobeRecord.setEpp_PersonRole("AAAA1111");
        eppDao.storeRecord(adobeRecord);
        log.info("Data of all records: " + Arrays.asList(eppDao.getAllRecords()));
    }

    @After
    public void tearDown() {
        eppDao = null;
        adobeRecord = null;
    }
}
