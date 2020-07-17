package com.mr.gof.behavioral.templatemethod;

import static com.mr.gof.behavioral.templatemethod.LoginResult.*;

/**
 * Created by Ramanovich on 5/13/2017.
 */
public class TokenLogin extends Login {

  private String loginName;

  private int token;

  public TokenLogin(String loginName, int token) {
    this.loginName = loginName;
    this.token = token;
  }

  @Override protected void postAuthentication(LoginResult loginResult) {
    System.out.printf("TokenLogin.postAuthentication: %s%n", loginResult);
  }

  @Override protected LoginResult authenticate(Credential credential) throws LoginException {
    TokenCredential tokenCredentials = (TokenCredential) credential;
    TokenUser user = (TokenUser) UserStorage.getInstance().findUserByLoginName(tokenCredentials.getLoginName());
    if (user == null) {
      return WRONG_LOGIN_NAME;
    }
    int token = TokenService.getTokenService().getToken(user.getTokenId());

    if (token == tokenCredentials.getToken()) {
      return SUCCESSFUL;
    }
    else {
      return FAILED;
    }
  }

  @Override protected Credential fetchCredentials() {
    TokenCredential credentials = new TokenCredential();
    credentials.setLoginName(loginName);
    credentials.setToken(token);
    return credentials;
  }
}
