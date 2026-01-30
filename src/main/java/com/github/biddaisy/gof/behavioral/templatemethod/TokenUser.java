package com.github.biddaisy.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/23/2017.
 */
public class TokenUser extends User {

  private int tokenId;

  public TokenUser(String userId) {
    super(userId);
  }

  public int getTokenId() {
    return tokenId;
  }

  public void setTokenId(int tokenId) {
    this.tokenId = tokenId;
  }
}
