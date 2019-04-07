package cliff.ford.data.structure.queue;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class QueueTest {
    @Test
    public void test(){
        Queue queue = new Queue();
        System.out.println(queue.peek().val);
        queue.push(3);
        System.out.println(queue.peek().val);
        queue.push(4);
        System.out.println(queue.pop().val);
        System.out.println(queue.peek().val);
        System.out.println(queue.pop().val);
        queue.push(5);
        queue.change(6);
        System.out.println(queue.peek().val);
        System.out.println(queue.pop().val);
        System.out.println(queue.peek().val);
    }
}
