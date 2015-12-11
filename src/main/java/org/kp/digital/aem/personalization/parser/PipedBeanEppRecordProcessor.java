package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppRecord;

import javax.inject.Inject;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanEppRecordProcessor extends BeanProcessor<EppRecord> {
    @Inject
    DbConnector dbConnector;

    public PipedBeanEppRecordProcessor(Class<EppRecord> beanType) {
        super(beanType);
    }

    public PipedBeanEppRecordProcessor(Class<EppRecord> beanType, DbConnector dbConnector) {
        super(beanType);
        this.dbConnector = dbConnector;
    }

    @Override
    public void beanProcessed(EppRecord eppRecord, ParsingContext parsingContext) {
        log.info("ROW Content: " + eppRecord.toString());
        dbConnector.storeRecord(eppRecord);
    }
}
