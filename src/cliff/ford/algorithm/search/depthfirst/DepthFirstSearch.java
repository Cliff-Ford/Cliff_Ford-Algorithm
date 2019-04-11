package cliff.ford.algorithm.search.depthfirst;

import cliff.ford.data.structure.graph.adjacencylist.AdjacencyListGraph;
import cliff.ford.data.structure.graph.adjacencylist.Vector;


/**
 * 深度优先搜索
 * @author Cliff_Ford
 */
public class DepthFirstSearch {
    /**
     *
     * @param key 查找值
     * @return 查找到就返回该节点，否则返回空
     */
    public static Vector search(AdjacencyListGraph graph, Integer key){
        if(key == null || graph == null || graph.vectors == null){
            return null;
        }
        //用于标记某个节点是否已经被访问过
        boolean[] flag = new boolean[graph.vectors.size()];
        //访问孤立的点
        int len = graph.vectors.size();
        for(int i = 0; i < len; i++){
            if(graph.vectors.get(i).reachAbleNodes.size() == 0){
                if(graph.vectors.get(i).key.equals(key)){
                    return graph.vectors.get(i);
                }else{
                    flag[i] = true;
                }
            }
        }
        int index = -1;
        for(int i = 0; i < flag.length; i++){
            if(!flag[i]){
                index = i;
                break;
            }
        }
        Vector result = null;
        if(index != -1){
            result = dfs(graph, key, flag, index);
        }
        return result;
    }

    private static Vector dfs(AdjacencyListGraph graph, Integer key, boolean[] flag, int index) {
        if(graph.vectors.get(index).key.equals(key)){
            return graph.vectors.get(index);
        }
        flag[index] = true;
        for(int i = 0, len = graph.vectors.get(index).reachAbleNodes.size(); i < len; i++){
            Vector target = graph.vectors.get(index).reachAbleNodes.get(i);
            if(!isVisited(graph, flag, target)){
                return dfs(graph, key, flag, indexOfVector(graph, target));
            }
        }
        //回溯到上一个节点，get(0)保证了回溯到与之连通的第一个节点，这个有addEdge保证
        if(!isAllVisited(flag)){
            return dfs(graph, key, flag, indexOfVector(graph, graph.vectors.get(index).reachAbleNodes.get(0)));
        }
        return null;
    }

    private static boolean isAllVisited(boolean[] flag){
        for (boolean aFlag : flag) {
            if (!aFlag) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisited(AdjacencyListGraph graph, boolean[] flag, Vector vector){
        int index = indexOfVector(graph, vector);
        if(index != -1){
            return flag[index];
        }
        return false;
    }

    private static int indexOfVector(AdjacencyListGraph graph, Vector vector){
        int index = -1;
        for(int i = 0, len = graph.vectors.size(); i < len; i++){
            if(graph.vectors.get(i).key.equals(vector.key)){
                index = i;
            }
        }
        return index;
    }
}
