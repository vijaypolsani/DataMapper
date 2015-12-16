package org.kp.digital.aem.personalization.service;

import com.univocity.parsers.csv.CsvParser;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.components.ConnectorComponent;
import org.kp.digital.aem.personalization.components.PipedBeanProcessorComponent;
import org.kp.digital.aem.personalization.connect.Connector;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;
import org.kp.digital.aem.personalization.modules.ConnectorModule;
import org.kp.digital.aem.personalization.modules.PipedBeanProcessorModule;
import org.kp.digital.aem.personalization.parser.*;
import org.kp.digital.aem.personalization.util.CsvParserFactory;
import org.kp.digital.aem.personalization.util.FileTypes;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;
import org.kp.digital.aem.personalization.util.TableExport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Slf4j
@Path("/mapper")
public class DataMapperService {

    private final ConnectorComponent connectorComponent = org.kp.digital.aem.personalization.components
            .DaggerConnectorComponent.builder().connectorModule(new ConnectorModule()).build();
    private final PipedBeanProcessorComponent pipedBeanProcessorComponent = org.kp.digital.aem.personalization
            .components.DaggerPipedBeanProcessorComponent.builder().pipedBeanProcessorModule(new
                    PipedBeanProcessorModule())
            .build();
    //TODO: Dagger2 Injection
    private final InboundSftpConnector inboundConnector;
    private final OutboundSftpConnector outboundConnector;
    private final DbConnector dbConnector;

    private final PipedBeanEppRecordProcessor pipedBeanParserProcessor;
    private final PipedBeanMergedProcessor pipedBeanMergedProcessor;
    private final PipedBeanBenefitsProcessor pipedBeanBenefitsProcessor;
    private final PipedBeanCommPreferencesProcessor pipedBeanCommPreferencesProcessor;
    private final PipedBeanContactMethodsProcessor pipedBeanContactMethodsProcessor;
    private final PipedBeanDocPreferencesProcessor pipedBeanDocPreferencesProcessor;
    private final PipedBeanPersonIdentifiersProcessor pipedBeanPersonIdentifiersProcessor;
    private final PipedBeanPersonProcessor pipedBeanPersonProcessor;

    private final CsvParser csvParserMerged;
    private final CsvParser csvParserBenefits;
    private final CsvParser csvParserCommPreferences;
    private final CsvParser csvParserContactMethods;
    private final CsvParser csvParserDocPreferences;
    private final CsvParser csvParserPersonIdentifiers;
    private final CsvParser csvParserPerson;

    public DataMapperService() {
        inboundConnector = connectorComponent.provideInboundSftpConnector();
        outboundConnector = connectorComponent.provideOutboundSftpConnector();
        dbConnector = connectorComponent.provideEppDb();

        pipedBeanParserProcessor = pipedBeanProcessorComponent.providePipedBeanEppRecordProcessor();
        pipedBeanMergedProcessor = pipedBeanProcessorComponent.providePipedBeanMergedProcessor();
        pipedBeanBenefitsProcessor = pipedBeanProcessorComponent.providePipedBeanBenefitsProcessor();
        pipedBeanCommPreferencesProcessor = pipedBeanProcessorComponent.providePipedBeanCommPreferencesProcessor();
        pipedBeanContactMethodsProcessor = pipedBeanProcessorComponent.providePipedBeanContactMethodsProcessor();
        pipedBeanDocPreferencesProcessor = pipedBeanProcessorComponent.providePipedBeanDocPreferencesProcessor();
        pipedBeanPersonIdentifiersProcessor = pipedBeanProcessorComponent.providePipedBeanPersonIdentifiersProcessor();
        pipedBeanPersonProcessor = pipedBeanProcessorComponent.providePipedBeanPersonProcessor();

        csvParserMerged = CsvParserFactory.getCsvParser(pipedBeanMergedProcessor);
        csvParserBenefits = CsvParserFactory.getCsvParser(pipedBeanBenefitsProcessor);
        csvParserCommPreferences = CsvParserFactory.getCsvParser(pipedBeanCommPreferencesProcessor);
        csvParserContactMethods = CsvParserFactory.getCsvParser(pipedBeanContactMethodsProcessor);
        csvParserDocPreferences = CsvParserFactory.getCsvParser(pipedBeanDocPreferencesProcessor);
        csvParserPersonIdentifiers = CsvParserFactory.getCsvParser(pipedBeanPersonIdentifiersProcessor);
        csvParserPerson = CsvParserFactory.getCsvParser(pipedBeanPersonProcessor);
    }

    @GET
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public String start() {
        //TODO Impement a Command Pattern and COR for sequencing the Loop.
        try {
            //1.Read the FTP files from REMOTE to local.
            inboundConnector.readInputFiles();
            //2.Perform Merge(table) of the files

            final File directory = new File(PropertiesFileLoader.loadProperties(null).getProperty(Connector
                    .MAPPED_DIRECTORY));
            final File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isFile()) {
                    log.info("Local file name: " + file.getName());
                    final Reader reader = new FileReader(file);
                    //TODO: Use better Switch & Enum handling...
                    if (FileTypes.Benefit.getName().equalsIgnoreCase(file.getName()))
                        csvParserBenefits.parse(reader);
                    else if (FileTypes.CommunicationPreferences.getName().equalsIgnoreCase(file.getName()))
                        csvParserCommPreferences.parse(reader);
                    else if (FileTypes.ContactMethods.getName().equalsIgnoreCase(file.getName()))
                        csvParserContactMethods.parse(reader);
                    else if (FileTypes.DocumentPreferences.getName().equalsIgnoreCase(file.getName()))
                        csvParserDocPreferences.parse(reader);
                    else if (FileTypes.PersonIdentifiers.getName().equalsIgnoreCase(file.getName()))
                        csvParserPersonIdentifiers.parse(reader);
                    else if (FileTypes.Person.getName().equalsIgnoreCase(file.getName()))
                        csvParserPerson.parse(reader);
                    reader.close();
                }
            }
            //Export the merge(table) to a file
            TableExport.callBashScript();

            //Read the file and Convert to Adobe format & Obfuscation with started excel encode.
            final File mergedDirectory = new File(PropertiesFileLoader.loadProperties(null).getProperty(Connector
                    .MERGED_DIRECTORY));
            final File[] mergedFileList = mergedDirectory.listFiles();
            for (File mergedFile : mergedFileList) {
                if (mergedFile.isFile()) {
                    log.info("Local merged file name: " + mergedFile.getName());
                    final Reader reader = new FileReader(mergedFile);
                    //TODO: Use better Switch & Enum handling...
                    if (FileTypes.Merged.getName().equalsIgnoreCase(mergedFile.getName()))
                        csvParserMerged.parse(reader);
                    reader.close();
                }
            }
            //Send FTP file from LOCAL to remote
            outboundConnector.writeOutputLine();
            return "{'status':'done'}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{'status':'failed'}";
        }
    }
}
