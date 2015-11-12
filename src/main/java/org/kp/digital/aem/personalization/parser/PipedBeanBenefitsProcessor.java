package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppBenefits;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanBenefitsProcessor extends BeanProcessor<EppBenefits> {
    private DbConnector dbConnector;

    public PipedBeanBenefitsProcessor(Class<EppBenefits> beanType) {
        super(beanType);
    }

    public PipedBeanBenefitsProcessor(Class<EppBenefits> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppBenefits eppBenefits, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppBenefits.toString());
        dbConnector.storeRecord(eppBenefits);
    }
}
