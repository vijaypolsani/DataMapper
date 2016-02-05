package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.EppPerson;

import javax.inject.Inject;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanPersonProcessor extends BeanProcessor<EppPerson> {
    @Inject
    EppDao eppDao;

    public PipedBeanPersonProcessor(Class<EppPerson> beanType) {
        super(beanType);
    }

    public PipedBeanPersonProcessor(Class<EppPerson> beanType, EppDao eppDao) {
        super(beanType);
        this.eppDao = eppDao;
    }

    @Override
    public void beanProcessed(EppPerson eppPerson, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppPerson.toString());
        eppDao.storeRecord(eppPerson);
    }
}
