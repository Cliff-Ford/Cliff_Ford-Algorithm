package cliff.ford.algorithm.sort.radix;

import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.Sort;
import cliff.ford.algorithm.sort.bucket.BucketSort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class RadixSortTest {
    @Test
    public void test(){
        Sort radixSort = new RadixSort();
        radixSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        radixSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        radixSort.sort(list2);
        Check.check(list2);
    }
}
