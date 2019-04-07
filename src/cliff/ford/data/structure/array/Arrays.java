package cliff.ford.data.structure.array;

/**
 * 通过链接的形式模拟数组访问的增删查改操作
 * @author Cliff_Ford
 */
public class Arrays {
    Node head = null;
    Integer size = null;

    /**
     * 创建指定大小的链表
     * @param size 大小
     */
    Arrays(int size){
        try{
            if(size >= 1){
                this.head = new Node();
                this.size = size;
                Node q = head;
                q.index = 0;
                Node p = head;
                for(int i = 1; i < size; i++){
                    q = new Node();
                    q.index = i;
                    p.next = q;
                    p = p.next;
                }
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("请输入正确的数组范围");
        }
    }

    /**
     * 访问是否越界
     * @param index 下标
     * @return boolean
     */
    public boolean isOutOfSize(int index){
        if(index >= 0){
            return index > this.size;
        }
        return false;
    }

    /**
     * 获取指定下标的节点
     * @param index 下标
     * @return Node指定下标节点
     */
    public Node getNodeByIndex(int index){
        Node p = this.head;
        int i = 0;
        while(i != index){
            p = p.next;
            i++;
        }
        return p;
    }

    /**
     * 增、改
     * @param index 下标
     * @param val 值
     */
    public void add(int index, int val){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            t.val = val;
        }else{
            System.out.println("数组访问越界");
        }
    }

    /**
     * 删
     * @param index 下标
     */
    public void delete(int index){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            t.val = null;
        }else{
            System.out.println("数组访问越界");
        }
    }

    /**
     * 查
     * @param index 下标
     * @return Integer 对应值
     */
    public Integer get(int index){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            return t.val;
        }else{
            System.out.println("数组访问越界");
        }
        return null;
    }

    /**
     * 遍历
     */
    public void check(){
        Node h = this.head;
        while (h != null){
            System.out.print(h.index + " " + h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}
