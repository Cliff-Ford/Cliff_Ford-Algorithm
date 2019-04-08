package cliff.ford.data.structure.heap;

import java.util.LinkedList;


/**
 * 堆结构的实现可以借助数组，也可以借助自定义的类二叉树节点，
 * 这里借助包含左右孩子指针和父亲指针的Node节点实现小根堆
 * @author Cliff_Ford
 */
public class Heap {
    private Node heap = null;
    private int size = 0;
    /**
     * 层次遍历
     */
    public void check(){
        if(this.heap != null){
            LinkedList<Node> queue = new LinkedList<>();
            Node head = this.heap;
            queue.addFirst(head);
            while (!queue.isEmpty()){
                Node t = queue.pop();
                System.out.print(t.val+" ");
                if(t.lChild != null){
                    queue.addLast(t.lChild);
                }
                if(t.rChild != null){
                    queue.addLast(t.rChild);
                }
            }
            System.out.println();
        }
    }

    /**
     * 返回第一个可以插入子节点的父节点
     * 该节点通常是左右孩子均为空或者只有右孩子为空
     * @return Node
     */
    private Node getNodeToAddChild(){
        if(this.heap != null){
            LinkedList<Node> queue = new LinkedList<>();
            Node head = this.heap;
            queue.addFirst(head);
            Node t;
            while (!queue.isEmpty()){
                t = queue.pop();
                //是否能直接返回
                if(t.lChild == null && t.rChild == null){
                    return t;
                }
                if(t.lChild != null && t.rChild == null){
                    return t;
                }
                //不能直接返回时，后续节点入队继续接受下一轮的检查
                if(t.lChild != null){
                    queue.addLast(t.lChild);
                }
                if(t.rChild != null){
                    queue.addLast(t.rChild);
                }
            }
        }
        return null;
    }

    /**
     * 模拟增操作
     * 层次遍历获取第一个左右孩子不全为null的节点，在该节点处插入值
     * 插入值可能会破坏堆的结构，需要调整堆的结构
     * @param val 目标值
     */
    public void add(Integer val){
        //空堆的处理情况
        if(this.heap == null){
            this.heap = new Node();
            this.heap.val = val;
            this.size++;
            return;
        }
        //非空堆
        Node t = getNodeToAddChild();
        Node p = new Node();
        if(t != null){
            p.val = val;
            p.parent = t;
            //插到该节点的左边
            if(t.lChild == null){
                t.lChild = p;
            }else{
                //插入到右边
                t.rChild = p;
            }
            this.size++;
        }
        //新插入的节点可能破坏了堆结构
        adjustHeapFromBottomToTop(p);
    }

    /**
     * 删除最小节点，并调整小根堆
     * 模拟删操作，小根堆无法确定节点左右孩子的大小关系
     * 这里层次遍历查找，也可以先中后续遍历查找
     */
    public void delete(){
        if(this.heap != null){
            //将target节点移到顶端
            Node target = null;
            int targetIndex = this.size;
            int currentIndex = 1;
            //堆节点只有一个，删除的也就是查找到的要
            if(targetIndex == currentIndex){
                this.heap = null;
                return;
            }
            LinkedList<Node> queue = new LinkedList<>();
            Node head = this.heap;
            queue.addFirst(head);
            while(!queue.isEmpty()){
                Node p = queue.pop();
                if(p.lChild != null){
                    queue.addLast(p.lChild);
                    currentIndex++;
                    if(currentIndex == targetIndex){
                        target = p.lChild;
                        break;
                    }
                }
                if(p.rChild != null){
                    queue.addLast(p.rChild);
                    currentIndex++;
                    if(currentIndex == targetIndex){
                        target = p.rChild;
                        break;
                    }
                }
            }
            //断开联系，删除根节点
            if(target != null){
                //当target.parent为null时，也就是只有一个节点的情况，在上面已经处理了
                if(target.parent.rChild == target){
                    target.parent.rChild = null;
                }else{
                    target.parent.lChild = null;
                }
                this.heap.val = target.val;
                this.size--;
            }
            //自上而下递归调整堆结构
            adjustHeapFromTopToBottom(this.heap);
        }

    }

    /**
     * 模拟查操作，获取小根堆最小的元素
     * @return Node 返回一个除指针外所有属性的节点
     */
    public Node peek(){
        Node t = new Node();
        if(this.heap != null){
            t.val = this.heap.val;
        }
        return t;
    }

    /**
     * 模拟改操作
     * @param val 根节点的新值
     */
    public void change(Integer val){
        this.heap.val = val;
        adjustHeapFromTopToBottom(this.heap);
    }

    private void adjustHeapFromTopToBottom(Node heap) {
        //只剩下最后一个节点
        if(heap.lChild == null && heap.rChild == null){
            return;
        }
        //多于一个节点

        if(heap.rChild != null && heap.lChild != null){
            if(heap.lChild.val < heap.rChild.val){
                swap(heap, heap.lChild);
                adjustHeapFromTopToBottom(heap.lChild);
            }else{
                swap(heap, heap.rChild);
                adjustHeapFromTopToBottom(heap.rChild);
            }
        }else if(heap.lChild != null){
            if(heap.lChild.val < heap.val){
                swap(heap, heap.lChild);
                adjustHeapFromTopToBottom(heap.lChild);
            }
        }

    }

    /**
     * 从开始节点往上尾递归调整堆结构
     * @param start 开始节点
     */
    private void adjustHeapFromBottomToTop(Node start) {
        //符合小根堆的定义
        if(start.parent == null || start.parent.val < start.val){
            return;
        }
        //不符合小根堆定义
        boolean isLeftChild = false;
        if(start == start.parent.lChild){
            isLeftChild = true;
        }
        if(isLeftChild){
            if(start.val < start.parent.val){
                swap(start, start.parent);
            }
            adjustHeapFromBottomToTop(start.parent);
        }else{
            if(start.val > start.parent.lChild.val){
                swap(start.parent.lChild, start.parent);
            }else{
                swap(start, start.parent);
            }
            adjustHeapFromBottomToTop(start.parent);
        }
    }
    private void swap(Node source, Node target){
        Integer t = source.val;
        source.val = target.val;
        target.val = t;
    }
}
