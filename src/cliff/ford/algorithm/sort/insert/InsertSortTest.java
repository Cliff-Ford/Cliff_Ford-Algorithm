package cliff.ford.algorithm.sort.insert;

import cliff.ford.algorithm.sort.Check;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class InsertSortTest {
    @Test
    public void test(){
        InsertSort insertSort = new InsertSort();
        insertSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        insertSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        insertSort.sort(list2);
        Check.check(list2);
    }
}
