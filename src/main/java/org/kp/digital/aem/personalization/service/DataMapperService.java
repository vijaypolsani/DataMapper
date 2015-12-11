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
import org.kp.digital.aem.personalization.util.FileTypes;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;
import org.kp.digital.aem.personalization.util.TableExport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
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
    //Dagger2 Injection
    @Inject
    InboundSftpConnector inboundConnector;
    @Inject
    OutboundSftpConnector outboundConnector;
    @Inject
    DbConnector dbConnector;
    //@Inject
    //private final PipedFileEppRecordProcessor pipedFileEppRecordProcessor = new PipedFileEppRecordProcessor
    // (dbConnector);
    @Inject
    PipedBeanEppRecordProcessor pipedBeanParserProcessor;
    @Inject
    PipedBeanMergedProcessor pipedBeanMergedProcessor;
    @Inject
    PipedBeanBenefitsProcessor pipedBeanBenefitsProcessor;
    @Inject
    PipedBeanCommPreferencesProcessor pipedBeanCommPreferencesProcessor;
    @Inject
    PipedBeanContactMethodsProcessor pipedBeanContactMethodsProcessor;
    @Inject
    PipedBeanDocPreferencesProcessor pipedBeanDocPreferencesProcessor;
    @Inject
    PipedBeanPersonIdentifiersProcessor pipedBeanPersonIdentifiersProcessor;
    @Inject
    PipedBeanPersonProcessor pipedBeanPersonProcessor;
    @Inject
    @Named("MergedProcessor")
    CsvParser csvParserMerged;
    @Inject
    @Named("BenefitsProcessor")
    CsvParser csvParserBenefits;
    @Inject
    @Named("CommPreferencesProcessor")
    CsvParser csvParserCommPreferences;
    @Inject
    @Named("ContactMethodsProcessor")
    CsvParser csvParserContactMethods;
    @Inject
    @Named("DocPreferencesProcessor")
    CsvParser csvParserDocPreferences;
    @Inject
    @Named("PersonIdentifiersProcessor")
    CsvParser csvParserPersonIdentifiers;
    @Inject
    @Named("PersonProcessor")
    CsvParser csvParserPerson;

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

        /*
        csvParserMerged = CsvParserFactory.getCsvParser(pipedBeanMergedProcessor);
        csvParserBenefits = CsvParserFactory.getCsvParser(pipedBeanBenefitsProcessor);
        csvParserCommPreferences = CsvParserFactory.getCsvParser(pipedBeanCommPreferencesProcessor);
        csvParserContactMethods = CsvParserFactory.getCsvParser(pipedBeanContactMethodsProcessor);
        csvParserDocPreferences = CsvParserFactory.getCsvParser(pipedBeanDocPreferencesProcessor);
        csvParserPersonIdentifiers = CsvParserFactory.getCsvParser(pipedBeanPersonIdentifiersProcessor);
        csvParserPerson = CsvParserFactory.getCsvParser(pipedBeanPersonProcessor);
        */

    }

    /*
        public DataMapperService() {
            inboundConnector = InboundSftpConnector.create();
            outboundConnector = OutboundSftpConnector.create();
            dbConnector = new EppDb();

            pipedBeanParserProcessor = new PipedBeanEppRecordProcessor(EppRecord.class, dbConnector);
            pipedBeanMergedProcessor = new PipedBeanMergedProcessor(EppRecord.class);
            pipedBeanBenefitsProcessor = new PipedBeanBenefitsProcessor(EppBenefits.class, dbConnector);
            pipedBeanCommPreferencesProcessor = new PipedBeanCommPreferencesProcessor(EppCommunicationPreferences
            .class, dbConnector);
            pipedBeanContactMethodsProcessor = new PipedBeanContactMethodsProcessor(EppContactMethods.class,
            dbConnector);
            pipedBeanDocPreferencesProcessor = new PipedBeanDocPreferencesProcessor(EppDocumentPreferences.class,
            dbConnector);
            pipedBeanPersonIdentifiersProcessor = new PipedBeanPersonIdentifiersProcessor(EppPersonIdentifiers.class,
             dbConnector);
            pipedBeanPersonProcessor = new PipedBeanPersonProcessor(EppPerson.class, dbConnector);

            csvParserMerged = new CsvParserFactory(pipedBeanMergedProcessor).getCsvParser();
            csvParserBenefits = new CsvParserFactory(pipedBeanBenefitsProcessor).getCsvParser();
            csvParserCommPreferences = new CsvParserFactory(pipedBeanCommPreferencesProcessor).getCsvParser();
            csvParserContactMethods = new CsvParserFactory(pipedBeanContactMethodsProcessor).getCsvParser();
            csvParserDocPreferences = new CsvParserFactory(pipedBeanDocPreferencesProcessor).getCsvParser();
            csvParserPersonIdentifiers = new CsvParserFactory(pipedBeanPersonIdentifiersProcessor).getCsvParser();
            csvParserPerson = new CsvParserFactory(pipedBeanPersonProcessor).getCsvParser();
        }
    */
    @POST
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public void start() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
