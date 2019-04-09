package cliff.ford.algorithm.sort.soap;
import cliff.ford.algorithm.sort.Check;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class SoapSortTest {
    @Test
    public void test(){
        SoapSort soapSort = new SoapSort();
        soapSort.sort(null);
        Check.check(null);
        int[] list1 = {};
        soapSort.sort(list1);
        Check.check(list1);
        int[] list2 = {3, 11, 4, 6, 2, 2, 1, 10};
        soapSort.sort(list2);
        Check.check(list2);
    }
}
