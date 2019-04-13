package cliff.ford.algorithm.search.bellmanford;

import cliff.ford.algorithm.search.BuildPaths;
import cliff.ford.data.structure.graph.adjacencylist.Vector;
import cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist.AdjacencyListGraphWithWeight;


import java.util.ArrayList;

import java.util.List;

/**
 * 贝尔曼-福特算法, 广度优先遍历的一个应用，用于查找两点之间的最短距离
 * @author Cliff_Ford
 */
public class BellmanFordSearch {
    /**
     *
     * @param graph 一张带权邻接列表图
     * @param startPoint 起始点
     * @param endPoint 目的地
     * @return 一组最短路径
     */
    public static List<String>  shortestPaths(AdjacencyListGraphWithWeight graph, Integer startPoint, Integer endPoint){
        if(graph == null || startPoint == null || endPoint == null){
            return null;
        }
        if(!BuildPaths.isTwoPointConnected(graph, startPoint, endPoint)){
            return null;
        }
        List<String> paths = new ArrayList<>();
        int[] distance = new int[graph.vectors.size()];
        initDistance(graph, startPoint, distance);

        for(Vector vector : graph.vectors){
            updateDistance(graph, vector, distance);
        }
        int minDistance = findMinDistance(graph, distance, endPoint);
        //构建路径

        BuildPaths.buildPaths(graph, minDistance, paths, startPoint, endPoint);
        return paths;
    }


    private static int findMinDistance(AdjacencyListGraphWithWeight graph, int[] distance, Integer endPoint) {
        int index = BuildPaths.indexOfVectorByKey(graph, endPoint);
        return distance[index];
    }

    private static void updateDistance(AdjacencyListGraphWithWeight graph, Vector h, int[] distance) {
        int indexForH = BuildPaths.indexOfVectorByKey(graph, h.key);
        for(int i = 0, len = h.reachAbleNodes.size(); i < len; i++){
            int j = BuildPaths.indexOfVectorByKey(graph, h.reachAbleNodes.get(i).key);
            if(distance[indexForH] + graph.weights.get(indexForH).get(i) < distance[j]){
                distance[j] = distance[indexForH] + graph.weights.get(indexForH).get(i);
            }
        }
    }

    /**
     * 起始点设为0，其他设为Integer.MAX_VALUE
     * @param graph 邻接列表图
     * @param startPoint 起点关键值
     * @param distance 距离统计数组
     */
    private static void initDistance(AdjacencyListGraphWithWeight graph, Integer startPoint, int[] distance) {
        for(int i = 0, len = graph.vectors.size(); i < len; i++){
            if(graph.vectors.get(i).key.equals(startPoint)){
                distance[i] = 0;
            }else{
                distance[i] = Integer.MAX_VALUE;
            }
        }
    }




}
