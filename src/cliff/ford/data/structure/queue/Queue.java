package cliff.ford.data.structure.queue;

/**
 * 数据结构队列
 * @author Cliff_Ford
 */
public class Queue {
    Node queue = null;
    Node last = null;
    public Queue(){
        this.queue = new Node();
        this.last = this.queue;
    }

    /**
     * 入队,模拟增操作
     * @param val 指定值
     */
    public void push(Integer val){
        if(this.queue == null){
            this.queue = new Node();
            this.last = this.queue;
            if(val != null){
                this.queue.val = val;
            }
            return;
        }
        if(val != null){
            if(this.last.val == null){
                this.last.val = val;
            }else{
                Node t = new Node();
                t.val = val;
                this.last.next = t;
                this.last = t;
            }
        }
    }

    /**
     * 出队，模拟删操作
     * @return Node
     */
    public Node pop(){
        Node t = new Node();
        if(this.queue != null){
            t = this.queue;
            this.queue = this.queue.next;
        }
        return t;
    }

    /**
     * 查看队列的第一个节点除指针外的属性，模拟查操作
     * @return
     */
    public Node peek(){
        Node t = new Node();
        if(this.queue != null){
            t.val = this.queue.val;
        }
        return t;
    }

    /**
     * 更改队列第一个节点的属性，模拟改操作
     * @param newVal
     */
    public void change(Integer newVal){
        if(this.queue == null){
            this.queue = new Node();
            this.queue.val = newVal;
            return;
        }
        this.queue.val = newVal;
    }
}
