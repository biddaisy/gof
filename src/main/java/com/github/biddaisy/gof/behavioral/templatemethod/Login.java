package com.github.biddaisy.gof.behavioral.templatemethod;

import com.github.biddaisy.gof.Logger;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public abstract class Login {

  public final LoginResult login() throws LoginException {
    Credential credential = fetchCredentials();
    logCredential(credential);
    LoginResult loginResult = authenticate(credential);
    logAuthentication(loginResult);
    postAuthentication(loginResult);
    return loginResult;
  }

  private void logAuthentication(LoginResult loginResult) {
    Logger.log("login result : " + loginResult);
  }

  private void logCredential(Credential credential) {
    Logger.log("login : " + credential.getLoginName());
  }

  protected abstract void postAuthentication(LoginResult loginResult);

  protected abstract LoginResult authenticate(Credential credential) throws LoginException;

  protected abstract Credential fetchCredentials();
}
