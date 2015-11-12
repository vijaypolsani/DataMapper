package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppPerson;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanPersonProcessor extends BeanProcessor<EppPerson> {
    private DbConnector dbConnector;

    public PipedBeanPersonProcessor(Class<EppPerson> beanType) {
        super(beanType);
    }

    public PipedBeanPersonProcessor(Class<EppPerson> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppPerson eppPerson, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppPerson.toString());
        dbConnector.storeRecord(eppPerson);
    }
}
