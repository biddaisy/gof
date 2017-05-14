package com.mr.gof.behavioral.templatemethod;

/**
 * Created by Ramanovich on 5/13/2017.
 */
public class TokenService {

    private static TokenService tokenService = new TokenService();

    public static TokenService getTokenService(){
        return tokenService;
    }


    public int getToken( int tokenId ){
        switch (tokenId){
            case 1: return tokenId % 2;
            case 2: return tokenId % 3;
            case 3: return tokenId % 10;
        }
        return -1;
    }
}
