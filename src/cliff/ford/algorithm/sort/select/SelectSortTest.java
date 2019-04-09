package cliff.ford.algorithm.sort.select;
import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.soap.SoapSort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class SelectSortTest {
    @Test
    public void test(){
        SelectSort selectSort = new SelectSort();
        selectSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        selectSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        selectSort.sort(list2);
        Check.check(list2);
    }
}
