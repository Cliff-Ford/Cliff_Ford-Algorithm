package cliff.ford.algorithm.search.linear;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class LinearSearchTest {
    @Test
    public void test(){
        LinearSearch linearSearch = new LinearSearch();
        int[] list = {4, 6, 9, 10, 88, 11, 6, -9, 0};
        int[] list1 = {};
        System.out.println(linearSearch.search(null, 0));
        System.out.println(linearSearch.search(list1, 0));
        //找到
        System.out.println(linearSearch.search(list, 0));
        //找不到
        System.out.println(linearSearch.search(list, 22));
    }
}
