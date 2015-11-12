package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.AbstractRowProcessor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.EppRecord;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by vijay on 11/9/15.
 */
@Slf4j
public class PipedFileEppRecordProcessor extends AbstractRowProcessor {

    private final DbConnector dbConnector;
    @Getter
    private final Queue<EppRecord> fileRecordOutput = new LinkedBlockingQueue<>(1);
    @Getter
    private EppRecord eppRecord = null;

    public PipedFileEppRecordProcessor(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public void rowProcessed(String[] record, ParsingContext context) {
        final EppRecord eppRecord = new EppRecord();
        log.info("ROW Content: " + Arrays.toString(record));
        eppRecord.setEpp_PersonRole(record[0]);
        //eppRecord.setEpp_MemberContractOptionBenefitKey(row[1]);
        dbConnector.storeRecord(eppRecord);
    }

    @Override
    public void processEnded(ParsingContext context) {
        //fileRecordOutput.offer(eppRecord);
    }
}
