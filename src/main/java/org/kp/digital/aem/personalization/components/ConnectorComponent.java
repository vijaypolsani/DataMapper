package org.kp.digital.aem.personalization.components;

import dagger.Component;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;
import org.kp.digital.aem.personalization.modules.ConnectorModule;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/8/15.
 */
@Singleton
@Component(modules = {ConnectorModule.class})
public interface ConnectorComponent {
    InboundSftpConnector provideInboundSftpConnector();

    OutboundSftpConnector provideOutboundSftpConnector();

    DbConnector provideEppDb();
}
