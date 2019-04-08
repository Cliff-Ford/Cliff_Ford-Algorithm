package cliff.ford.data.structure.tree;

/**
 * 二叉搜索树 简称BST
 * @author Cliff_Ford
 */
public class BinarySearchTree {
    private BinaryNode root = null;
    private BinaryNode temp = null;
    /**
     * 模拟增操作，插入一个节点
     * @param val 插入值
     */
    public void push(Integer val){
        if(this.root == null){
            this.root = new BinaryNode();
            this.root.val = val;
            return;
        }
        add(this.root, val);
    }
    private void add(BinaryNode start, Integer val){
        //忽略已存在的值
        //插入右边
        if(start.val < val){
            if(start.rChild == null){
                start.rChild = new BinaryNode();
                start.rChild.val = val;
            }else{
                add(start.rChild, val);
            }
        }else if(start.val > val){
            //插入左边
            if(start.lChild == null){
                start.lChild = new BinaryNode();
                start.lChild.val = val;
            }else{
                add(start.lChild, val);
            }
        }
    }
    /**
     * 模拟查操作
     * @param targetVal 查找目标值
     * @return 找到时返回该节点，否则返回null
     */
    public BinaryNode get(Integer targetVal){
        return find(this.root, targetVal);
    }
    private BinaryNode find(BinaryNode root, Integer val){
        if(root.val.equals(val)){
            return root;
        }else if(val > root.val){
            return root.rChild != null ? find(root.rChild, val) : null;
        }else{
            return root.lChild != null ? find(root.lChild, val) : null;
        }
    }
    public void change(Integer oldVal, Integer newVal){
        if(this.root != null){
            if(this.root.val.equals(oldVal)){
                BinaryNode leftTree = this.root.lChild;
                BinaryNode rightTree = this.root.rChild;
                this.root.lChild = null;
                this.root.rChild = null;
                addATree(leftTree);
                addATree(rightTree);
                return;
            }
            BinaryNode t = get(oldVal);
            if(t != null){
                t.val = newVal;
                //折枝,折第二层以下的枝
                pickDownFromThis(t);
                addATree(t);
            }
        }

    }

    private void pickDownFromThis(BinaryNode t) {
        pickDown(this.root, t);
    }

    private void pickDown(BinaryNode root, BinaryNode t){
        if(root != null){
            if(root.lChild == t){
                root.lChild = null;
                return;
            }
            if(root.rChild == t){
                root.rChild = null;
                return;
            }
            pickDown(root.lChild, t);
            pickDown(root.rChild, t);
        }
    }

    private void addATree(BinaryNode t) {
        if(t != null){
            if(t.lChild != null){
                addATree(t.lChild);
            }
            push(t.val);
            if(t.rChild != null){
                addATree(t.rChild);
            }
        }
    }

    /**
     * 模拟删操作
     */
    public void delete(Integer val){
        deleteFromRoot(this.root, val);
    }

    private void deleteFromRoot(BinaryNode root, Integer val) {
        if(root != null){
            BinaryNode t = find(root, val);
            if(t != null){
                if(t.lChild == null && t.rChild == null){
                    BinaryNode parent = findParent(t);
                    if(parent != null){
                        if(parent.lChild == t){
                            parent.lChild = null;
                        }else{
                            parent.rChild = null;
                        }
                    }else{
                        this.root = null;
                    }


                }else if(t.lChild != null && t.rChild != null){
                    //待删除的节点有两个孩子
                    BinaryNode parent = findParent(t);
                    this.temp = null;
                    BinaryNode maxChild = sliceMaxNodeOnThisTree(t.lChild);
                    if(parent == null){
                        //删除的是顶点
                        if(maxChild != null){
                            //顶点的左孩子有右孩子，maxChild是顶点左树的最大值
                            maxChild.lChild = t.lChild;
                            maxChild.rChild = t.rChild;
                            this.root = maxChild;
                        }

                    }else if(maxChild != null){
                        //删除的不是顶点
                        if(parent.lChild == t){
                            parent.lChild = maxChild;
                        }else{
                            parent.rChild = maxChild;
                        }
                        maxChild.rChild = t.rChild;
                        maxChild.lChild = t.lChild;
                    }

                }else if(t.lChild != null){
                    //待删除节点只有一个孩子
                    //只有左孩子
                    BinaryNode parent = findParent(t);
                    this.temp = null;
                    if(parent != null){
                        if(parent.lChild == t){
                            parent.lChild = t.lChild;
                        }else{
                            parent.rChild = t.lChild;
                        }
                    }else{
                        this.root = this.root.lChild;
                    }


                }else {
                    //只有右孩子
                    BinaryNode parent = findParent(t);
                    this.temp = null;
                    if(parent != null){
                        if(parent.lChild == t){
                            parent.lChild = t.rChild;
                        }else{
                            parent.rChild = t.rChild;
                        }
                    }else{
                        this.root = this.root.rChild;
                    }

                }

            }
        }
    }

    private BinaryNode sliceMaxNodeOnThisTree(BinaryNode root) {
        if(root == null){
            return null;
        }
        if(root.lChild == null && root.rChild == null){
            return root;
        }
        while(root.rChild != null){
            root = root.rChild;
        }
        deleteFromRoot(findParent(root), root.val);
        this.temp = null;
        return root;
    }

    private BinaryNode findParent(BinaryNode t) {
        findParentFromOneNode(this.root, t);
        //temp用于暂时寻找某个节点的父节点
        if(this.temp != null){
            if((this.temp.lChild == t || this.temp.rChild == t)){
                return this.temp;
            }
        }
        return null;
    }

    private void findParentFromOneNode(BinaryNode root, BinaryNode t) {
        if(t != null && root != null){
            if(t.val > root.val){
                this.temp = root;
                findParentFromOneNode(root.rChild, t);

            }else if(t.val < root.val){
                this.temp = root;
                findParentFromOneNode(root.lChild, t);
            }
        }
    }

    /**
     * 中序遍历检查二叉搜索树是否正确
     */
    public void check(){
        inorderTraversal(this.root);
        System.out.println();
    }
    private void inorderTraversal(BinaryNode start){
        if(start != null){
            if(start.lChild != null){
                inorderTraversal(start.lChild);
            }
            System.out.print(start.val+" ");
            if(start.rChild != null){
                inorderTraversal(start.rChild);
            }
        }
    }
}
