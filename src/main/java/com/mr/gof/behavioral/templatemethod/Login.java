package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public abstract class Login {

    public final LoginResult login() throws LoginException {
        Credential credential = fetchCredentials();
        logCredential (credential);
        LoginResult loginResult = authenticate(credential);
        logAuthentication(loginResult);
        postAuthentication(loginResult);
        return loginResult;
    }

    private void logAuthentication(LoginResult loginResult) {
        System.out.println ("login result : " + loginResult);
    }

    private void logCredential(Credential credential) {
        System.out.println ("login : " + credential.getLoginName ());
    }

    protected abstract void postAuthentication(LoginResult loginResult);

    protected abstract LoginResult authenticate(Credential credential) throws LoginException;

    protected abstract Credential fetchCredentials();
}
