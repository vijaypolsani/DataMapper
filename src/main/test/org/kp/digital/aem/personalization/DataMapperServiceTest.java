package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kp.digital.aem.personalization.service.DataMapperService;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class DataMapperServiceTest {
    private DataMapperService dataMapperService = null;

    @Before
    public void startup() {
        dataMapperService = new DataMapperService();
    }

    @Test
    public void startTest() {
        dataMapperService.start();
    }

    @After
    public void tearDown() {
        dataMapperService = null;
    }
}
