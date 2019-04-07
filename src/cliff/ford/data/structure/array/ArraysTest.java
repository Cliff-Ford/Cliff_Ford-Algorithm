package cliff.ford.data.structure.array;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class ArraysTest {
    @Test
    public void Test(){
        Arrays arrays = new Arrays(5);
        arrays.check();
        arrays.add(0,0);
        arrays.add(1,1);
        arrays.add(2,2);
        arrays.add(3,3);
        arrays.add(4,4);
        arrays.check();
        arrays.add(2,4);
        arrays.check();
        arrays.delete(2);
        arrays.check();
        System.out.println(arrays.get(2));
    }
    @Test
    public void t(){
        int[] a = new int[5];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        for(int t : a){
            System.out.print(t);
        }

    }
}
