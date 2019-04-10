package cliff.ford.algorithm.search.breadthfirst;

import cliff.ford.data.structure.graph.adjacencylist.AdjacencyListGraph;
import cliff.ford.data.structure.graph.adjacencylist.Vector;


import java.util.LinkedList;

import java.util.Queue;

/**
 * 邻接列表的广度优先搜索
 * @author Cliff_Ford
 */

public class BreadthFirstSearch {
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
        Queue<Vector> queue = new LinkedList<>();
        if(graph.vectors.size()>0){
            queue.add(graph.vectors.get(0));
        }
        while(!queue.isEmpty()){
            Vector t = queue.poll();
            flag[graph.vectors.indexOf(t)] = true;
            if(t != null && t.key.equals(key)){
                return t;
            }else if(t != null){
                for(Vector v : t.reachAbleNodes){
                    if(!flag[graph.vectors.indexOf(v)]){
                        queue.add(v);
                    }
                }
            }
        }
        return null;
    }
}
