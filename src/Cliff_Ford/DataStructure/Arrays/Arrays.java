package Cliff_Ford.DataStructure.Arrays;

/*
* 通过链接的形式模拟数组访问的增删查改操作
* */
public class Arrays {
    Node head = null;
    Integer size = null;
    /*创建指定大小的链表*/
    public Arrays(int size){
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
    /*访问是否越界*/
    public boolean isOutOfSize(int index){
        if(index >= 0){
            return index > this.size;
        }
        return false;
    }
    /*获取指定下标的节点*/
    public Node getNodeByIndex(int index){
        Node p = this.head;
        int i = 0;
        while(i != index){
            p = p.next;
            i++;
        }
        return p;
    }
    /*增、改*/
    public void add(int index, int val){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            t.val = val;
        }else{
            System.out.println("数组访问越界");
        }
    }
    /*删*/
    public void delete(int index){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            t.val = null;
        }else{
            System.out.println("数组访问越界");
        }
    }
    /*查*/
    public Integer get(int index){
        if(!isOutOfSize(index)){
            Node t = getNodeByIndex(index);
            return t.val;
        }else{
            System.out.println("数组访问越界");
        }
        return null;
    }
    /*遍历*/
    public void check(){
        Node h = this.head;
        while (h != null){
            System.out.print(h.index + " " + h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}
