package org.kp.digital.aem.personalization.service;

import lombok.extern.slf4j.Slf4j;
import org.kp.digital.aem.personalization.connect.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by prokarma on 11/2/15.
 */
@Slf4j
@Path("/datamapper")
public class DataMapperService {
    //TODO Dagger Injection
    private final DbConnector dbConnector = new EppDbConnector();
    private final Connector inboundConnector = new InboundSftpConnector().create();
    private final Connector outboundConnector = new OutboundSftpConnector().create();

    @POST
    @Path("start")
    @Produces(MediaType.APPLICATION_JSON)
    public void start() {
    }

}
