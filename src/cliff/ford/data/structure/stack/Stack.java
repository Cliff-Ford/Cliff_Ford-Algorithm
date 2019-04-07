package cliff.ford.data.structure.stack;

/**
 * @author Cliff_Ford
 */
public class Stack {
    Node top = null;
    public Stack(){
        this.top = new Node();
    }

    /**
     * 压栈,相当于增操作
     * @param val 指定值
     */
    public void push(Integer val){
        if(this.top == null){
            this.top = new Node();
            this.top.val = val;
            return;
        }
        if(val != null){
            if(top.val == null){
                top.val = val;
            }else{
                Node t = new Node();
                t.val = val;
                t.next = top;
                this.top = t;
            }
        }
    }

    /**
     * 出栈，相当于删操作
     * @return Node 栈顶节点
     */
    public Node pop(){
        Node p = null;
        if(this.top != null){
            p = this.top;
            this.top = this.top.next;
        }
        return p;
    }

    /**
     * 只查看栈顶元素的值，不出栈，相当于查操作
     * @return Node(包含非指针外的所有属性)
     */
    public Node peek(){
        Node p = new Node();
        if(this.top != null){
            p.val = this.top.val;
        }

        return p;
    }

    /**
     * 更改栈顶元素的值，相当于改操作
     * @param val 新值
     */
    public void changePeek(Integer val){
        if(this.top == null){
            this.top = new Node();
            this.top.val = val;
        }
        this.top.val = val;
    }
}
