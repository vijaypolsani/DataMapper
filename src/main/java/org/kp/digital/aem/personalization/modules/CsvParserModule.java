package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.parser.PipedBeanCommPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanContactMethodsProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanDocPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanPersonProcessor;
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
    PipedBeanPersonProcessor pipedBeanPersonProcessor;
    @Inject
    PipedBeanCommPreferencesProcessor pipedBeanCommPreferencesProcessor;
    @Inject
    PipedBeanContactMethodsProcessor pipedBeanContactMethodsProcessor;
    @Inject
    PipedBeanDocPreferencesProcessor pipedBeanDocPreferencesProcessor;

    @Provides
    @Singleton
    @Named("PersonProcessor")
    com.univocity.parsers.csv.CsvParser provideBeanPersonProcessor() {
        return CsvParserFactory.getCsvParser(pipedBeanPersonProcessor);
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


}
