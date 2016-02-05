package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.EppContactMethods;

import javax.inject.Inject;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanContactMethodsProcessor extends BeanProcessor<EppContactMethods> {
    @Inject
    EppDao eppDao;

    public PipedBeanContactMethodsProcessor(Class<EppContactMethods> beanType) {
        super(beanType);
    }

    public PipedBeanContactMethodsProcessor(Class<EppContactMethods> beanType, EppDao eppDao) {
        super(beanType);
        this.eppDao = eppDao;
    }

    @Override
    public void beanProcessed(EppContactMethods eppContactMethods, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppContactMethods.toString());
        eppDao.storeRecord(eppContactMethods);
    }
}
