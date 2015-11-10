package org.kp.digital.aem.personalization.service;

import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.*;
import org.kp.digital.aem.personalization.parser.PipedFileParserProcessor;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by prokarma on 11/2/15.
 */
@Slf4j
@Path("/datamapper")
public class DataMapperService {
    //TODO Dagger Injection
    private final InboundSftpConnector inboundConnector = InboundSftpConnector.create();
    private final OutboundSftpConnector outboundConnector = OutboundSftpConnector.create();
    private final DbConnector dbConnector = new EppDbConnector();

    private final CsvParserSettings csvParserSettings = new CsvParserSettings();
    private final PipedFileParserProcessor pipedFileParserProcessor = new PipedFileParserProcessor(dbConnector);
    private final CsvFormat csvFormat = new CsvFormat();
    ;
    private final CsvParser csvParser;
    private static final char[] charBuf = new char[4096];

    public DataMapperService() {
        csvParserSettings.setLineSeparatorDetectionEnabled(true);
        csvParserSettings.setParseUnescapedQuotes(true);
        csvParserSettings.setHeaderExtractionEnabled(false);
        csvParserSettings.setRowProcessor(pipedFileParserProcessor);
        csvFormat.setDelimiter('|');
        csvParserSettings.setFormat(csvFormat);
        csvParser = new CsvParser(csvParserSettings);
    }

    @POST
    @Path("start")
    @Produces(MediaType.APPLICATION_JSON)
    public void start() {
        //TODO Impement a Command Pattern and COR for sequencing the Loop.
        try {
            //1.Read the FTP files from REMOTE to local.
            inboundConnector.readInputFiles();
            //2.Perform Merge(table) of the files
            final File directory = new File(PropertiesFileLoader.loadProperties(null).getProperty(Connector.MAPPED_DIRECTORY));
            final File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isFile()) {
                    log.info("Local file name: " + file.getName());
                    final Reader reader = new FileReader(file);
                        csvParser.parse(reader);
                    reader.close();
                }
            }
            //log.info("List of all the records in DB: " + Arrays.toString(dbConnector.getAllRecords()));
            //Export the merge(table) to a file WITH Obfuscation catalog
            //Send FTP file from LOCAL to remote
           // outboundConnector.writeOutputLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
