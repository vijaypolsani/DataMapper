package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.connect.DbConnector;
import org.kp.digital.aem.personalization.connect.EppDb;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/4/15.
 */
@Module
public class ConnectorModule {

    @Provides
    @Singleton
    public InboundSftpConnector provideInboundSftpConnector() {
        return InboundSftpConnector.create();
    }

    @Provides
    @Singleton
    public OutboundSftpConnector provideOutboundSftpConnector() {
        return OutboundSftpConnector.create();
    }

    @Provides
    @Singleton
    public DbConnector provideEppDbConnector() {
        return new EppDb();
    }


}
