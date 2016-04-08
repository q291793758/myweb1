package cn.itcast.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//密码加密  md5-->BASE64-->密码
public class ServiceUtils {
    public static String codingPassword(String password) {
        try {
            byte[] md5s = MessageDigest.getInstance("md5").digest(password.getBytes());
            String encode = BASE64Encoder.class.newInstance().encode(md5s);
            return encode;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
