package todoapp.config.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin123";

    /**
     * Validates user credentials by comparing them to the default username and password.
     *
     * @param username the entered username
     * @param password the entered password
     * @return true if the credentials are valid, otherwise false
     */
    public Boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}