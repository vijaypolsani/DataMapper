package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.dao.EppDao;
import org.kp.digital.aem.personalization.model.EppCommunicationPreferences;
import org.kp.digital.aem.personalization.model.EppContactMethods;
import org.kp.digital.aem.personalization.model.EppDocumentPreferences;
import org.kp.digital.aem.personalization.model.EppPerson;
import org.kp.digital.aem.personalization.parser.PipedBeanCommPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanContactMethodsProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanDocPreferencesProcessor;
import org.kp.digital.aem.personalization.parser.PipedBeanPersonProcessor;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/4/15.
 */
@Module
public class PipedBeanProcessorModule {

    @Provides
    @Singleton
    public PipedBeanPersonProcessor providePipedBeanPersonProcessor(EppDao eppDao) {
        return new PipedBeanPersonProcessor(EppPerson.class, eppDao);
    }

    @Provides
    @Singleton
    public PipedBeanCommPreferencesProcessor providePipedBeanCommPreferencesProcessor(EppDao eppDao) {
        return new PipedBeanCommPreferencesProcessor(EppCommunicationPreferences.class, eppDao);
    }

    @Provides
    @Singleton
    public PipedBeanContactMethodsProcessor providePipedBeanContactMethodsProcessor(EppDao eppDao) {
        return new PipedBeanContactMethodsProcessor(EppContactMethods.class, eppDao);
    }

    @Provides
    @Singleton
    public PipedBeanDocPreferencesProcessor providePipedBeanDocPreferencesProcessor(EppDao eppDao) {
        return new PipedBeanDocPreferencesProcessor(EppDocumentPreferences.class, eppDao);
    }

}

