package com.github.biddaisy.gof.behavioral.templatemethod;

import static com.github.biddaisy.gof.behavioral.templatemethod.LoginResult.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class PasswordLogin extends Login {

  private final String loginName;

  private final String password;

  public PasswordLogin(String loginName, String password) {
    this.loginName = loginName;
    this.password = password;
  }

  @Override
  public void postAuthentication(LoginResult loginResult) {
    System.out.printf("PasswordLogin.postAuthentication: %s%n", loginResult);
  }

  @Override
  public LoginResult authenticate(Credential credential) throws LoginException {
    PasswordCredential passwordCredentials = (PasswordCredential) credential;
    PasswordUser user = (PasswordUser) UserStorage.getInstance().findUserByLoginName(passwordCredentials.getLoginName());
    if (user == null) {
      return WRONG_LOGIN_NAME;
    }
    boolean authenticated;
    try {
      authenticated = Digester.validatePassword(passwordCredentials.getPassword(), user.getPasswordDigest(), user.getSalt());
    }
    catch (UnsupportedEncodingException e) {
      throw new LoginException(e);
    }
    catch (NoSuchAlgorithmException e) {
      throw new LoginException(e);
    }
    if (authenticated) {
      return SUCCESSFUL;
    }
    else {
      return FAILED;
    }

  }

  @Override
  public Credential fetchCredentials() {
    PasswordCredential passwordCredentials = new PasswordCredential();
    passwordCredentials.setLoginName(loginName);
    passwordCredentials.setPassword(password);
    return passwordCredentials;
  }
}
