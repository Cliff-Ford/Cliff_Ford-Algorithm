package cliff.ford.data.structure.list;

/**
 * 数据结构链表
 * @author Cliff_Ford
 */
public class List {
    Node head = null;
    List(){
        this.head = new Node();
    }

    /**
     * 尾插法
     * @param val
     */
    public void addToTail(Integer val){
        //链表可能被删空了
        if(this.head == null){
            this.head = new Node();
        }
        if(this.head.val == null && this.head.next == null){
            this.head.val = val;
        }else{
            Node t = this.head;
            while(t.next != null){
                t = t.next;
            }
            Node p = new Node();
            p.val = val;
            t.next = p;
        }
    }

    /**
     * 头插法
     * @param val
     */
    public void addToHead(Integer val){
        //链表可能被删空了
        if(this.head == null){
            this.head = new Node();
        }
        if(this.head.val == null && this.head.next == null){
            this.head.val = val;
        }else{
            Node p = new Node();
            p.val = val;
            p.next = this.head;
            this.head = p;
        }
    }

    /**
     * 删除指定值的第一个节点
     * @param val
     */
    public void deleteNodeByVal(Integer val){
        //第一个就命中
        if(this.head.val.equals(val)){
            this.head = this.head.next;
        }else{
            Node p = this.head;
            Node q = this.head.next;
            boolean flag = false;
            while(q!=null && !flag){
                if(q.val.equals(val)){
                    p.next = q.next;
                    flag = true;
                }else{
                    p = p.next;
                    q = q.next;
                }
            }
        }
    }

    /**
     * 查找指定值的第一节点
     * @param val 指定值
     * @return p为指定值的节点，没有则为空
     */
    public Node findNodeByVal(Integer val){
        Node p = this.head;
        while(!p.val.equals(val)){
            p = p.next;
        }
        return p;
    }

    /**
     * 将指定值的第一个节点修改成另一个指定值
     * @param val 旧值
     * @param otherVal 新值
     */
    public void changeValToOtherValByVal(Integer val, Integer otherVal){
        Node t = findNodeByVal(val);
        if(t != null){
            t.val = otherVal;
        }
    }

    /**
     * 遍历
     */
    public void check(){
        Node p = this.head;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }
}
