package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppCommunicationPreferences;

import javax.inject.Inject;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanCommPreferencesProcessor extends BeanProcessor<EppCommunicationPreferences> {
    @Inject
    DbConnector dbConnector;

    public PipedBeanCommPreferencesProcessor(Class<EppCommunicationPreferences> beanType) {
        super(beanType);
    }

    public PipedBeanCommPreferencesProcessor(Class<EppCommunicationPreferences> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppCommunicationPreferences eppCommunicationPreferences, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppCommunicationPreferences.toString());
        dbConnector.storeRecord(eppCommunicationPreferences);
    }
}
