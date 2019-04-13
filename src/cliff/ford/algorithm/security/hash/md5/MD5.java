package cliff.ford.algorithm.security.hash.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Cliff_Ford
 */
public class MD5 {
    public static String encryption(String message){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(message.getBytes());
            return Arrays.toString(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
