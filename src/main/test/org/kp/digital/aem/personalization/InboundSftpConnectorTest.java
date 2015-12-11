package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.connect.EppDb;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;

import java.io.IOException;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class InboundSftpConnectorTest {
    private DbConnector dbConnector = null;
    private InboundSftpConnector inboundConnector = null;
    private OutboundSftpConnector outboundConnector = null;

    @Before
    public void setup() {
        dbConnector = new EppDb();
        inboundConnector = InboundSftpConnector.create();
        outboundConnector = OutboundSftpConnector.create();
    }

    @Test
    public void testFtpFileRead() {
        log.info("Starting the test for Input FTP file:");
        try {
            inboundConnector.readInputFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        dbConnector = null;
        InboundSftpConnector.destroy();
        OutboundSftpConnector.destroy();
    }

}
