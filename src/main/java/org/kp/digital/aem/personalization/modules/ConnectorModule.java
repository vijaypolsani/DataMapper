package org.kp.digital.aem.personalization.modules;

import dagger.Module;
import dagger.Provides;
import org.kp.digital.aem.personalization.connect.InboundSftpConnector;
import org.kp.digital.aem.personalization.connect.OutboundSftpConnector;
import org.kp.digital.aem.personalization.dao.EppDao;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/4/15.
 */
@Module
public class ConnectorModule {

    @Provides
    @Singleton
    public InboundSftpConnector provideInboundSftpConnector() {
        return new InboundSftpConnector();
    }

    @Provides
    @Singleton
    public OutboundSftpConnector provideOutboundSftpConnector() {
        return new OutboundSftpConnector();
    }

    @Provides
    @Singleton
    public EppDao provideEppDao() {
        return new EppDao();
    }


}
