package org.kp.digital.aem.personalization.service;

import com.univocity.parsers.csv.CsvParser;
import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.*;
import org.kp.digital.aem.personalization.model.*;
import org.kp.digital.aem.personalization.parser.*;
import org.kp.digital.aem.personalization.util.CsvParserConfig;
import org.kp.digital.aem.personalization.util.FileTypes;
import org.kp.digital.aem.personalization.util.PropertiesFileLoader;
import org.kp.digital.aem.personalization.util.TableExport;

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

    //TODO: Encapulate all the below in a factory. Shortcuts for POC.
    //private final PipedFileEppRecordProcessor pipedFileEppRecordProcessor = new PipedFileEppRecordProcessor(dbConnector);
    private final PipedBeanEppRecordProcessor pipedBeanParserProcessor = new PipedBeanEppRecordProcessor(EppRecord.class, dbConnector);
    private final PipedBeanMergedProcessor pipedBeanMergedProcessor = new PipedBeanMergedProcessor(EppRecord.class);
    private final PipedBeanBenefitsProcessor pipedBeanBenefitsProcessor = new PipedBeanBenefitsProcessor(EppBenefits.class, dbConnector);
    private final PipedBeanCommPreferencesProcessor pipedBeanCommPreferencesProcessor = new PipedBeanCommPreferencesProcessor(EppCommunicationPreferences.class, dbConnector);
    private final PipedBeanContactMethodsProcessor pipedBeanContactMethodsProcessor = new PipedBeanContactMethodsProcessor(EppContactMethods.class, dbConnector);
    private final PipedBeanDocPreferencesProcessor pipedBeanDocPreferencesProcessor = new PipedBeanDocPreferencesProcessor(EppDocumentPreferences.class, dbConnector);
    private final PipedBeanPersonIdentifiersProcessor pipedBeanPersonIdentifiersProcessor = new PipedBeanPersonIdentifiersProcessor(EppPersonIdentifiers.class, dbConnector);
    private final PipedBeanPersonProcessor pipedBeanPersonProcessor = new PipedBeanPersonProcessor(EppPerson.class, dbConnector);

    //TODO: Dagger inject
    private final CsvParser csvParserMerged = new CsvParserConfig(pipedBeanMergedProcessor).getCsvParser();
    private final CsvParser csvParserBenefits = new CsvParserConfig(pipedBeanBenefitsProcessor).getCsvParser();
    private final CsvParser csvParserCommPreferences = new CsvParserConfig(pipedBeanCommPreferencesProcessor).getCsvParser();
    private final CsvParser csvParserContactMethods = new CsvParserConfig(pipedBeanContactMethodsProcessor).getCsvParser();
    private final CsvParser csvParserDocPreferences = new CsvParserConfig(pipedBeanDocPreferencesProcessor).getCsvParser();
    private final CsvParser csvParserPersonIdentifiers = new CsvParserConfig(pipedBeanPersonIdentifiersProcessor).getCsvParser();
    private final CsvParser csvParserPerson = new CsvParserConfig(pipedBeanPersonProcessor).getCsvParser();

    public DataMapperService() {
    }

    @POST
    @Path("/start")
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
            final File mergedDirectory = new File(PropertiesFileLoader.loadProperties(null).getProperty(Connector.MERGED_DIRECTORY));
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
