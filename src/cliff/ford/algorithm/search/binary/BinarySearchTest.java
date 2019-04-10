package cliff.ford.algorithm.search.binary;

import cliff.ford.algorithm.search.Search;
import cliff.ford.algorithm.search.linear.LinearSearch;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class BinarySearchTest {
    @Test
    public void test(){
        Search binarySearch = new BinarySearch();
        int[] list = {1, 6, 9, 10, 11, 88, 666, 999, 1000};
        int[] list1 = {};
        System.out.println(binarySearch.search(null, 0));
        System.out.println(binarySearch.search(list1, 0));
        //找到
        System.out.println(binarySearch.search(list, 88));
        //找不到
        System.out.println(binarySearch.search(list, 22));
    }
}
