package cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist;


import cliff.ford.data.structure.graph.adjacencylist.AdjacencyListGraph;
import cliff.ford.data.structure.graph.adjacencylist.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接列表形式的图
 * @author Cliff_Ford
 */
public class AdjacencyListGraphWithWeight extends AdjacencyListGraph {
    public List<List<Integer>> weights = new ArrayList<>();
    /**
     * 添加顶点
     * @param key 顶点关键字
     */
    @Override
    public void addVector(Integer key){
        super.addVector(key);
        this.weights.add(new ArrayList<>());
    }


    /**
     * 添加边和权重
     * @param leftNode 边的左顶点
     * @param rightNode 边的右顶点
     */
    public void addEdge(Integer leftNode, Integer rightNode, Integer weight){
        super.addEdge(leftNode, rightNode);
        int i = indexOfVectorByKey(leftNode);
        int j = indexOfVectorByKey(rightNode);
        if(i != -1 && j != -1){
            this.weights.get(i).add(weight);
            this.weights.get(j).add(weight);
        }
    }

    private int indexOfVectorByKey(Integer key) {
        for(int i = 0, len = super.vectors.size(); i < len; i++){
            if(super.vectors.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除顶点
     * @param key 指定key
     */
    @Override
    public void deleteVector(Integer key){
        int i = indexOfVectorByKey(key);
        Vector target = findVectorByKey(key);
        if(i == -1 || target == null){
            return;
        }
        this.weights.remove(i);
        this.vectors.remove(target);
        //删除其他顶点连接该顶点的边
        for(int j = 0, len = super.vectors.size(); j < len; j++){
            int k = super.vectors.get(j).reachAbleNodes.indexOf(target);
            if(k != -1){
                this.weights.get(j).remove(k);
                super.vectors.get(j).reachAbleNodes.remove(target);
            }

        }
    }


    /**
     * 查找指定key的顶点，输出该顶点的所有边和权重
     * @param key 指定key
     */
    public void find(Integer key){
        Vector target = super.findVectorByKey(key);
        if(target != null){
            System.out.print(key+" 可达节点: ");
            for(Vector vector : target.reachAbleNodes){
                System.out.print(vector.key+" ");
            }
            System.out.println();
            int i = super.vectors.indexOf(target);
            System.out.print("对应权重: ");
            for(Integer t : this.weights.get(i)){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
    /**
     * 输出所有节点及其对应可到达的节点和权重
     */

    @Override
    public void check(){
        for(Vector vector : this.vectors){
            find(vector.key);
        }
    }
}
