package org.kp.digital.aem.personalization.connect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by vijay on 11/5/15.
 */
@Slf4j
public class InboundSftpConnector implements Connector {
    //Connection specific to INBOOUND
    private static final FTPClient ftp = new FTPClient();
    private static final FTPClientConfig ftpClientConfig = new FTPClientConfig();

    private static InboundSftpConnector inboundSftpConnector = null;

    public InboundSftpConnector() {
        ftp.configure(ftpClientConfig);
    }

    public static InboundSftpConnector create() {
        //new ftp client
        //TODO: Use Dagger to inject the instance
        if (inboundSftpConnector == null)
            inboundSftpConnector = new InboundSftpConnector();
        return inboundSftpConnector;
    }

    public static void destroy() {
        inboundSftpConnector = null;
    }

    public void readInputFiles() throws IOException {
        ftp.connect(properties.getProperty(SERVER_ADDRESS), Integer.decode(properties.getProperty(PORT)));
        //login to server
        if (!ftp.login(properties.getProperty(USERID), properties.getProperty(PASSWORD))) {
            log.info("Logged in failed...");
            ftp.logout();
            return;
        }
        int reply = ftp.getReplyCode();
        //FTPReply stores a set of constants for FTP reply codes.
        if (!FTPReply.isPositiveCompletion(reply)) {
            log.info("Relay code in not positive...");
            ftp.disconnect();
            return;
        }
        log.info("Relay code :" + reply + " . Server logged-in successfully.");
        //enter passive mode
        ftp.enterLocalPassiveMode();
        //Set file type to binary
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        //get system name
        log.info("Remote system is " + ftp.getSystemType());
        //change current directory
        ftp.changeWorkingDirectory(properties.getProperty(LOCAL_DIRECTORY));
        log.info("Current FTP working Local directory is " + ftp.printWorkingDirectory());
        //get list of filenames
        FTPFile[] ftpFiles = ftp.listFiles();
        log.info("List of Local directory is " + Arrays.toString(ftpFiles));
        if (ftpFiles != null && ftpFiles.length > 0) {
            //loop thru files
            for (FTPFile file : ftpFiles) {
                if (!file.isFile()) {
                    continue;
                }
                log.info("File is " + file.getName());
                //get output stream

                final OutputStream outputStream = new FileOutputStream(properties.getProperty(MAPPED_DIRECTORY) + "/"
                        + file.getName());
                //get the file from the remote system
                ftp.retrieveFile(file.getName(), outputStream);
                //close output stream
                log.info("The file is uploaded successfully. " + file);
                outputStream.close();
            }
            //TODO: Cleanup/Backup the files after reading.
        }
        ftp.logout();
        ftp.disconnect();
        //return null;
        //Finally () close the connection or use Try with()
    }
}
