package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kp.digital.aem.personalization.connect.*;

import java.io.IOException;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class OutboundSftpConnectorTest {
    private DbConnector dbConnector = null;
    private InboundSftpConnector inboundConnector = null;
    private OutboundSftpConnector outboundConnector = null;

    @Before
    public void setup() {
        dbConnector = new EppDbConnector();
        inboundConnector = new InboundSftpConnector().create();
        outboundConnector = new OutboundSftpConnector().create();
    }

    @Test
    public void testFtpFileRead() {
        log.info("Starting the test for Input FTP file:");
        try {
            inboundConnector.readInputFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        dbConnector = null;
        inboundConnector = null;
        outboundConnector = null;
    }

}
