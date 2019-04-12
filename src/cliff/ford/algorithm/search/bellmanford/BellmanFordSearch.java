package cliff.ford.algorithm.search.bellmanford;

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
        if(!isTwoPointConnected(graph, startPoint, endPoint)){
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

        buildPaths(graph, minDistance, paths, startPoint);
        return paths;
    }

    /**
     * 构建最短路径
     * @param graph 起点 终点 所在图
     * @param minDistance 距离终点的最小距离
     * @param paths 所有可能路径
     * @param startPoint 起始点
     */
    private static void buildPaths(AdjacencyListGraphWithWeight graph,
                                   int minDistance,
                                   List<String> paths,
                                   Integer startPoint) {
        boolean[] flag = new boolean[graph.vectors.size()];
        int indexForStartPoint = indexOfVectorByKey(graph, startPoint);
        for(int i = 0, len = graph.vectors.get(indexForStartPoint).reachAbleNodes.size(); i < len; i++){
            //一步到达终点
            if(minDistance == graph.weights.get(indexForStartPoint).get(i)){
                paths.add(startPoint+"->"+graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key);
                flag[indexForStartPoint] = true;
            }else if(minDistance > graph.weights.get(indexForStartPoint).get(i)){
                //两步以上
                StringBuilder path = new StringBuilder();
                //第一步
                path.append(startPoint).append("->");
                flag[indexForStartPoint] = true;
                //剩下的步
                restPath(graph,
                        minDistance-graph.weights.get(indexForStartPoint).get(i),
                        graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key,
                        path, flag, paths);


            }
        }

    }

    private static void restPath(AdjacencyListGraphWithWeight graph, int minDistance, Integer startPoint, StringBuilder path, boolean[] flag, List<String> paths) {
        StringBuilder newPath = new StringBuilder();
        newPath.append(path);
        boolean[] newFlag = new boolean[flag.length];
        System.arraycopy(flag,0,newFlag,0,flag.length);
        int indexForStartPoint = indexOfVectorByKey(graph, startPoint);
        Vector cur = graph.vectors.get(indexForStartPoint);
        for(int i = 0, len = graph.vectors.get(indexForStartPoint).reachAbleNodes.size(); i < len; i++){

            //一步到达终点
            if(minDistance == graph.weights.get(indexForStartPoint).get(i) && !newFlag[indexOfVectorByKey(graph, cur.reachAbleNodes.get(i).key)]){
                newFlag[indexForStartPoint] = true;
                String s = ""+newPath+cur.key+"->"+graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key;
                paths.add(s);
            }else if(minDistance >= graph.weights.get(indexForStartPoint).get(i) && !newFlag[indexOfVectorByKey(graph, cur.reachAbleNodes.get(i).key)]){
                String s = startPoint+"->";
                newPath.append(s);

                newFlag[indexForStartPoint] = true;
                //剩下的步
                restPath(graph,minDistance-graph.weights.get(indexForStartPoint).get(i),
                                    graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key,newPath,newFlag,paths);
                //回溯
                newFlag[indexForStartPoint] = false;
                newPath = new StringBuilder().append(newPath.substring(0, newPath.length()-s.length()));

            }
        }
    }

    private static int findMinDistance(AdjacencyListGraphWithWeight graph, int[] distance, Integer endPoint) {
        int index = indexOfVectorByKey(graph, endPoint);
        return distance[index];
    }

    private static void updateDistance(AdjacencyListGraphWithWeight graph, Vector h, int[] distance) {
        int indexForH = indexOfVectorByKey(graph, h.key);
        for(int i = 0, len = h.reachAbleNodes.size(); i < len; i++){
            int j = indexOfVectorByKey(graph, h.reachAbleNodes.get(i).key);
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

    private static boolean isTwoPointConnected(AdjacencyListGraphWithWeight graph, Integer startPoint, Integer endPoint) {
        int i = indexOfVectorByKey(graph, startPoint);
        int j = indexOfVectorByKey(graph, endPoint);
        if(i != -1 && j != -1){
            return (graph.vectors.get(i).reachAbleNodes.size()>0) && (graph.vectors.get(j).reachAbleNodes.size()>0);
        }
        return false;
    }

    private static int indexOfVectorByKey(AdjacencyListGraphWithWeight graph, Integer key) {
        for(int i = 0, len = graph.vectors.size(); i < len; i++){
            if(graph.vectors.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }
}
