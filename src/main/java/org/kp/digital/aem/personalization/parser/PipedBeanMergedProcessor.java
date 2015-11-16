package org.kp.digital.aem.personalization.parser;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.model.EppRecord;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by vijay on 11/10/15.
 */
@Slf4j
public class PipedBeanMergedProcessor extends BeanProcessor<EppRecord> {
    private static final String SEND_DIRECTORY = "send_directory";
    private static final String PARTNER_ID = "52585_";
    private static long timestamp = System.currentTimeMillis() / 1000;
    private static final String OUTPUT_GZIP_FILE_NAME = "ftp_dpm_" + PARTNER_ID + timestamp + ".overwrite.gz";
    private GZIPOutputStream gzipOutputStream = null;
    private BufferedWriter bufferedWriter = null;

    public PipedBeanMergedProcessor(Class<EppRecord> beanType) {
        super(beanType);
    }

    @Override
    public void processStarted(ParsingContext context) {
        super.initialize();
        try {
            gzipOutputStream = new GZIPOutputStream(new FileOutputStream(new File(PropertiesFileLoader.loadProperties(null).getProperty(SEND_DIRECTORY) + "/" + OUTPUT_GZIP_FILE_NAME)));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(gzipOutputStream, "UTF-8"));
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Override
    public void beanProcessed(EppRecord eppRecord, ParsingContext parsingContext) {
        try {
            bufferedWriter.append(eppRecord.adobeAamFormat());
            bufferedWriter.newLine();
            //gzos.write(eppRecord.adobeAamFormat().getBytes());
            //bufFileOutputstream.write(eppRecord.adobeAamFormat().getBytes());
            log.info("ROW AdobeFormat: " + eppRecord.adobeAamFormat());
            //log.info("ROW Normal Format: " + eppRecord.toString());
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    @Override
    public void processEnded(ParsingContext context) {
        try {
            bufferedWriter.flush();
            gzipOutputStream.flush();
            gzipOutputStream.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
