package com.github.biddaisy.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class User {

  private String userId;

  private String loginName;

  public User(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

}
