package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.processor.BeanProcessor;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppRecord;

import javax.inject.Inject;

/**
 * Created by vijay on 11/11/15.
 */
public class ParserFactory {
    private final DbConnector dbConnector;
    private final BeanProcessor<EppRecord> eppRecordBean = null;

    @Inject
    public ParserFactory(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

}
