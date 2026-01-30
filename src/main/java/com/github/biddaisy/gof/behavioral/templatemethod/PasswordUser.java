package com.github.biddaisy.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/23/2017.
 */
public class PasswordUser extends User {

  private String passwordDigest;

  private int salt;

  public PasswordUser(String userId) {
    super(userId);
  }

  public String getPasswordDigest() {
    return passwordDigest;
  }

  public void setPasswordDigest(String passwordDigest) {
    this.passwordDigest = passwordDigest;
  }

  public int getSalt() {
    return salt;
  }

  public void setSalt(int salt) {
    this.salt = salt;
  }
}
