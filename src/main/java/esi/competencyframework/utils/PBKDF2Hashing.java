package esi.competencyframework.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PBKDF2Hashing {
  public static String hashPassword(String password) throws Exception {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);

    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

    byte[] hash = factory.generateSecret(spec).getEncoded();
    return Base64.getEncoder().encodeToString(hash);
  }

  public static boolean verifyPassword(String inputPassword, String storedHash, byte[] salt, int iterationCount, int keyLength) throws Exception {
    KeySpec spec = new PBEKeySpec(inputPassword.toCharArray(), salt, iterationCount, keyLength);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

    byte[] hash = factory.generateSecret(spec).getEncoded();
    String newHash = Base64.getEncoder().encodeToString(hash);

    return newHash.equals(storedHash);
  }
}
