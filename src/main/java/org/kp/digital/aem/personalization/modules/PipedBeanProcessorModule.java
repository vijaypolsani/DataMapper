package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.model.*;
import org.kp.digital.aem.personalization.parser.*;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/4/15.
 */
@Module
public class PipedBeanProcessorModule {

    @Provides
    @Singleton
    public PipedBeanEppRecordProcessor providePipedBeanEppRecordProcessor(DbConnector dbConnector) {
        return new PipedBeanEppRecordProcessor(EppRecord.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanMergedProcessor providePipedBeanMergedProcessor() {
        return new PipedBeanMergedProcessor(EppRecord.class);
    }

    @Provides
    @Singleton
    public PipedBeanBenefitsProcessor providePipedBeanBenefitsProcessor(DbConnector dbConnector) {
        return new PipedBeanBenefitsProcessor(EppBenefits.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanCommPreferencesProcessor providePipedBeanCommPreferencesProcessor(DbConnector dbConnector) {
        return new PipedBeanCommPreferencesProcessor(EppCommunicationPreferences.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanContactMethodsProcessor providePipedBeanContactMethodsProcessor(DbConnector dbConnector) {
        return new PipedBeanContactMethodsProcessor(EppContactMethods.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanDocPreferencesProcessor providePipedBeanDocPreferencesProcessor(DbConnector dbConnector) {
        return new PipedBeanDocPreferencesProcessor(EppDocumentPreferences.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanPersonIdentifiersProcessor providePipedBeanPersonIdentifiersProcessor(DbConnector dbConnector) {
        return new PipedBeanPersonIdentifiersProcessor(EppPersonIdentifiers.class, dbConnector);
    }

    @Provides
    @Singleton
    public PipedBeanPersonProcessor providePipedBeanPersonProcessor(DbConnector dbConnector) {
        return new PipedBeanPersonProcessor(EppPerson.class, dbConnector);
    }

}

