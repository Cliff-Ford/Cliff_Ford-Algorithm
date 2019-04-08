package cliff.ford.data.structure.heap;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class HeapTest {
    @Test
    public void test(){
        Heap heap = new Heap();
        heap.add(3);
        heap.add(6);
        heap.add(9);
        heap.add(7);
        //加入一个最小的
        heap.add(2);
        //加入一个最大的
        heap.add(10);
        //加入一个向上调整一级的
        heap.add(8);
        heap.check();
        heap.delete();
        heap.delete();
        heap.delete();
        System.out.println(heap.peek().val);
        heap.check();
        heap.change(11);
        heap.check();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        System.out.println(heap.peek());
        heap.check();
    }
}
