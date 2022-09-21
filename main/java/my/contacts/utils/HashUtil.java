package my.contacts.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

    public static String passwordToHash(String password){
        return DigestUtils.sha256Hex(password);
    }
}
