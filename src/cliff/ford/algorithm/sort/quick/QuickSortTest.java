package cliff.ford.algorithm.sort.quick;

import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.select.SelectSort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class QuickSortTest {
    @Test
    public void test(){
        QuickSort quickSort = new QuickSort();
        quickSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        quickSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 11, 4, 6, 2, 2, 2, 1, 10};
        quickSort.sort(list2);
        Check.check(list2);
    }
}
