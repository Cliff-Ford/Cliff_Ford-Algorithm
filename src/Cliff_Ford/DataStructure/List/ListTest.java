package Cliff_Ford.DataStructure.List;

import org.junit.Test;

public class ListTest {
    @Test
    public void Test(){
        List list = new List();
        list.addToHead(3);
        list.deleteNodeByVal(3);
        list.check();
        list.addToHead(4);
        list.addToTail(5);
        list.addToTail(6);
        list.deleteNodeByVal(5);
        list.check();
        list.changeValToOtherValByVal(4, 5);
        list.check();
        System.out.println(list.findNodeByVal(6).val);
        list.deleteNodeByVal(5);
        list.deleteNodeByVal(6);
        list.check();
    }
}
