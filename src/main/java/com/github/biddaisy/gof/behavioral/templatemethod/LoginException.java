package com.github.biddaisy.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class LoginException extends Exception {

  public LoginException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoginException(Throwable cause) {
    super(cause);
  }
}
