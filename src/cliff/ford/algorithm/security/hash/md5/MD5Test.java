package cliff.ford.algorithm.security.hash.md5;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class MD5Test {
    @Test
    public void test(){
        System.out.println(MD5.encryption("12345"));
        System.out.println(MD5.encryption("12345"));
        System.out.println(MD5.encryption("123"));
    }
}
