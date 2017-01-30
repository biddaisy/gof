package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 1/23/2017.
 */
public class TokenUser extends User {

    private String tokenId;

    public TokenUser(String userId) {
        super (userId);
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
