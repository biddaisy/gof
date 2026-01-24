package com.mr.gof.behavioral.templatemethod;

import com.mr.gof.Logger;

/**
 * Created by Ramanovich on 1/23/2017.
 */
public class Test {

  public static void main(String[] args) {

    try {
      UserStorage.getInstance().initialize();
    }
    catch (UserStorageException e) {
      e.printStackTrace();
    }

    String login = "login1";
    String password = /* "wrong" + */"password1";

    PasswordLogin passwordLogin = new PasswordLogin(login, password);

    try {
      LoginResult loginResult = passwordLogin.login();
      Logger.log(loginResult.name());
    }
    catch (LoginException e) {
      e.printStackTrace();
    }

    login = "login7";
    int token = 2;

    TokenLogin tokenLogin = new TokenLogin(login, token);

    try {
      LoginResult loginResult = tokenLogin.login();
      Logger.log(loginResult.name());
    }
    catch (LoginException e) {
      e.printStackTrace();
    }
  }
}
