package cliff.ford.data.structure.graph.adjacencylist;


import java.util.ArrayList;
import java.util.List;

/**
 * 邻接列表形式的图
 * @author Cliff_Ford
 */
public class AdjacencyListGraph {
    public List<Vector> vectors = new ArrayList<>();

    /**
     * 添加顶点
     * @param key 顶点关键字
     */
    public void addVector(Integer key){
        this.vectors.add(new Vector(key));
    }


    protected Vector findVectorByKey(Integer key){
        if(key == null){
            return null;
        }
        for(Vector v : this.vectors){
            if(v.key.equals(key)){
                return v;
            }
        }
        return null;
    }
    /**
     * 添加边
     * @param leftNode 边的左顶点
     * @param rightNode 边的右顶点
     */
    public void addEdge(Integer leftNode, Integer rightNode){
        Vector left = findVectorByKey(leftNode);
        if(left != null){
            Vector right = findVectorByKey(rightNode);
            if(right != null){
                left.reachAbleNodes.add(right);
                right.reachAbleNodes.add(left);
            }
        }
    }

    /**
     * 删除顶点
     * @param key 指定key
     */
    public void deleteVector(Integer key){
        Vector target = findVectorByKey(key);
        if(target != null){
            this.vectors.remove(target);
            //删除其他顶点连接该顶点的边
            for(Vector v : this.vectors){
                v.reachAbleNodes.remove(target);
            }
        }
    }


    /**
     * 查找指定key的顶点
     * @param key 指定key
     */
    public Vector get(Integer key){
        Vector target = findVectorByKey(key);
        if(target != null){
            return target;
        }
        return null;
    }

    /**
     * 更新某个顶点(边不用更新，因为edge由leftNode和rightNode决定)
     * @param oldKey 旧值
     * @param newKey 新值
     */
    public void change(Integer oldKey, Integer newKey){
        Vector target = findVectorByKey(oldKey);
        if(target != null){
            target.key = newKey;
        }
    }

    /**
     * 输出所有节点及其对应可到达的节点
     */
    public void check(){
        for(Vector vector : this.vectors){
            System.out.print(vector.key+" -> ");
            for(Vector v : vector.reachAbleNodes){
                System.out.print(v.key+" ");
            }
            System.out.println();
        }
    }
}
