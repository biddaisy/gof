package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class Digest {

  private String digest;

  private int salt;

  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public int getSalt() {
    return salt;
  }

  public void setSalt(int salt) {
    this.salt = salt;
  }
}
