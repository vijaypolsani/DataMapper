package org.kp.digital.aem.personalization;

import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.service.DataMapperService;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class DataMapperServiceMain {
    private static final DataMapperService dataMapperService = new DataMapperService();

    public static void main(String args[]) {
        dataMapperService.start();
    }

}
