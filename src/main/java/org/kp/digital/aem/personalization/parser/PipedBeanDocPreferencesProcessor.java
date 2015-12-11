package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppDocumentPreferences;

import javax.inject.Inject;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanDocPreferencesProcessor extends BeanProcessor<EppDocumentPreferences> {
    @Inject
    DbConnector dbConnector;

    public PipedBeanDocPreferencesProcessor(Class<EppDocumentPreferences> beanType) {
        super(beanType);
    }

    public PipedBeanDocPreferencesProcessor(Class<EppDocumentPreferences> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppDocumentPreferences eppDocumentPreferences, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppDocumentPreferences.toString());
        dbConnector.storeRecord(eppDocumentPreferences);
    }
}
