package com.mr.gof.behavioral.templatemethod;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * Created by Ramanovich on 1/14/2017.
 */
public class Digester {

  private static final  Random RANDOM = new SecureRandom();

  public static Digest calculateDigest(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

    int salt = createSalt();
    Digest digest = new Digest();
    digest.setSalt(salt);
    digest.setDigest(calculateDigest(password, salt));
    return digest;
  }

  public static String calculateDigest(String password, int salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    messageDigest.update(saltToString(salt));
    messageDigest.update(password.getBytes("UTF8"));
    return Base64.getEncoder().encodeToString(messageDigest.digest());
  }

  public static boolean validatePassword(String password, String digest, int salt) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    return calculateDigest(password, salt).equals(digest);
  }

  public static int createSalt() {
    byte[] sValue = new byte[4];
    RANDOM.nextBytes(sValue);
    int nValue = (((((sValue[3] << 8) | sValue[2]) << 8) | sValue[1]) << 8) | sValue[0];
    return Math.abs(nValue);
  }

  public static byte[] saltToString(int salt) {
    byte[] saltBytes = new byte[4];
    saltBytes[0] = (byte) (salt & 0xff);
    saltBytes[1] = (byte) (salt >> 8 & 0xff);
    saltBytes[2] = (byte) (salt >> 16 & 0xff);
    saltBytes[3] = (byte) (salt >> 24 & 0xff);
    return saltBytes;
  }

}
