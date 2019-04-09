package cliff.ford.algorithm.sort.heap;

import cliff.ford.algorithm.sort.Check;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class HeapSortTest {
    @Test
    public void test(){
        HeapSort heapSort = new HeapSort();
        heapSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        heapSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        heapSort.sort(list2);
        Check.check(list2);
    }
}
