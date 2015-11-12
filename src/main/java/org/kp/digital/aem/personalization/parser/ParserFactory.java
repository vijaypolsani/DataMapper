package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.processor.BeanProcessor;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppRecord;

/**
 * Created by vijay on 11/11/15.
 */
public class ParserFactory {
    private final DbConnector dbConnector;
    private final BeanProcessor<EppRecord> eppRecordBean = null;

    private ParserFactory(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

}
