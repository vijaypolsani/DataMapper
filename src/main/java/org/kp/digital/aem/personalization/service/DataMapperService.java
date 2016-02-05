package org.kp.digital.aem.personalization.service;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;
import com.univocity.parsers.csv.CsvParser;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.components.ConnectorComponent;
import org.kp.digital.aem.personalization.components.PipedBeanProcessorComponent;
import org.kp.digital.aem.personalization.connect.Connector;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;
import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.AdobeRecord;
import org.kp.digital.aem.personalization.model.EppCommunicationPreferences;
import org.kp.digital.aem.personalization.model.EppContactMethods;
import org.kp.digital.aem.personalization.model.EppDocumentPreferences;
import org.kp.digital.aem.personalization.modules.ConnectorModule;
import org.kp.digital.aem.personalization.modules.PipedBeanProcessorModule;
import org.kp.digital.aem.personalization.parser.PipedBeanCommPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanContactMethodsProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanDocPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanPersonProcessor;
import org.kp.digital.aem.personalization.util.CsvParserFactory;
import org.kp.digital.aem.personalization.util.FileTypes;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Path("/mapper")
public class DataMapperService {
    private final ConnectorComponent connectorComponent = org.kp.digital.aem.personalization.components
            .DaggerConnectorComponent.builder().connectorModule(new ConnectorModule()).build();
    private final PipedBeanProcessorComponent pipedBeanProcessorComponent = org.kp.digital.aem.personalization
            .components.DaggerPipedBeanProcessorComponent.builder().pipedBeanProcessorModule(new
                    PipedBeanProcessorModule())
            .build();
    //TODO: Dagger2 Injection. It does not work
    //TODO: Dagger is inject 1 and I am invoking another. Check how to solve this...
    private final EppDao eppDao;
    private final InboundSftpConnector inboundConnector;
    private final OutboundSftpConnector outboundConnector;
    private final PipedBeanCommPreferencesProcessor pipedBeanCommPreferencesProcessor;
    private final PipedBeanContactMethodsProcessor pipedBeanContactMethodsProcessor;
    private final PipedBeanDocPreferencesProcessor pipedBeanDocPreferencesProcessor;
    private final PipedBeanPersonProcessor pipedBeanPersonProcessor;
    private final CsvParser csvParserCommPreferences;
    private final CsvParser csvParserContactMethods;
    private final CsvParser csvParserDocPreferences;
    private final CsvParser csvParserPerson;
    int count = 0;

    public DataMapperService() {
        inboundConnector = new InboundSftpConnector();
        outboundConnector = new OutboundSftpConnector();
        eppDao = new EppDao();
        pipedBeanCommPreferencesProcessor = pipedBeanProcessorComponent.providePipedBeanCommPreferencesProcessor();
        pipedBeanContactMethodsProcessor = pipedBeanProcessorComponent.providePipedBeanContactMethodsProcessor();
        pipedBeanDocPreferencesProcessor = pipedBeanProcessorComponent.providePipedBeanDocPreferencesProcessor();
        pipedBeanPersonProcessor = pipedBeanProcessorComponent.providePipedBeanPersonProcessor();

        csvParserCommPreferences = CsvParserFactory.getCsvParser(pipedBeanCommPreferencesProcessor);
        csvParserContactMethods = CsvParserFactory.getCsvParser(pipedBeanContactMethodsProcessor);
        csvParserDocPreferences = CsvParserFactory.getCsvParser(pipedBeanDocPreferencesProcessor);
        csvParserPerson = CsvParserFactory.getCsvParser(pipedBeanPersonProcessor);
    }

    @GET
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public String start() {
        //TODO Implement a Command Pattern and COR for sequencing the Loop.
        try {
            //1.Read the FTP files from REMOTE to local.
            inboundConnector.readInputFiles();
            //2.Perform insert to the (table) for finding the dependencies. Could have had JSON for making things
            // easier.
            //Perform Cleanup.

            final File directory = new File(PropertiesFileLoader.loadProperties(null).getProperty(Connector
                    .MAPPED_DIRECTORY));
            final File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isFile()) {
                    log.info("Local file name: " + file.getName() + " Count: " + count++);
                    final Reader reader = new FileReader(file);
                    //TODO: Use better Switch & Enum handling...
                    if (FileTypes.CommunicationPreferences.getName().equalsIgnoreCase(file.getName()))
                        csvParserCommPreferences.parse(reader);
                    else if (FileTypes.ContactMethods.getName().equalsIgnoreCase(file.getName()))
                        csvParserContactMethods.parse(reader);
                    else if (FileTypes.DocumentPreferences.getName().equalsIgnoreCase(file.getName()))
                        csvParserDocPreferences.parse(reader);
                    else if (FileTypes.Person.getName().equalsIgnoreCase(file.getName()))
                        csvParserPerson.parse(reader);
                    reader.close();
                }
            }
            //3. Select the Person along with the dependencies.
            // TODO: Mark the record as complete, so as to not reprocess
            List<AdobeRecord> adobeRecordList = eppDao.getAllRecords();
            log.info("***AdobeRecord size: " + adobeRecordList.size());
            for (AdobeRecord adobeRecord : adobeRecordList) {
                ForeignCollection<EppCommunicationPreferences> eppCommunicationPreferencesList = adobeRecord
                        .getEppCommunicationPreferences();
                log.info("*** Count Record eppCommunicationPreferencesList: " + eppCommunicationPreferencesList
                        .size());
                ForeignCollection<EppContactMethods> eppContactMethods = adobeRecord
                        .getEppContactMethods();
                log.info("*** Count Record eppDocumentPreferences: " + eppContactMethods.size());
                ForeignCollection<EppDocumentPreferences> eppDocumentPreferences = adobeRecord
                        .getEppDocumentPreferences();
                log.info("*** Count Record eppDocumentPreferences: " + eppDocumentPreferences.size());
                CloseableIterator<EppCommunicationPreferences> commIterator = eppCommunicationPreferencesList
                        .closeableIterator();
                try {
                    if (commIterator.hasNext()) {
                        EppCommunicationPreferences eppCommunicationPreferences = commIterator.next();
                    }
                } finally {
                    try {
                        commIterator.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            //4. Obfuscation with stated excel encode.

            //5. Convert to Adobe Format.


            //6.Send FTP file from LOCAL to remote
            outboundConnector.writeOutputLine();

            return "{'status':'done'}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{'status':'failed'}";
        }
    }
}
