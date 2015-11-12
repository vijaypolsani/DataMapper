package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppContactMethods;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanContactMethodsProcessor extends BeanProcessor<EppContactMethods> {
    private DbConnector dbConnector;

    public PipedBeanContactMethodsProcessor(Class<EppContactMethods> beanType) {
        super(beanType);
    }

    public PipedBeanContactMethodsProcessor(Class<EppContactMethods> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppContactMethods eppContactMethods, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppContactMethods.toString());
        dbConnector.storeRecord(eppContactMethods);
    }
}
