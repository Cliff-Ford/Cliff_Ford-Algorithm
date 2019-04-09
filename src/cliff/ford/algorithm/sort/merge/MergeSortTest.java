package cliff.ford.algorithm.sort.merge;
import cliff.ford.algorithm.sort.Check;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class MergeSortTest {
    @Test
    public void test(){
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        mergeSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 11, 4, 6, 2, 2, 2, 1, 10};
        mergeSort.sort(list2);
        Check.check(list2);
    }
    @Test
    public void test2(){
        MergeSort mergeSort = new MergeSort();
        int[] list = {4, 1, 2, 3};
        mergeSort.sort(list);
        Check.check(list);
    }
}
