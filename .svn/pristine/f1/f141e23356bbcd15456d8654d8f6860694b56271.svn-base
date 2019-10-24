package com.netcracker.tc.server.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);

    public static String hash(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            LOGGER.error("Error while hashing password: " + password, e);
        }

        return password;
    }
    public static String decodeMail() {
        String encodedPass = "XXX";
        StandardPBEStringEncryptor textEncryptor = new StandardPBEStringEncryptor();
        textEncryptor.setPassword("XXX");
        String pass = textEncryptor.decrypt(encodedPass);

        return pass;

    }

}
