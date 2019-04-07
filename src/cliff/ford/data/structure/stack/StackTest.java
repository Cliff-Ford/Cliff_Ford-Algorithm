package cliff.ford.data.structure.stack;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class StackTest {
    @Test
    public void test(){
        Stack stack = new Stack();
        System.out.println(stack.peek().val);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek().val);
        stack.changePeek(5);
        System.out.println(stack.peek().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.peek().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.peek().val);
        stack.push(6);
        System.out.println(stack.peek().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.peek().val);
    }
}
