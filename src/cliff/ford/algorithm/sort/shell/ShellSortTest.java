package cliff.ford.algorithm.sort.shell;

import cliff.ford.algorithm.sort.Check;
import cliff.ford.algorithm.sort.Sort;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class ShellSortTest {
    @Test
    public void test(){
        Sort shellSort = new ShellSort();
        shellSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        shellSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        shellSort.sort(list2);
        Check.check(list2);
    }
}
