package org.kp.digital.aem.personalization.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by vijay on 11/12/15.
 */
@Slf4j
public class TableExport {
    private static final String PROPERTIES_LOCATION = "/Users/vijay/research/datamapper/config";
    private static final String FILE_NAME = "export_db_csv.sh";

    private static final String SCRIPT_LOCATION = PROPERTIES_LOCATION + "/" + FILE_NAME;
    private static final String SCRIPT_SHELL = "/bin/sh";

    public static boolean callBashScript() {
        log.info("Script location: " + SCRIPT_LOCATION);
        final String[] cmd = new String[]{SCRIPT_SHELL, SCRIPT_LOCATION};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            log.info("Exit value of the process : " + process.exitValue());
            if (process.exitValue() == 0) {
                process.destroy();
                return true;
            } else {
                process.destroy();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            process.destroy();
            return false;
        }
    }
}
