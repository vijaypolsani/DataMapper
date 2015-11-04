package org.kp.digital.aem.personalization.poc;

/**
 * Created by prokarma on 11/2/15.
 */

public class BackendService {
    private User user;

    public BackendService(User user) {
        this.user = user;
    }

    public boolean callServer() {
        if (user != null) {
            return true;
        }
        return false;
    }
}
