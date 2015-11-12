package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppPersonIdentifiers;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanPersonIdentifiersProcessor extends BeanProcessor<EppPersonIdentifiers> {
    private DbConnector dbConnector;

    public PipedBeanPersonIdentifiersProcessor(Class<EppPersonIdentifiers> beanType) {
        super(beanType);
    }

    public PipedBeanPersonIdentifiersProcessor(Class<EppPersonIdentifiers> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppPersonIdentifiers eppPersonIdentifiers, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppPersonIdentifiers.toString());
        dbConnector.storeRecord(eppPersonIdentifiers);
    }
}
