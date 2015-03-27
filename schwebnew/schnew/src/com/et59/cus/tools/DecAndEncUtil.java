package com.et59.cus.tools;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DecAndEncUtil
{
  public static String base64Encode(byte[] bstr)
  {
    return new BASE64Encoder().encode(bstr);
  }

  public static byte[] base64Decode(String str)
  {
    byte[] bt = null;
    try {
      BASE64Decoder decoder = new BASE64Decoder();
      bt = decoder.decodeBuffer(str);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return bt;
  }

  public static String encryptedData(byte[] plainData, byte[] key)
  {
    DESKeySpec dks = null;
    try {
      dks = new DESKeySpec(key);
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }
    SecureRandom sr = new SecureRandom();
    SecretKeyFactory keyFactory = null;
    try {
      keyFactory = SecretKeyFactory.getInstance("DES");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    SecretKey secretKey = null;
    try {
      secretKey = keyFactory.generateSecret(dks);
    } catch (InvalidKeySpecException e) {
      e.printStackTrace();
    }
    Cipher cipher = null;
    try {
      cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    }
    try {
      cipher.init(1, secretKey, sr);
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }
    byte[] encryptedData = null;
    try {
      encryptedData = cipher.doFinal(plainData);
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    }
    catch (BadPaddingException e) {
      e.printStackTrace();
    }

    String encryptedStr = base64Encode(encryptedData);
    return encryptedStr;
  }

  public static String decryptedData(String encryptedStr, byte[] key)
  {
    byte[] encryptedData = base64Decode(encryptedStr);

    SecureRandom sr = new SecureRandom();

    DESKeySpec dks = null;
    try {
      dks = new DESKeySpec(key);
    } catch (InvalidKeyException e4) {
      e4.printStackTrace();
    }
    SecretKeyFactory keyFactory = null;
    try {
      keyFactory = SecretKeyFactory.getInstance("DES");
    } catch (NoSuchAlgorithmException e3) {
      e3.printStackTrace();
    }
    SecretKey secretKey = null;
    try {
      secretKey = keyFactory.generateSecret(dks);
    } catch (InvalidKeySpecException e3) {
      e3.printStackTrace();
    }
    Cipher cipher = null;
    try {
      cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    } catch (NoSuchAlgorithmException e2) {
      e2.printStackTrace();
    } catch (NoSuchPaddingException e2) {
      e2.printStackTrace();
    }
    try {
      cipher.init(2, secretKey, sr);
    } catch (InvalidKeyException e1) {
      e1.printStackTrace();
    }
    byte[] decryptedData = null;
    try {
      decryptedData = cipher.doFinal(encryptedData);
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    }

    String plainStr = new String(decryptedData);
    return plainStr;
  }

  public static void main(String[] args)
  {
    String str = "sajdasldjasd4a655465656a5s6d5a6s5da6s5d6a5s6d5as";
    String key = "123456789";
    String sss = encryptedData(str.getBytes(), key.getBytes());
    System.out.println("jiamishuju:"+sss);
    String decstr = decryptedData(sss, key.getBytes());
    System.out.println(decstr);
    if (decstr.equals(str))
      System.out.println("success");
    else
      System.out.println("fail");
  }
}