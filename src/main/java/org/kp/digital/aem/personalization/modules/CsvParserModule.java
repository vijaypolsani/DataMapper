package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.parser.*;
import org.kp.digital.aem.personalization.util.CsvParserFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by vijay on 12/10/15.
 */
@Module
public class CsvParserModule {

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


    @Provides
    @Singleton
    @Named("MergedProcessor")
    com.univocity.parsers.csv.CsvParser providePipedBeanMergedCsvParser() {
        return CsvParserFactory.getCsvParser(pipedBeanMergedProcessor);
    }

    @Provides
    @Singleton
    @Named("BenefitsProcessor")
    com.univocity.parsers.csv.CsvParser providePipedBeanBenefitsProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanBenefitsProcessor);
    }

    @Provides
    @Singleton
    @Named("CommPreferencesProcessor")
    com.univocity.parsers.csv.CsvParser providePipedBeanCommPreferencesProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanCommPreferencesProcessor);
    }

    @Provides
    @Singleton
    @Named("ContactMethodsProcessor")
    com.univocity.parsers.csv.CsvParser provideBeanContactMethodsProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanContactMethodsProcessor);
    }

    @Provides
    @Singleton
    @Named("DocPreferencesProcessor")
    com.univocity.parsers.csv.CsvParser provideBeanDocPreferencesProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanDocPreferencesProcessor);
    }

    @Provides
    @Singleton
    @Named("PersonIdentifiersProcessor")
    com.univocity.parsers.csv.CsvParser provideBeanPersonIdentifiersProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanPersonIdentifiersProcessor);
    }

    @Provides
    @Singleton
    @Named("PersonProcessor")
    com.univocity.parsers.csv.CsvParser provideBeanPersonProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanPersonProcessor);
    }

}
