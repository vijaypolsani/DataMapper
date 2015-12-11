package org.kp.digital.aem.personalization.components;

import dagger.Component;
import org.kp.digital.aem.personalization.modules.ConnectorModule;
import org.kp.digital.aem.personalization.modules.PipedBeanProcessorModule;
import org.kp.digital.aem.personalization.parser.*;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/8/15.
 */
@Singleton
@Component(modules = {PipedBeanProcessorModule.class, ConnectorModule.class})
public interface PipedBeanProcessorComponent {
    PipedBeanEppRecordProcessor providePipedBeanEppRecordProcessor();

    PipedBeanMergedProcessor providePipedBeanMergedProcessor();

    PipedBeanBenefitsProcessor providePipedBeanBenefitsProcessor();

    PipedBeanCommPreferencesProcessor providePipedBeanCommPreferencesProcessor();

    PipedBeanContactMethodsProcessor providePipedBeanContactMethodsProcessor();

    PipedBeanDocPreferencesProcessor providePipedBeanDocPreferencesProcessor();

    PipedBeanPersonIdentifiersProcessor providePipedBeanPersonIdentifiersProcessor();

    PipedBeanPersonProcessor providePipedBeanPersonProcessor();

}
