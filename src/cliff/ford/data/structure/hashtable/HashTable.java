package cliff.ford.data.structure.hashtable;

/**
 * 数据结构哈希表（散列表）
 * @author Cliff_Ford
 */
public class HashTable {
    Integer len = 12;
    Node[] hashTable = null;

    /**
     * 默认初始大小为12
     */
    public HashTable(){
        this.hashTable = new Node[this.len];

    }
    /**
     * 通过hashCode取模确定位置，冲突时形成链结构，链的插入采用头插法
     * 模拟增操作,允许重复值的插入
     * @param val 指定值
     */
    public void push(Integer val){
        if(val != null){
            int i = val % this.len;
            Node t = new Node();
            t.val = val;
            if(this.hashTable[i] == null){
                this.hashTable[i] = t;
            }else{
                t.next = this.hashTable[i];
                this.hashTable[i] = t;
            }
        }
    }

    /**
     * 模拟查操作
     * 查找不一定在对应的链里面，因为是取模运算
     * @param val 查找值
     * @return Node 返回除指针外的属性
     */
    public Node get(Integer val){
        if(val != null){
            Node t = new Node();
            int i = val % this.len;
            if(this.hashTable[i] == null){
                return null;
            }
            Node p = this.hashTable[i];
            while(p != null){
                if(p.val.equals(val)){
                    t.val = val;
                    break;
                }
                p = p.next;
            }
            if(t.val != null){
                return t;
            }else{
                return null;
            }

        }
        return null;
    }

    /**
     * 模拟删操作
     * @param targetVal 查找值
     * @return Node 返回一个除指针外所有属性的节点，且该节点是匹配上的第一个节点
     */
    public Node pop(Integer targetVal){
        int i = targetVal % this.len;
        Node r = new Node();
        //空链表
        if(this.hashTable[i] == null){
            return null;
        }
        //查找第一个节点就匹配上
        if(this.hashTable[i].val.equals(targetVal)){
            r.val = targetVal;
            this.hashTable[i] = this.hashTable[i].next;
            return r;
        }
        Node q = this.hashTable[i].next;
        Node p = this.hashTable[i];
        //查找两个节点以上的情况
        if(q != null){
            while(q != null){
                if(q.val.equals(targetVal)){
                    r.val = q.val;
                    break;
                }
                q = q.next;
                p = p.next;
            }
            if(q != null){
                p.next = q.next;
            }
        }
        return r;
    }

    /**
     * 模拟改操作，新值不一定和旧值在同一条链上
     * @param oldVal 旧值
     * @param newVal 新值
     */
    public void change(Integer oldVal, Integer newVal){
        Node t = get(oldVal);
        if(t != null){
            pop(oldVal);
            push(newVal);
        }
    }
}
