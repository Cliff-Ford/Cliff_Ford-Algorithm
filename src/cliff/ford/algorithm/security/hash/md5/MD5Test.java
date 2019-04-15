package cliff.ford.algorithm.security.hash.md5;

import org.junit.Test;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author Cliff_Ford
 */
public class MD5Test {
    @Test
    public void test() throws NoSuchAlgorithmException {
        //https://zhuanlan.zhihu.com/p/37257569
        //https://baike.baidu.com/item/MD5
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        System.out.println(MD5.encryption("12345"));
        md5.update("12345".getBytes());
        System.out.println(String.format("%032x", new BigInteger(1, md5.digest())));

        System.out.println(MD5.encryption(""));
        md5.update("".getBytes());
        System.out.println(String.format("%032x", new BigInteger(1, md5.digest())));


        System.out.println(MD5.encryption("adsfsd"));
        md5.update("adsfsd".getBytes());
        System.out.println(String.format("%032x", new BigInteger(1, md5.digest())));

    }
}
