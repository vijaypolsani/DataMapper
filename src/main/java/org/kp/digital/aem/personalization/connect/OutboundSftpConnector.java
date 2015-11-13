package org.kp.digital.aem.personalization.connect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * Created by vijay on 11/5/15.
 */
@Slf4j
public class OutboundSftpConnector implements Connector {
    //Connection specific to outbound
    private static final FTPClient ftp = new FTPClient();
    private static final byte[] bytesIn = new byte[4096];
    private static OutboundSftpConnector outboundSftpConnector = null;


    public OutboundSftpConnector() {
        super();
    }

    public static OutboundSftpConnector create() {
        //new ftp client
        //TODO: Use Dagger to inject the instance. Or atleast use Holder for singleton
        if (outboundSftpConnector == null)
            outboundSftpConnector = new OutboundSftpConnector();
        return outboundSftpConnector;
    }

    public static void destroy() {
        outboundSftpConnector = null;
    }

    public void writeOutputLine() throws IOException {
        //try to connect
        ftp.connect(properties.getProperty(SERVER_ADDRESS));
        //login to server
        if (!ftp.login(properties.getProperty(USERID), properties.getProperty(PASSWORD))) {
            ftp.logout();
            //return false;
        }
        int reply = ftp.getReplyCode();
        //FTPReply stores a set of constants for FTP reply codes.
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            //return false;
        }

        //enter passive mode
        ftp.enterLocalPassiveMode();
        //Set file type to binary
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        //get system name
        log.info("Remote system is " + ftp.getSystemType());
        //change current directory
        ftp.changeWorkingDirectory(properties.getProperty(SEND_DIRECTORY));
        log.info("Current directory is " + ftp.printWorkingDirectory());

        //Reading from local TEMP file
        File directory = new File(properties.getProperty(SEND_DIRECTORY));

        //get all the files from a directory (Not FTP)
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                log.info("Local file name: " + file.getName());
                InputStream inputStream = new FileInputStream(file);
                log.info("Start uploading the file.");
                OutputStream outputStream = ftp.storeFileStream(properties.getProperty(REMOTE_DIRECTORY) + "/" + file.getName());
                int read = 0;
                while ((read = inputStream.read(bytesIn)) != -1) {
                    outputStream.write(bytesIn, 0, read);
                }
                inputStream.close();
                outputStream.close();
            }
        }
        ftp.logout();
        ftp.disconnect();
        //return null;
        //finally() close.
    }
}
