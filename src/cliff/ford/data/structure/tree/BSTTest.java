package cliff.ford.data.structure.tree;

import org.junit.Test;

/**
 * 二叉搜索树测试类
 * @author Cliff_Ford
 */
public class BSTTest {
    @Test
    public void test(){
        //新建树
        BinarySearchTree bst = new BinarySearchTree();
        bst.push(15);
        bst.push(9);
        bst.push(23);
        bst.push(3);
        bst.push(12);
        bst.push(17);
        bst.push(28);
        bst.push(8);
        bst.check();
        //测试查 数据存在
        System.out.println(bst.get(17).val);
        //测试查 数据不存在
        System.out.println(bst.get(6));
        bst.change(17,6);
        bst.check();
        bst.delete(23);
        bst.check();
        bst.delete(15);
        bst.check();
        bst.delete(9);
        bst.check();
        bst.delete(12);
        bst.check();
        bst.delete(3);

        bst.check();
        //故意删除没有的数据
        bst.delete(17);
        bst.check();
        bst.delete(28);
        bst.check();
        bst.delete(8);
        bst.check();
        bst.delete(6);
        //至此，bst已经空
        bst.check();
        //重建
        bst.push(7);
        bst.check();
        bst.delete(7);
        bst.check();
    }
    @Test
    public void test2(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.push(6);
        bst.push(5);
        bst.push(7);
        bst.check();
        bst.delete(6);
        bst.check();
        bst.delete(5);
        bst.check();
        bst.delete(7);
        bst.check();
    }
}
