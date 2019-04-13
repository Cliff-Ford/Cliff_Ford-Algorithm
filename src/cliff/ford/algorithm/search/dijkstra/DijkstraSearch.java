package cliff.ford.algorithm.search.dijkstra;

import cliff.ford.algorithm.search.BuildPaths;
import cliff.ford.data.structure.graph.adjacencylist.Vector;
import cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist.AdjacencyListGraphWithWeight;

import java.util.ArrayList;
import java.util.List;

/**
 * 狄克斯特拉算法，深度优先遍历的一个应用，用于查找图中两点的最短路径
 * @author Cliff_Ford
 */
public class DijkstraSearch {
    public static List<String> shortestPaths(AdjacencyListGraphWithWeight graph, Integer startPoint, Integer endPoint) {
        if(graph == null || startPoint == null || endPoint == null){
            return null;
        }
        if(!BuildPaths.isTwoPointConnected(graph, startPoint, endPoint)){
            return null;
        }
        List<String> paths = new ArrayList<>();
        int[] distance = new int[graph.vectors.size()];
        //用于标记一个顶点是否已经被访问过了
        boolean[] flag = new boolean[graph.vectors.size()];
        initDistanceAndFlag(graph, startPoint, distance, flag);
        updateDistance(graph, startPoint, distance, flag);
        int minDistance = findMinDistance(graph, distance, endPoint);
        System.out.println("minDistance: "+minDistance);
        //构建路径
        BuildPaths.buildPaths(graph, minDistance, paths, startPoint, endPoint);
        return paths;
    }



    private static int findMinDistance(AdjacencyListGraphWithWeight graph, int[] distance, Integer endPoint) {
        int index = BuildPaths.indexOfVectorByKey(graph, endPoint);
        return distance[index];
    }

    private static void updateDistance(AdjacencyListGraphWithWeight graph, Integer startPoint, int[] distance, boolean[] flag) {
        int indexOfStartPoint = BuildPaths.indexOfVectorByKey(graph, startPoint);
        if(!flag[indexOfStartPoint]){
            //将该节点加入到图中
            flag[indexOfStartPoint] = true;
            Vector cur = graph.vectors.get(indexOfStartPoint);

            for(int i = 0, len = cur.reachAbleNodes.size(); i < len; i++){
                int indexOfNextVector = BuildPaths.indexOfVectorByKey(graph, cur.reachAbleNodes.get(i).key);
                if(distance[indexOfStartPoint] + graph.weights.get(indexOfStartPoint).get(i) <= distance[indexOfNextVector]){
                    distance[indexOfNextVector] = distance[indexOfStartPoint] + graph.weights.get(indexOfStartPoint).get(i);
                }
            }
            //根据distance判断出后补节点，从后补节点中选出下一轮开始的点
            int minRelative = distance[indexOfStartPoint];
            int k = -1;
            for(int i = 0, temp = 0; i < distance.length; i++){
                if(distance[i] != Integer.MAX_VALUE && !flag[i] && distance[i] >= minRelative){
                    if(temp == 0){
                        k = i;
                        temp = distance[i];
                    }else{
                        if(distance[i] < temp){
                            k = i;
                            temp = distance[i];
                        }
                    }
                }
            }
            if(k != -1){
                updateDistance(graph,graph.vectors.get(k).key, distance, flag);
            }
        }
    }

    private static void initDistanceAndFlag(AdjacencyListGraphWithWeight graph, Integer startPoint, int[] distance, boolean[] flag) {
        for(int i = 0, len = graph.vectors.size(); i < len; i++){
            if(graph.vectors.get(i).key.equals(startPoint)){
                distance[i] = 0;
            }else{
                distance[i] = Integer.MAX_VALUE;
            }
            //将孤立点标记为已被访问
            if(graph.vectors.get(i).reachAbleNodes.size() == 0){
                flag[i] = true;
            }
        }
    }



}
