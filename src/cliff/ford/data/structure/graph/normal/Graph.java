package cliff.ford.data.structure.graph.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * G<V, E>表示一张图
 * @author Cliff_Ford
 */
public class Graph {
    List<Vector> vectors = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();

    /**
     * 添加顶点
     * @param key 顶点关键字
     */
    public void addVector(Integer key){
        this.vectors.add(new Vector(key));
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
                this.edges.add(new Edge(left, right));
            }
        }
    }
    private Vector findVectorByKey(Integer key){
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
     * 删除顶点
     * @param key 指定key
     */
    public void deleteVector(Integer key){
        Vector target = findVectorByKey(key);
        if(target != null){
            this.vectors.remove(target);
            deleteEdges(target);
        }
    }
    private void deleteEdges(Vector target){
        for(int i = this.edges.size()-1; i >= 0; i--){
            Edge edge = this.edges.get(i);
            if(edge.leftNode == target || edge.rightNode == target){
                this.edges.remove(edge);
            }
        }
    }

    /**
     * 查找指定key的顶点，输出该顶点的所有边
     * @param key 指定key
     */
    public void get(Integer key){
        Vector target = findVectorByKey(key);
        if(target != null){
            for(Edge edge : this.edges){
                if(edge.leftNode == target || edge.rightNode == target){
                    System.out.print(edge.leftNode.key+"-"+edge.rightNode.key+" ");
                }
            }
            System.out.println();
        }
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
    public void check(){
        System.out.println("Vectors:");
        for(Vector vector : this.vectors){
            System.out.print(vector.key + " ");
        }
        System.out.println();
        System.out.println("Edges:");
        for (Edge e : this.edges){
            System.out.print(e.leftNode.key+"-"+e.rightNode.key+" ");
        }
        System.out.println();
    }
}
