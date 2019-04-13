package cliff.ford.algorithm.sort.count;

import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.Sort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class CountSortTest {
    @Test
    public void test(){
        Sort countSort = new CountSort();
        countSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        countSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        countSort.sort(list2);
        Check.check(list2);
    }
}
