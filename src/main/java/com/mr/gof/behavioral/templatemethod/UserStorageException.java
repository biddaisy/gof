package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class UserStorageException extends Exception {

  public UserStorageException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserStorageException(Throwable cause) {
    super(cause);
  }

}
