package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public abstract class Login {

    public final LoginResult login() throws LoginException {
        Credential credential = fetchCredentials();
        logCredentials();
        LoginResult loginResult = authenticate(credential);
        logAuthentication(loginResult);
        postAuthentication(loginResult);
        return loginResult;
    }

    private void logAuthentication(LoginResult loginResult) {

    }

    private void logCredentials() {
    }

    public abstract void postAuthentication(LoginResult loginResult);

    public abstract LoginResult authenticate(Credential credential) throws LoginException;

    public abstract Credential fetchCredentials();
}
