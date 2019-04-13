package cliff.ford.algorithm.sort.bucket;

import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.Sort;
import cliff.ford.algorithm.sort.count.CountSort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class BucketSortTest {
    @Test
    public void test(){
        Sort bucketSort = new BucketSort();
        bucketSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        bucketSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        bucketSort.sort(list2);
        Check.check(list2);
    }
}
